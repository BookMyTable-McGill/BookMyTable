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
			restaurant: '',
            errorRestaurant: '',
            reservation: '',
            errorReservation: '',
            date: '',
            appt: '',
            size: '',
            quantity: '',
            table: '',
            tables: [],
            errorTables: '',
            response: []
		}
	},

	created: function() {
		this.restaurant = this.$store.state.restaurant


    AXIOS.get('/getTables?restaurantId='+this.restaurant.id)
      .then(response => {
        this.tables = response.data
      })
      .catch(e => {
        this.errorTables = e
      })
	},
    methods:{
       
        modifyReservation: function(id,size, date, appt, table){
            AXIOS.get('/getTables/number?restaurantId='+this.restaurant.id+"&tableNumber=" + table)
        .then(response => {
          this.table = response.data
        })
        .catch(e => {
          this.errorTables = e
        })


      AXIOS.post('/reservation/?startTime=' + appt + ":00" + '&date=' + date + '&groupSize=' + size + "&tableID=" + this.table.id + '&customerID=' + this.$store.state.user.id + '&restaurantID=' + this.restaurant.id)
        .then(response => {
          this.reservation = response.data
        })
        .catch(e => {
          this.errorRestaurant = e
        })
        }
    }
}