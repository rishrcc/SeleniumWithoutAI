@Group2
Feature: Gestion Des Lieux

  @CreationNouveauLieux @Consultation
  Scenario Outline: Verify that a new lieux <denomination> can be created
    Given I on Gestion des lieux page
    When I click on Nouveau
    Then I should be able to create new lieux with denomination <denomination>, address 1 <adresse_1>,address 2 <adresse_2>, complement <complement>, ville code <ville_code>, ville address <ville_adresse> and country <pays>

    Examples:
      | denomination | adresse_1  | adresse_2 | complement | ville_code | ville_adresse | pays   |
      | ZZ           | Automation | Street    | Main       | 81600      | AUSSAC        | France |
      | YY           | Automation | Street    | Main       | 81600      | AUSSAC        | France |

  @AlphabeticallySorted
  Scenario Outline: Verify that the lieux <denomination_1> and <denomination_2> are alphabetically sorted in the gestion des lieux main page
    Given I on Gestion des lieux page
    Then I should see denomination A of the lieu <denomination_1> alphabetically ordered with respect to denomination B of lieu <denomination_2>

    Examples:
      | denomination_1 | denomination_2 |
      | ZZ             | YY             |

  @DenominationAsMandatoryField
  Scenario: Verify that an error message is displayed when user tries to create a new lieu without inputting the denomination
    Given I on Gestion des lieux page
    When I click on Nouveau
    Then I should not be able to create new lieux without denomination

  @DenominationAsMandatoryField @EmptySpaceAsValue
  Scenario: Verify that an error message is displayed when user tries to create a new lieu with space as the denomination value
    Given I on Gestion des lieux page
    When I click on Nouveau
    Then I should not be able to create new lieux with only space as denomination value

  @NewLieuNotCreated @Annuler
  Scenario: Verify that a new lieux is not created when user clicks on annuler button
    Given I on Gestion des lieux page
    When I click on Nouveau
    Then I should not be able to create new lieux if I click on annuler button

  @LieuDisplayedInSuiviDesStagesEffectif
  Scenario: Verify that after creation of a new lieu, the lieu is displayed under Effectif lieu (Suivi des stages)
    Given I on Gestion des lieux page
    When I click on Nouveau
    And I should to create new lieux
    Then I should see the new lieu in Effectif tab under suivi des stages

  @LieuDisplayedInSuiviDesStagesPlanning
  Scenario: Verify that after creation of a new lieu, the lieu is displayed under Planning lieu (Suivi des stages)
    Given I on Gestion des lieux page
    When I click on Nouveau
    And I should to create new lieux
    Then I should see the new lieu in Planning tab under suivi des stages

  @RechercheLieu @ResultFound
  Scenario Outline: Verify that user can search for an existing lieu by keyword <keyword>
    Given I on Gestion des lieux page
    When I search for a lieu using <keyword> as a search criteria
    Then I should see only the lieu with <keyword> displayed

    Examples:
      | keyword |
      | YY      |
      | y       |

  @RechercheLieu @ResultNotFound
  Scenario Outline: Verify that no lieu is displayed if search criteria does not match keyword <keyword>
    Given I on Gestion des lieux page
    When I search for a lieu using <keyword> as a search criteria
    Then I should not see any lieu displayed

    Examples:
      | keyword |
      | YYY     |

  @ModifyExistingLieu
  Scenario Outline: Verify that an existing lieu can be modified
    Given I on Gestion des lieux page
    And I search for a lieu using <keyword> as a search criteria
    And I should see only the lieu with <keyword> displayed
    When I click on the last lieu in the page
    Then I should be able to modify the denomination name to new denomination

    Examples:
      | keyword |
      | ZZ      |

  @DeleteALieu
  Scenario Outline: Verify that an existing lieu can be deleted
    Given I on Gestion des lieux page
    And I search for a lieu using <keyword> as a search criteria
    And I should see only the lieu with <keyword> displayed
    When I click on the last lieu in the page
    Then I should be able to delete the lieu <keyword>

    Examples:
      | keyword |
      | YY      |