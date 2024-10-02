Feature: ASPX pages

  @RecherchePersonneMorale
  Scenario Outline: Verify that user can search a personne morale of type <type> and save the BO without any errors
    Given I am logged in with valid user
    And I search for a personne morale of type <type>
    When I click on enregistrer button on the <type> tab
    Then I should not see error message

    Examples:
      | type        |
      | Client      |
      | Prospect    |
      | Fournisseur |