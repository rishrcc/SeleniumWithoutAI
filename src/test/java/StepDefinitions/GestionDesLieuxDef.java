package StepDefinitions;

import Helpers.DashboardHelper;
import Helpers.GestionDesLieuxHelper;
import Helpers.GestionDesStagesHelper;
import Helpers.LoginHelper;
import Pages.GestionDesLieuxPage;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class GestionDesLieuxDef {

    public GestionDesLieuxHelper GestionDesLieuxStep;
    public DashboardHelper DashboardStep;
    public GestionDesStagesHelper GestionDesStagesStep;

    public WebDriver driver;

    public GestionDesLieuxDef() {
        driver = BrowserDriver.getDriver();
        GestionDesLieuxStep = new GestionDesLieuxHelper(driver);
        DashboardStep =  new DashboardHelper(driver);
        GestionDesStagesStep = new GestionDesStagesHelper(driver);
    }

    @When("^I click on Nouveau$")
    public void IClickOnNouveau() throws InterruptedException {
        GestionDesLieuxStep.clickOnNouveau();
    }

    @Then("^I should be able to create new lieux with denomination (.*), address 1 (.*),address 2 (.*), complement (.*), ville code (.*), ville address (.*) and country (.*)$")
    public void iShouldBeAbleToCreateNewLieuxWithDenominationDenominationAddressAdresse_AddressAdresse_ComplementComplementVilleCodeVille_codeVilleAddressVille_adresseAndCountryPays(String denomination, String adresse_1, String adresse_2, String complement, String ville_code, String ville_adresse, String country) throws InterruptedException {
        GestionDesLieuxStep.fillCreationFormOfNewLieu(denomination, adresse_1, adresse_2, complement, ville_code, ville_adresse, country);
        GestionDesLieuxStep.clickOnEnregistrer();
        GestionDesLieuxStep.verifyNewLieuxHasBeenCreated();
    }

    @Then("^I should see denomination A of the lieu (.*) alphabetically ordered with respect to denomination B of lieu (.*)$")
    public void iShouldSeeDenominationAOfTheLieuDenomination_AlphabeticallyOrderedWithRespectToDenominationBOfLieuDenomination(String denomination_1, String denomination_2) throws InterruptedException {
        GestionDesLieuxStep.verifyDenominationsAreAlphabeticallyOrdered(denomination_1,denomination_2);
    }

    @Then("^I should not be able to create new lieux without denomination$")
    public void iShouldNotBeAbleToCreateNewLieuxWithoutDenomination() throws InterruptedException {
        GestionDesLieuxStep.fillCreationFormOfNewLieu("", "test", "test", "test", "0", "test", "test");
        GestionDesLieuxStep.clickOnEnregistrer();
        GestionDesLieuxStep.verifyMandatoryErrMessage();
    }

    @Then("^I should not be able to create new lieux with only space as denomination value$")
    public void iShouldNotBeAbleToCreateNewLieuxWithOnlySpaceAsDenominationValue() throws InterruptedException {
        GestionDesLieuxStep.fillCreationFormOfNewLieu(" ", "test", "test", "test", "0", "test", "test");
        GestionDesLieuxStep.clickOnEnregistrer();
        GestionDesLieuxStep.verifyMandatoryErrMessage();
    }

    @Then("^I should not be able to create new lieux if I click on annuler button$")
    public void iShouldNotBeAbleToCreateNewLieuxIfIClickOnAnnulerButton() throws InterruptedException {
        GestionDesLieuxStep.fillCreationFormOfNewLieu("Denomination Value", "test", "test", "test", "0", "test", "test");
        GestionDesLieuxStep.clickOnAnnulerButton();
        GestionDesLieuxStep.verifyNewLieuNotCreated();
    }

    @And("^I should to create new lieux$")
    public void iShouldToCreateNewLieux() throws InterruptedException {
        GestionDesLieuxStep.fillCreationFormOfNewLieu();
        GestionDesLieuxStep.clickOnEnregistrer();
        GestionDesLieuxStep.verifyNewLieuxHasBeenCreated();
    }

    @Then("^I should see the new lieu in Effectif tab under suivi des stages$")
    public void iShouldSeeTheNewLieuInEffectifTabUnderSuiviDesStages() throws InterruptedException {
        DashboardStep.clickOnMenuGrid();
        DashboardStep.navigateToGestionFormation();
        DashboardStep.navigateToGestionDesStages();
        DashboardStep.navigateToSuiviDesStages();
        GestionDesStagesStep.clickOnLastCreatedStage();
        GestionDesStagesStep.clickOnEffectif();
        GestionDesStagesStep.clickOnLieuIcon();
        GestionDesLieuxStep.verifyDenominationIsPresentInEffectifLieu();
    }

    @Then("I should see the new lieu in Planning tab under suivi des stages")
    public void iShouldSeeTheNewLieuInPlanningTabUnderSuiviDesStages() throws InterruptedException {
        DashboardStep.clickOnMenuGrid();
        DashboardStep.navigateToGestionFormation();
        DashboardStep.navigateToGestionDesStages();
        DashboardStep.navigateToSuiviDesStages();
        GestionDesStagesStep.clickOnLastCreatedStage();
        GestionDesStagesStep.clickOnPlanning();
        GestionDesLieuxStep.verifyDenominationIsPresentInPlanningLieu();
    }

    @When("^I search for a lieu using (.*) as a search criteria$")
    public void iSearchForALieuUsingKeywordAsASearchCriteria(String keyword) throws InterruptedException {
        GestionDesLieuxStep.searchForKeyword(keyword);
    }

    @Then("^I should see only the lieu with (.*) displayed$")
    public void iShouldSeeOnlyTheLieuWithKeywordDisplayed(String keyword) throws InterruptedException {
        GestionDesLieuxStep.verifySearchResultsContainKeyword(keyword);
    }

    @Then("^I should not see any lieu displayed$")
    public void iShouldNotSeeAnyLieuDisplayed() throws InterruptedException {
        GestionDesLieuxStep.verifyNoResultsAreDisplayed();

    }

    @When("^I click on the last lieu in the page$")
    public void iClickOnTheLastLieuInThePage() throws InterruptedException {
        GestionDesLieuxStep.clickOnLastLieu();
    }

    @Then("^I should be able to modify the denomination name to new denomination$")
    public void iShouldBeAbleToModifyTheDenominationNameToNew_denomination() throws InterruptedException {
        String new_denomination = GestionDesLieuxStep.fillCreationFormOfNewLieu();
        GestionDesLieuxStep.clickOnEnregistrer();
        GestionDesLieuxStep.searchForKeyword(new_denomination);
        GestionDesLieuxStep.verifySearchResultsContainKeyword(new_denomination);
    }

    @Then("^I should be able to delete the lieu (.*)$")
    public void iShouldBeAbleToDeleteTheLieu(String keyword) throws InterruptedException {
        GestionDesLieuxStep.verifyLieuCanBeDeleted();
        GestionDesLieuxStep.agreeToDeleteLieu(keyword);
        GestionDesLieuxStep.verifyLieuIsDeleted(keyword);
    }

    @And("^I should be able to consult the newly created lieux with denomination (.*), address 1 (.*),address 2 (.*), complement (.*), ville code (.*), ville address (.*) and country (.*)$")
    public void iShouldBeAbleToConsultTheNewlyCreatedLieuxWithDenominationDenominationAddressAdresse_AddressAdresse_ComplementComplementVilleCodeVille_codeVilleAddressVille_adresseAndCountryPays(String denomination, String adresse_1, String adresse_2, String complement, String ville_code, String ville_adresse, String country) throws InterruptedException {
        GestionDesLieuxStep.searchForKeyword(denomination);
        GestionDesLieuxStep.verifySearchResultsContainKeyword(denomination);
        GestionDesLieuxStep.clickOnLastLieu();
        GestionDesLieuxStep.verifyLieuHasBeenCreatedWithCorrectInfo(denomination, adresse_1, adresse_2, complement, ville_code, ville_adresse, country);
    }
}
