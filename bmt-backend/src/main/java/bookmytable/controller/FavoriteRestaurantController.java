package bookmytable.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bookmytable.dao.CustomerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dto.RestaurantDTO;
import bookmytable.model.Restaurant;
import bookmytable.service.FavoriteRestaurantService;

@CrossOrigin(origins = "*")
@RestController
public class FavoriteRestaurantController {
  
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  RestaurantRepository restaurantRepository;
  @Autowired
  FavoriteRestaurantService favoriteRestaurantService;
  
  @PostMapping(value = { "/customer/favorite/add", "/customer/favorite/add/" })
  public RestaurantDTO addRestaurantToFavorites(@RequestParam(name = "email") String email,
      @RequestParam(name = "restoID") long restoID) {
    Restaurant newFavorite = favoriteRestaurantService.addRestaurantToFavorites(email, restoID);
    RestaurantDTO newFavoriteDTO = Converters.convertToDto(newFavorite);
    return newFavoriteDTO;
  }
  
  @PostMapping(value = { "/customer/favorite/remove", "/customer/favorite/remove/" })
  public RestaurantDTO removeRestaurantFromFavorites(@RequestParam(name = "email") String email,
      @RequestParam(name = "restoID") long restoID) {
    Restaurant removedFavorite = favoriteRestaurantService.removeRestaurantFromFavorites(email, restoID);
    RestaurantDTO removedFavoriteDTO = Converters.convertToDto(removedFavorite);
    return removedFavoriteDTO;
  }
  
  @GetMapping(value = { "/customer/favorites", "/customer/favorites/" })
  public List<RestaurantDTO> getFavorites(@RequestParam(name = "email") String email) {
    List<Restaurant> favorites = favoriteRestaurantService.viewFavoriteRestaurants(email);
    List<RestaurantDTO> favoriteDTOs = new ArrayList<RestaurantDTO>();
    for (Restaurant r : favorites) {
      favoriteDTOs.add(Converters.convertToDto(r));
    }
    return favoriteDTOs;
  }
  
  

}
