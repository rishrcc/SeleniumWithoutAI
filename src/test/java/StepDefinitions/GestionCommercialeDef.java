package StepDefinitions;

import Helpers.GestionCommercialeHelper;
import Helpers.GestionDesStagesHelper;
import Helpers.LoginHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class GestionCommercialeDef {

    public WebDriver driver;
    public LoginHelper LoginStep;
    public GestionCommercialeHelper GestionCommercialeStep;
    public GestionDesStagesHelper GestionDesStagesStep;

    public GestionCommercialeDef() {
        driver = BrowserDriver.getDriver();
        LoginStep = new LoginHelper(driver);
        GestionCommercialeStep = new GestionCommercialeHelper(driver);
        GestionDesStagesStep = new GestionDesStagesHelper(driver);
    }

    @When("^I search (.*) by (.*)$")
    public void iSearchClientBySearch_condition(String client, String search_condition) throws InterruptedException {
        GestionCommercialeStep.chooseSearchCondition(search_condition);
        GestionCommercialeStep.enterSearchCriteria(client, search_condition);
    }

    @And("^I click on any of the card of the client(.*)$")
    public void iClickOnAnyOfTheCard(String client_link) {
        GestionCommercialeStep.clickOnFirstCard(client_link);
    }

    @Then("^I should see respective type of PM (.*) on Action page$")
    public void iShouldSeeRespectiveTypeOfPMType_pmOnActionPage(String type_pm) {
        GestionCommercialeStep.clickOnActionTab();
        GestionCommercialeStep.verifyClientTypeOfPM(type_pm);
    }

    @When("^I create a new action of type (.*)$")
    public void iCreateANewActionOfTypeAction_type(String action_type) throws InterruptedException {
        GestionCommercialeStep.clickOnNouvelleAction();
        GestionCommercialeStep.clickOnActionType(action_type);
    }

    @And("^I select personne morale as (.*) and as type of PM (.*)$")
    public void iSelectPersonneMoraleAsPersonne_morale(String personne_morale, String type_pm) {
        GestionCommercialeStep.selectPersonneMorale(personne_morale);
        GestionCommercialeStep.selectTypePM(type_pm);
    }

    @And("^I create an individuel client with civilite (.*), lastname (.*), firstname (.*), function (.*), group de (.*) on the stage$")
    public void iCreateAnIndividuelClientWithCiviliteCiviliteLastnameNomFirstnamePrenomFunctionFunctionGroupDeGroupe_deOnTheStage(String civilite, String nom, String prenom, String function, String groupe_de) {
        GestionDesStagesStep.inputPersonalInfoOnCreateClientIndividuelForm(civilite,nom,prenom,function,groupe_de);
        GestionDesStagesStep.saveClientIndividuel();
    }

    @Then("^I should see fullname consisting of (.*) and (.*) as Personne Morale$")
    public void iShouldSeeFullnameConsistingOfNomAndPrenomAsPersonneMorale(String nom, String prenom) throws InterruptedException {
        GestionCommercialeStep.verifyPersonneMoraleIsPopulated(nom,prenom);
    }

    @And("^I should see fullname consisting of (.*) and (.*) as Contact principal$")
    public void iShouldSeeFullnameConsistingOfNomAndPrenomAsContactPrincipal(String nom, String prenom) {
        GestionCommercialeStep.verifyContactPrincipalIsPopulated(nom,prenom);
    }

    @And("^I should see fullname consisting of (.*) and (.*) as Contact under Devis tab$")
    public void iShouldSeeFullnameConsistingOfNomAndPrenomAsContactUnderDevisTab(String nom, String prenom) throws InterruptedException {
        GestionCommercialeStep.selectCollaborateur();
        GestionCommercialeStep.clickOnSave();
        GestionCommercialeStep.clickOnDevisTab();
        GestionCommercialeStep.verifyContactIsPopulatedForContactUnderDevis(nom,prenom);
    }

    @And("^I should see fullname consisting of (.*) and (.*) as Contact principal under Devis tab$")
    public void iShouldSeeFullnameConsistingOfNomAndPrenomAsContactPrincipalUnderDevisTab(String nom, String prenom) {
        GestionCommercialeStep.verifyContactPrincipalIsPopulatedForContactUnderDevis(nom,prenom);
    }
}
