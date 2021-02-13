import axios from 'axios'
//import Router from "../../router"
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({

	baseURL: backendUrl,
	headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

/*
	function CustomerDTO(name, email, password, id, phoneNumber, reservations, favoriteRestaurants) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.reservations = reservations;
		this.favoriteRestaurants = favoriteRestaurants;
	}
	
	function AccountTypeDTO(name, email, password, id) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
	}
	
	function FoodDTO(id, menuLink, price, cuisine, options, restaurant) {
		this.id = id;
		this.menuLink = menuLink;
		this.price = price;
		this.cuisine = cuisine;
		this.options = options;
		this.restaurant = restaurant;
	}
	
	function ReservationDTO(startTime, endTime, date, groupSize, id, table,
		customer, restaurant) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.groupSize = groupSize;
		this.id = id;
		this.table = table;
		this.customer = customer;
		this.restaurant = restaurant;
	}
	
	function RestaurantOwnerDTO(name, email, password, id, restaurants) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.restaurants = restaurants;
	}
	
	function TableDTO(id, capacity, x, y, tableNumber, restaurant, reservations) {
		this.id = id;
		this.capacity = capacity;
		this.x = x;
		this.y = y;
		this.tableNumber = tableNumber;
		this.restaurant = restaurant;
		this.reservations = reservations;
	}
	
	function RestaurantDTO(id, name, address, openingHours, isBooked,
		estimatedDuration, food, map, reservations, restaurantOwner) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.openingHours = openingHours;
		this.isBooked = isBooked;
		this.estimatedDuration = estimatedDuration;
		this.food = food;
		this.map = map;
		this.reservations = reservations;
		this.restaurantOwner = restaurantOwner;
	}
*/
	export default {
		name: 'restaurantInfo',
		data() {
			return {
				restaurant: '',
				errorRestaurant: '',
				openingHours: '',
				response: []
			}
		},
		created: function() {
			AXIOS.get('/getRestaurant/ID/'.concat(this.$route.params.restaurantID))
				.then(response => {
					this.restaurant = response.data
					let hoursList = this.restaurant.openingHours
					this.openingHours = "Sun: " + hoursList[0][0] + " - " + hoursList[0][1] + '\n'
										+ "Mon: " + hoursList[1][0] + " - " + hoursList[1][1] + '\n'
										+ "Tue: " + hoursList[2][0] + " - " + hoursList[2][1] + '\n'
										+ "Wed: " + hoursList[3][0] + " - " + hoursList[3][1] + '\n'
										+ "Thu: " + hoursList[4][0] + " - " + hoursList[4][1] + '\n'
										+ "Fri: " + hoursList[5][0] + " - " + hoursList[5][1] + '\n'
										+ "Sat: " + hoursList[6][0] + " - " + hoursList[6][1] + '\n'
				})
				.catch(e => {
					this.errorRestaurant = e
				})
		},
		methods: {
			goToReservation: function() {
				window.location.href = "/#/reservation/".concat(this.restaurant)
			}
		}
	}