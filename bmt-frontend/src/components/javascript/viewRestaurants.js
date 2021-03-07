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
			response: []
		}
	},

	created: function() {
		AXIOS.get('/restaurants')
			.then(response => {
				this.restaurants = response.data
			})
			.catch(e => {
				this.restaurantError = e
			})
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

		},
		getRestaurantsByCuisine: function(cuisine) {
			AXIOS.get("/restaurants/cuisine", {}, {cuisine:cuisine})
			.then(response => {
				this.restaurants = response.data
			})
		}, 
		getRestaurantsByOption: function(options) {
			AXIOS.get("/restaurants/options", {}, {options:options})
			.then(response => {
				this.restaurants = response.data
			})
		}
	},
	computed: {
		filterRestaurantsByFood: function() {
			var searchType = document.getElementById("foodSearch").value
			var searchText = document.getElementById("searchBar").value
			if(searchType == "By Cuisine") {
				this.getRestaurantsByCuisine(searchText)
			} else {
				this.getRestaurantsByOption(searchText)
			}
		}
	}
}
