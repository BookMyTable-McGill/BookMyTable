import Vue from 'vue'
import Router from 'vue-router'
import CreateAccountPage from '@/components/CreateAccountPage'
import LoginPage from '@/components/LoginPage'
import RestaurantInfoPage from '@/components/RestaurantInfoPage'
//import CreateRestaurant from '@/components/CreateRestaurant'
import Reserve from '@/components/MakeReservation'

Vue.use(Router)

export default new Router({
  routes: [{
    path: '/',
    name: 'Login',
    component: LoginPage
  },
  {
    path: '/registration',
    name : 'Registration',
    component: CreateAccountPage
  },
  {
    path: '/restaurantInfo/:customerID/:restaurantID',
    name : 'RestaurantInfo',
    component: RestaurantInfoPage
  },
  {
    path: '/reserve',
    name: 'Reserve',
    component: Reserve
  }
  // ,
  // {
  //   path: '/CreateRestaurant',
  //   name: 'CreateRestaurant',
  //   component: CreateRestaurant
  // }
]


})
