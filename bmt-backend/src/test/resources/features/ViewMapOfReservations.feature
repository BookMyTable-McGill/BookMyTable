Feature: View Map Of Reservations

  As a Restaurant Owner
  I would like to query a view of the map of reservations of an owned restaurant
  So that I can have an overview of the booked table in that restaurant

  Scenario: Query map of reservations (Normal Flow)

    Given restaurant owner <restaurant_owner> is logged into BookMyTable as a restaurant owner
    And <restaurant_owner> owns <restaurant_id>
    And the following reservations are registered to the restaurant <restaurant_id>:
      | reservation_id | reservation_datetime | customer_id | table_id | table_coordinates | restaurant_id |
      | 0001           | 2021-03-23 20:34:45  | 69420       | 3246     | 0,2               | 0001          |
      | 0002           | 2021-03-23 19:48:58  | 12234       | 3240     | 0,8               | 0001          |
      | 0003           | 2021-03-23 19:15:25  | 82903       | 2358     | 2,6               | 0001          |
      | 0004           | 2021-03-23 16:32:24  | 23412       | 3246     | 0,2               | 0001          |
      | 0005           | 2021-03-23 18:29:44  | 28934       | 3266     | 3,6               | 0001          |
    When <restaurant_owner> queries reservations with <reservation_datetime> ranging from 2021-03-23 19:00:00 to 2021-03-23 20:00:00 in <restaurant_id>
    Then the following list of all tables in <restaurant_id> is returned:
      | reservation_id | customer_id | table_id | table_capacity | table_reserved | table_coordinates |
      | 0002           | 12234       | 3240     | 4              | true           | 0,8               |
      | 0003           | 82903       | 2358     | 2              | true           | 2,6               |
      | null           | null        | 3246     | 3              | false          | 0,2               |
      | null           | null        | 3266     | 2              | false          | 3,6               |
      | null           | null        | 3333     | 5              | false          | 3,3               |