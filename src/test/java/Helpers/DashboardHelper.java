package Helpers;

import Pages.*;
import Utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class DashboardHelper extends BrowserDriver {

    public WebDriverWait wait;

    public DashboardHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void navigateToGestionDesFormateurs()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuGestionDesFormateurs)));
        driver.findElement(By.xpath(DashboardPage.submenuGestionDesFormateurs)).click();
    }

    public void navigateToGestionDesStages()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.menuGestionDesStages)));
        driver.findElement(By.xpath(DashboardPage.menuGestionDesStages)).click();
    }

    public void navigateToSuiviDesStages()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuSuiviDesStages)));
        driver.findElement(By.xpath(DashboardPage.submenuSuiviDesStages)).click();
    }

    public void clickOnMenuGrid() throws InterruptedException {
        Thread.sleep(15000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.menuGrid)));
        driver.findElement(By.xpath(DashboardPage.menuGrid)).click();
    }

    public void navigateToFacturation()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuFacturation)));
        driver.findElement(By.xpath(DashboardPage.submenuFacturation)).click();
    }

    public void navigateToGestionDesReglements()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuOperationDeBanque)));
        driver.findElement(By.xpath(DashboardPage.submenuOperationDeBanque)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuGestionDesReglements)));
        driver.findElement(By.xpath(DashboardPage.submenuGestionDesReglements)).click();
    }

    public void navigateToGestionCommerciale()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuGestionCommerciale)));
        driver.findElement(By.xpath(DashboardPage.submenuGestionCommerciale)).click();
    }

    public void navigateToActionsCommerciales()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.menuSuiviCommercial)));
        driver.findElement(By.xpath(GestionCommercialePage.menuSuiviCommercial)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionCommercialePage.submenuActionsCommerciales)));
        driver.findElement(By.xpath(GestionCommercialePage.submenuActionsCommerciales)).click();
    }

    public void navigateToAdministration()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuAdministration)));
        driver.findElement(By.xpath(DashboardPage.submenuAdministration)).click();
    }

    public void navigateToGestionDesLieux()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdministrationPage.menuCentreFormation)));
        driver.findElement(By.xpath(AdministrationPage.menuCentreFormation)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdministrationPage.submenuGestionDesLieux)));
        driver.findElement(By.xpath(AdministrationPage.submenuGestionDesLieux)).click();
    }

    public void navigateToGestionFormation()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.submenuGestionFormation)));
        driver.findElement(By.xpath(DashboardPage.submenuGestionFormation)).click();
    }

    public void selectPersonneMoraleOfType(String type) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.btnListOfPersonneMorale)));
        driver.findElement(By.xpath(DashboardPage.btnListOfPersonneMorale)).click();

        String parametrizedPersonneMoraleXpath = String.format(DashboardPage.optPersonneMoraleType, type);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parametrizedPersonneMoraleXpath)));
        driver.findElement(By.xpath(parametrizedPersonneMoraleXpath)).click();
    }

    public void clickOnSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.iconSearch)));
        driver.findElement(By.xpath(DashboardPage.iconSearch)).click();
    }

    public void selectFirstElementInList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.firstElementInList)));
        driver.findElement(By.xpath(DashboardPage.firstElementInList)).click();
    }

    public void selectTabOfType(String type) throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        String xpath = switch (type) {
            case "Client" -> String.format(DashboardPage.tabInfo, DashboardPage.idClient);
            case "Prospect" -> String.format(DashboardPage.tabInfo, DashboardPage.idProspect);
            case "Fournisseur" -> String.format(DashboardPage.tabInfo, DashboardPage.idFournisseur);
            default -> null;
        };

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickOnSave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.btnRegister)));
        driver.findElement(By.xpath(DashboardPage.btnRegister)).click();
    }

    public void navigateToClotureEnMassePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdministrationPage.menuCentreFormation)));
        driver.findElement(By.xpath(AdministrationPage.menuCentreFormation)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdministrationPage.submenuClotureEnMasse)));
        driver.findElement(By.xpath(AdministrationPage.submenuClotureEnMasse)).click();
    }

}
