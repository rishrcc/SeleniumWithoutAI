@Group2
Feature: Gestion des Reglements

  @VerificationMontant
  Scenario: Verify that montant percu, ventilation de la facture and somme de la ventilation under Gestion des ecart et ventilation screen is correct when selecting 1 facture

    Given I am Gestion des reglements page
    And I select entity
    When I select the first facture
    Then I should be see the correct montant percu, ventilation de la facture and somme de la ventilation

  @ModificationMontantPercu
  Scenario Outline: Verify that montant ventilation, somme des ventilation are pre-populated, dropdown type d'ecarts is mandatory and button Rapprocher is not clickable when Montant percu is modified

    Given I am Gestion des reglements page
    And I select entity
    When I select the first facture
    And I modify the montant percu amount by <montant_percu_amount_increment>
    Then I should not be able to click on Rapprocher button
    And I should see message <err_message>

    Examples:
      | montant_percu_amount_increment | err_message                |
      | 10                             | renseignez le type d'écart |

  @ReglementPartielImpossible @TropPercuImpossible @EcartPerteEtProfitImpossible
  Scenario Outline: Verify that depending on Montant percu and Restant du, the type d'ecarts is displayed correctly and the button Rapprocher is greyed out when necessary

    Given I am Gestion des reglements page
    And I select entity
    When I select the first facture
    And I modify the montant percu amount by <montant_percu_amount_increment>
    And I should not see type d'ecarts <type_decarts>
    And I should not be able to click on Rapprocher button

    Examples:
      | montant_percu_amount_increment | type_decarts                |
      | 10                             | Règlement partiel           |
      | -10                            | Trop perçu                  |
      | 10                             | Pertes et profits (+/- 3 €) |
      | -10                            | Pertes et profits (+/- 3 €) |


  @ReglementPartielPossible @TropPercuPossible @EcartPerteEtProfitPossible
  Scenario Outline: Verify that depending on Montant percu and Restant du, the type d'ecarts is displayed correctly and the button Rapprocher is enabled

    Given I am Gestion des reglements page
    And I select entity
    When I select the first facture
    And I modify the montant percu amount by <montant_percu_amount_increment>
    And I select type d'ecarts <type_decarts>
    And I should be able to click on Rapprocher button

    Examples:
      | montant_percu_amount_increment | type_decarts                |
      | -10                            | Règlement partiel           |
      | 10                             | Trop perçu                  |
      | 1                              | Pertes et profits (+/- 3 €) |
      | -1                             | Pertes et profits (+/- 3 €) |

  @VerificationMontant @ThreeRecordsSelected
  Scenario: Verify that montant percu, ventilation de la facture and somme de la ventilation under Gestion des ecart et ventilation screen is correct when selecting 3 factures

    Given I am Gestion des reglements page
    And I select entity
    When I select multiple factures
    Then I should be see the total sum of restant du as montant percu, total ventilation de la facture and somme de la ventilation

  @ModificationMontantPercu @ThreeRecordsSelected
  Scenario Outline: Verify that montant ventilation, somme des ventilation are pre-populated, dropdown type d'ecarts is mandatory and button Rapprocher is not clickable when Montant percu is modified

    Given I am Gestion des reglements page
    And I select entity
    When I select multiple factures
    And I modify the montant percu amount by <montant_percu_amount_increment>
    Then I should not be able to click on Rapprocher button
    And I should see message <err_message>

    Examples:
      | montant_percu_amount_increment | err_message                |
      | 10                             | renseignez le type d'écart |

  @ReglementPartielImpossible @TropPercuImpossible @EcartPerteEtProfitImpossible @ThreeRecordsSelected
  Scenario Outline: Verify that depending on Montant percu and Restant du, the type d'ecarts is displayed correctly and the button Rapprocher is greyed out when necessary

    Given I am Gestion des reglements page
    And I select entity
    When I select multiple factures
    And I modify the montant percu amount by <montant_percu_amount_increment>
    Then I cannot select type d'ecarts <type_decarts>
    And I should not be able to click on Rapprocher button

    Examples:
      | montant_percu_amount_increment | type_decarts                |
      | 10                             | Règlement partiel           |
      | -10                            | Trop perçu                  |
      | 10                             | Pertes et profits (+/- 3 €) |
      | -10                            | Pertes et profits (+/- 3 €) |


  @ReglementPartielPossible @ThreeRecordsSelected
  Scenario Outline: Verify that depending on Montant percu and Restant du, the type d'ecarts is displayed correctly and the button Rapprocher is enabled

    Given I am Gestion des reglements page
    And I select entity
    When I select multiple factures
    And I modify the montant percu amount by <montant_percu_amount_increment>
    And I chose type d'ecarts <type_decarts> for the three records
    And I adjust the montant ventilation for the first record by <montant_percu_amount_increment>
    Then I should be able to click on Rapprocher button

    Examples:
      | montant_percu_amount_increment | type_decarts                |
      | -10                            | Règlement partiel           |


  @EcartPerteEtProfitPossible @ThreeRecordsSelected
  Scenario Outline: Verify that depending on Montant percu and Restant du, the type d'ecarts is displayed correctly and the button Rapprocher is enabled

    Given I am Gestion des reglements page
    And I select entity
    When I select multiple factures
    And I modify the montant percu amount by <montant_percu_amount_increment>
    And I chose type d'ecarts <type_decarts> for the three records
    Then I should be able to click on Rapprocher button

    Examples:
      | montant_percu_amount_increment | type_decarts                |
      | 1                              | Pertes et profits (+/- 3 €) |
      | -1                             | Pertes et profits (+/- 3 €) |



  @TropPercuPossible
  Scenario Outline: Verify that depending on Montant percu and Restant du, the type d'ecarts is displayed correctly and the button Rapprocher is enabled

    Given I am Gestion des reglements page
    And I select entity
    When I select multiple factures
    And I modify the montant percu amount by <montant_percu_amount_increment>
    And I chose type d'ecarts <type_decarts> for the three records
    And I should be able to click on Rapprocher button

    Examples:
      | montant_percu_amount_increment | type_decarts |
      | 10                            | Trop perçu   |