// import axios from 'axios'
//import Router from "../../router"
// var config = require('../../../config')
//
// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort
//
// var AXIOS = axios.create({
//
//   baseURL: backendUrl,
//   headers: {
//     'Access-Control-Allow-Origin': frontendUrl
//   }
// })

export default {
  data() {
    return {
      restaurants: [],
      restaurantError: '',
      restaurantOwner:'',
      response: []
    }
  },
  created: function() {
    this.restaurantOwner = this.$store.state.user
    this.restaurants = this.restaurantOwner.restaurants
  },
  methods:{
    getRestoPage: function (restoID) {
			return '/#/restaurantInfo/'+restoID + "/"+ this.$route.params.userID
		},
  }
}
