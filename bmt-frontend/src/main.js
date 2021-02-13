import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.use(router)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
