package Helpers;

import Pages.EffectifPage;
import Pages.SuiviDesStagesPage;
import Pages.Vue360Page;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GestionDesStagesHelper extends BrowserDriver {

    public WebDriverWait wait;
    public int countApprenantNumber;
    public int totalNumberOfApprenant;
    public String startDate;
    public String endDate;

    public GestionDesStagesHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickOnCreateNewStage() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SuiviDesStagesPage.btnCreateNewStage)));
        driver.findElement(By.cssSelector(SuiviDesStagesPage.btnCreateNewStage)).click();
    }

    public void clickOnCreateNewStageOfTypeCatalogueProduit() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SuiviDesStagesPage.btnSubCreateNewStage)));
        driver.findElement(By.cssSelector(SuiviDesStagesPage.btnSubCreateNewStage)).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SuiviDesStagesPage.btnCreateStageCatalogueProduit)));
        driver.findElement(By.xpath(SuiviDesStagesPage.btnCreateStageCatalogueProduit)).click();
    }

    public void selectCatalogue(String catalogues)
    {
        focusOnDropdown(catalogues);
    }

    public void selectCategory(String categories)
    {
        focusOnDropdown(categories);
    }

    public void selectProduit(String produits)
    {
        focusOnDropdown(produits);
    }

    public void selectTypeOnCreateStageForm(String type)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SuiviDesStagesPage.headerCreationOfStage)));
        WebElement dropdownElement = driver.findElement(By.xpath(SuiviDesStagesPage.dropdownTypeCreateStage)); // Use the appropriate locator
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(type);
    }

    public void saveNewStage()
    {
        driver.findElement(By.cssSelector(SuiviDesStagesPage.btnSaveStageForm)).click();
    }

    public void verifyProduitsHeaderOnVue360(String produits) throws InterruptedException {
        Thread.sleep(7000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Vue360Page.headerProduits)));
        String extractedProduitsHeader = driver.findElement(By.cssSelector(Vue360Page.headerProduits)).getText();
        Assert.assertEquals(produits,extractedProduitsHeader);
    }

    public void clickOnLastCreatedStage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SuiviDesStagesPage.cardCountLastInPlanifee)));
        WebElement lastCard = driver.findElement(By.xpath(SuiviDesStagesPage.cardLastTitle));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastCard);

        String content = lastCard.getAttribute("title");
        lastCard.click();
        verifyProduitsHeaderOnVue360(content);
    }

    public void clickOnEffectif()
    {
        driver.findElement(By.xpath(EffectifPage.tabEffectif)).click();
    }

    public void clickOnPlanning()
    {
        driver.findElement(By.xpath(EffectifPage.tabPlanning)).click();
    }

    public void clickOnClientPlusSignAndCreer()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.iconAddClient)));
        driver.findElement(By.xpath(EffectifPage.iconAddClient)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.btnCreate)));
        driver.findElement(By.xpath(EffectifPage.btnCreate)).click();
    }

    public void clickOnClientIndividuel() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.btnClientIndividuel)));
        driver.findElement(By.xpath(EffectifPage.btnClientIndividuel)).click();
    }

    public void selectClientAssocier() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.dropdownClientAssocier)));
        driver.findElement(By.xpath(EffectifPage.dropdownClientAssocier)).click();
        //driver.findElement(By.xpath("//*[@id=\"MainIndexBody\"]/ngb-modal-window/div/div/div/div[2]/select/option")).click();
    }

    public void inputPersonalInfoOnCreateClientIndividuelForm(String civilite, String nom, String prenom, String function, String groupe_de)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.dropdownCivilite)));
        WebElement dropdownElementCivilite = driver.findElement(By.xpath(EffectifPage.dropdownCivilite)); // Use the appropriate locator
        Select dropdownCivilite = new Select(dropdownElementCivilite);
        dropdownCivilite.selectByVisibleText(civilite);

        driver.findElement(By.xpath(EffectifPage.txtNom)).sendKeys(nom);
        driver.findElement(By.xpath(EffectifPage.txtPrenom)).sendKeys(prenom);

        WebElement dropdownElementFonction = driver.findElement(By.xpath(EffectifPage.dropdownFonction)); // Use the appropriate locator
        Select dropdownFonction = new Select(dropdownElementFonction);
        dropdownFonction.selectByVisibleText(function);

        driver.findElement(By.xpath(EffectifPage.txtGroupDe)).clear();
        driver.findElement(By.xpath(EffectifPage.txtGroupDe)).sendKeys(groupe_de);
    }

    public void saveClientIndividuel()
    {
        driver.findElement(By.xpath(EffectifPage.btnSaveClientIndividuel)).click();
    }

    public void verifyClientUnderClientBlock(String nom, String prenom) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.btnEditClientEffectif)));
        String extractedClientName = driver.findElement(By.xpath(EffectifPage.blockClientEffectif)).getText();
        assert extractedClientName.contains(nom + " " + prenom);
    }

    public void verifyApprenantUnderClientBlock(String nom, String prenom)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.blockApprenantEffectif)));
        String extractedClientName = driver.findElement(By.xpath(EffectifPage.blockApprenantEffectif)).getText();
        assert extractedClientName.contains(nom + " " + prenom);
    }

    public void removeAllClientFromEffectif() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.getCountofClient)));
        String countClient = driver.findElement(By.xpath(EffectifPage.getCountofClient)).getText();

        String[] parts = countClient.split("-");

        if (parts.length >= 2 && !parts[1].trim().isEmpty()) {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.iconAddClient)));
            driver.findElement(By.xpath(EffectifPage.iconAddClient)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.btnRemoveAllClients)));
            driver.findElement(By.xpath(EffectifPage.btnRemoveAllClients)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.btnConfirmClientRemoval)));
            driver.findElement(By.xpath(EffectifPage.btnConfirmClientRemoval)).click();
        }

    }

    public void clickOnEditClientEffectif()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.btnEditClientEffectif)));
        driver.findElement(By.xpath(EffectifPage.btnEditClientEffectif)).click();
    }

    public void verifyActiviteBPF(String BPF)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.dropdownActiviteBPF)));
        WebElement dropdownActiviteBPF = driver.findElement(By.xpath(EffectifPage.dropdownActiviteBPF));
        Select dropdownBPF = new Select(dropdownActiviteBPF);

        WebElement selectedOption = dropdownBPF.getFirstSelectedOption();
        String selectedBPFValue = selectedOption.getText();

        Assert.assertEquals(BPF, selectedBPFValue);
    }

    public int getInitialCountOfApprenant(String PageField)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageField)));
        String countApprenantWithText = driver.findElement(By.xpath(PageField)).getText();

        String[] parts = countApprenantWithText.split("-");

        if (parts.length >= 2 && !parts[1].trim().isEmpty()) {
            String countApprenant = parts[1].trim();
            countApprenantNumber = Integer.parseInt(countApprenant);
            return countApprenantNumber;
        }
        else {
            return 0;
        }
    }

    public int getFinalCountOfApprenant(String groupe_de, String PageField) throws InterruptedException {
        Thread.sleep(7000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageField)));
        String countApprenantFinalWithText = driver.findElement(By.xpath(PageField)).getText();

        String[] parts = countApprenantFinalWithText.split("-");

        int parametrizedNumberOfGroupeDe = Integer.parseInt(groupe_de);
        String countApprenantFinal = parts[1].trim();
        int countApprenantFinalNumber = Integer.parseInt(countApprenantFinal);
        totalNumberOfApprenant = parametrizedNumberOfGroupeDe + countApprenantNumber;

        Assert.assertEquals(totalNumberOfApprenant, countApprenantFinalNumber);
        return totalNumberOfApprenant;
    }


    public void clickOnApprenantPlusSignAndCreer()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.iconAddApprenant)));
        driver.findElement(By.xpath(EffectifPage.iconAddApprenant)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.btnCreate)));
        driver.findElement(By.xpath(EffectifPage.btnCreate)).click();
    }

    public void navigateToVue306()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.menuVue360)));
        driver.findElement(By.xpath(Vue360Page.menuVue360)).click();
    }

    public void clickOnEditVue306()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.btnEditVue360)));
        driver.findElement(By.xpath(Vue360Page.btnEditVue360)).click();
    }

    public void verifyNbStagInscrits() throws InterruptedException {
        Thread.sleep(15000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.txtNbstagInscrits)));
        String extractedNbStagInscrits = driver.findElement(By.xpath(Vue360Page.txtNbstagInscrits)).getAttribute("value");
        int extractedNbStagInscritsNumber = Integer.parseInt(extractedNbStagInscrits);
        Assert.assertEquals(totalNumberOfApprenant, extractedNbStagInscritsNumber);
    }

    public void clickOnApprenantEditButtonVue360()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.btnEditFirstApprenant)));
        driver.findElement(By.xpath(Vue360Page.btnEditFirstApprenant)).click();
    }

    public void editGroupDefieldonVue360(String groupe_de)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.txtGroupeDe)));
        String existingNumberOfGroupeDe = driver.findElement(By.xpath(Vue360Page.txtGroupeDe)).getAttribute("value");
        int convertedExistingNumberOfGroupeDe = Integer.parseInt(existingNumberOfGroupeDe);
        int convertedIncrementedNumber = Integer.parseInt(groupe_de);
        String newGroupeDeValue = String.valueOf(convertedExistingNumberOfGroupeDe+convertedIncrementedNumber);
        driver.findElement(By.xpath(Vue360Page.txtGroupeDe)).clear();
        driver.findElement(By.xpath(Vue360Page.txtGroupeDe)).sendKeys(newGroupeDeValue);
    }


    public void focusOnDropdown(String dropdownValue)
    {
        WebElement dropdownElement = driver.findElement(By.cssSelector(SuiviDesStagesPage.dropdownStageType)); // Use the appropriate locator
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(dropdownValue);
    }

    public void enterStartDateAndEndDate() throws InterruptedException {

        startDate = "06/02/2024";
        Thread.sleep(2000);
        //driver.findElement(By.xpath(SuiviDesStagesPage.txtStartDate)).click();
        driver.findElement(By.xpath(SuiviDesStagesPage.txtStartDate)).sendKeys(startDate);

        endDate = "07/02/2024";
        Thread.sleep(2000);
        //driver.findElement(By.xpath(SuiviDesStagesPage.txtEndDate)).click();
        driver.findElement(By.xpath(SuiviDesStagesPage.txtEndDate)).sendKeys(endDate);
    }

    public void verifyStartDateAndEndDateArePopulatedInVue360()
    {
        String vue360DateDu = driver.findElement(By.xpath(Vue360Page.txtDateDu)).getText();
        String vue360DateAu = driver.findElement(By.xpath(Vue360Page.txtDateAu)).getText();
        Assert.assertEquals(startDate,vue360DateDu);
        Assert.assertEquals(endDate,vue360DateAu);
    }

    public void clickOnLieuIcon()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EffectifPage.iconLieu)));
        driver.findElement(By.xpath(EffectifPage.iconLieu)).click();
    }

    public void addCursusOnVue360() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.menuVue360)));
        driver.findElement(By.xpath(Vue360Page.txtCursus)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.txtMonCursus)));
        driver.findElement(By.xpath(Vue360Page.txtMonCursus)).click();
    }

    public void saveTheStageOnVue360(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.btnSaveStage)));
        driver.findElement(By.xpath(Vue360Page.btnSaveStage)).click();
    }

    public void clickOnRetour(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vue360Page.btnRetour)));
        driver.findElement(By.xpath(Vue360Page.btnRetour)).click();
    }
}
