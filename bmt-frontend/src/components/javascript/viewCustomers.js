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
    };
  },

  created: function() {
    AXIOS.get("/customers")
      .then((response) => {
        this.customers = response.data;
      })
      .catch((e) => {
        this.customerError = e;
      });
  },
  methods: {
    getRestoPage: function() {
      
    },
  },
};
