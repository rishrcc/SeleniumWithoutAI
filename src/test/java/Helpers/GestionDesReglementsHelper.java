package Helpers;

import Pages.*;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GestionDesReglementsHelper extends BrowserDriver {

    public WebDriverWait wait;
    public Double RestantDuFromTable;
    public Double RestantDu2FromTable;
    public Double RestantDu3FromTable;
    public Double SumOfRestantDuFromTable;
    public Double MontantPercu;
    public Double MontantVentilation;
    public Double SommeDeLaVentilation;
    public Double RestantDu;
    public Double RestantDu1;
    public Double RestantDu2;
    public Double RestantDu3;
    public Double new_montant_percu;
    public String btnRapprocherColor;
    public String btnRapprocherCursor;

    public GestionDesReglementsHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void verifyReglementsHeaderMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.submenuReglements)));
    }

    public void clickOnFirstRecord() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu1)));
        driver.findElement(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu1)).click();
        Thread.sleep(5000);
    }

    public void clickOnThreeRecords() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu1)));
        Thread.sleep(2000);
        driver.findElement(By.xpath(GestionDesReglementsPage.checkboxFirstRow)).click();
        driver.findElement(By.xpath(GestionDesReglementsPage.checkboxSecondRow)).click();
        driver.findElement(By.xpath(GestionDesReglementsPage.checkboxThirdRow)).click();
    }

    public double getRecordRestantDu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu1)));
        String extractedRestantDuFromTable = driver.findElement(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu1)).getText();
        RestantDuFromTable = Double.parseDouble(extractedRestantDuFromTable);
        System.out.print("Restant du from table: " + RestantDuFromTable);
        return RestantDuFromTable;

    }

    public double getThreeRecordsRestantDu() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu1)));
        String extractedRestantDu1FromTable = driver.findElement(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu1)).getText();
        String extractedRestantDu2FromTable = driver.findElement(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu2)).getText();
        String extractedRestantDu3FromTable = driver.findElement(By.xpath(GestionDesReglementsPage.txtColumnValueRestantDu3)).getText();
        RestantDuFromTable = Double.parseDouble(extractedRestantDu1FromTable);
        RestantDu2FromTable = Double.parseDouble(extractedRestantDu2FromTable);
        RestantDu3FromTable = Double.parseDouble(extractedRestantDu3FromTable);
        SumOfRestantDuFromTable = RestantDuFromTable + RestantDu2FromTable + RestantDu3FromTable;
        System.out.print("Sum of restant du from table: " + SumOfRestantDuFromTable);
        return SumOfRestantDuFromTable;
    }

    public double getMontantPercu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantPercu)));
        //String extractedMontantPercu = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantPercu)).getAttribute("ng-reflect-model");
        String extractedMontantPercu = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantPercu)).getAttribute("value");
        MontantPercu = Double.parseDouble(extractedMontantPercu);
        System.out.print("Montant percu: " + MontantPercu);
        return MontantPercu;
    }

    public double getMontantVentilation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantVentilation)));
        //String extractedMontantVentilation = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantVentilation)).getAttribute("ng-reflect-model");
        String extractedMontantVentilation = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantVentilation)).getAttribute("value");
        MontantVentilation = Double.parseDouble(extractedMontantVentilation);
        System.out.print("Montant de la ventilation: " + MontantVentilation);
        return MontantVentilation;

    }

    public double getSumMontantVentilation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantVentilation)));
        List<WebElement> allMontantVentilation = driver.findElements(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantVentilation));
        MontantVentilation = 0.0;
        for (WebElement montantVentilationLoop : allMontantVentilation) {
            String montantVentilation = montantVentilationLoop.getAttribute("value");
            double valuemontantVentilation = Double.parseDouble(montantVentilation);
            MontantVentilation += valuemontantVentilation;
        }
        System.out.print("Get some of montant de la ventilation: " + MontantVentilation);
        return MontantVentilation;
    }

    public void modifyMontantVentilationOfFirstRecord(String montant_percu_amount_increment) {
        Double value_montant_percu_amount_increment = Double.parseDouble(montant_percu_amount_increment);
        String generatedXpathOfFirstMontantVentilation = GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantVentilation + "[1]";
        String actualMontantVentilation = driver.findElement(By.xpath(generatedXpathOfFirstMontantVentilation)).getAttribute("value");
        System.out.print("Actual Montant Ventilation: " + SommeDeLaVentilation);
        Double valueActualMontantVentilation = Double.parseDouble(actualMontantVentilation);
        Double incrementedValue = valueActualMontantVentilation + value_montant_percu_amount_increment;
        String txtincrementedValue = String.valueOf(incrementedValue);
        driver.findElement(By.xpath(generatedXpathOfFirstMontantVentilation)).clear();
        driver.findElement(By.xpath(generatedXpathOfFirstMontantVentilation)).sendKeys(txtincrementedValue);
    }

    public double getSommeDeLaVentilation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationSommeDeLaVentilation)));
        String extractedSommeDeLaVentilation = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationSommeDeLaVentilation)).getText();
        String extractedValueSommeDeLaVentilation = extractedSommeDeLaVentilation.replace("€", "").trim();
        SommeDeLaVentilation = Double.parseDouble(extractedValueSommeDeLaVentilation);
        System.out.print("Somme de la ventaillation: " + SommeDeLaVentilation);
        return SommeDeLaVentilation;

    }

    public double getRestantDuGestionDesEcartsEtVentilation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationRestantDu)));
        String extractedRestantDu = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationRestantDu)).getText();
        String extractedValueRestantDu = extractedRestantDu.replace("€", "").trim();
        RestantDu = Double.parseDouble(extractedValueRestantDu);
        System.out.print("Restant du: " + RestantDu);
        return RestantDu;
    }

    public double getSumOfThreeRestantDuGestionDesEcartsEtVentilation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationRestantDu)));
        String extractedRestantDu1 = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationRestantDu)).getText();
        String extractedValueRestantDu1 = extractedRestantDu1.replace("€", "").trim();
        RestantDu1 = Double.parseDouble(extractedValueRestantDu1);

        String extractedRestantDu2 = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationRestantDu2)).getText();
        String extractedValueRestantDu2 = extractedRestantDu2.replace("€", "").trim();
        RestantDu2 = Double.parseDouble(extractedValueRestantDu2);

        String extractedRestantDu3 = driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationRestantDu3)).getText();
        String extractedValueRestantDu3 = extractedRestantDu3.replace("€", "").trim();
        RestantDu3 = Double.parseDouble(extractedValueRestantDu3);

        RestantDu = RestantDu1 + RestantDu2 + RestantDu3;
        return RestantDu;
    }

    public void verifyRestantDuIsEqualToMontantPercuAndVentilationAndSommeDeLaVentilation() {
        Assert.assertEquals(RestantDuFromTable, MontantPercu);
        Assert.assertEquals(RestantDuFromTable, MontantVentilation);
        Assert.assertEquals(RestantDuFromTable, SommeDeLaVentilation);
        Assert.assertEquals(RestantDuFromTable, RestantDu);
    }

    public void verifyTotalRestantDuIsEqualToMontantPercuAndVentilationAndSommeDeLaVentilation() {
        Assert.assertEquals(SumOfRestantDuFromTable, MontantPercu);
        Assert.assertEquals(SumOfRestantDuFromTable, MontantVentilation);
        Assert.assertEquals(SumOfRestantDuFromTable, SommeDeLaVentilation);
        Assert.assertEquals(SumOfRestantDuFromTable, RestantDu);
    }

    public void verifyTypeDecartAndRapprocherButton() {
        btnRapprocherColor = driver.findElement(By.xpath(GestionDesReglementsPage.btnRapprocher)).getCssValue("background-color");
        btnRapprocherCursor = driver.findElement(By.xpath(GestionDesReglementsPage.btnRapprocher)).getCssValue("cursor");
        String dropdownTypeDecartColor = driver.findElement(By.xpath(GestionDesReglementsPage.dropdownTypeDecart)).getCssValue("color");

        if (MontantPercu.equals(RestantDu)) {
            Assert.assertEquals("pointer", btnRapprocherCursor);
        } else {
            Assert.assertEquals("not-allowed", btnRapprocherCursor);
        }
    }

    public double modifyMontantPercuAmount(String montant_percu_amount) {
        Double montant_percu = Double.parseDouble(montant_percu_amount);
        new_montant_percu = montant_percu + MontantPercu;
        driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantPercu)).clear();
        String new_montant_percu_amount = String.valueOf(new_montant_percu);
        driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantPercu)).sendKeys(new_montant_percu_amount);
        return new_montant_percu;
    }

    public void verifyVentilationAndSommeDeLaVentilationAfterModifyingMontantPercu() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertEquals(new_montant_percu, MontantVentilation);
        Assert.assertEquals(new_montant_percu, SommeDeLaVentilation);
    }

    public void verifyTypeDecartIsMandatory(String err_message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.txtTypeDecartMandatoryErrMessage)));
        String extractedtypeDecartErrMessage = driver.findElement(By.xpath(GestionDesReglementsPage.txtTypeDecartMandatoryErrMessage)).getText();
        Assert.assertEquals(err_message, extractedtypeDecartErrMessage);
    }

    public void selectEntiteDeFacturation() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.dropdownEntiteDeFacturation)));
        driver.findElement(By.xpath(GestionDesReglementsPage.dropdownEntiteDeFacturation)).click(); // Use the appropriate locator
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesReglementsPage.valueTesTFormation)));
        driver.findElement(By.xpath(GestionDesReglementsPage.valueTesTFormation)).click();
        Thread.sleep(3000);

    }

    public void verifyTypeDecartNotPresent(String type_decarts) {
        String parametrizedXpath = String.format(GestionDesReglementsPage.valueTypeDecarts, type_decarts);
        List<WebElement> valueOfTypeDecart = driver.findElements(By.xpath(parametrizedXpath));

        if (!type_decarts.contains("Pertes et profits")) {
            if (!valueOfTypeDecart.isEmpty()) {
                throw new AssertionError("Element found when it should not be: " + parametrizedXpath);
            }
        }
    }

    public void navigateToTypeEcartFor1FactureSelected() {
        driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantPercu)).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void navigateToTypeEcartFor3FactureSelected() {
        driver.findElement(By.xpath(GestionDesReglementsPage.txtGestionDesEcartsEtVentilationMontantPercu)).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        //actions.sendKeys(Keys.TAB).perform();
        //actions.sendKeys(Keys.TAB).perform();
        //actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void selectTypeDecart(String type_decarts) {
        navigateToTypeEcartFor1FactureSelected();
        String parametrizedXpath = String.format(GestionDesReglementsPage.valueTypeDecarts, type_decarts);
        driver.findElement(By.xpath(parametrizedXpath)).click();
    }

    public void selectTypeDecartForThreeRecords(String type_decarts) {
        navigateToTypeEcartFor3FactureSelected();
        String parametrizedXpath = String.format(GestionDesReglementsPage.valueTypeDecarts, type_decarts);
        driver.findElement(By.xpath(parametrizedXpath)).click();
    }

    public void enabledRapprocherButton() throws InterruptedException {
        Thread.sleep(3000);
        btnRapprocherColor = driver.findElement(By.xpath(GestionDesReglementsPage.btnRapprocher)).getCssValue("background-color");
        btnRapprocherCursor = driver.findElement(By.xpath(GestionDesReglementsPage.btnRapprocher)).getCssValue("cursor");
        Assert.assertEquals("pointer", btnRapprocherCursor);
        Assert.assertEquals("rgba(133, 193, 59, 1)", btnRapprocherColor); //green element
    }

    public void verifyEcartsAfterModifyingVentilation(String montant_percu_amount_increment) {
        String actualEcartValue = driver.findElement(By.xpath(GestionDesReglementsPage.txtEcartValueForFirstRecord)).getText();
        Double expectedEcartValue = Double.parseDouble(montant_percu_amount_increment);
        String txtexpectedEcartValue;
        if (expectedEcartValue < 0) {
            txtexpectedEcartValue = (Math.abs(expectedEcartValue) + "0 " + "€");
        } else {
            txtexpectedEcartValue = (-expectedEcartValue + "0 " + "€");
        }
        Assert.assertEquals(txtexpectedEcartValue, actualEcartValue);

    }

}
