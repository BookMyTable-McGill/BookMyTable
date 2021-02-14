import axios from 'axios'
import datetime from 'vuejs-datetimepicker'
import { allTables, reservedTables } from './testData';

var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
	baseURL: backendUrl,
	headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


export default {
    name: 'viewMapReservation',
    data() {
        return {
            restaurant: '',
            errorRestaurant: '',
            reservedTables: [],
            errorReservedTables: '',
            errorAllTables: '',
            tablesMap: null,
            response: []
        }
    },
    created: function () {
        // AXIOS.get('/getRestaurant/ID/'.concat(this.$route.params.restaurantID))
        //     .then(response => {
        //     this.restaurant = response.data
        //     })
        //     .catch(e => {
        //     this.errorRestaurant = e
        //     })
    },
    methods: {
        getAllTables: async function (reservationDate, reservationTime) {
            try {
                // const { data: allTables } = await AXIOS.get('/getTables?restaurantId=' + this.restaurant.id)
                // const { data: reservedTables } = await AXIOS.get('/getReservedTables?restaurantId=' + this.restaurant.id + '&reservationDate=' + reservationDate + '&reservationTime=' + reservationTime)

                let allTablesWithReserved = []
                allTables.forEach(t => {
                    const myTable = reservedTables.find(reserved => reserved.id === t.id);
                    if (!myTable) {
                        allTablesWithReserved.push({...t, reserved: false});
                    } else {
                        allTablesWithReserved.push({...t, reserved: true}); 
                    }
                });

                
                
                const tablesMap = [
                    [null, null, null, null],
                    [null, null, null, null],
                    [null, null, null, null],
                    [null, null, null, null],
                ];
                allTablesWithReserved.forEach(t => {
                    tablesMap[t.y][t.x] = t.reserved
                })
                
                this.tablesMap = tablesMap
            } catch (err) {
                this.errorAllTables = err
            }
        }
    },
    components: {
        datetime
    }
}