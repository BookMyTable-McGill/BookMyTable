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
      restaurant: '',
      errorRestaurant: '',
      reservation: '',
      errorReservation: '',
      date: '',
      appt: '',
      size: '',
      quantity: '',
      table: '',
      response: []
    }
  },
  created: function() {
    AXIOS.get('/getRestaurant/ID/'.concat(this.$route.params.restaurantID))
      .then(response => {
        this.restaurant = response.data
      })
      .catch(e => {
        this.errorRestaurant = e
      })
  },
  methods: {
    goToReservation: function() {
      window.location.href = "/#/reservation/".concat(this.restaurant)
    },
    createReservation: function(size, date, appt, table ) {
      //Need to add table id
      AXIOS.post('/reservation/?startTime=' + appt + '&date=' + date + '&groupsize=' + size + table + '&customerID=' + this.$route.params.customerID + '&restaurantID=' + this.$route.params.restaurantID)
      .then(response =>{
        this.reservation = response.data
      })
      .catch(e => {
        this.errorRestaurant = e
      })
    },
  }
}
