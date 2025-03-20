package Pages;

public class GestionDesFormateursPage {

    public static String txtGestionDesFormateursTitle = "//*[@id=\"menubar1\"]/ul/li[3]/div/span"; //css
    public static String btnNewFormateur = "//button[normalize-space()='Nouveau']"; //Xpath
    public static String txtInitiale = "//*[@id=\"TrigrPER\"]"; //xpath
    public static String dropdownTypeDeContratBPF = "//*[@id=\"TypCoPER\"]"; //xpath
    public static String btnSaveNewFormateur = "//*[@id=\"boL1\"]/div[1]/button[3]/i"; //xpath
    public static String lblCreatedFormateur = "//*[@id=\"contentapp\"]/formateurs/div/div/f-details/div/div/div[1]"; //xpath
    public static String countOfFormateur = "//*[@id=\"contentapp\"]/formateurs/div/div/formateurs-list/div/div[2]/formateur-card"; //xpath
    public static String menuSideBarGED = "//*[@id=\"contentapp\"]/formateurs/div/queoval-sidebar/div/div[2]/div[3]/div/div/q-sidebar-icon/div/i[1]"; //xpath
    public static String subMenuGEDDocumentsExpand = "//*[@id=\"contentapp\"]/formateurs/div/div/ged/div/div[2]/div/div[1]/div/mat-tree/mat-tree-node[2]/button/mat-icon";//xpath
    public static String subMenuGEDFullForm = "//span[normalize-space()='GED']"; //xpath
    public static String iconRechercher = "//*[@id=\"contentapp\"]/formateurs/div/div/ged/div/div[2]/div/div[2]/div[1]/mat-form-field/div[1]/div[2]/div[2]/button/i"; //xpath
    public static String iconAddDocument = "(//*[name()='path'][@fill-rule='evenodd'])[1]"; //xpath
    public static String placeHolderAttachDocument = "//*[@id=\"MainIndexBody\"]/ngb-modal-window/div/div/div[2]/q-insertdoc/div/div[2]/q-insertdoc-input/div/div/label"; //xpath
    public static String btnSelectDocumentSmallScreenResolution = "(//*[@id=\"inputGroup-sizing-sm\"])[1]";
    public static String dropdownStateOfDocument = "//*[@id=\"Etat_DOC\"]"; //xpath
    public static String btnSaveDocument = "//button[@title='Enregistrer']//i"; //xpath
    public static String optStatus = "(//mat-tree-node[normalize-space()='%s'])[1]"; //xpath
    public static String countOfDocuments = "//*[@id=\"contentapp\"]/formateurs/div/div/ged/div/div[2]/div/div[2]/div[2]/document-card"; //xpath
}
