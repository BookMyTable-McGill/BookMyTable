import Vue from 'vue'
import Router from 'vue-router'
import CreateAccountPage from '@/components/CreateAccountPage'
import LoginPage from '@/components/LoginPage'
//import CreateRestaurant from '@/components/CreateRestaurant'

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
  }
  // ,
  // {
  //   path: '/CreateRestaurant',
  //   name: 'CreateRestaurant',
  //   component: CreateRestaurant
  // }
]


})
