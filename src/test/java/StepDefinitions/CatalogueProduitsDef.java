package StepDefinitions;

import Helpers.CatalogueProduitsHelper;
import Helpers.DashboardHelper;
import Helpers.GestionDesReglementsHelper;
import Helpers.LoginHelper;
import Pages.CatalogueProduitsPage;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CatalogueProduitsDef {

    public WebDriver driver;
    public DashboardHelper DashboardStep;
    public LoginHelper LoginStep;
    public CatalogueProduitsHelper CatalogueProduitsStep;


    public CatalogueProduitsDef() {
        driver = BrowserDriver.getDriver();
        DashboardStep = new DashboardHelper(driver);
        LoginStep = new LoginHelper(driver);
        CatalogueProduitsStep = new CatalogueProduitsHelper(driver);
    }

    @When("^I click on Nouveau button to create new catalogue$")
    public void iClickOnNouveauButtonForNewCatalogue() throws InterruptedException {
        CatalogueProduitsStep.clickOnNouveauCatalogueButton();
    }

    @Then("^I should be able to create new catalogues with name (.*)$")
    public void iCreateCataloguesWithNames(String name) throws InterruptedException {
        CatalogueProduitsStep.createCatalogue(name);
        CatalogueProduitsStep.verifyNewCatalogueHasBeenCreated();
    }

    @Then("^I should see catalogue A (.*) alphabetically ordered with respect to catalogue B (.*)$")
    public void iShouldSeeCatalogueANameAlphabeticallyOrderedWithRespectToCatalogueBName(String name_1, String name_2) throws InterruptedException {
        CatalogueProduitsStep.verifyCataloguesAreAlphabeticallyOrdered(name_1,name_2);
    }

    @When("^I search for a catalogue using (.*) as a search criteria$")
    public void iSearchForACatlogueUsingTitleAsASearchCriteria(String title) throws InterruptedException {
        CatalogueProduitsStep.searchForCatalogue(title);
    }

    @Then("^I should see only the catalogues with (.*) displayed$")
    public void iShouldSeeOnlyTheCataloguesWithTitleDisplayed(String title) throws InterruptedException {
        CatalogueProduitsStep.verifySearchResultsContainTitle(title);
    }

    @Then("^I should not see any catalogue displayed$")
    public void iShouldNotSeeAnyCatalogueDisplayed() throws InterruptedException {
        CatalogueProduitsStep.verifyNoCataloguesAreDisplayed();
    }

    @When("^I click on the last catalogue listed$")
    public void iClickOnTheLastCatalogueListed() throws InterruptedException {
        CatalogueProduitsStep.clickOnLastCatalogue();
    }

    @Then("^I should be able to delete the catalogue$")
    public void iShouldBeAbleToDeleteTheCatalogue() throws InterruptedException {
        CatalogueProduitsStep.clickOnSupprimerCatalogue();
        CatalogueProduitsStep.confirmDeletionOnModal();
        CatalogueProduitsStep.verifyCatalogueHasBeenDeleted();
    }

    @Then("^I should be able to edit name of catalogue from title (.*) to (.*), collaborateur (.*), publiable webstore and devis$")
    public void iShouldBeAbleToEditNameOfCatalogueToNameCollaborateurCollaborateurPubliableWebstorePubliableAndDevisDevis(String title, String name, String collaborateur) throws InterruptedException {
        CatalogueProduitsStep.changeNomDuCatalogue(name);
        CatalogueProduitsStep.changeCollaborateur(collaborateur);
        CatalogueProduitsStep.changePubliableWebStoreCatalogue();
        CatalogueProduitsStep.changeUsedInDevisCatalogue();
        CatalogueProduitsStep.clickOnRetourALaListeDesCatalogues();
        CatalogueProduitsStep.searchForCatalogue(title);
        CatalogueProduitsStep.verifyCatalogueHasBeenDeleted();
    }

    @Then("^I should be able to create new category with column name (.*)$")
    public void iShouldBeAbleToCreateNewCategoryWithColumnNameName(String name) {
        CatalogueProduitsStep.addNewCategory(name);
    }

    @Then("^I should see category (.*) alphabetically ordered with respect to category (.*)$")
    public void iShouldSeeCategoryNom_AlphabeticallyOrderedWithRespectToCategoryNom(String nom_1, String nom_2) throws InterruptedException {
        CatalogueProduitsStep.verifyCategoriesAreAlphabeticallyOrdered(nom_1,nom_2);
    }

    @And("^I click on edit button for the first category$")
    public void iClickOnEditButtonForTheFirstCategory() {
        CatalogueProduitsStep.clickOnEditCategory();
    }

    @And("^I should be able to modify the title to (.*), add an info (.*), set a collaborateur (.*)$")
    public void iShouldBeAbleToModifyTheTitleToNew_titleAddAnInfoNew_infoSetACollaborateurNew_collaborateur(String new_title, String new_info, String new_collaborateur) throws InterruptedException {
        CatalogueProduitsStep.setNewCategoryTitle(new_title);
        CatalogueProduitsStep.setCategoryCollaborateur(new_collaborateur);
        CatalogueProduitsStep.setNewInfoForCategory(new_info);
        CatalogueProduitsStep.setCategoryPubliableWebstore();
        CatalogueProduitsStep.clickOnEnregistrerCategory();
    }

    @When("^I click on ajouter un produit for the last category$")
    public void iClickOnAjouterUnProduitForTheLastCategory() throws InterruptedException {
        CatalogueProduitsStep.clickOnLastAjouterUnProduitButton();
    }

    @Then("^I should be to add a new webstore publiable produit with intitule (.*), code (.*), tarif (.*), plan de fac (.*) for the catalogue$")
    public void iShouldBeToAddANewWebstorePubliableProduitWithIntituleIntituleCodeCodeTarifTarifPlanDeFacPlan_facForTheCatalogue(String intitule, String code, String tarif, String plan_fac) throws InterruptedException {
        CatalogueProduitsStep.createNewProductPubliableWebstore(intitule,code,tarif,plan_fac);
    }

    @When("^I click on supprimer for the catalogue$")
    public void iClickOnSupprimerForTheCatalogue() {
        CatalogueProduitsStep.clickOnSupprimerCatalogue();
        CatalogueProduitsStep.confirmDeletionOnModal();
    }

    @Then("^I should see the error message that catalogue cannot be deleted (.*)$")
    public void iShouldSeeTheErrorMessageThatCatalogueCannotBeDeletedCannot_delete_catalogue(String cannot_delete_catalogue) {
        CatalogueProduitsStep.verifyCatalogCannotBeDeleted(cannot_delete_catalogue);
    }
}
