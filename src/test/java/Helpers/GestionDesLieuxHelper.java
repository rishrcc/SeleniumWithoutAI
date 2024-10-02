package Helpers;

import Pages.*;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class GestionDesLieuxHelper extends BrowserDriver {

    public int countBeforeCreation;
    public int countAfterCreation;
    public String nameDenomination;

    public WebDriverWait wait;

    public GestionDesLieuxHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickOnNouveau() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnNouveau)));
        Thread.sleep(5000);
        countBeforeCreation = getCountOfLieuxPresent();
        driver.findElement(By.xpath(GestionDesLieuxPage.btnNouveau)).click();
    }

    public void fillCreationFormOfNewLieu(String denomination, String adresse_1, String adresse_2, String complement, String ville_code, String ville_adresse, String country) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.txtDenomination)));

        driver.findElement(By.xpath(GestionDesLieuxPage.txtDenomination)).clear();
        driver.findElement(By.xpath(GestionDesLieuxPage.txtDenomination)).sendKeys(denomination);
        driver.findElement(By.xpath(GestionDesLieuxPage.txtAddress1)).sendKeys(adresse_1);
        driver.findElement(By.xpath(GestionDesLieuxPage.txtAddress2)).sendKeys(adresse_2);
        driver.findElement(By.xpath(GestionDesLieuxPage.txtComplement)).sendKeys(complement);
        driver.findElement(By.xpath(GestionDesLieuxPage.txtCodeVille)).sendKeys(ville_code);
        driver.findElement(By.xpath(GestionDesLieuxPage.txtVilleAddress)).sendKeys(ville_adresse);
        driver.findElement(By.xpath(GestionDesLieuxPage.txtPayAddress)).sendKeys(country);
    }

    public String fillCreationFormOfNewLieu() throws InterruptedException {

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.txtDenomination)));

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder name = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            name.append(characters.charAt(random.nextInt(characters.length())));
        }

        nameDenomination = name.toString();
        driver.findElement(By.xpath(GestionDesLieuxPage.txtDenomination)).clear();
        driver.findElement(By.xpath(GestionDesLieuxPage.txtDenomination)).sendKeys(nameDenomination);
        driver.findElement(By.xpath(GestionDesLieuxPage.txtAddress1)).sendKeys("adresse_1");
        driver.findElement(By.xpath(GestionDesLieuxPage.txtAddress2)).sendKeys("adresse_2");
        driver.findElement(By.xpath(GestionDesLieuxPage.txtComplement)).sendKeys("complement");
        driver.findElement(By.xpath(GestionDesLieuxPage.txtCodeVille)).sendKeys("8");
        driver.findElement(By.xpath(GestionDesLieuxPage.txtVilleAddress)).sendKeys("ville_adresse");
        driver.findElement(By.xpath(GestionDesLieuxPage.txtPayAddress)).sendKeys("Maurice");

        return nameDenomination;
    }

    public static boolean isValuePresentInDropdown(Select dropdown, String value) {
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void verifyDenominationIsPresentInEffectifLieu() throws InterruptedException {

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.dropdownLieu)));
        WebElement dropdownElement = driver.findElement(By.xpath(EffectifPage.dropdownLieu));
        Select dropdown = new Select(dropdownElement);
        boolean isValuePresent = isValuePresentInDropdown(dropdown, nameDenomination + " " + "adresse_1" + " " + "adresse_2");

        if (isValuePresent) {
            assert true;
        } else {
            assert false;
        }
    }

    public void verifyDenominationIsPresentInPlanningLieu() throws InterruptedException {

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanningPage.dropdownLieu)));
        WebElement dropdownElement = driver.findElement(By.xpath(PlanningPage.dropdownLieu));
        Select dropdown = new Select(dropdownElement);
        boolean isValuePresent = isValuePresentInDropdown(dropdown, nameDenomination + " " + "adresse_1" + " " + "adresse_2");

        if (isValuePresent) {
            assert true;
        } else {
            assert false;
        }
    }

    public void clickOnEnregistrer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnEnregistrer)));
        driver.findElement(By.xpath(GestionDesLieuxPage.btnEnregistrer)).click();
    }

    public int getCountOfLieuxPresent() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnNouveau)));
            Thread.sleep(10000);
            List<WebElement> allCountLieuxElements = driver.findElements(By.xpath(GestionDesLieuxPage.countOfLieux));

            int countOfLieux = allCountLieuxElements.size();
            return countOfLieux;
        } catch (Exception e) {
            return 0;
        }
    }

    public void verifyNewLieuxHasBeenCreated() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnNouveau)));
        countAfterCreation = getCountOfLieuxPresent();

        if (countAfterCreation == (countBeforeCreation + 1)) {
            assert true;
        } else {
            assert false;
        }
    }

    public void verifyDenominationsAreAlphabeticallyOrdered(String denomination_1, String denomination_2) throws InterruptedException {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnNouveau)));
        List<WebElement> allLieuxInTheList = driver.findElements(By.xpath(GestionDesLieuxPage.countOfLieux));
        int countNumberLieux = allLieuxInTheList.size();

        int indexDenomination1 = -1;
        int indexDenomination2 = -1;

        for (int index = 0; index < countNumberLieux; index++) {
            WebElement denominationElement = allLieuxInTheList.get(index);
            WebElement identityElement = denominationElement.findElement(By.tagName("b"));
            String denominationName = identityElement.getText();

            if (denominationName.equals(denomination_1)) {
                indexDenomination1 = index;
            }

            if (denominationName.equals(denomination_2)) {
                indexDenomination2 = index;
            }

            if (indexDenomination1 != -1 && indexDenomination2 != -1) {
                break;
            }
        }
        if (indexDenomination1 > indexDenomination2) {
            assert true;
        } else {
            assert false;
        }
    }

    public void verifyMandatoryErrMessage() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.msgGenericMandatoryField)));
        String errMessage = driver.findElement(By.xpath(GestionDesLieuxPage.msgGenericMandatoryField)).getText();
        Assert.assertEquals("Remplissez les champs suivants avec les données appropriées:\nDénomination",errMessage);
    }

    public void clickOnAnnulerButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnAnnuler)));
        driver.findElement(By.xpath(GestionDesLieuxPage.btnAnnuler)).click();
    }

    public void verifyNewLieuNotCreated() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnNouveau)));
        countAfterCreation = getCountOfLieuxPresent();

        if (countAfterCreation == (countBeforeCreation)) {
            assert true;
        } else {
            assert false;
        }
    }

    public void searchForKeyword(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.txtRecherche)));
        driver.findElement(By.xpath(GestionDesLieuxPage.txtRecherche)).click();
        driver.findElement(By.xpath(GestionDesLieuxPage.txtRecherche)).sendKeys(keyword);
        Thread.sleep(2000);
    }

    public void verifySearchResultsContainKeyword(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnNouveau)));
        List<WebElement> allLieuxInTheList = driver.findElements(By.xpath(GestionDesLieuxPage.countOfLieux));
        countBeforeCreation = getCountOfLieuxPresent();

        for (WebElement denominationElement : allLieuxInTheList) {
            WebElement identityElement = denominationElement.findElement(By.tagName("b"));
            WebElement addressElement = denominationElement.findElement(By.tagName("p"));
            String denominationName = identityElement.getText();
            String addressText = addressElement.getText();

            if (denominationName.toLowerCase().contains(keyword.toLowerCase()) || addressText.toLowerCase().contains(keyword.toLowerCase())) {
                assert true;
            } else {
                assert false : "Not part of search result";
            }
        }
    }

    public void verifyNoResultsAreDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.txtRecherche)));
        List<WebElement> elements = driver.findElements(By.xpath(GestionDesLieuxPage.countOfLieux));
        assert elements.size() == 0 : "Lieu is present, but it should not be.";
    }

    public void clickOnLastLieu() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.countOfLieux)));
        List<WebElement> allLieuxInTheList = driver.findElements(By.xpath(GestionDesLieuxPage.countOfLieux));

        countBeforeCreation = getCountOfLieuxPresent();

        if (!allLieuxInTheList.isEmpty()) {
            WebElement lastLieu = allLieuxInTheList.get(allLieuxInTheList.size() - 1);
            lastLieu.click();
        } else {
            assert false;
        }
    }

    public void verifyLieuCanBeDeleted() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnSupprimer)));
        driver.findElement(By.xpath(GestionDesLieuxPage.btnSupprimer)).click();
    }

    public void agreeToDeleteLieu(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnPopUpDeleteYes)));
        String popUpText = driver.findElement(By.xpath(GestionDesLieuxPage.txtPopUpDelete)).getText().toLowerCase();
        assert popUpText.contains(keyword.toLowerCase()) : "Not expected lieu to be deleted";
        driver.findElement(By.xpath(GestionDesLieuxPage.btnPopUpDeleteYes)).click();
    }

    public void verifyLieuIsDeleted(String keyword) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.btnNouveau)));
        searchForKeyword(keyword);
        countAfterCreation = getCountOfLieuxPresent();
        assert (countAfterCreation == (countBeforeCreation - 1)) : "Lieu count is still not decremented by 1";
    }

    public void verifyLieuHasBeenCreatedWithCorrectInfo(String denomination, String adresse_1, String adresse_2, String complement, String ville_code, String ville_adresse, String country) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesLieuxPage.txtDenomination)));

        String actualDenomination = driver.findElement(By.xpath(GestionDesLieuxPage.txtDenomination)).getText();
        String actualAddress1 = driver.findElement(By.xpath(GestionDesLieuxPage.txtAddress1)).getText();
        String actualAddress2 = driver.findElement(By.xpath(GestionDesLieuxPage.txtAddress2)).getText();
        String actualComplement = driver.findElement(By.xpath(GestionDesLieuxPage.txtComplement)).getText();
        String actualCodeVille = driver.findElement(By.xpath(GestionDesLieuxPage.txtCodeVille)).getText();
        String actualVilleAddress = driver.findElement(By.xpath(GestionDesLieuxPage.txtVilleAddress)).getText();
        String actualPayAddress = driver.findElement(By.xpath(GestionDesLieuxPage.txtPayAddress)).getText();

        assert actualDenomination.equals(denomination) : "Incorrect denomination";
        assert actualAddress1.equals(adresse_1) : "Incorrect adresse_1";
        assert actualAddress2.equals(adresse_2) : "Incorrect adresse_2";
        assert actualComplement.equals(complement) : "Incorrect complement";
        assert actualCodeVille.equals(ville_code) : "Incorrect ville_code";
        assert actualVilleAddress.equals(ville_adresse) : "Incorrect ville_adresse";
        assert actualPayAddress.equals(country) : "Incorrect country";

    }
}
