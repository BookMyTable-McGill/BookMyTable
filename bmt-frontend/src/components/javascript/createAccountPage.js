import axios from 'axios'
var config = require('../../../config')

var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl
})

export default {
	data () {
		creationError: ''
	},
	created: function() {

	},
	methods: {
		createProfile: function(name, email, password, repeatPassword, accountType) {
			if (name == "") {
				this.sendErrorMessage("Name cannot be empty")
				return
			}
			if (email = "") {
				this.sendErrorMessage("Email cannot be empty")
				return
			}
			if (password = "") {
				this.sendErrorMessage("Password cannot be empty")
				return
			}
			if (repeatPassword = "") {
				this.sendErrorMessage("Please re-enter your password")
				return
			}
			if (accountType = "") {
				this.sendErrorMessage("Please choose an account type")
				return
			}
			if (password.length < 6) {
				this.sendErrorMessage("Password must be at least 6 characters")
				return
			}

		},
		createCustomerProfile: function(name, email, password, phoneNumber) {

		},
		createRestaurantOwnerProfile: function(name, email, password) {

		},
		sendErrorMessage: function(error) {
        	console.log(error)
        	this.creationError = error
        	alert(error)
		}
	}
}