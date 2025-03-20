@Group1
Feature: Cloture en masse

  @FilterByType @FilterByState @FilterByCursus @DateOfStage
  Scenario Outline: Verify that user can filter stages by type of stage <type_stage>, state of stage <state_stage> and cursus of stage <cursus_stage>

    Given I am on Cloture en masse page
    And I select to retrieve all stages of the current year
    And I see that the end date of stage filter is populated by yesterday date
    Then I should be able to filter by type of stage <type_stage>
    And I should be able to filter by state of stage <state_stage>
    And I should be able to filter by cursus of stage <cursus_stage>

    Examples:
      | type_stage | state_stage           | cursus_stage |
      | Inter      | En cours              | Tous         |
      | Intra      | A repositionner       | Tous         |
      | Session    | A facturer maintenant | Tous         |

  @ClotureEnMasse @ConfirmCloture
  Scenario Outline: Verify that user is able to close more than one stage at the same time

    Given I am on Cloture en masse page
    And I select multiple stages at the same time
    When I click on <action> the cloture en masse
    Then I should expect the stage in the list to be deleted

    Examples:
      | action  |
      | confirm |

  @ClotureEnMasse @CancelCloture
  Scenario Outline: Verify that user is able to cancel a closure of stage

    Given I am on Cloture en masse page
    And I select multiple stages at the same time
    When I click on <action> the cloture en masse
    Then I should expect the stage in the list to not be deleted

    Examples:
      | action |
      | cancel |

#  @EditStage @AddCursus @ResetDate
#  Scenario: Verify that user can edit stage from cloture en masse page to add a cursus after reseting the end date of stage

#    Given I am on Cloture en masse page
#    And I click on date reset button
#    When I click on Edit button for the first stage in the list
#    Then I should be able to edit the cursus of the stage