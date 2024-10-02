package Pages;

public class GestionCommercialePage {
    public static String menuSuiviCommercial = "//*[@id=\"dd_[BLO_GRC]\"]/span"; //xpath
    public static String submenuActionsCommerciales = "//*[@id=\"blockList\"]/li[1]/ul/li[1]/div/a"; //xpath
    public static String btnSelectSearchCategory = "//i[@class='fas fa-caret-down']"; //xpath
    public static String valueSearchBy = "//div[contains(text(),'%s')]"; //xpath
    public static String txtSearchByField = "(//input[@placeholder='%s'])"; //xpath
    public static String cardFirstItem = "(//div[@title='%s'][normalize-space()='%s'])[1]"; //xpath
    public static String btnActionTab = "//button[normalize-space()='Action']"; //xpath
    public static String lblActionTabTypeOfPM = "//h5[normalize-space()='%s']"; //xpath
    public static String txtFirstOptionValue = "//*[@id=\"contentapp\"]/q-comp-pipe-action-co/div/div[1]/div/div[1]/div[1]/div[1]/q-quicksearch/div/div[2]/div[1]/cdk-virtual-scroll-viewport/div[1]/div";
    public static String btnCreateNouvelleAction = "//*[@id=\"0\"]/div/div[3]/div[2]"; //xpath
    public static String btnDevisCatalogueActions ="//*[@id=\"popUp0\"]/div[1]/div[2]"; //xpath
    public static String btnDevisCatalogueProduits = "//*[@id=\"popUp0\"]/div[2]/div[2]"; //xpath
    public static String btnCreatePersonneMorale = "//*[@id=\"contentapp\"]/queoval-action-co-card/q-action-co-card/div/div[2]/q-action-co-action/div/div[3]/div[1]/div/div[2]/button/i"; //xpath
    public static String optionPersonneMorale = "(//button[normalize-space()='%s'])[1]"; //xpath
    public static String dropdownTypeOfPM = "//*[@id=\"contentapp\"]/queoval-action-co-card/q-action-co-card/div/div[2]/q-action-co-action/div/q-action-co-bo/div/div/div[1]/select"; //xpath
    public static String dropdownPersonneMorale = "(//input[@placeholder='Sélectionnez une personne morale'])[1]"; //xpath
    public static String dropdownContactPrincipal = "(//input[@placeholder='Sélectionnez un contact'])[1]"; //xpath
    public static String btnSave = "//*[@id=\"contentapp\"]/queoval-action-co-card/q-action-co-card/div/div[2]/q-action-co-action/div/div[1]/button/i"; //xpath
    public static String txtCollaborateur = "//*[@id=\"contentapp\"]/queoval-action-co-card/q-action-co-card/div/div[2]/q-action-co-action/div/div[1]/q-avatar-search/div/div/div/img"; //xpath
    public static String btnCollaborateur = "(//span[normalize-space()='%s'])[1]"; //xpath
    public static String tabDevis = "(//button[normalize-space()='Devis'])[1]"; //xpath
    public static String txtContactDevis = "//*[@id=\"contentapp\"]/queoval-action-co-card/q-action-co-card/div/div[2]/q-action-co-devis/div/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/span[1]"; //xpath
    public static String txtContactPrincipauxDevis = "//*[@id=\"contentapp\"]/queoval-action-co-card/q-action-co-card/div/div[2]/q-action-co-devis/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/div/span[1]"; //xpath
}
