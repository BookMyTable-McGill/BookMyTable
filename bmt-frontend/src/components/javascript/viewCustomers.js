import axios from "axios";
//import Router from "../../router"
var config = require("../../../config");

var frontendUrl = "http://" + config.dev.host + ":" + config.dev.port;
var backendUrl =
  "http://" + config.dev.backendHost + ":" + config.dev.backendPort;

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: {
    "Access-Control-Allow-Origin": frontendUrl,
  },
});

export default {
  data() {
    return {
      customers: [],
      customerError: "",
      response: [],
      deletingError: "",
    };
  },

  created: function() {
    AXIOS.get('/customers/')
      .then((response) => {
        this.customers = response.data;
      })
      .catch((e) => {
        this.customerError = e;
      });
  },
  methods: {
    getCustPage: function(custID) {
      AXIOS.get('/getCustumer/ID/?ID='.concat(custID))
				.then(response => {
					this.$store.state.customer = response.data
				})
				.catch(e => {
					this.customerError = e
				})
			return '/#/restaurantInfo/'
    },
    deleteCustomer: function(custID) {
      AXIOS.delete("/customer/delete", {}, {params: {ID:custID}})
      .then(
        alert("You have successfully deleted the customer.")
      )
      .catch(e => {
        alert("There was an error deleting the customer.")
        this.deletingError = e;
      })
    },
  },
};
