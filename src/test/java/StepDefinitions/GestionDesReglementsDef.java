package StepDefinitions;

import Helpers.DashboardHelper;
import Helpers.GestionDesReglementsHelper;
import Helpers.LoginHelper;
import Pages.GestionDesReglementsPage;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class GestionDesReglementsDef {

    public WebDriver driver;
    public DashboardHelper DashboardStep;
    public LoginHelper LoginStep;
    public GestionDesReglementsHelper GestionDesReglementsStep;

    public GestionDesReglementsDef() {
        driver = BrowserDriver.getDriver();
        DashboardStep = new DashboardHelper(driver);
        LoginStep = new LoginHelper(driver);
        GestionDesReglementsStep = new GestionDesReglementsHelper(driver);
    }

    @When("^I select the first facture$")
    public void iSelectTheFirstFacture() throws InterruptedException {
        GestionDesReglementsStep.clickOnFirstRecord();
    }

    @Then("I should be see the correct montant percu, ventilation de la facture and somme de la ventilation")
    public void iShouldBeSeeTheCorrectMontantPercuVentilationDeLaFactureAndSommeDeLaVentilation() {
        GestionDesReglementsStep.getRecordRestantDu();
        GestionDesReglementsStep.getMontantPercu();
        GestionDesReglementsStep.getSumMontantVentilation();
        GestionDesReglementsStep.getSommeDeLaVentilation();
        GestionDesReglementsStep.getRestantDuGestionDesEcartsEtVentilation();
        GestionDesReglementsStep.verifyRestantDuIsEqualToMontantPercuAndVentilationAndSommeDeLaVentilation();
        GestionDesReglementsStep.verifyTypeDecartAndRapprocherButton();
    }

    @And("^I modify the montant percu amount by (.*)$")
    public void iModifyTheMontantPercuAmount(String montant_percu_amount_increment) {
        GestionDesReglementsStep.getMontantPercu();
        GestionDesReglementsStep.modifyMontantPercuAmount(montant_percu_amount_increment);
    }

    @Then("^I should see new amount in ventilation de la facture and somme de la ventilation$")
    public void iShouldSeeNewAmountInVentilationDeLaFactureAndSommeDeLaVentilation() throws InterruptedException {
        GestionDesReglementsStep.getSumMontantVentilation();
        GestionDesReglementsStep.getSommeDeLaVentilation();
        GestionDesReglementsStep.getMontantPercu();
        GestionDesReglementsStep.verifyVentilationAndSommeDeLaVentilationAfterModifyingMontantPercu();
    }

    @And("^I should not be able to click on Rapprocher button$")
    public void iShouldNotBeAbleToClickOnRapprocherButton() {
        GestionDesReglementsStep.getMontantPercu();
        GestionDesReglementsStep.getRestantDuGestionDesEcartsEtVentilation();
        GestionDesReglementsStep.verifyTypeDecartAndRapprocherButton();
    }

    @And("^I should see message (.*)$")
    public void iShouldSeeMessageToSelectTypeDEcart(String err_message) {
        GestionDesReglementsStep.verifyTypeDecartIsMandatory(err_message);
    }

    @And("^I select entity$")
    public void iSelectEntityEntite_de_facturationAndABankBank() throws InterruptedException {
        GestionDesReglementsStep.selectEntiteDeFacturation();
    }

    @And("^I select type d'ecarts (.*)$")
    public void iSelectTypeDEcartsType_decarts(String type_decarts) {
        GestionDesReglementsStep.selectTypeDecart(type_decarts);
    }

    @And("^I chose type d'ecarts (.*) for the three records$")
    public void iSelectTypeDEcartsType_decartsForThreeRecords(String type_decarts) {
        GestionDesReglementsStep.selectTypeDecartForThreeRecords(type_decarts);
    }

    @And("^I should be able to click on Rapprocher button$")
    public void iShouldBeAbleToClickOnRapprocherButton() throws InterruptedException {
        GestionDesReglementsStep.enabledRapprocherButton();
    }

    @When("^I select multiple factures$")
    public void iSelectMultipleFactures() throws InterruptedException {
        GestionDesReglementsStep.clickOnThreeRecords();
        GestionDesReglementsStep.getThreeRecordsRestantDu();
    }

    @Then("^I should be see the total sum of restant du as montant percu, total ventilation de la facture and somme de la ventilation$")
    public void iShouldBeSeeTheTotalSumOfRestantDuAsMontantPercuTotalVentilationDeLaFactureAndSommeDeLaVentilation() {
        GestionDesReglementsStep.getThreeRecordsRestantDu();
        GestionDesReglementsStep.getMontantPercu();
        GestionDesReglementsStep.getSommeDeLaVentilation();
        GestionDesReglementsStep.getSumMontantVentilation();
        GestionDesReglementsStep.getSumOfThreeRestantDuGestionDesEcartsEtVentilation();
        GestionDesReglementsStep.verifyTotalRestantDuIsEqualToMontantPercuAndVentilationAndSommeDeLaVentilation();
        GestionDesReglementsStep.verifyTypeDecartAndRapprocherButton();
    }

    @And("^I adjust the montant ventilation for the first record by (.*)$")
    public void iAdjustTheMontantVentilationForOneOfTheRecordByMontant_percu_amount_increment(String montant_percu_amount_increment) {
        GestionDesReglementsStep.verifyTypeDecartIsMandatory(GestionDesReglementsPage.txtErrMsgSommeDeLaVentilationDiffDuMontantPercu);
        GestionDesReglementsStep.modifyMontantVentilationOfFirstRecord(montant_percu_amount_increment);
        GestionDesReglementsStep.verifyEcartsAfterModifyingVentilation(montant_percu_amount_increment);
    }

    @And("^I should not see type d'ecarts (.*)$")
    public void iShouldNotSeeTypeDEcartsType_decarts(String type_decarts) {
        GestionDesReglementsStep.navigateToTypeEcartFor1FactureSelected();
        GestionDesReglementsStep.verifyTypeDecartNotPresent(type_decarts);
    }

    @And("^I cannot select type d'ecarts (.*)$")
    public void iCannotSelectTypeDEcartsType_decarts(String type_decarts) {
        GestionDesReglementsStep.navigateToTypeEcartFor3FactureSelected();
        GestionDesReglementsStep.verifyTypeDecartNotPresent(type_decarts);
    }
}
