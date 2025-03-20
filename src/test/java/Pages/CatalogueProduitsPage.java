package Pages;

public class CatalogueProduitsPage {

    public static String btnNouveauCatalogue = "//*[@id=\"contentapp\"]/catalogues-produits/div/div[1]/button"; //xpath
    public static String headerNouveauCatalogue = "//*[@id=\"MainIndexBody\"]/ngb-modal-window/div/div/div/div[1]/div";// Nouveau catalogue  //xpath
    public static String txtDescription = "//input[@placeholder='Description']"; //xpath
    public static String btnEnregistrer = "//*[@id=\"MainIndexBody\"]/ngb-modal-window/div/div/div/div[2]/button"; //xpath
    public static String countOfCatalogue = "//*[@id=\"contentapp\"]/catalogues-produits/div/div[2]/div/article"; //xpath
    public static String txtRechercheCatalogue = "//input[@placeholder='Tapez ici...']"; //xpath
    public static String btnSupprimerCatalogue = "//button[normalize-space()='Supprimer']"; //xpath
    public static String btnConfirmDeletion = "//button[normalize-space()='Oui, supprimer']"; //xpath
    public static String txtNomDuCatalogue = "//input[@placeholder='Rechercher']"; //xpath
    public static String dropdownCollaborateur = "//body/queoval-root/ng-component/div/div/catalogues-produits/div/div/div/mat-form-field/div/div/div/mat-select[@role='combobox']/div/div[1]";
    public static String dropdownCollaborateurValue = "//span[normalize-space()='%s']";
    public static String radioCatalogueWebstore = "//body/queoval-root/ng-component/div/div/catalogues-produits/div/div/div/mat-slide-toggle[1]/div[1]/button[1]"; //xpath set "aria-checked" attribute to true
    public static String radioCatalogueDevis = "/html/body/queoval-root/ng-component/div[2]/div[3]/catalogues-produits/div/div[1]/div[1]/mat-slide-toggle[2]/div/button"; //xpath set "aria-checked" attribute to true
    public static String btnBackToCatalogue = "//img[@alt='Retour']"; //xpath
    public static String btnAddCategorieToCatalogue ="//b[normalize-space()='Ajouter une catégorie']"; //xpath
    public static String txtCategoryName = "//mat-label[normalize-space()='Nom de la colonne']"; //xpath
    public static String btnSaveCategory = "//catalogues-produits//button[2]//i[1]"; //xpath
    public static String countOfCategoryColumns ="//*[@id=\"contentapp\"]/catalogues-produits/div/div[2]/q-pipes/div/div"; //xpath
    public static String btnCategoryEdit = "//*[@id=\"contentapp\"]/catalogues-produits/div/div[2]/q-pipes/div/div[1]/div[1]/button/i"; //xpath
    public static String txtCategoryTitle = "//*[@placeholder=\"Titre\"]"; //xpath
    public static String txtInfo = "//*[@placeholder='Info']"; //xpath
    public static String dropdownCateogryCollaborateur = "/html/body/ngb-modal-window/div/div/div/div[2]/mat-form-field[2]/div[1]/div[2]/div/mat-select/div/div[1]/span"; //xpath
    public static String dropdownCategoryCollaborateurValue ="//mat-option[@role='option']//span[contains(text(),'%s')]"; //xpath
    public static String radioCategoryWebstore = "/html/body/ngb-modal-window/div/div/div/div[2]/mat-slide-toggle/div/button"; //xpath
    public static String btnSaveNewCategoryDetails = "//button[normalize-space()='Enregistrer']"; //xpath
    public static String txtCatalogueTitle = "(//b[contains(text(),'C')])"; //xpath
    public static String btnAjouterProduit = "(//b[contains(text(),'Ajouter un produit')])"; //xpath
    public static String txtIntituleDeFormation = "//input[@aria-describedby='DesigPRO-btn']"; //xpath
    public static String txtCode = "//input[@aria-describedby='Code_PRO-btn']"; //xpath
    public static String txtTarifPrincipal = "//input[@aria-describedby='Prix_PRO-btn']"; //xpath
    public static String dropdownPlanDeFacturation = "//*[@id=\"CodauPRO\"]"; //xpath
    public static String checkboxPubliableWebstore = "/html[1]/body[1]/queoval-root[1]/ng-component[1]/div[2]/div[3]/produits-details[1]/div[1]/div[2]/q-bodisplay[1]/div[1]/div[2]/div[5]/q-dynamic-tag-group[1]/div[1]/div[5]/div[1]/q-dynamictag[1]/div[1]/label[1]/span[1]"; //xpath
    public static String btnSaveProduct = "//i[@class='fa-save fas']"; //xpath
    public static String txtModalCannotDeleteCatlogue = "//p[contains(text(),'%s')]"; //xpath
}
