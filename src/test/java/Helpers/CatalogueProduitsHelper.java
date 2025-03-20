package Helpers;

import Pages.*;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CatalogueProduitsHelper extends BrowserDriver {

    public int countBeforeCreation;
    public int countAfterCreation;
    public int countBeforeDeletion;
    public int countAfterDeletion;
    public int countAfterEdit;
    public WebDriverWait wait;

    public CatalogueProduitsHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickOnNouveauCatalogueButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
        countBeforeCreation = getCountOfCataloguePresent();
        driver.findElement(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)).click();
    }

    public void createCatalogue(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.headerNouveauCatalogue)));
        String modalTitleNewCatalogue = driver.findElement(By.xpath(CatalogueProduitsPage.headerNouveauCatalogue)).getText().trim();
        String expectedNouveauCatalogueTitle = "Nouveau catalogue";
        Assert.assertEquals(expectedNouveauCatalogueTitle, modalTitleNewCatalogue);

        String classAttribute = driver.findElement(By.xpath(CatalogueProduitsPage.btnEnregistrer)).getAttribute("class");

        if (classAttribute.contains("btn-submit disabled")) {
            assert true;
        } else {
            assert false;
        }

        driver.findElement(By.xpath(CatalogueProduitsPage.txtDescription)).click();
        driver.findElement(By.xpath(CatalogueProduitsPage.txtDescription)).sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.btnEnregistrer)));
        driver.findElement(By.xpath(CatalogueProduitsPage.btnEnregistrer)).click();
    }

    public int getCountOfCataloguePresent() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
            Thread.sleep(10000);

            List<WebElement> allCountCatalogueElements = driver.findElements(By.xpath(CatalogueProduitsPage.countOfCatalogue));

            int countOfcatalogue = allCountCatalogueElements.size();
            return countOfcatalogue;
        } catch (Exception e) {
            return 0;
        }
    }

    public void verifyNewCatalogueHasBeenCreated() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
        countAfterCreation = getCountOfCataloguePresent();

        if (countAfterCreation == (countBeforeCreation + 1)) {
            assert true;
        } else {
            assert false:"Catalogue not created";
        }
    }

    public void verifyCataloguesAreAlphabeticallyOrdered(String nom_1, String nom_2) throws InterruptedException {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
        List<WebElement> allCataloguesInTheList = driver.findElements(By.xpath(CatalogueProduitsPage.countOfCatalogue));
        int countNumberCatalogue = allCataloguesInTheList.size();

        int indexNom1 = -1;
        int indexNom2 = -1;

        for (int index = 0; index < countNumberCatalogue; index++) {
            WebElement formateurElement = allCataloguesInTheList.get(index);
            WebElement identityElement = formateurElement.findElement(By.className("article-title"));
            String formateurName = identityElement.getText();

            if (formateurName.contains(nom_1)) {
                indexNom1 = index;
            }

            if (formateurName.contains(nom_2)) {
                indexNom2 = index;
            }

            if (indexNom1 != -1 && indexNom2 != -1) {
                break;
            }
        }
        if (indexNom1 < indexNom2) {
            assert true;
        } else {
            assert false : "Catalogues not alphabetically ordered";
        }
    }

    public void searchForCatalogue(String title) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.txtRechercheCatalogue)));
        driver.findElement(By.xpath(CatalogueProduitsPage.txtRechercheCatalogue)).click();
        driver.findElement(By.xpath(CatalogueProduitsPage.txtRechercheCatalogue)).sendKeys(title);
        Thread.sleep(2000);
    }

    public void verifySearchResultsContainTitle(String title) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
        List<WebElement> allCatalogueInTheList = driver.findElements(By.xpath(CatalogueProduitsPage.countOfCatalogue));
        countBeforeCreation = getCountOfCataloguePresent();

        for (WebElement titleElement : allCatalogueInTheList) {
            WebElement identityElement = titleElement.findElement(By.tagName("span"));
            String catalogueTitle = identityElement.getText();
            System.out.println(catalogueTitle);

            if (catalogueTitle.toLowerCase().contains(title.toLowerCase())) {
                assert true;
            } else {
                assert false : "Not part of search result";
            }
        }
    }

    public void verifyNoCataloguesAreDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
        List<WebElement> allCatalogueInTheList = driver.findElements(By.xpath(CatalogueProduitsPage.countOfCatalogue));
        assert allCatalogueInTheList.size() == 0 : "Catalogues are present, but they should not.";
    }

    public void clickOnLastCatalogue() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
        List<WebElement> allCataloguesInTheList = driver.findElements(By.xpath(CatalogueProduitsPage.countOfCatalogue));

        countBeforeDeletion = getCountOfCataloguePresent();

        if (!allCataloguesInTheList.isEmpty()) {
            WebElement lastCatalogue = allCataloguesInTheList.get(allCataloguesInTheList.size() - 1);
            lastCatalogue.click();
        } else {
            assert false;
        }
    }

    public void clickOnSupprimerCatalogue() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.btnSupprimerCatalogue)));
        driver.findElement(By.xpath(CatalogueProduitsPage.btnSupprimerCatalogue)).click();
    }

    public void confirmDeletionOnModal() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.btnConfirmDeletion)));
        driver.findElement(By.xpath(CatalogueProduitsPage.btnConfirmDeletion)).click();
    }

    public void verifyCatalogueHasBeenDeleted() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnNouveauCatalogue)));
        countAfterDeletion = getCountOfCataloguePresent();
        assert (countAfterDeletion == (countBeforeDeletion - 1)) : "Catalogue has not been deleted/edited";
    }

    public void changeNomDuCatalogue(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.btnSupprimerCatalogue)));
        driver.findElement(By.xpath(CatalogueProduitsPage.txtNomDuCatalogue)).clear();
        driver.findElement(By.xpath(CatalogueProduitsPage.txtNomDuCatalogue)).sendKeys(name);
    }

    public void changeCollaborateur(String collaborateur) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(CatalogueProduitsPage.dropdownCollaborateur)).click();
        Thread.sleep(3000);
        String parametrizedXpathCollaborateurValue = String.format(CatalogueProduitsPage.dropdownCollaborateurValue, collaborateur);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedXpathCollaborateurValue)));
        driver.findElement(By.xpath(parametrizedXpathCollaborateurValue)).click();
    }

    public void changePubliableWebStoreCatalogue() {
        driver.findElement(By.xpath(CatalogueProduitsPage.radioCatalogueWebstore)).click();
    }

    public void changeUsedInDevisCatalogue() {
        driver.findElement(By.xpath(CatalogueProduitsPage.radioCatalogueDevis)).click();
    }

    public void clickOnRetourALaListeDesCatalogues() {
        driver.findElement(By.xpath(CatalogueProduitsPage.btnBackToCatalogue)).click();
    }

    public void addNewCategory(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.btnAddCategorieToCatalogue)));
        driver.findElement(By.xpath(CatalogueProduitsPage.btnAddCategorieToCatalogue)).click();

        WebElement inputElement = driver.findElement(By.xpath(CatalogueProduitsPage.txtCategoryName));
        Actions actions = new Actions(driver);
        actions.click(inputElement).sendKeys(name).build().perform();

        driver.findElement(By.xpath(CatalogueProduitsPage.btnSaveCategory)).click();
    }

    public void verifyCategoriesAreAlphabeticallyOrdered(String nom_1, String nom_2) throws InterruptedException {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnSupprimerCatalogue)));
        List<WebElement> allCategoriesInTheList = driver.findElements(By.xpath(CatalogueProduitsPage.countOfCategoryColumns));
        int countNumberCategories = allCategoriesInTheList.size() - 1; //remove 1 because Ajouter une categorie also included in the count

        int indexNom1 = -1;
        int indexNom2 = -1;

        for (int index = 0; index < countNumberCategories; index++) {
            WebElement formateurElement = allCategoriesInTheList.get(index);
            WebElement identityElement = formateurElement.findElement(By.tagName("b"));
            String formateurName = identityElement.getText();

            if (formateurName.contains(nom_1)) {
                indexNom1 = index;
            }

            if (formateurName.contains(nom_2)) {
                indexNom2 = index;
            }

            if (indexNom1 != -1 && indexNom2 != -1) {
                break;
            }
        }
        if (indexNom1 < indexNom2) {
            assert true;
        } else {
            assert false : "Categories not alphabetically ordered";
        }
    }

    public void clickOnEditCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.btnCategoryEdit)));
        driver.findElement(By.xpath(CatalogueProduitsPage.btnCategoryEdit)).click();
    }

    public void setNewCategoryTitle(String new_title) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.txtCategoryTitle)));
        driver.findElement(By.xpath(CatalogueProduitsPage.txtCategoryTitle)).click();
        driver.findElement(By.xpath(CatalogueProduitsPage.txtCategoryTitle)).clear();
        driver.findElement(By.xpath(CatalogueProduitsPage.txtCategoryTitle)).sendKeys(new_title);
    }

    public void setCategoryCollaborateur(String new_collaborateur) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(CatalogueProduitsPage.dropdownCateogryCollaborateur)).click();
        Thread.sleep(2000);
        String parametrizedXpathCateogryCollaborateurValue = String.format(CatalogueProduitsPage.dropdownCategoryCollaborateurValue, new_collaborateur);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedXpathCateogryCollaborateurValue)));
        driver.findElement(By.xpath(parametrizedXpathCateogryCollaborateurValue)).click();
    }

    public void setNewInfoForCategory(String new_info) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.txtInfo)));
        driver.findElement(By.xpath(CatalogueProduitsPage.txtInfo)).click();
        driver.findElement(By.xpath(CatalogueProduitsPage.txtInfo)).sendKeys(new_info);
    }

    public void setCategoryPubliableWebstore() {
        driver.findElement(By.xpath(CatalogueProduitsPage.radioCategoryWebstore)).click();
    }

    public void clickOnEnregistrerCategory() {
        driver.findElement(By.xpath(CatalogueProduitsPage.btnSaveNewCategoryDetails)).click();
    }

    public void clickOnLastCategory() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnSupprimerCatalogue)));
        List<WebElement> allCatagoriesInTheList = driver.findElements(By.xpath(CatalogueProduitsPage.txtCatalogueTitle));

        if (!allCatagoriesInTheList.isEmpty()) {
            WebElement lastCategory = allCatagoriesInTheList.get(allCatagoriesInTheList.size() - 1);
            lastCategory.click();
        } else {
            assert false: "Some technical error or catalogue not loaded";
        }
    }

    public void clickOnLastAjouterUnProduitButton() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.btnSupprimerCatalogue)));
        List<WebElement> allAjouterButtonInTheList = driver.findElements(By.xpath(CatalogueProduitsPage.btnAjouterProduit));

        if (!allAjouterButtonInTheList.isEmpty()) {
            WebElement lastAjouterProduitButton = allAjouterButtonInTheList.get(allAjouterButtonInTheList.size() - 1);
            lastAjouterProduitButton.click();
        } else {
            assert false: "Some technical error or catalogue not loaded";
        }
    }

    public void createNewProductPubliableWebstore(String intitule, String code, String tarif, String plan_fac) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueProduitsPage.txtIntituleDeFormation)));

        driver.findElement(By.xpath(CatalogueProduitsPage.txtIntituleDeFormation)).sendKeys(intitule);
        driver.findElement(By.xpath(CatalogueProduitsPage.txtCode)).sendKeys(code);
        driver.findElement(By.xpath(CatalogueProduitsPage.txtTarifPrincipal)).sendKeys(tarif);

        WebElement dropdownPlanDeFacturation = driver.findElement(By.xpath(CatalogueProduitsPage.dropdownPlanDeFacturation));
        Select plandefac = new Select(dropdownPlanDeFacturation);
        plandefac.selectByVisibleText(plan_fac);

        driver.findElement(By.xpath(CatalogueProduitsPage.checkboxPubliableWebstore)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(CatalogueProduitsPage.btnSaveProduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CatalogueProduitsPage.btnSupprimerCatalogue)));

    }

    public void verifyCatalogCannotBeDeleted(String cannot_delete_catalogue) {
        String parametrizedXpathCannotDeleteCatalogueErrMsg = String.format(CatalogueProduitsPage.txtModalCannotDeleteCatlogue, cannot_delete_catalogue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedXpathCannotDeleteCatalogueErrMsg)));
    }

}
