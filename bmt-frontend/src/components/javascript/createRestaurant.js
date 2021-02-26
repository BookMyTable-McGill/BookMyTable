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
	name: 'createRestaurant',
	data() {
		return {
			restaurantOwner: '',
			errorRestaurantOwner: '',
			errorRestaurant: '',
			response: []
		}
	},
	created: function() {
		AXIOS.get('/getRestaurantOwner/ID/?ID='.concat(this.$route.params.restaurantOwnerID))
			.then(response => {
				this.restaurantOwner = response.data
			})
			.catch(e => {
				this.errorRestaurantOwner = e
			})
	},

	methods: {
		createRestaurant: function(name, address, monOpTime, monCloTime, tuOpTime, tuCloTime,
			wedOpTime, wedCloTime, thuOpTime, thuCloTime, friOpTime, friCloTime,
			satOpTime, satCloTime, sunOpTime, sunCloTime,
			estDuration, menuLink, price, cuisine, options) {
			AXIOS.post('/restaurant/createRestaurant/?name=' + name + '&address=' + address + '&hours=' +
				monOpTime + ":00," + monCloTime + ":00," + tuOpTime + ":00," + tuCloTime + ":00," +
				wedOpTime + ":00," + wedCloTime + ":00," + thuOpTime + ":00," + thuCloTime + ":00," + friOpTime + ":00," + friCloTime + ":00," +
				satOpTime + ":00," + satCloTime + ":00," + sunOpTime + ":00," + sunCloTime +":00"
				+ '&owner=' + this.restaurantOwner.email + '&estDuration=' + parseInt(estDuration)
				+ '&menuLink=' + menuLink + '&price=' + parseInt(price) + '&cuisine=' + cuisine + '&options=' + options)
				.then(response => {
					alert("Restaurant Created: " + response.name)
				})
				.catch(e => {
					this.errorRestaurant = e
				})
		},
		goToReservation: function() {
			window.location.href = "/#/reservation/".concat(this.restaurant)
		}
	}
}
