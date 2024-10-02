package Utility;


import io.cucumber.java.Scenario;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendResult {

    public static SendResult instance;
    public List<String> results;
    public static Map<String, List<String>> featureResults = new HashMap<>();

    //public static final String RESET = "</span>";
    public static final String RED = "\\u274C";
    public static final String GREEN = "\\u2714";
    //public static final String BLUE = "<span style='color:blue'>";

    public SendResult()
    {
        results = new ArrayList<>();
    }

    public static synchronized SendResult getInstance() {
        if (instance == null) {
            instance = new SendResult();
        }
        return instance;
    }

    public void addResult(String result) {
        results.add(result);
    }

    public List<String> getResults() {
        return results;
    }

    public static void addResultTolist(Scenario scenario) {

        String fullFileName = scenario.getUri().toString();
        String[] parts = fullFileName.split("/");
        String fileNameWithExtension = parts[parts.length - 1];


        String featureName = fileNameWithExtension.replace(".feature", "");
        String status = scenario.isFailed() ? "FAILED" : "PASSED";
        String coloredStatus;

        switch (status) {
            case "FAILED":
                coloredStatus = RED; //+ "FAILED" + RESET;
                break;
            case "PASSED":
                coloredStatus = GREEN; //+ "PASSED" + RESET;
                break;
            default:
                coloredStatus = GREEN; //+ "WARNING" + RESET;
                break;
        }

        String message = String.format("%s - %s%n", scenario.getName(), coloredStatus);
        featureResults.computeIfAbsent(featureName, k -> new ArrayList<>()).add(message);
    }

    public static void formatAndStoreFinalResults() {
        StringBuilder resultMessage = new StringBuilder();

        // Format the entire message grouping by feature name
        for (Map.Entry<String, List<String>> entry : featureResults.entrySet()) {
            resultMessage.append(entry.getKey()).append(":\n");
            List<String> testResults = entry.getValue();
            for (int i = 0; i < testResults.size(); i++) {
                resultMessage.append("\t").append(i + 1).append(". ").append(testResults.get(i)).append("\n");
            }
        }

        // Store the final formatted result
        SendResult.getInstance().addResult(resultMessage.toString());
    }


    public static void sendReportToGoogle() throws URISyntaxException, IOException {

        String apiUrl = "https://chat.googleapis.com/v1/spaces/AAAALflqFH8/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=3bWMGsJvBpYDuGvqqbm4eYnSLFJfeOgtrfyLd_t6_CE";
        List<String> results = SendResult.getInstance().getResults();
        String message = String.join("\n", results);

        URI url = new URI(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String jsonPayload = "{\"text\": \"" + message + "\"}";

        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(jsonPayload);
            outputStream.flush();
        }
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}
