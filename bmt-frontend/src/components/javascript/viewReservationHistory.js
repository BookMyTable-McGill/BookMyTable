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
      reservations: [],
      reservationError: "",
      customer: {},
      response: [],
    };
  },
  created: function() {
    this.customer = this.$store.state.user;
    this.reservations = this.customer.reservations;
  },
  methods: {
    getRestoPage: function(customerId) {
      AXIOS.get('getReservationHistory/' + customerId)
        .then((res) => {
          this.reservations = res.data;
        })
        .catch((e) => {
          this.reservationError = e;
        });
    },
  },
};
