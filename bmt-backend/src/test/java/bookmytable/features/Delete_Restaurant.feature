Feature: Delete Restaurant

  As a restaurant owner
  I want to delete a restaurant I own
  So that the restaurant does not exist anymore

  Background:

    Given restaurant owner <restaurant_owner_id> is logged in
    And restaurant <restaurant_id> exists
    And restaurant owner <restaurant_owner_id> owns restaurant <restaurant_id>

    Scenario: Deleting a restaurant (Normal Flow)

      Given the restaurant owner <restaurant_owner_id> wants to delete a restaurant <restaurant_id>
      When they delete restaurant <restaurant_id>
      Then restaurant <restaurant_id> will be deleted from the database