import axios from 'axios'
//import Router from "../../router"
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({

	baseURL: backendUrl,
	headers: {
		'Access-Control-Allow-Origin': frontendUrl
	}
})

export default {
	data() {
		return {
			restaurants: [],
			restaurantError: '',
			favoriteRestaurants: [],
			favoriteRestaurantIDs: [],
			customer: '',
			response: [],
			filterType: '',
		}
	},

	created: function() {
		this.customer = this.$store.state.user;
		this.getFavorites()
		AXIOS.get('/featuredRestaurants/')
			.then((response) => {
				this.restaurants = response.data;
			})
			.catch((e) => {
				this.restaurantError = e;
			});
	},
	methods: {
		getRestoPage: function(restoID) {
			AXIOS.get('/getRestaurant/ID/?ID='.concat(restoID))
				.then(response => {
					this.$store.state.restaurant = response.data
				})
				.catch(e => {
					this.restaurantError = e
				})
			return '/#/restaurantInfo/'

		},addToFavorites: function(restaurant) {
			AXIOS.post('/customer/favorite/add?email='.concat(this.customer.email, '&restoID=', parseInt(restaurant.id)))
			.then(response => {
				alert(restaurant.name.concat(" was added to your favorites!"))
				restaurant.isFavorite = true
				this.favoriteRestaurants.push(response.data)
				this.favoriteRestaurantIDs.push(response.data.id)
			}).catch(e => {
				this.restaurantError = e
			})
		},removeFromFavorites: function(restaurant) {
			AXIOS.post('/customer/favorite/remove?email='.concat(this.customer.email, '&restoID=', parseInt(restaurant.id)))
			.then(response => {
				alert(restaurant.name.concat(" was removed from your favorites"))
				restaurant.isFavorite = false
				this.response.push(response)
			}).catch(e => {
				this.restaurantError = e
			})
		},getFavorites: function() {
			this.favoriteRestaurants = []
			this.favoriteRestaurantIDs = []
			AXIOS.get('/customer/favorites?email='.concat(this.customer.email))
			.then(response => {
				this.favoriteRestaurants = response.data
				this.favoriteRestaurants.forEach(element => {
					this.favoriteRestaurantIDs.push(element.id)
				});
			}).catch(e => {
				this.restaurantError = e
			})
		}
	}
}
