package bookmytable.dto;

public class FoodDTO {
  
  private Long id;
  private String menuLink;
  private int price;
  private String cuisine;
  private String options;
  private RestaurantDTO restaurant;
  
  public FoodDTO() {
    
  }

  public FoodDTO(Long id, String menuLink, int price, String cuisine, String options, RestaurantDTO restaurant) {
    super();
    this.id = id;
    this.menuLink = menuLink;
    this.price = price;
    this.cuisine = cuisine;
    this.options = options;
    this.restaurant = restaurant;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMenuLink() {
    return menuLink;
  }

  public void setMenuLink(String menuLink) {
    this.menuLink = menuLink;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getCuisine() {
    return cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }

  public RestaurantDTO getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(RestaurantDTO restaurant) {
    this.restaurant = restaurant;
  }
  
  

}
