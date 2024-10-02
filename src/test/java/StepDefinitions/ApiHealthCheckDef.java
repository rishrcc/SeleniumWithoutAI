package StepDefinitions;
import Helpers.APIHealthCheckHelper;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class ApiHealthCheckDef {


    @Given("^All apis should return 200 status code$")
    public void iSendRequest() throws InterruptedException, IOException {
        APIHealthCheckHelper.readJsonAndSendRequests();
    }
}
