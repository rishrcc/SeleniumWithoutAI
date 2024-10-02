package Pages;

public class GestionDesLieuxPage {
    public static String btnNouveau = "//*[@id=\"contentapp\"]/queoval-location/div/div[1]/button/span[2]"; //xpath
    public static String txtRecherche = "(//input[@aria-invalid='false'])[1]"; //xpath
    public static String txtDenomination = "//*[@id=\"DenomADR\"]"; //xpath
    public static String test= "(//input[@aria-describedby='DenomADR-btn'])[1]";
    public static String txtAddress1 = "//*[@id=\"Adre1ADR\"]"; //xpath
    public static String txtAddress2 = "//*[@id=\"Adre2ADR\"]"; //xpath
    public static String txtComplement = "//*[@id=\"Adre3ADR\"]"; //xpath
    public static String txtCodeVille = "//*[@id=\"VilleADR_codepos\"]"; //xpath
    public static String txtVilleAddress = "//*[@id=\"VilleADR\"]"; //xpath
    public static String txtPayAddress = "//*[@id=\"Pays_ADR\"]"; //xpath
    public static String btnEnregistrer = "(//button[normalize-space()='Enregistrer'])[1]"; //xpath
    public static String btnAnnuler = "(//button[normalize-space()='Annuler'])[1]"; //xpath
    public static String countOfLieux = "//*[@id=\"contentapp\"]/queoval-location/div/div[2]/div"; //xpath
    public static String msgGenericMandatoryField = "/html[1]/body[1]/queoval-root[1]/ng-component[1]/div[2]/div[3]/q-toast[1]/section[1]/div[2]/div[1]/p[1]"; //xpath
    public static String btnSupprimer = "(//button[normalize-space()='Supprimer'])[1]"; //xpath
    public static String txtPopUpDelete = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/q-material-modal/div/div/div[1]/p"; //xpath
            //*[@id=\"deleteModal\"]/div/div/div/div/p
    public static String btnPopUpDeleteYes = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/q-material-modal/div/div/div[2]/button[2]"; //xpath


}
