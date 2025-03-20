package StepDefinitions;

import Helpers.DashboardHelper;
import Helpers.GestionDesReglementsHelper;
import Helpers.LoginHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DashboardDef {

    public WebDriver driver;
    public DashboardHelper DashboardStep;
    public LoginHelper LoginStep;

    public GestionDesReglementsHelper GestionDesReglementsStep;

    public DashboardDef() {
        driver = BrowserDriver.getDriver();
        DashboardStep = new DashboardHelper(driver);
        LoginStep = new LoginHelper(driver);
        GestionDesReglementsStep = new GestionDesReglementsHelper(driver);
    }

    @When("^I navigate to Gestion des formateur$")
    public void iNavigateToGestionDesFormateur() {
        DashboardStep.navigateToGestionDesStages();
        DashboardStep.navigateToGestionDesFormateurs();
    }

    @Given("^I am on Suivi des stages menu$")
    public void iAmOnSuiviDesStagesMenu() {
        LoginStep.userLogin();
        DashboardStep.navigateToGestionDesStages();
        DashboardStep.navigateToSuiviDesStages();
    }

    @Given("^I am Gestion des reglements page$")
    public void iAmGestionDesReglementsPage() throws InterruptedException {
        LoginStep.userLogin();
        DashboardStep.clickOnMenuGrid();
        DashboardStep.navigateToFacturation();
        DashboardStep.navigateToGestionDesReglements();
        GestionDesReglementsStep.verifyReglementsHeaderMenu();
    }

    @Given("^I am on Action commerciale page$")
    public void iamOnActionCommercialePage() throws InterruptedException {
        LoginStep.userLogin();
        DashboardStep.clickOnMenuGrid();
        DashboardStep.navigateToGestionCommerciale();
        DashboardStep.navigateToActionsCommerciales();
    }

    @Given("^I on Gestion des lieux page$")
    public void iamOnGestionDesLieuxPage() throws InterruptedException {
        LoginStep.userLogin();
        DashboardStep.clickOnMenuGrid();
        DashboardStep.navigateToAdministration();
        DashboardStep.navigateToGestionDesLieux();
    }
    @And("^I search for a personne morale of type (.*)$")
    public void iSearchForAPersonneMoraleOfTypeType(String type) throws InterruptedException {
        DashboardStep.selectPersonneMoraleOfType(type);
        DashboardStep.clickOnSearch();
    }

    @When("^I click on enregistrer button on the (.*) tab$")
    public void iClickOnEnregistrerButtonOnTheTypeTab(String type) throws InterruptedException {
        DashboardStep.selectFirstElementInList();
        //DashboardStep.selectTabOfType(type);
        DashboardStep.clickOnSave();
    }

    @Then("^I should not see error message$")
    public void iShouldNotSeeErrorMessage() throws InterruptedException {
        DashboardStep.clickOnSave();
    }

    @Given("^I am on Cloture en masse page$")
    public void iAmOnClotureEnMassePage() throws InterruptedException {
        LoginStep.userLogin();
        DashboardStep.clickOnMenuGrid();
        DashboardStep.navigateToAdministration();
        DashboardStep.navigateToClotureEnMassePage();
    }

    @Given("^I am on Catalogue Produits page$")
    public void iAmOnCatalogueProduitsPage() throws InterruptedException {
        LoginStep.userLogin();
        DashboardStep.clickOnMenuGrid();
        DashboardStep.navigateToAdministration();
        DashboardStep.navigateToCatalogueProduits();
    }
}
