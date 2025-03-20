package Helpers;

import Pages.ClotureEnMassePage;
import Pages.DashboardPage;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClotureEnMasseHelper extends BrowserDriver {

    public WebDriverWait wait;
    public List<String> spanValues = new ArrayList<>();

    public ClotureEnMasseHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void filterPeriodeByThisYear() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.listBoxFiltreSurLaPeriode)));
        driver.findElement(By.xpath(ClotureEnMassePage.listBoxFiltreSurLaPeriode)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.optionThisYear)));
        driver.findElement(By.xpath(ClotureEnMassePage.optionThisYear)).click();
    }

    public void filterPeriodeByAll() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.listBoxFiltreSurLaPeriode)));
        driver.findElement(By.xpath(ClotureEnMassePage.listBoxFiltreSurLaPeriode)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.optionAll)));
        driver.findElement(By.xpath(ClotureEnMassePage.optionAll)).click();
    }

    public void filterByTypeOfStage(String type_stage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.listBoxTypeDeStage)));
        driver.findElement(By.xpath(ClotureEnMassePage.listBoxTypeDeStage)).click();

        String typeOfStage = String.format(ClotureEnMassePage.optionTypeEtatCursusStage, type_stage);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(typeOfStage)));
        driver.findElement(By.xpath(typeOfStage)).click();
    }

    public void filterByStateOfStage(String state_stage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.listBoxEtatDuStage)));
        driver.findElement(By.xpath(ClotureEnMassePage.listBoxEtatDuStage)).click();

        String stateOfStage = String.format(ClotureEnMassePage.optionTypeEtatCursusStage, state_stage);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stateOfStage)));
        driver.findElement(By.xpath(stateOfStage)).click();
    }

    public void filterByCursusOfStage(String cursus_stage) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.listBoxCursusDuStage)));
        driver.findElement(By.xpath(ClotureEnMassePage.listBoxCursusDuStage)).click();

        String cursusOfStage = String.format(ClotureEnMassePage.optionCursusDuStageTous, cursus_stage);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cursusOfStage)));
        driver.findElement(By.xpath(cursusOfStage)).click();
    }

    public void verifyDateDeFinDuStageFilter() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.optionDateDeFinStagePredefinedDate)));
        String extractedDate = driver.findElement(By.xpath(ClotureEnMassePage.optionDateDeFinStagePredefinedDate)).getAttribute("value");

        LocalDate date = LocalDate.now();
        LocalDate expectedDate = date.minusDays(1);
        LocalDate actualDate = LocalDate.parse(extractedDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String expectedFormattedDate = expectedDate.format(formatter);
        String actualFormattedDate = actualDate.format(formatter);

        LocalDate columnExpectedDate = LocalDate.parse(expectedFormattedDate, formatter);

        assertEquals(expectedFormattedDate, actualFormattedDate);
        verifyFilteredDateDeFin(columnExpectedDate);
    }

    public void verifyFilteredDateDeFin(LocalDate columnExpectedDate) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.columnDateDeFin)));
        List<WebElement> elements = driver.findElements(By.xpath(ClotureEnMassePage.columnDateDeFin));
        for (WebElement element : elements) {
            String actualText = element.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate elementDate = LocalDate.parse(actualText, formatter);
            assertTrue(elementDate.isBefore(columnExpectedDate) || elementDate.isEqual(columnExpectedDate));
        }
    }

    public void verifyFilteredTypeOfStage(String type_stage) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.columnType)));
        List<WebElement> elements = driver.findElements(By.xpath(ClotureEnMassePage.columnType));
        for (WebElement element : elements) {
            String actualText = element.getText();
            if (type_stage.equals("Tous"))
            {
                System.out.println("Type stage is 'Tous', skipping the check.");
            }
            else{
                assertEquals(type_stage.toLowerCase(), actualText.toLowerCase());
            }
        }
    }

    public void verifyFilteredStateOfStage(String state_stage) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.columnEtat)));
        List<WebElement> elements = driver.findElements(By.xpath(ClotureEnMassePage.columnEtat));
        for (WebElement element : elements) {
            String actualText = element.getText();
            if (state_stage.equals("Tous"))
            {
                System.out.println("Cursus stage is 'Tous', skipping the check.");
            }
            else{
                assertEquals(state_stage.toLowerCase(), actualText.toLowerCase());
            }
        }
    }

    public void verifyFilteredCursusOfStage(String cursus_stage) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.columnCursus)));
        List<WebElement> elements = driver.findElements(By.xpath(ClotureEnMassePage.columnCursus));
        for (WebElement element : elements) {
            String actualText = element.getText();
            if (cursus_stage.equals("Tous"))
            {
                System.out.println("Cursus stage is 'Tous', skipping the check.");
            }
            else{
                assertEquals(cursus_stage.toLowerCase(), actualText.toLowerCase());
            }
        }
    }

    public void clickOnSearchIcon(){
        driver.findElement(By.xpath(ClotureEnMassePage.iconSearch)).click();
    }

    public void selectMultiplestages(int start, int end) throws InterruptedException {
        Thread.sleep(3000);

        for (int i = start; i <= end; i++) {
            String dynamicXPath = String.format(ClotureEnMassePage.checkboxValue, i);
            String spanElement = String.format(ClotureEnMassePage.columnIdent, i);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
            driver.findElement(By.xpath(dynamicXPath)).click();
            String spanValue = driver.findElement(By.xpath(spanElement)).getText();
            spanValues.add(spanValue);
            System.out.println(spanValue);
        }
    }

    public void clickOnCloturer(String action) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.btnCloturer)));
        driver.findElement(By.xpath(ClotureEnMassePage.btnCloturer)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.modalTxtCloturerConfirmation)));
        String cloturerModalText = driver.findElement(By.xpath(ClotureEnMassePage.modalTxtCloturerConfirmation)).getText();
        assertEquals(ClotureEnMassePage.clotureModalText, cloturerModalText);

        switch (action) {
            case "confirm" -> driver.findElement(By.xpath(ClotureEnMassePage.btnOuiCloturer)).click();
            case "cancel" -> driver.findElement(By.xpath(ClotureEnMassePage.btnAnnuler)).click();

        }
        Thread.sleep(3000);
    }

    public void verifyThatTheDeletedStageIsNotInTheList() throws InterruptedException {

        driver.navigate().to(driver.getCurrentUrl());
        Thread.sleep(3000);
        List<WebElement> allSpansOnPage = driver.findElements(By.xpath(ClotureEnMassePage.listColumnIdent));

        for (String spanValue : spanValues) {
            boolean valueFound = false;

            for (WebElement element : allSpansOnPage) {
                String actualText = element.getText();
                if (spanValue.equals(actualText)) {
                    valueFound = true;
                }
            }
            Assert.assertFalse("Error: Value '" + spanValue + "' is still present on the page.", valueFound);
        }
    }

    public void verifyThatStageIsInTheList() throws InterruptedException {

        driver.navigate().to(driver.getCurrentUrl());
        Thread.sleep(3000);
        List<WebElement> allSpansOnPage = driver.findElements(By.xpath(ClotureEnMassePage.listColumnIdent));

        for (String spanValue : spanValues) {
            boolean valueFound = false;

            for (WebElement element : allSpansOnPage) {
                String actualText = element.getText();
                if (spanValue.equals(actualText)) {
                    valueFound = true;
                    break;
                }
            }
            Assert.assertTrue("Value '" + spanValue + "' is still present on the page.", valueFound);
        }
    }

    public void clickOnDateDeFinResetIcon() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.btnClearDateDeFinDuStage)));
        driver.findElement(By.xpath(ClotureEnMassePage.btnClearDateDeFinDuStage)).click();
        Thread.sleep(2000);
        verifyDateDeFinDuStageFilter();
    }

    public void clickOnEditStage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.editFirst)));
        driver.findElement(By.xpath(ClotureEnMassePage.editFirst)).click();
    }

    public void verifyNewCursusAfterEditing(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClotureEnMassePage.cursusFirst)));
        String newCursus = driver.findElement(By.xpath(ClotureEnMassePage.cursusFirst)).getText();
        assertEquals("Mon cursus",newCursus);
    }

}
