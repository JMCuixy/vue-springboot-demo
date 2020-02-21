import Vue from 'vue'
import Router from 'vue-router'

const loginpage = resolve => require(['@/components/Login'], resolve)

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: loginpage
    },
    {
      path: '/login',
      name: 'login',
      component: loginpage
    }
  ]
})
