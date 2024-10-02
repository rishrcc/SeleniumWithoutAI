package Pages;

public class Vue360Page {

    public static String headerProduits = "h5:nth-child(2) strong:nth-child(1)"; //css
    public static String menuVue360 = "//button[contains(text(),'Vue 360°')]"; //xpath
    public static String btnEditVue360 = "//i[@class='fas fa-edit q-c-main mx-4 mx-md-2']"; //xpath
    public static String txtNbstagInscrits ="//*[@id=\"NbstaPRO\"]"; //xpath
    public static String txtGroupeDe = "//*[@id=\"NbGrpPER\"]"; //xpath
    public static String getCountOfApprenants = "//*[@id=\"contentapp\"]/queoval-modal-pipe/mat-drawer-container/mat-drawer-content/div/div[2]/div[2]/queoval-stage-vue360/div/div/div[1]/div/q-effectifs[2]/fieldset/legend"; //xpath
    public static String btnEditFirstApprenant = "//*[@id=\"contentapp\"]/queoval-modal-pipe/mat-drawer-container/mat-drawer-content/div/div[2]/div[2]/queoval-stage-vue360/div/div/div[1]/div/q-effectifs[2]/fieldset/div[2]/effectifs-render/div/cdk-virtual-scroll-viewport/div[1]/div[1]/i[2]"; //xpath
    public static String txtDateDu = "//*[@id=\"header-info-date\"]/div/div[1]"; //xpath
    public static String txtDateAu = "//*[@id=\"header-info-date\"]/div/div[2]"; //xpath
    public static String txtCursus = "//*[@id=\"header-btn\"]/div[2]/q-bo-property-inline[1]/div/span/span";
    public static String txtMonCursus = "(//div[normalize-space()='Mon cursus'])[1]";
    public static String btnSaveStage = "//button[@ngbtooltip='Enregistrer le stage']//i";
    public static String btnRetour = "(//button[normalize-space()='Retour'])[1]";
}
