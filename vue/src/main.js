import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '@/assets/global.css'

// // 解决重复点击报错bug
// const routerPush = VueRouter.prototype.push;
//
// VueRouter.prototype.push = function (location) {
//
//   return routerPush.call(this, location).catch(err => {})
//
// };


Vue.config.productionTip = false
Vue.use(ElementUI, { size: 'small' });

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
