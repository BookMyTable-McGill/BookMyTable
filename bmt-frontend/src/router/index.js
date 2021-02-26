import Vue from 'vue'
import Router from 'vue-router'
import CreateAccountPage from '@/components/CreateAccountPage'
import LoginPage from '@/components/LoginPage'
import RestaurantInfo from '@/components/RestaurantInfo'
import CreateRestaurant from '@/components/CreateRestaurant'
import Reserve from '@/components/MakeReservation'
import ReservationMap from '@/components/ViewMapReservation'
import ViewRestaurant from '@/components/ViewRestaurants'
import ViewOwnerRestaurants from '@/components/ViewOwnerRestaurants'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      name: 'Login',
      component: LoginPage
    },
    {
      path: '/registration',
      name: 'Registration',
      component: CreateAccountPage
    },
    {
      path: '/restaurantInfo/:restaurantID/:userID',
      name: 'RestaurantInfo',
      component: RestaurantInfo
    },
    {
      path: '/CreateRestaurant/:restaurantOwnerID',
      name: 'CreateRestaurant',
      component: CreateRestaurant
    },
    {
      path: '/reserve',
      name: 'Reserve',
      component: Reserve
    },
    {
      path: '/getReservedTables',
      name: 'ReservationMap',
      component: ReservationMap
    },
    {
      path: '/viewRestaurants/:userID',
      name: 'viewRestaurants',
      component: ViewRestaurant
    },
    {
      path: '/viewOwnerRestaurants',
      name: 'viewOwnerRestaurants',
      component: ViewOwnerRestaurants
    }
  ]
})
