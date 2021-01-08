import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import User from "@/views/User";
import PageOne from "@/views/PageOne";
import PageTwo from "@/views/PageTwo";
import PageThree from "@/views/PageThree";
import PageFour from "@/views/PageFour";
import App from "@/App";
import Index from "@/views/Index";
Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home
  // },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // },
  // {
  //   path: "/user",
  //   name: "User",
  //   component: User
  // },
  {
    path: "/",
    name: "导航1",
    component: Index,
    redirect:"/pageone",
    children: [
      {
        path: "/pageone",
        name: "页面1",
        component: PageOne
      },
      {
        path: "/pagetwo",
        name: "页面2",
        component: PageTwo
      },
    ]
  },
  {
    path: "/navigation",
    name: "导航2",
    component: Index,
    children: [
      {
        path: "/pagethree",
        name: "页面3",
        component: PageThree
      },
      {
        path: "/pagefour",
        name: "页面4",
        component: PageFour
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
