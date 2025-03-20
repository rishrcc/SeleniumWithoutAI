@Group1
Feature: Catalogue Produits

  @CreateNewCatalogue
  Scenario Outline: Verify that new catalogues can be created with name <name> and verify that catalogue cannot be created without description

    Given I am on Catalogue Produits page
    When I click on Nouveau button to create new catalogue
    Then I should be able to create new catalogues with name <name>

    Examples:
      | name |
      | ZZ   |
      | YY   |

  @AlphabeticallySortedCatalogue
  Scenario Outline: Verify that the catalogue created are alphabetically ordered by description

    Given I am on Catalogue Produits page
    Then I should see catalogue A <nom_1> alphabetically ordered with respect to catalogue B <nom_2>

    Examples:
      | nom_1             | nom_2         |
      | CATALOGUE MAGIQUE | MON CATALOGUE |

  @RechercheCatalogue @ResultFound
  Scenario Outline: Verify that user can search for an existing catalogue by title <title>
    Given I am on Catalogue Produits page
    When I search for a catalogue using <title> as a search criteria
    Then I should see only the catalogues with <title> displayed

    Examples:
      | title |
      | ZZ    |

  @RechercheCatalogue @ResultNotFound
  Scenario Outline: Verify that user can search for an existing catalogue by title <title>
    Given I am on Catalogue Produits page
    When I search for a catalogue using <title> as a search criteria
    Then I should not see any catalogue displayed

    Examples:
      | title |
      | AAA   |

  @DeleteCatalogue
  Scenario: Verify that user can delete an existing catalogue
    Given I am on Catalogue Produits page
    When I click on the last catalogue listed
    Then I should be able to delete the catalogue

  @EditingCatalogue
  Scenario Outline: Verify that user can edit an existing catalogue
    Given I am on Catalogue Produits page
    And I search for a catalogue using <title> as a search criteria
    When I click on the last catalogue listed
    Then I should be able to edit name of catalogue from title <title> to <name>, collaborateur <collaborateur>, publiable webstore and devis

    Examples:
      | title | name | collaborateur |
      | YY    | Doe  | ranto andri   |

  @CreatingCategory
  Scenario Outline: Verify that user can add category <name> to an existing catalogue
    Given I am on Catalogue Produits page
    When I click on the last catalogue listed
    Then I should be able to create new category with column name <name>

    Examples:
      | name |
      | B    |
      | A    |

  @AlphabeticallySortedCategory
  Scenario Outline: Verify that the categories created are alphabetically ordered by name of category

    Given I am on Catalogue Produits page
    When I click on the last catalogue listed
    Then I should see category <nom_1> alphabetically ordered with respect to category <nom_2>

    Examples:
      | nom_1 | nom_2 |
      | A     | B     |

  @ModifyACategory
  Scenario Outline: Verify that the user can edit a category

    Given I am on Catalogue Produits page
    And I click on the last catalogue listed
    When I click on edit button for the first category
    And I should be able to modify the title to <new_title>, add an info <new_info>, set a collaborateur <new_collaborateur>
    Then I should see category <nom_1> alphabetically ordered with respect to category <new_title>

    Examples:
      | new_title | new_info        | new_collaborateur | nom_1 |
      | C         | Change of title | ranto andri       | B     |

  @AddingProduitsToACatalogue
  Scenario Outline: Verify that the user can add a product to a category

    Given I am on Catalogue Produits page
    And I search for a catalogue using <title> as a search criteria
    And I click on the last catalogue listed
    When I click on ajouter un produit for the last category
    Then I should be to add a new webstore publiable produit with intitule <intitule>, code <code>, tarif <tarif>, plan de fac <plan_fac> for the catalogue

    Examples:
      | title | intitule     | code | tarif | plan_fac     |
      | YY    | Formation RG | F01  | 100   | Formation 0% |


  @DeletionNotAllowedCatalogue
  Scenario Outline: Verify that the user cannot delete a catalogue containing a category

    Given I am on Catalogue Produits page
    And I search for a catalogue using <title> as a search criteria
    And I click on the last catalogue listed
    When I click on supprimer for the catalogue
    Then I should see the error message that catalogue cannot be deleted <cannot_delete_catalogue>

    Examples:
      | title | cannot_delete_catalogue                                                |
      | YY    | Des catégories sont présentes sur le catalogue. Suppression impossible |