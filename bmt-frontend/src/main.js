import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from '@/store/store'
import axios from 'axios'

Vue.use(router)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App },
  store: store
})

Vue.prototype.$http = axios;
const token = localStorage.getItem("token");
if (token) {
  Vue.prototype.$http.defaults.headers.common["Authorization"] = token;
}
