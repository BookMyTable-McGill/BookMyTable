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
			modificationError: '',
			account: '',
      response: []
		}
	},

	created: function() {
		console.log("backendUrl:".concat(backendUrl))
	},

    methods:{
        modifyCustAccount: function(){
            var name = document.getElementById("name").value 
            var email = document.getElementById("email").value
			var oldPassword = document.getElementById("old-psw").value
			var newPassword = document.getElementById("new-psw").value
            var repeatPassword = document.getElementById("new-psw-repeat").value
			var phoneNumber = document.getElementById("phone-number").value
            var id = this.$store.state.user.id

            if (newPassword.length < 6) {
				this.sendErrorMessage("Password must be at least 6 characters")
				return
			}
			if (newPassword != repeatPassword) {
				this.sendErrorMessage("Passwords must match")
			}

            if(newPassword == ""){
                    this.modifyCustAccount(id, name, email,oldPassword,phoneNumber)
            }
            else{
                this.modifyCustAccount(id, name, email,newPassword,phoneNumber)
            }

        },
        modifyCustAccount: function(id,name,email,password,phoneNumber){
            AXIOS.post("/customer/edit-info", {}, {params: {id:id, name:name, email:email, password:password, phoneNumber:phoneNumber}})
			.then(response => {
				alert("Congratulations on modifying your account information!")
				this.account = response.data
				window.location.href = "/#/"
			})
			.catch(e => {
				alert("An account with this email already exists.")
				this.modificationError = e
			})
        }
    }
}