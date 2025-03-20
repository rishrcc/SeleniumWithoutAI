package Helpers;

import Pages.*;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.List;

public class GestionDesFormateurHelper extends BrowserDriver {

    public WebDriverWait wait;

    public GestionDesFormateurHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void verifyGestionDesFormateurTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.txtGestionDesFormateursTitle)));
        String actualGestionDesFormateurTitle = driver.findElement(By.xpath(GestionDesFormateursPage.txtGestionDesFormateursTitle)).getText();
        String expectedGestionDesFormateurTitle = "Gestion des formateurs";
        Assert.assertEquals(expectedGestionDesFormateurTitle, actualGestionDesFormateurTitle);
    }

    public void clickOnCreateNewFormateur() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.btnNewFormateur)));
        driver.findElement(By.xpath(GestionDesFormateursPage.btnNewFormateur)).click();
    }

    public void inputFormateurDetails(String civilite, String nom, String prenom, String initiales, String type_de_contrat) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.dropdownCivilite)));
        WebElement dropdownElementCivilite = driver.findElement(By.xpath(EffectifPage.dropdownCivilite)); // Use the appropriate locator
        Select dropdownCivilite = new Select(dropdownElementCivilite);
        dropdownCivilite.selectByVisibleText(civilite);

        driver.findElement(By.xpath(EffectifPage.txtNom)).sendKeys(nom);
        driver.findElement(By.xpath(EffectifPage.txtPrenom)).sendKeys(prenom);

        driver.findElement(By.xpath(GestionDesFormateursPage.txtInitiale)).sendKeys(initiales);

        WebElement dropdownElementTypeDeContrat = driver.findElement(By.xpath(GestionDesFormateursPage.dropdownTypeDeContratBPF)); // Use the appropriate locator
        Select dropdownTypeDeContrat = new Select(dropdownElementTypeDeContrat);
        dropdownTypeDeContrat.selectByVisibleText(type_de_contrat);
    }

    public void clickOnSave(){
        driver.findElement(By.xpath(GestionDesFormateursPage.btnSaveNewFormateur)).click();
    }

    public void verifyFormateurHasBeenCreated(String nom, String prenom) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.lblCreatedFormateur)));
        String extractedFormateurName = driver.findElement(By.xpath(GestionDesFormateursPage.lblCreatedFormateur)).getText();
        System.out.println(extractedFormateurName);

        boolean containsPrenom = extractedFormateurName.contains(prenom);
        boolean containsNom = extractedFormateurName.contains(nom);

        if (containsPrenom && containsNom) {
            assert true;
        } else {
            assert false;
        }
    }

    public void verifyLastnamesAreAlphabeticallyOrdered(String nom_1, String nom_2) throws InterruptedException {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.btnNewFormateur)));
        List<WebElement> allFormateurInTheList = driver.findElements(By.xpath(GestionDesFormateursPage.countOfFormateur));
        int countNumberFormateur = allFormateurInTheList.size();

        int indexNom1 = -1;
        int indexNom2 = -1;

        for (int index = 0; index < countNumberFormateur; index++) {
            WebElement formateurElement = allFormateurInTheList.get(index);
            WebElement identityElement = formateurElement.findElement(By.className("identity"));
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
        if (indexNom1 > indexNom2) {
            assert true;
        } else {
            assert false;
        }
    }

    public void clickOnTheLastCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.countOfFormateur)));
        List<WebElement> formateurElements = driver.findElements(By.xpath(GestionDesFormateursPage.countOfFormateur));

        if (!formateurElements.isEmpty()) {

            WebElement lastElement = formateurElements.get(formateurElements.size() - 1);
            lastElement.click();
        } else {
            throw new RuntimeException("No elements found ");
        }
    }

    public void navigateToDocumentPage() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.menuSideBarGED)));
        driver.findElement(By.xpath(GestionDesFormateursPage.menuSideBarGED)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.subMenuGEDFullForm)));
        driver.findElement(By.xpath(GestionDesFormateursPage.subMenuGEDFullForm)).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(GestionDesFormateursPage.iconRechercher)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.subMenuGEDDocumentsExpand)));
        driver.findElement(By.xpath(GestionDesFormateursPage.subMenuGEDDocumentsExpand)).click();
    }

    public void clickOnDocumentStatusSubMenu(String sub_menu_document_status) {
        String parametrizedXpathDocumentStatusSubMenu = String.format(GestionDesFormateursPage.optStatus, sub_menu_document_status);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedXpathDocumentStatusSubMenu)));
        driver.findElement(By.xpath(parametrizedXpathDocumentStatusSubMenu)).click();
    }

    public void addDocumentWithStatus(String document_status, String sub_menu_document_status) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.iconAddDocument)));
        int beforeAddingDocument = getCountOfDocumentsPresent();
        driver.findElement(By.xpath(GestionDesFormateursPage.iconAddDocument)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.dropdownStateOfDocument)));
        WebElement dropdownElement = driver.findElement(By.xpath(GestionDesFormateursPage.dropdownStateOfDocument));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(document_status);

        try {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.placeHolderAttachDocument)));
            driver.findElement(By.xpath(GestionDesFormateursPage.placeHolderAttachDocument)).click();
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath(GestionDesFormateursPage.btnSelectDocumentSmallScreenResolution)).click();
        }

        // Use the Robot class to handle the file upload dialog
        Robot robot = new Robot();
        robot.setAutoDelay(2000);

        // Copy the file path to the clipboard
        String filePath = getDirectoryFile();
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Paste the file path and press Enter
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.btnSaveDocument)));
        driver.findElement(By.xpath(GestionDesFormateursPage.btnSaveDocument)).click();

        Thread.sleep(10000);

        int afterAddingDocument = getCountOfDocumentsPresent();

        verifyDocumentStatusWhenStatusIsSelectedFromSubMenu(sub_menu_document_status);

        if (document_status.equals(sub_menu_document_status)) {
            Assert.assertEquals(String.valueOf(afterAddingDocument), String.valueOf(beforeAddingDocument + 1));
        } else {
            Assert.assertEquals(String.valueOf(afterAddingDocument), String.valueOf(beforeAddingDocument));
        }
    }

    public String getDirectoryFile() {
        String projectDir = System.getProperty("user.dir");
        String filePath = projectDir + "\\src\\test\\resources\\drivers\\UploadTest.txt";
        return filePath;
    }

    public int getCountOfDocumentsPresent() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDesFormateursPage.countOfDocuments)));
            Thread.sleep(15000);
            List<WebElement> allCountformateurElements = driver.findElements(By.xpath(GestionDesFormateursPage.countOfDocuments));

            int countOfDocs = allCountformateurElements.size();
            return countOfDocs;
        } catch (Exception e) {
            return 0;
        }
    }

    public String converStatusToCapitalLetters(String sub_menu_document_status) {
        Map<Character, Character> accentMap = new HashMap<>();
        accentMap.put('é', 'E');
        StringBuilder sb = new StringBuilder();
        for (char c : sub_menu_document_status.toCharArray()) {
            sb.append(accentMap.getOrDefault(c, c));
        }
        return sb.toString().toUpperCase();
    }

    public void verifyDocumentStatusWhenStatusIsSelectedFromSubMenu(String sub_menu_document_status) {

        List<WebElement> allDocumentInTheList = driver.findElements(By.xpath(GestionDesFormateursPage.countOfDocuments));
        int countNumberDocument = allDocumentInTheList.size();
        String convertedStatus = converStatusToCapitalLetters(sub_menu_document_status);

        for (int index = 0; index < countNumberDocument; index++) {
            WebElement documentElement = allDocumentInTheList.get(index);
            WebElement identityStatusElement = documentElement.findElement(By.className("state"));
            String documentStatus = identityStatusElement.getText();
            Assert.assertEquals(convertedStatus, documentStatus);
        }

    }
}
