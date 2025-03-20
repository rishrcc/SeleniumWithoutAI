package StepDefinitions;

import Helpers.ClotureEnMasseHelper;
import Helpers.GestionDesStagesHelper;
import Pages.ClotureEnMassePage;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ClotureEnMasseDef {
    public WebDriver driver;
    public ClotureEnMasseHelper ClotureEnMasseStep;
    public GestionDesStagesHelper GestionDesStagesStep;

    public ClotureEnMasseDef() {
        driver = BrowserDriver.getDriver();
        ClotureEnMasseStep = new ClotureEnMasseHelper(driver);
        GestionDesStagesStep = new GestionDesStagesHelper(driver);
    }

    @And("^I select to retrieve all stages of the current year$")
    public void iSelectToRetrieveAllStagesOfTheCurrentYear() throws InterruptedException {
        //ClotureEnMasseStep.filterPeriodeByThisYear();
        ClotureEnMasseStep.filterPeriodeByAll();
    }

    @And("^I see that the end date of stage filter is populated by yesterday date$")
    public void iSeeThatTheEndDateOfStageFilterIsPopulatedByYesterdayDate() throws InterruptedException {
        ClotureEnMasseStep.verifyDateDeFinDuStageFilter();
    }

    @Then("^I should be able to filter by type of stage (.*)$")
    public void iShouldBeAbleToFilterByTypeOfStageType_stage(String type_stage) throws InterruptedException {
        ClotureEnMasseStep.filterByTypeOfStage(type_stage);
        ClotureEnMasseStep.clickOnSearchIcon();
        ClotureEnMasseStep.verifyFilteredTypeOfStage(type_stage);
    }

    @And("^I should be able to filter by state of stage (.*)$")
    public void iShouldBeAbleToFilterByStageOfStageState_stage(String state_stage) throws InterruptedException {
        ClotureEnMasseStep.filterByStateOfStage(state_stage);
        ClotureEnMasseStep.clickOnSearchIcon();
        ClotureEnMasseStep.verifyFilteredStateOfStage(state_stage);
    }

    @And("^I should be able to filter by cursus of stage (.*)$")
    public void iShouldBeAbleToFilterByCursusOfStageCursus_stage(String cursus_stage) throws InterruptedException {
        ClotureEnMasseStep.filterByCursusOfStage(cursus_stage);
        ClotureEnMasseStep.clickOnSearchIcon();
        ClotureEnMasseStep.verifyFilteredCursusOfStage(cursus_stage);
    }

    @And("^I select multiple stages at the same time$")
    public void iSelectTwoStagesAtTheSameTime() throws InterruptedException {
        ClotureEnMasseStep.selectMultiplestages(4,5);
    }

    @When("^I click on (.*) the cloture en masse$")
    public void iClickOnActionTheClotureEnMasse(String action) throws InterruptedException {
        ClotureEnMasseStep.clickOnCloturer(action);
    }

    @Then("^I should expect the stage in the list to be deleted$")
    public void iShouldNotSeeTheDeletedStageInTheList() throws InterruptedException {
        ClotureEnMasseStep.verifyThatTheDeletedStageIsNotInTheList();
    }

    @Then("I should expect the stage in the list to not be deleted")
    public void iShouldExpectTheStageInTheListToNotBeDeleted() throws InterruptedException {
        ClotureEnMasseStep.verifyThatStageIsInTheList();
    }

    @And("^I click on date reset button$")
    public void iClickOnDateResetButton() throws InterruptedException {
        ClotureEnMasseStep.clickOnDateDeFinResetIcon();
    }

    @When("^I click on Edit button for the first stage in the list$")
    public void iClickOnEditButtonForTheFirstStageInTheList() throws InterruptedException {
        ClotureEnMasseStep.clickOnDateDeFinResetIcon();
        ClotureEnMasseStep.clickOnEditStage();
    }

    @Then("^I should be able to edit the cursus of the stage$")
    public void iShouldBeAbleToEditTheCursusOfTheStage() throws InterruptedException {
        GestionDesStagesStep.addCursusOnVue360();
        GestionDesStagesStep.saveTheStageOnVue360();
        GestionDesStagesStep.clickOnRetour();
        ClotureEnMasseStep.verifyNewCursusAfterEditing();
    }
}
