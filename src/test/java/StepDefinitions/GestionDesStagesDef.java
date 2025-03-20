package StepDefinitions;

import Helpers.DashboardHelper;
import Helpers.GestionDesStagesHelper;
import Helpers.LoginHelper;
import Pages.EffectifPage;
import Pages.SuiviDesStagesPage;
import Pages.Vue360Page;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GestionDesStagesDef {

    public WebDriver driver;
    public LoginHelper LoginStep;
    public DashboardHelper DashboardStep;
    public GestionDesStagesHelper GestionDesStagesStep;

    public GestionDesStagesDef() {
        driver = BrowserDriver.getDriver();
        GestionDesStagesStep = new GestionDesStagesHelper(driver);
        LoginStep = new LoginHelper(driver);
        DashboardStep = new DashboardHelper(driver);
    }

    @When("^I click on Creer un stage$")
    public void IClickOnCreerUnStage() throws InterruptedException {
        GestionDesStagesStep.clickOnCreateNewStage();
        GestionDesStagesStep.clickOnCreateNewStageOfTypeCatalogueProduit();
    }

    @Then("^I should be able to create a new stage with catalogues (.*), categories (.*), produits (.*), type (.*), etat (.*)$")
    public void iShouldBeAbleToCreateANewStage(String catalogues, String categories, String produits, String type, String etat) throws InterruptedException {

        GestionDesStagesStep.selectCatalogue(catalogues);
        GestionDesStagesStep.selectCategory(categories);
        GestionDesStagesStep.selectProduit(produits);
        GestionDesStagesStep.selectTypeOnCreateStageForm(type);
        GestionDesStagesStep.selectEtatOnCreateStageForm(etat);
        GestionDesStagesStep.enterStartDateAndEndDate();
        GestionDesStagesStep.saveNewStage();
        GestionDesStagesStep.verifyProduitsHeaderOnVue360(produits);
        //GestionDesStagesStep.verifyStartDateAndEndDateArePopulatedInVue360();
    }

    @When("^I click on a card item$")
    public void iClickOnACard() throws InterruptedException {

        GestionDesStagesStep.clickOnLastCreatedStage();
    }

    @And("^I click on Effectif$")
    public void iClickOnEffectif() {
        GestionDesStagesStep.clickOnEffectif();
        GestionDesStagesStep.removeAllClientFromEffectif();
    }

    @Then("^I should be able to create an individuel client with civilite (.*), lastname (.*), firstname (.*), function (.*), group de (.*) on the stage$")
    public void iShouldBeAbleToCreateAnIndividuelClientOnTheStage(String civilite, String nom, String prenom, String function, String groupe_de) throws InterruptedException {

        GestionDesStagesStep.clickOnClientPlusSignAndCreer();
        GestionDesStagesStep.clickOnClientIndividuel();
        GestionDesStagesStep.inputPersonalInfoOnCreateClientIndividuelForm(civilite,nom,prenom,function,groupe_de);
        GestionDesStagesStep.saveClientIndividuel();
    }

    @And("^I should see the client lastname (.*) and firstname (.*) listed under Clients$")
    public void iShouldSeeTheClientListedUnderClients(String nom, String prenom) throws InterruptedException {
        GestionDesStagesStep.verifyClientUnderClientBlock(nom,prenom);
    }

    @And("^I should see the client lastname (.*) and firstname (.*) listed under Apprenants$")
    public void iShouldSeeTheClientListedUnderApprenants(String nom, String prenom) {
        GestionDesStagesStep.verifyApprenantUnderClientBlock(nom, prenom);
    }

    @And("^the BPF of client should be listed as activity (.*) upon edit$")
    public void theBPFOfClientShouldBeListedAsIndividuelUponEdit(String BPF) {
        GestionDesStagesStep.clickOnEditClientEffectif();
        GestionDesStagesStep.verifyActiviteBPF(BPF);
    }

    @Given("^I create an apprenant in the Effectif with civilite (.*), lastname (.*), firstname (.*), function (.*), group de (.*) on the stage$")
    public void iCreateAnApprenantInTheEffectif(String civilite, String nom, String prenom, String function, String groupe_de) throws InterruptedException {
        LoginStep.userLogin();
        DashboardStep.navigateToGestionDesStages();
        DashboardStep.navigateToSuiviDesStages();
        GestionDesStagesStep.clickOnLastCreatedStage();
        GestionDesStagesStep.clickOnEffectif();
        GestionDesStagesStep.getInitialCountOfApprenant(EffectifPage.getCountofApprenants);
        GestionDesStagesStep.clickOnApprenantPlusSignAndCreer();
        GestionDesStagesStep.selectClientAssocier();
        GestionDesStagesStep.inputPersonalInfoOnCreateClientIndividuelForm(civilite,nom,prenom,function,groupe_de);
        GestionDesStagesStep.saveClientIndividuel();
        GestionDesStagesStep.getFinalCountOfApprenant(groupe_de,EffectifPage.getCountofApprenants);
        GestionDesStagesStep.verifyApprenantUnderClientBlock(nom, prenom);
    }

    @When("^I navigate to Vue 360 edit page$")
    public void iNavigateToVueEditPage() {
        GestionDesStagesStep.navigateToVue306();
        GestionDesStagesStep.clickOnEditVue306();
    }

    @Then("^I should see the correct number listed in Nb stag inscrits field$")
    public void iShouldSeeTheCorrectNumberListedInNbStagInscritsField() throws InterruptedException {
        GestionDesStagesStep.verifyNbStagInscrits();
    }

    @Given("^I change the groupe de (.*) of an apprenant in Vue360$")
    public void iChangeTheGroupeDeGroupe_deOfAnApprenantInVue(String groupe_de_increment) throws InterruptedException {
        LoginStep.userLogin();
        DashboardStep.navigateToGestionDesStages();
        DashboardStep.navigateToSuiviDesStages();
        GestionDesStagesStep.clickOnLastCreatedStage();
        GestionDesStagesStep.navigateToVue306();
        GestionDesStagesStep.getInitialCountOfApprenant(Vue360Page.getCountOfApprenants);
        GestionDesStagesStep.clickOnApprenantEditButtonVue360();
        GestionDesStagesStep.editGroupDefieldonVue360(groupe_de_increment);
        GestionDesStagesStep.saveClientIndividuel();
        GestionDesStagesStep.getFinalCountOfApprenant(groupe_de_increment,Vue360Page.getCountOfApprenants);
    }
}
