Feature: Gestion Commerciale

  @Prospect @Client
  Scenario Outline: Verify that <type_pm> are both displayed in the pipe for <search_condition>

    Given I am on Action commerciale page
    When I search <client> by <search_condition>
    And I click on any of the card of the client <client_link>
    Then I should see respective type of PM <type_pm> on Action page

    Examples:
      | client              | search_condition | type_pm  | client_link     |
      | CAPTAIN             | Donneur d'ordre  | Client   | CAPTAIN AMERICA |
      | HALARA              | Donneur d'ordre  | Prospect | HALARA          |
      | STARK               | Contact          | Client   | CAPTAIN AMERICA |
      | ALBERNOI            | Contact          | Prospect | HALARA          |
      | 186                 | N° de devis      | Client   | CAPTAIN AMERICA |
      | 202                 | N° de devis      | Prospect | HALARA          |
      | AUTOMATION_CLIENT   | Tag              | Client   | CAPTAIN AMERICA |
      | AUTOMATION_PROSPECT | Tag              | Prospect | HALARA          |


  @CreationNouvelleAction @Individuel
  Scenario Outline: Verify that new <action_type> can be created for personne morale <personne_morale> and type <type_pm>

    Given I am on Action commerciale page
    When I create a new action of type <action_type>
    And I select personne morale as <personne_morale> and as type of PM <type_pm>
    And I create an individuel client with civilite <civilite>, lastname <nom>, firstname <prenom>, function <function>, group de <groupe_de> on the stage
    Then I should see fullname consisting of <nom> and <prenom> as Personne Morale
    And I should see fullname consisting of <nom> and <prenom> as Contact principal
    And I should see fullname consisting of <nom> and <prenom> as Contact under Devis tab
    And I should see fullname consisting of <nom> and <prenom> as Contact principal under Devis tab

    Examples:
      | action_type              | personne_morale | type_pm  | civilite | nom        | prenom | function   | groupe_de |
      | Devis Catalogue Actions  | Individuel      | Prospect | Madame   | Automation | Indi   | Commercial | 1         |
      | Devis Catalogue Actions  | Individuel      | Client   | Madame   | Automation | Indic  | Commercial | 1         |
      | Devis Catalogue Produits | Individuel      | Prospect | Madame   | Automation | Indip  | Commercial | 1         |
      | Devis Catalogue Produits | Individuel      | Client   | Madame   | Automation | Indipc | Commercial | 1         |