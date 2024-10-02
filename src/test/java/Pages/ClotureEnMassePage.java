package Pages;

public class ClotureEnMassePage {

    public static String listBoxFiltreSurLaPeriode = "//*[@id=\"mat-select-value-1\"]/span"; //xpath
    public static String optionThisYear = "(//span[normalize-space()='Cette année'])[1]"; //xpath
    public static String optionDateDeFinStagePredefinedDate = "//*[@id=\"mat-input-1\"]"; //xpath
    public static String btnClearDateDeFinDuStage = "//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[1]/div[1]/div[1]/q-material-datepicker/form/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle[1]/button/span[3]"; //xpath
    public static String listBoxTypeDeStage = "//*[@id=\"mat-select-value-3\"]/span"; //xpath
    public static String listBoxEtatDuStage = "//*[@id=\"mat-select-value-5\"]/span"; //xpath
    public static String listBoxCursusDuStage = "//*[@id=\"mat-select-value-7\"]/span"; //xpath
    public static String optionTypeEtatCursusStage = "//span[normalize-space()='%s']"; //xpath
    public static String columnType = "//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[4]"; //xpath
    public static String columnDateDeFin = "//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[6]"; //xpath
    public static String columnEtat = "//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[8]"; //xpath
    public static String columnCursus = "//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[9]"; //xpath
    public static String cursusFirst = "(//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[9])[1]"; //xpath
    public static String editFirst = "(//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[10]/span)[1]"; //xpath
    public static String columnIdent = "(//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div[%d]/div[1]/div/span)"; //xpath
    public static String listColumnIdent = "(//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div/span)"; //xpath
    public static String checkboxValue = "(//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[1]/div[1]/div[1])[%d]"; //xpath
    public static String btnCloturer = "//*[@id=\"contentapp\"]/queoval-cloture-stage/div/div[2]/queoval-cloture-stage-grid/div/div/div[2]/button";
    public static String modalTxtCloturerConfirmation = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/q-material-modal/div/div/div[2]/p"; //Vous êtes sur le point de clôturer des stages.
    public static String btnAnnuler = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/q-material-modal/div/div/div[3]/button[1]";
    public static String btnOuiCloturer = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/q-material-modal/div/div/div[3]/button[2]";
    public static String clotureModalText = "Vous êtes sur le point de clôturer des stages.";
}
