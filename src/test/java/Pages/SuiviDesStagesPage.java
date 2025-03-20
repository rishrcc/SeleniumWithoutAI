package Pages;

public class SuiviDesStagesPage {
    public static String btnCreateNewStage = "div[class='board ng-star-inserted'] div:nth-child(1) div:nth-child(1) div:nth-child(3) div:nth-child(1) i:nth-child(1)"; //css
    public static String btnSubCreateNewStage = ".rounded-button.q-dark-secondary.mx-1.q-pointer.font-weight-bold.q-danger"; //css
    public static String btnCreateStageCatalogueProduit = "//div[normalize-space()='Catalogue produit']"; //Xpath
    public static String dropdownStageType = ".q-main-select.col-4.ng-untouched.ng-pristine.ng-valid"; //css
    public static String txtStartDate = "//*[@id=\"DatedPRO\"]"; //xpath
    public static String txtEndDate = "//*[@id=\"DatefPRO\"]"; //xpath
    public static String headerCreationOfStage = "//h5[normalize-space()='Action']"; //xpath
    public static String dropdownTypeCreateStage = "(//select[@class='col q-main-select q-bo-select q-bo-wrap q-bo-required'])[3]"; //xpath
    public static String dropdownEtatCreateStage = "//*[@id=\"Etat_PRO\"]"; //xpath
    public static String btnSaveStageForm = "div[class='d-flex align-items-center mb-4'] button[class='q-btn q-main ng-star-inserted']"; //css
    public static String cardCountLastInPlanifee = "//*[@id=\"0\"]/div/div[2]/cdk-virtual-scroll-viewport/div[1]/a[last()]/queoval-stage-pipe-card/div/div[3]/div[2]/div[3]/span"; //xpath
    public static String cardLastTitle = "//*[@id=\"0\"]/div/div[2]/cdk-virtual-scroll-viewport/div[1]/a[last()]/queoval-stage-pipe-card/div/div[2]/div[1]"; //xpath
}
