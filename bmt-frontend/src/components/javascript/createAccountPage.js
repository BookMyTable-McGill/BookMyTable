import axios from 'axios'
var config = require('../../../config')

var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl
})

export default {
	data () {
		return {
			creationError: '',
			newProfile: '',
      response: []
		}
	},
	methods: {
		createProfile: function() {
			var name = document.getElementById("name").value
			var email = document.getElementById("email").value
			var password = document.getElementById("psw").value
			var repeatPassword = document.getElementById("psw-repeat").value
			var phoneNumber = document.getElementById("phone-number").value
			var accountType = document.getElementById("accountType").value
			console.log(name.concat(email, password, repeatPassword, phoneNumber))
			if (name == "") {
				this.sendErrorMessage("Name cannot be empty")
				return
			}
			if (email == "") {
				this.sendErrorMessage("Email cannot be empty")
				return
			}
			if (password == "") {
				this.sendErrorMessage("Password cannot be empty")
				return
			}
			if (repeatPassword == "") {
				this.sendErrorMessage("Please re-enter your password")
				return
			}
			if (accountType != "Customer" && accountType != "Restaurant Owner") {
				this.sendErrorMessage("Please choose an account type")
				return
			}
			if (password.length < 6) {
				this.sendErrorMessage("Password must be at least 6 characters")
				return
			}
			if (password != repeatPassword) {
				this.sendErrorMessage("Passwords must match")
			}
			if (accountType == "Customer") {
				this.createCustomerProfile(name, email, password, phoneNumber)
			} else if (accountType == "Restaurant Owner") {
				this.createRestaurantOwnerProfile(name, email, password)
			} else {
				this.sendErrorMessage("Unexpected account type")
			}

		},
		createCustomerProfile: function(name, email, password, phoneNumber) {
			if (phoneNumber == "") {
				this.sendErrorMessage("Phone number cannot be empty")
			}
			AXIOS.post("/customer/register", {}, {params: {name:name, email:email, password:password, phoneNumber:phoneNumber}})
			.then(response => {
				alert("Congratulations on creating your account!")
				this.newProfile = response.data
				window.location.href = "/#/"
			})
			.catch(e => {
				alert("An account with this email already exists.")
				this.creationError = e
			})
		},
		createRestaurantOwnerProfile: function(name, email, password) {
			AXIOS.post("/restaurantOwner/register", {}, {params: {name:name, email:email, password:password}})
			.then(response => {
				alert("Congratulations on creating your account!")
				this.newProfile = response.data
				window.location.href = "/#/"
			})
			.catch(e => {
				alert("An account with this email already exists.")
				this.creationError = e
			})
		},
		sendErrorMessage: function(error) {
			console.log(error)
			this.creationError = error
			alert(error)
		}
	}
}
