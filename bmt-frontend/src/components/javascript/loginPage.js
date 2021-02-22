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
  name: 'createRestaurant',
  data() {
    return {

      customer: '',
      restaurantOwner: '',
      errorRestaurantOwner: '',
      errorCustomer: '',
      emailLogin: '',
      chooseAccount: '',
      pswLogin: '',
      response: []
    }
  },


  methods: {
    login: function(email, password, accountType) {

      if (accountType == 'Customer') {

        let params = {
          password: password,
          email: email
        };
        AXIOS.post('/customer/login', {}, {
            params: params
          })
          .then(response => {
            this.customer = response.data
            this.$store.state.user = this.customer
            console.log(this.$store.state)
            window.location.href = "/#/viewRestaurants/"+this.customer.id
          })
          .catch(e => {
            this.errorCustomer = e;
            console.log(e);
          })

      } else if (accountType == 'Restaurant Owner') {

        let params = {
          email: email,
          password: password

        };
        AXIOS.post('/restaurantOwner/login', {}, {
            params: params
          })
          .then(response => {
            this.restaurantOwner = response.data
            this.$store.state.user = this.restaurantOwner
            console.log(this.$store.state)
            window.location.href = "/#/CreateRestaurant/" + this.restaurantOwner.id
          })
          .catch(e => {
            this.errorRestaurantOwner = e;
            console.log(e);
          });
      }

    },


  }
}
