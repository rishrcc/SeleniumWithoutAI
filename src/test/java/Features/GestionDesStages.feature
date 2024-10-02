Feature: Gestion des Stages

  @CreationStage
  Scenario Outline: Verify that user can create a new stage

    Given I am on Suivi des stages menu
    When I click on Creer un stage
    Then I should be able to create a new stage with catalogues <catalogues>, categories <categories>, produits <produits>, type <type>

    Examples:
      | catalogues    | categories   | produits       | type  |
      | MON CATALOGUE | MA CATEGORIE | Formation Zoom | Inter |

  @CreationClientIndividuel @Effectif
  Scenario Outline: Verify that user can create entity of type INDIVIDUAL over stage 1

    Given I am on Suivi des stages menu
    When I click on a card item
    And I click on Effectif
    Then I should be able to create an individuel client with civilite <civilite>, lastname <nom>, firstname <prenom>, function <function>, group de <groupe_de> on the stage
    And I should see the client lastname <nom> and firstname <prenom> listed under Clients
    And I should see the client lastname <nom> and firstname <prenom> listed under Apprenants
    And the BPF of client should be listed as activity <BPF> upon edit

    Examples:
      | civilite | nom        | prenom | function   | groupe_de | BPF        |
      | Madame   | Automation | Indi   | Commercial | 1         | Individuel |

  @MiseAJourApresAjoutApprenantsSurVue360 @Vue360
  Scenario Outline: Verify that after adding an apprenant to the effectif, the number of Nb stag. inscrits is reflected correctly on Vue360

    Given I create an apprenant in the Effectif with civilite <civilite>, lastname <nom>, firstname <prenom>, function <function>, group de <groupe_de> on the stage
    When I navigate to Vue 360 edit page
    Then I should see the correct number listed in Nb stag inscrits field

    Examples:
      | civilite | nom     | prenom | function   | groupe_de |
      | Monsieur | Learner | New    | Commercial | 2         |

  @MiseAJourApresModificationApprenantsSurVue306 @Vue360
  Scenario Outline: Verify that after modifying the field Group de of an apprenant in Vue360, the number of Nb stag. inscrits is reflected correctly

    Given I change the groupe de <groupe_de_increment> of an apprenant in Vue360
    When I navigate to Vue 360 edit page
    Then I should see the correct number listed in Nb stag inscrits field

    Examples:
      | groupe_de_increment |
      | 2                   |