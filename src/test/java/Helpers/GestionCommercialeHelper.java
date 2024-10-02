package Helpers;

import Pages.GestionCommercialePage;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GestionCommercialeHelper extends BrowserDriver {

    public WebDriverWait wait;
    String parametrizedSearchConditionXpath;
    String parametrizedSearchFieldXpath;

    public GestionCommercialeHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void chooseSearchCondition(String search_condition) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.btnSelectSearchCategory)));
        driver.findElement(By.xpath(GestionCommercialePage.btnSelectSearchCategory)).click();

        if (search_condition.equals("Donneur d'ordre")) {
            String[] parts = search_condition.split(" ");
            String firstPart = parts[0].trim();
            parametrizedSearchConditionXpath = String.format(GestionCommercialePage.valueSearchBy, firstPart);
        } else if (search_condition.equals("Contact")) {
            String multiElementsparametrizedSearchConditionXpath = String.format(GestionCommercialePage.valueSearchBy, search_condition);
            parametrizedSearchConditionXpath = "(" + multiElementsparametrizedSearchConditionXpath + ")[2]";
        } else {
            parametrizedSearchConditionXpath = String.format(GestionCommercialePage.valueSearchBy, search_condition);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedSearchConditionXpath)));
        driver.findElement(By.xpath(parametrizedSearchConditionXpath)).click();
    }

    public void enterSearchCriteria(String client, String search_condition) throws InterruptedException {

        if (search_condition.equals("Donneur d'ordre")) {
            parametrizedSearchFieldXpath = "(//input[@placeholder=\"Donneur d'ordre\"])";
        } else {
            parametrizedSearchFieldXpath = String.format(GestionCommercialePage.txtSearchByField, search_condition);
        }

        driver.findElement(By.xpath(parametrizedSearchFieldXpath)).click();

        for (char ch : client.toCharArray()) {
            driver.findElement(By.xpath(parametrizedSearchFieldXpath)).sendKeys(Character.toString(ch));
            Thread.sleep(100);
        }

        Thread.sleep(5000);
        driver.findElement(By.xpath(GestionCommercialePage.txtFirstOptionValue)).click();
    }

    public void clickOnFirstCard(String client_link) {
        String parametrizedcardTitleXpath = String.format(GestionCommercialePage.cardFirstItem, client_link.trim(), client_link.trim());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedcardTitleXpath)));
        driver.findElement(By.xpath(parametrizedcardTitleXpath)).click();
    }

    public void clickOnActionTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.btnActionTab)));
        driver.findElement(By.xpath(GestionCommercialePage.btnActionTab)).click();
    }

    public void verifyClientTypeOfPM(String type_pm) {
        String parametrizedTypeOfPM = String.format(GestionCommercialePage.lblActionTabTypeOfPM, type_pm.trim());
        boolean presenceOflabelPM = driver.findElement(By.xpath(parametrizedTypeOfPM)).isDisplayed();
        if (presenceOflabelPM) {
            Assert.assertTrue(true);
        } else {
            throw new AssertionError("Element not found: " + parametrizedTypeOfPM);
        }
    }

    public void clickOnNouvelleAction() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.btnCreateNouvelleAction)));
        driver.findElement(By.xpath(GestionCommercialePage.btnCreateNouvelleAction)).click();
    }

    public void clickOnActionType(String action_type) throws InterruptedException {

        Thread.sleep(5000);
        switch (action_type) {
            case "Devis Catalogue Actions":
                driver.findElement(By.xpath(GestionCommercialePage.btnDevisCatalogueActions)).click();
                break;
            case "Devis Catalogue Produits":
                driver.findElement(By.xpath(GestionCommercialePage.btnDevisCatalogueProduits)).click();
                break;
        }
    }

    public void selectPersonneMorale(String personne_morale) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.btnCreatePersonneMorale)));
        driver.findElement(By.xpath(GestionCommercialePage.btnCreatePersonneMorale)).click();

        String parametrizedTypeOfPersonneMoralle = String.format(GestionCommercialePage.optionPersonneMorale, personne_morale.trim());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedTypeOfPersonneMoralle)));
        driver.findElement(By.xpath(parametrizedTypeOfPersonneMoralle)).click();
    }

    public void selectTypePM(String type_pm) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.dropdownTypeOfPM)));
        WebElement dropdownElement = driver.findElement(By.xpath(GestionCommercialePage.dropdownTypeOfPM));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(type_pm);
    }

    public void verifyPersonneMoraleIsPopulated(String nom, String prenom) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.dropdownPersonneMorale)));
        String extractedPopulatedPersonneMorale = driver.findElement(By.xpath(GestionCommercialePage.dropdownPersonneMorale)).getAttribute("value");
        String fullname = nom + " " + prenom;
        Assert.assertTrue(extractedPopulatedPersonneMorale.contains(fullname));
    }

    public void verifyContactPrincipalIsPopulated(String nom, String prenom) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.dropdownContactPrincipal)));
        String extractedPopulatedContactPrincipal = driver.findElement(By.xpath(GestionCommercialePage.dropdownContactPrincipal)).getAttribute("value");
        String fullname = nom + " " + prenom;
        Assert.assertTrue(extractedPopulatedContactPrincipal.contains(fullname));
    }

    public void selectCollaborateur()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.txtCollaborateur)));
        driver.findElement(By.xpath(GestionCommercialePage.txtCollaborateur)).click();
        String collaborateur = "Barbera Bruno";
        String xpathCollaborateur = String.format(GestionCommercialePage.btnCollaborateur, collaborateur);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathCollaborateur)));
        driver.findElement(By.xpath(xpathCollaborateur)).click();
    }

    public void clickOnSave()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.btnSave)));
        driver.findElement(By.xpath(GestionCommercialePage.btnSave)).click();
    }

    public void clickOnDevisTab() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.tabDevis)));
        driver.findElement(By.xpath(GestionCommercialePage.tabDevis)).click();
    }

    public void verifyContactIsPopulatedForContactUnderDevis(String nom, String prenom) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.txtContactDevis)));
        String extractedContactDevis = driver.findElement(By.xpath(GestionCommercialePage.txtContactDevis)).getText();
        String fullname = nom + " " + prenom;
        Assert.assertEquals(extractedContactDevis, fullname);
    }

    public void verifyContactPrincipalIsPopulatedForContactUnderDevis(String nom, String prenom) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.txtContactPrincipauxDevis)));
        String extractedPopulatedContactPrincipalDevis = driver.findElement(By.xpath(GestionCommercialePage.txtContactPrincipauxDevis)).getText();
        String fullname = nom + " " + prenom;
        Assert.assertEquals(extractedPopulatedContactPrincipalDevis, fullname);
    }

}
