import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.config.productionTip = false
import axios from 'axios'

Vue.use(ElementUI);
Vue.prototype.$http=axios;
axios.defaults.baseURL="Http://localhost:8888/";

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
