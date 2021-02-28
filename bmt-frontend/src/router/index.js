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
import modifyCustomerAccount from '@/components/modifyCustomerAccount'
import modifyRestaurantOwnerAccount from '@/components/modifyRestaurantOwnerAccount'

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
      path: '/restaurantInfo/',
      name: 'RestaurantInfo',
      component: RestaurantInfo
    },
    {
      path: '/CreateRestaurant/',
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
      path: '/viewRestaurants/',
      name: 'viewRestaurants',
      component: ViewRestaurant
    },
    {
      path: '/viewOwnerRestaurants',
      name: 'viewOwnerRestaurants',
      component: ViewOwnerRestaurants
    },
    {
      path: '/modifyCustomerAccount/',
      name: 'modifyCustomerAccount',
      component: modifyCustomerAccount
    },
    {
      path: '/modifyRestaurantOwnerAccount/',
      mname: 'modifyRestaurantOwnerAccount',
      component: modifyRestaurantOwnerAccount
    }
  ]
})
