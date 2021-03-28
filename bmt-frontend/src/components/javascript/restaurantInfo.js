import axios from 'axios'
//import Router from "../../router"
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({

	baseURL: backendUrl,
	headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

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
			AXIOS.get('/getRestaurant/ID/?ID='.concat(this.$store.state.restaurant.id))
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
				this.$store.state.restaurant = this.restaurant
				window.location.href = "/#/reserve/"
			},
			openMenu: function () {
				window.open(this.restaurant.food.menuLink, "_blank");
			}
		}
	}
