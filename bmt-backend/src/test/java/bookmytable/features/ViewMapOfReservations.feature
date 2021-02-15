Feature: View Map Of Reservations

  As a Restaurant Owner
  I would like to query a view of the map of reservations of an owned restaurant
  So that I can have an overview of the booked table in that restaurant

  Scenario: Query map of reservations (Normal Flow)

    Given restaurant owner <restaurant_owner> is logged into BookMyTable as a restaurant owner
    And <restaurant_owner> owns <restaurant_id>
    And the following reservations are registered to the restaurant <restaurant_id>:
      | reservation_id | reservation_date| reservation_time | customer_name | table_id | table_coordinates | restaurant_id |
      | 0001           | 2021-03-23      | 20:34:45         | adam        | 1        | 0,2               | 0001          |
      | 0002           | 2021-03-23      | 19:48:58         | tom        | 2        | 0,8               | 0001          |

    When <restaurant_owner> queries reservations with <reservation_datetime> ranging from 2021-03-23 19:00:00 to 2021-03-23 20:00:00 in <restaurant_id>
    Then the following list of all tables in <restaurant_id> is returned:
      | reservation_id | customer_name | table_id | table_capacity | table_coordinates |
      | 0002           | tom           | 2        | 5              | 0,8               |