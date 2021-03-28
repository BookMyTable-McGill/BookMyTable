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
import ModifyCustomerAccount from '@/components/ModifyCustomerAccount'
import ModifyRestaurantOwnerAccount from '@/components/ModifyRestaurantOwnerAccount'
import ViewCustomers from '@/components/ViewCustomers'
import OwnerRestaurantInfo from '@/components/OwnerRestaurantInfo'
import ViewRestaurantsWithLeastReservations from '@/components/ViewRestaurantsWithLeastReservations'
import ViewFeaturedRestaurants from '@/components/ViewFeaturedRestaurants'
import ModifyReservation from '@/components/ModifyReservation'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: "/",
      name: "Login",
      component: LoginPage,
    },
    {
      path: "/registration",
      name: "Registration",
      component: CreateAccountPage,
    },
    {
      path: "/restaurantInfo/",
      name: "RestaurantInfo",
      component: RestaurantInfo,
    },
    {
      path:"/ownerRestaurantInfo/",
      name:"OwnerRestaurantInfo",
      component: OwnerRestaurantInfo,
    },
    {
      path: "/CreateRestaurant/",
      name: "CreateRestaurant",
      component: CreateRestaurant,
    },
    {
      path: "/reserve",
      name: "Reserve",
      component: Reserve,
    },
    {
      path: "/getReservedTables",
      name: "ReservationMap",
      component: ReservationMap,
    },
    {
      path: "/viewRestaurants/",
      name: "viewRestaurants",
      component: ViewRestaurant,
    },
    {
      path: "/viewOwnerRestaurants",
      name: "viewOwnerRestaurants",
      component: ViewOwnerRestaurants,
    },
    {
      path: "/modifyCustomerAccount/",
      name: "ModifyCustomerAccount",
      component: ModifyCustomerAccount,
    },
    {
      path: "/modifyRestaurantOwnerAccount/",
      name: "ModifyRestaurantOwnerAccount",
      component: ModifyRestaurantOwnerAccount,
    },
    {
      path: "/customers",
      name: "ViewCustomers",
      component: ViewCustomers,
    },
    {
      path: "/viewRestaurantsWithLeastReservations/",
      name: "viewRestaurantsWithLeastReservations",
      component: ViewRestaurantsWithLeastReservations,
    },
    {
      path: "/viewFeaturedRestaurants/",
      name: "viewFeaturedRestaurants",
      component: ViewFeaturedRestaurants,
    },
    {
      path: "/modifyReservation/",
      name: "modifyReservation",
      component: ModifyReservation,
    }
  ],
});
