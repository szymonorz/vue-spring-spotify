import Vue from 'vue'
import App from './App.vue'
import VueRouter from "vue-router"
import Vuikit from "vuikit"
import ArtistInfo from "./components/ArtistInfo.vue"
import HomeComponent from "./components/HomeComponent"
import axios from "axios"
import '@vuikit/theme'
Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.use(Vuikit)

const instance = axios.create({
  baseURL: "http://192.168.0.30:8081"
})

Vue.prototype.$http = instance

const router = new VueRouter({
  mode: "history",
  routes: [
    {path: '/', name: "home", component: HomeComponent},
    {path: '/artist/:id',name:"artist", component: ArtistInfo}
  ]
})
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
