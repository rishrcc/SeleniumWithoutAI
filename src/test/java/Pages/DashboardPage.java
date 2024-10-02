package Pages;

public class DashboardPage
{
    public static String menuGestionDesStages = "//*[@id=\"dd_[BLO_ACTION]\"]/span"; //xpath
    public static String submenuGestionDesFormateurs = "//*[@id=\"blockList\"]/li[1]/ul/li[3]/div/a"; //xpath
    public static String submenuSuiviDesStages = "//a[normalize-space()='Suivi des stages']"; //xpath
    public static String menuGrid = "//*[@id=\"shortcuti\"]"; //xpath
    public static String submenuFacturation = "//div[@role='tooltip']//span[contains(text(),'Facturation')]"; //xpath
    public static String submenuOperationDeBanque = "//span[normalize-space()='Opérations de banque']"; //xpath
    public static String submenuGestionDesReglements = "//a[normalize-space()='Gestion des règlements']"; //xpath
    public static String submenuGestionCommerciale = "//div[@role='tooltip']//div//div//div//div//span[contains(text(),'Gestion commerciale')]"; //xpath
    public static String submenuAdministration = "(//span[contains(text(),'Administration')])[3]"; //xpath
    public static String submenuGestionFormation = "(//span[contains(text(),'Gestion formation')])[3]"; //xpath
    public static String btnListOfPersonneMorale = "(//button[@type='button'])[1]"; //xpath
    public static String optPersonneMoraleType = "(//span[contains(text(),'%s')])[1]"; //xpath
    public static String iconSearch = "(//i)[2]"; //xpath
    public static String firstElementInList = "(//*[@id=\"ANG_SEGMENTATION\"])[1]"; //xpath
    public static String tabInfo = "//*[@id=\"%s\"]"; //xpath
    public static String idClient = "PRESENTATION_ctl00_[1REL_BO_CENT_BO_CSOC|BO_CSOC]";
    public static String idProspect = "PRESENTATION_ctl00_[1REL_BO_CENT_BO_CPPT|BO_CPPT]";
    public static String idFournisseur = "PRESENTATION_ctl00_[REL_BO_CENT_BO_FOURNISSEUR|BO_FOURNISSEUR]";
    public static String btnRegister = "(//button[normalize-space()='Enregistrer'])[1]"; //xpath
}
