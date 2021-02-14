import axios from "axios";
import moment from "moment";
import datetime from "vuejs-datetimepicker";
//import { allTables, reservedTables } from "./testData";

var config = require("../../../config");

var frontendUrl = "http://" + config.dev.host + ":" + config.dev.port;
var backendUrl =
  "http://" + config.dev.backendHost + ":" + config.dev.backendPort;

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { "Access-Control-Allow-Origin": frontendUrl },
});

export default {
  name: "viewMapReservation",
  data() {
    return {
      restaurant: "",
      errorRestaurant: "",
      reservedTables: [],
      errorReservedTables: "",
      errorAllTables: "",
      tablesMap: null,
      response: [],
    };
  },
  created: function() {
    AXIOS.get("/getRestaurant/ID/".concat(this.$route.params.resrtaurantID))
      .then((response) => {
        this.restaurant = response.data;
      })
      .catch((e) => {
        this.errorRestaurant = e;
      });
  },
  methods: {
    getAllTables: async function() {
      try {
        const now = moment();
        let reservationDate = now.format("MM-DD-YYYY");
        let reservationTime = now.format("HH:mm:ss");

        if (this.datetime) {
          const datetime = moment(this.datetime);
          reservationDate = datetime.format("MM-DD-YYYY");
          reservationTime = datetime.format("HH:mm:ss");
        }
        const { data: allTables } = await AXIOS.get(
          "/getTables?restaurantId=" + this.restaurant.id
        );
        const { data: reservedTables } = await AXIOS.get(
          "/getReservedTables?restaurantId=" +
            this.restaurant.id +
            "&reservationDate=" +
            reservationDate +
            "&reservationTime=" +
            reservationTime
        );

        console.log(this.datetime);

        let allTablesWithReserved = [];
        allTables.forEach((t) => {
          const myTable = reservedTables.find(
            (reserved) => reserved.id === t.id
          );
          if (!myTable) {
            allTablesWithReserved.push({ ...t, reserved: false });
          } else {
            allTablesWithReserved.push({ ...t, reserved: true });
          }
        });

        const maxX = Math.max.apply(
          Math,
          allTables.map(function(t) {
            return t.x;
          })
        );
        const maxY = Math.max.apply(
          Math,
          allTables.map(function(t) {
            return t.y;
          })
        );

        const tablesMap = Array.from(Array(maxY + 1), () =>
          new Array(maxX + 1).fill(null)
        );
        allTablesWithReserved.forEach((t) => {
          tablesMap[t.y][t.x] = {
            reserved: t.reserved,
            tableNumber: t.tableNumber,
          };
        });

        this.tablesMap = tablesMap;
      } catch (err) {
        this.errorAllTables = err;
      }
    },
  },
  components: {
    datetime,
  },
};
