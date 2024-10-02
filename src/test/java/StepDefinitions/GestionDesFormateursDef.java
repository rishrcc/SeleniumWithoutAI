package StepDefinitions;

import Helpers.DashboardHelper;
import Helpers.GestionDesFormateurHelper;
import Helpers.LoginHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class GestionDesFormateursDef {

    public WebDriver driver;
    public GestionDesFormateurHelper GestionDesFormateurStep;
    public LoginHelper LoginStep;
    public DashboardHelper DashboardStep;

    public GestionDesFormateursDef() {
        driver = BrowserDriver.getDriver();
        GestionDesFormateurStep = new GestionDesFormateurHelper(driver);
        LoginStep = new LoginHelper(driver);
        DashboardStep = new DashboardHelper(driver);
    }

    @Then("^I should see the title Gestion des formateur displayed$")
    public void iShouldSeeTheTitleGestionDesFormateurDisplayed() {
        GestionDesFormateurStep.verifyGestionDesFormateurTitle();
    }

    @Given("^I am on Gestion des formateur page$")
    public void iAmOnGestionDesFormateurPage() {
        LoginStep.userLogin();
        DashboardStep.navigateToGestionDesStages();
        DashboardStep.navigateToGestionDesFormateurs();
        GestionDesFormateurStep.verifyGestionDesFormateurTitle();
    }

    @When("^I click on New button for a formateur$")
    public void iClickOnNewButton() {
        GestionDesFormateurStep.clickOnCreateNewFormateur();
    }

    @Then("^I should be able to create a new formateur with civilite (.*), lastname (.*), firstname (.*), initiale (.*), type de contrat (.*) on the formateur page$")
    public void iShouldBeAbleToCreateANewFormateurWithCiviliteCiviliteLastnameNomFirstnamePrenomInitialeInitialesTypeDeContratBPFType_de_contratOnTheFormateurPage(String civilite, String nom, String prenom, String initiales, String type_de_contrat) throws InterruptedException {
        GestionDesFormateurStep.inputFormateurDetails(civilite, nom, prenom, initiales, type_de_contrat);
        GestionDesFormateurStep.clickOnSave();
        GestionDesFormateurStep.verifyFormateurHasBeenCreated(nom, prenom);
    }

    @Then("^I should see lastname of the formateur A (.*) alphabetically ordered with respect to lastname of formateur B (.*)$")
    public void lastnameOfTheFormateurANom_ShouldBeAlphabeticallyOrderedWithRespectToLastnameOfFormateurBNom_(String nom_1, String nom_2) throws InterruptedException {
        GestionDesFormateurStep.verifyLastnamesAreAlphabeticallyOrdered(nom_1, nom_2);
    }

    @When("^I click on the last formateur card on the Gestion des formateurs page$")
    public void iClickOnTheLastFormateurCardOnTheGestionDesFormateursPage() {
        GestionDesFormateurStep.clickOnTheLastCard();
    }

    @And("^I attach a document of document status (.*) under submenu document status (.*)$")
    public void iAttachADocumentOfDocumentStatusDocument_statusUnderSubmenuDocumentStatusSub_menu_document_status(String document_status, String sub_menu_document_status) throws InterruptedException, AWTException {
        GestionDesFormateurStep.navigateToDocumentPage();
        GestionDesFormateurStep.clickOnDocumentStatusSubMenu(sub_menu_document_status);
        GestionDesFormateurStep.addDocumentWithStatus(document_status, sub_menu_document_status);
    }
}
