Feature: Gestion des Formateur

  @CreateANewFormateur
  Scenario Outline: Verify that user can create a new formateur

    Given I am on Gestion des formateur page
    When I click on New button for a formateur
    Then I should be able to create a new formateur with civilite <civilite>, lastname <nom>, firstname <prenom>, initiale <initiales>, type de contrat <type_de_contrat> on the formateur page

    Examples:
      | civilite | nom | prenom | initiales | type_de_contrat |
      | Madame   | ZZ  | Audi   | ZA        | CDD             |
      | Madame   | YY  | Audi   | YA        | CDD             |

  @AlphabeticallySortedFormateur
  Scenario Outline: Verify that the formateur created are alphabetically ordered by last name

    Given I am on Gestion des formateur page
    Then I should see lastname of the formateur A <nom_1> alphabetically ordered with respect to lastname of formateur B <nom_2>

    Examples:
      | nom_1 | nom_2 |
      | ZZ    | YY    |

  @AddDocumentToFormateur @FilterOnDocumentsStatus
  Scenario Outline: Verify that the user can add a document to an existing formateur and the filter on documents are working correctly

    Given I am on Gestion des formateur page
    When I click on the last formateur card on the Gestion des formateurs page
    And I attach a document of document status <document_status> under submenu document status <sub_menu_document_status>

    Examples:
      | sub_menu_document_status | document_status |
      | A approuver              | A approuver     |
      | Envoyé                   | Envoyé          |
      | Signé                    | Signé           |
      | A approuver              | Envoyé          |