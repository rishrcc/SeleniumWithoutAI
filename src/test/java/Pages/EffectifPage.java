package Pages;

public class EffectifPage {
    public static String tabEffectif = "//button[contains(text(),'Effectif')]"; //xpath
    public static String tabPlanning = "(//button[contains(text(),'Planning')])[1]"; //xpath
    public static String iconAddClient = "(//i[@class='fas fa-user-plus fa-flip-horizontal'])[1]"; //xpath
    public static String iconAddApprenant = "//*[@id=\"Apprenants\"]/i"; //xpath
    public static String btnCreate = "//button[normalize-space()='Créer']"; //xpath
    public static String btnClientIndividuel = "//button[normalize-space()='Client Individuel']"; //xpath
    public static String dropdownCivilite = "//*[@id=\"CivilPER\"]"; //xpath
    public static String txtNom = "//*[@id=\"NomfaPER\"]"; //xpath
    public static String txtPrenom = "//*[@id=\"Pre01PER\"]"; //xpath
    public static String dropdownFonction = "//*[@id=\"FonctPER\"]"; //xpath
    public static String txtGroupDe = "//*[@id=\"NbGrpPER\"]"; //xpath
    public static String btnSaveClientIndividuel = "//i[@class='fa-save fas']"; //xpath
    public static String blockClientEffectif = "(//cdk-virtual-scroll-viewport[@class='cdk-virtual-scroll-viewport h-100 cdk-virtual-scrollable cdk-virtual-scroll-orientation-vertical ng-star-inserted'])[1]"; //xpath
    public static String blockApprenantEffectif = "(//div[@class='h-100'])[2]"; //xpath
    public static String btnEditClientEffectif = "(//i[@title='Editer'])[1]"; //xpath
    public static String btnRemoveAllClients = "//span[@class='q-c-danger q-pointer']"; //xpath
    public static String btnConfirmClientRemoval = "//button[normalize-space()='Supprimer']"; //xpath
    public static String dropdownActiviteBPF = "//*[@id=\"ActivCLI\"]"; //xpath
    public static String getCountofClient = "//*[@id=\"contentapp\"]/queoval-modal-pipe/mat-drawer-container/mat-drawer-content/div/div[2]/div[2]/queoval-stage-effectif/div/div/div[1]/div/q-effectifs[1]/fieldset/legend"; //xpath
    public static String getCountofApprenants = "//*[@id=\"contentapp\"]/queoval-modal-pipe/mat-drawer-container/mat-drawer-content/div/div[2]/div[2]/queoval-stage-effectif/div/div/div[1]/div/q-effectifs[2]/fieldset/legend"; //xpath
    public static String dropdownClientAssocier ="//*[@id=\"MainIndexBody\"]/ngb-modal-window/div/div/div/div[2]/select";
    public static String iconLieu = "//*[@id=\"contentapp\"]/queoval-modal-pipe/mat-drawer-container/mat-drawer-content/div/div[2]/div[2]/queoval-stage-effectif/div/div/div[2]/fieldset/queoval-lieu/div/span/i[1]"; //xpath
    public static String dropdownLieu = "//*[@id=\"contentapp\"]/queoval-modal-pipe/mat-drawer-container/mat-drawer-content/div/div[2]/div[2]/queoval-stage-effectif/div/div/div[2]/fieldset/queoval-lieu/div/select[1]"; //xpath
}
