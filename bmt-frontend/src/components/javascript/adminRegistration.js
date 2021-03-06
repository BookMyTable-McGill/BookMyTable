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
	data () {
		return {
			creationError: '',
			newProfile: '',
      response: []
		}
	},

	created: function() {
		console.log("backendUrl:".concat(backendUrl))
	},

	methods: {
		createAdmin: function() {
			var name = document.getElementById("name").value
			var email = document.getElementById("email").value
			var password = document.getElementById("psw").value
			var repeatPassword = document.getElementById("psw-repeat").value
			var phoneNumber = document.getElementById("phone-number").value
			var accountType = document.getElementById("accountType").value
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
			if (password.length < 6) {
				this.sendErrorMessage("Password must be at least 6 characters")
				return
			}
			if (password != repeatPassword) {
				this.sendErrorMessage("Passwords must match")
			}
            this.createAdminProfile(name, email, password)

		},
        createAdminProfile: function(name, email, password) {
            AXIOS.post("/admin/register", {}, {params: {name:name, email:email, password:password}})
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
