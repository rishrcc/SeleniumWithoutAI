package Pages;

public class GestionDesReglementsPage {
    public static String submenuReglements = "//button[normalize-space()='Règlements']"; //xpath
    public static String txtColumnValueRestantDu1 = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[4]/div/div/q-customgrid/div/div[2]/div/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/div[11]/span"; //xpath
    public static String checkboxFirstRow = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[4]/div/div/q-customgrid/div/div[2]/div/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]/input"; //xpath
    public static String txtColumnValueRestantDu2 = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[4]/div/div/q-customgrid/div/div[2]/div/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]/div[11]/span"; //xpath
    public static String checkboxSecondRow = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[4]/div/div/q-customgrid/div/div[2]/div/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]/div[1]/div/div/div/div[2]/input"; //xpath
    public static String txtColumnValueRestantDu3 = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[4]/div/div/q-customgrid/div/div[2]/div/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div[3]/div[11]/span"; //xpath
    public static String checkboxThirdRow = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[4]/div/div/q-customgrid/div/div[2]/div/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div[3]/div[1]/div/div/div/div[2]/input"; //xpath
    public static String txtGestionDesEcartsEtVentilationMontantPercu = "//*[@id=\"mat-input-0\"]"; //xpath
    public static String txtGestionDesEcartsEtVentilationMontantVentilation = "(//*[@id=\"montant\"])"; //xpath
    public static String txtGestionDesEcartsEtVentilationSommeDeLaVentilation = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[2]/div[2]/span/strong"; //xpath
    public static String txtGestionDesEcartsEtVentilationRestantDu = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div[2]/strong"; //xpath
    public static String txtGestionDesEcartsEtVentilationRestantDu2 = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[3]/div[2]/strong"; //xpath
    public static String txtGestionDesEcartsEtVentilationRestantDu3 = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[4]/div[2]/strong"; //xpath
    public static String btnRapprocher = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[3]/div[1]/button"; //xpath
    public static String dropdownTypeDecart = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[2]/div[2]/mat-form-field[2]/div[1]"; //xpath
    public static String txtTypeDecartMandatoryErrMessage = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[3]/div[2]/span"; //xpath
    public static String dropdownEntiteDeFacturation = "(//span[@class='mat-mdc-select-min-line ng-tns-c3393473648-2 ng-star-inserted'])[1]"; //xpath
    public static String valueTesTFormation = "//*[@id=\"mat-option-1\"]/span"; //xpath Option 0:Adams, Option 1:HPS, Option 2: DEV OF
    public static String valueTypeDecarts = "//span[@class='mdc-list-item__primary-text'][normalize-space()='%s']"; //xpath
    public static String txtErrMsgSommeDeLaVentilationDiffDuMontantPercu = "la somme de la ventilation est différente du montant perçu";
    public static String txtEcartValueForFirstRecord = "//*[@id=\"contentapp\"]/queoval-gestionreglements/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div[4]/span[2]"; //xpath
}
