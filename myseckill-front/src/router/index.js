import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "@/components/Home";
import Login from "@/components/Login";
import User from "@/components/admin/User";
import Goods from "@/components/Goods";
Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    redirect:'/home'
  },
  {
    path: "/login",
    name:"登录",
    component: Login
  },
  {
    path: "/home",
    name:"首页",
    component:Home,
    children: [
      { path:'/user', component: User},
      { path:'/goods', component: Goods}
    ],
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

//挂载路由导航守卫
router.beforeEach((to,from,next) => {
//  to 将要访问的页面
//  from 从哪访问
//  next 接下来要干 next(url) 重定向到url next() 继续访问to的路径
  if(to.path == '/login') return next();
  //获取user
  const userKey=window.sessionStorage.getItem("user"); //取出用户
  if(!userKey) return next('/login');
  next();
})

export default router
