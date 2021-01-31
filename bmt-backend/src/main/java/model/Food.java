package model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Food{
   private String menuLink;

public void setMenuLink(String value) {
    this.menuLink = value;
}
public String getMenuLink() {
    return this.menuLink;
}
private int price;

public void setPrice(int value) {
    this.price = value;
}
public int getPrice() {
    return this.price;
}
private String cuisine;

public void setCuisine(String value) {
    this.cuisine = value;
}
public String getCuisine() {
    return this.cuisine;
}
private String options;

public void setOptions(String value) {
    this.options = value;
}
public String getOptions() {
    return this.options;
}
   private Restaurant restaurant;
   
   @OneToOne(optional=false)
   public Restaurant getRestaurant() {
      return this.restaurant;
   }
   
   public void setRestaurant(Restaurant restaurant) {
      this.restaurant = restaurant;
   }
   
   }
