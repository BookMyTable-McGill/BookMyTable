package bookmytable.model;

import javax.persistence.Entity;
import javax.persistence.Id;
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

private long id;

public void setId(long value) {
    this.id = value;
}

@Id
public long getId() {
    return this.id;
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
   
   @OneToOne(optional=true)
   public Restaurant getRestaurant() {
      return this.restaurant;
   }
   
   public void setRestaurant(Restaurant restaurant) {
      this.restaurant = restaurant;
   }
   
   }
