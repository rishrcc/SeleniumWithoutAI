package Helpers;

import io.qameta.allure.Allure;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class APIHealthCheckHelper {

    public static String authToken;
    public static String jsonBody;
    public static String apiName;
    public static String methodName;
    public static long startTime;
    public static int responseCode;
    public static long endTime;
    public static long duration;
    public static String endpoint;
    public static String preprodApiEndpoint = "https://apimetier.com/web.api.erp.preprod";

    public APIHealthCheckHelper() {
        authToken = null;
        jsonBody = null;
    }

    public static void sendRequestAndCheckStatusCode(String apiName, String method, String endpoint, String jsonBody) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        // Create the request builder based on the HTTP method
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .timeout(Duration.ofSeconds(60));

        // If the request is not APIauth, include the Authorization token
        if (!"APIauth".equals(apiName) && authToken != null) {
            requestBuilder.header("Authorization", "Bearer " + authToken);
        }

        requestBuilder.header("Content-Type", "application/json");

        // Add the JSON body for POST, PUT, PATCH
        if (method.equals("POST") || method.equals("PUT") || method.equals("PATCH")) {
            requestBuilder.method(method, HttpRequest.BodyPublishers.ofString(jsonBody));
        } else {
            requestBuilder.method(method, HttpRequest.BodyPublishers.noBody());
        }

        HttpRequest request = requestBuilder.build();

        // Start timing the request
        startTime = System.currentTimeMillis();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Calculate the time taken
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;

        // Get response code and body
        responseCode = response.statusCode();
        String responseBody = response.body();

        // If it's the APIauth request, extract and store the token
        if ("APIauth".equals(apiName) && responseCode == 200) {
            assert true;
            authToken = extractTokenFromResponse(responseBody);
            System.out.println("Success! Response code: " + responseCode);
            System.out.println("Duration in milliseconds: " + duration);
            System.out.println("Authorization Token generated: " + authToken);
        } else if (responseCode == 200) {
            assert true;
            System.out.println("Success! Response code: " + responseCode);
            System.out.println("Duration in milliseconds: " + duration);
        } else {
            assert false : apiName + " " + "is returning status code" + " " + responseCode;
            System.out.println("Failed! Response code: " + responseCode);
            System.out.println("Duration in milliseconds: " + duration);
        }
    }

    private static String extractTokenFromResponse(String response) {
        try {
            JSONObject jsonResponse = new JSONObject(response);
            return jsonResponse.getString("Token");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void readJsonAndSendRequests() throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File("C:\\Queoval_Automation\\Queoval_Azure\\automation%20testing\\src\\test\\java\\TestData\\API.json"));
        JsonNode entitiesNode = rootNode.path("entities");

        for (JsonNode entityNode : entitiesNode) {
            JsonNode entityDetails = entityNode.path("entity");
            JsonNode childrenNode = entityNode.path("children");


            for (JsonNode childNode : childrenNode) {
                JsonNode childEntity = childNode.path("entity");

                apiName = childEntity.path("name").asText();
                Allure.step("API Name: " + apiName);

                // Extract method.name
                methodName = childEntity.path("method").path("name").asText();
                //System.out.println("Method Name: " + methodName);

                // Extract body.textBody
                jsonBody = childEntity.path("body").path("textBody").asText();
                //System.out.println("Body Text: " + jsonBody);

                // Extract uri.path
                String path = childEntity.path("uri").path("path").asText();
                endpoint = preprodApiEndpoint + path;
                //System.out.println("endpoint: " + endpoint);

                // Check if query items are present
                JsonNode queryNode = childEntity.path("uri").path("query").path("items");
                if (queryNode.isArray() && queryNode.size() > 0) {
                    StringBuilder queryParams = new StringBuilder("?");

                    for (JsonNode itemNode : queryNode) {
                        String name = itemNode.path("name").asText();
                        String value = itemNode.path("value").asText();
                        queryParams.append(name).append("=").append(value).append("&");
                    }

                    // Remove the last '&' if present
                    if (queryParams.length() > 1) {
                        queryParams.setLength(queryParams.length() - 1);
                    }

                    // Append query parameters to the endpoint
                    endpoint += queryParams.toString();
                }

                Allure.step("Endpoint: " + endpoint);

                sendRequestAndCheckStatusCode(apiName, methodName, endpoint, jsonBody);
                System.out.println("----------");
            }
        }
    }
}
