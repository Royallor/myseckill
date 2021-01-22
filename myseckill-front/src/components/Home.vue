<template>
  <el-container class="home-container">
    <!--头部-->
    <el-header>
      <div>
        <img src="../assets/e0ab266497850f64.gif" height="60" width="70" alt/>
        <span>狗的商城</span>
      </div>
      <el-button type="info" @click="logout">安全退出</el-button>
    </el-header>

    <el-container>
      <!--侧边栏-->
      <el-aside :width="isCollapse ?'64px':'200px'">
        <div class="toggle-button" @click="toggleCollapase">|||</div>
        <!--侧边栏菜单区 unique-opened="true" 只保持一个菜单展开 router开启路由 active-text-color 颜色-->
        <el-menu background-color="#545c64" text-color="#fff" active-text-color="#409eff" unique-opened :collapse="isCollapse"
                 :collapse-transition="false"  :router="true" :default-active="activePath">
          <el-submenu :index="item.id+''" v-for="item in menuList" :key="item.id">
            <template slot="title">
              <i :class="iconsObject[item.id]"></i>
              <span>{{item.title}}</span>
            </template>
            <el-menu-item  :index="it.path+''" v-for="it in item.sList" :key="it.id"  @click="saveNavState(it.path+'')">
              <template slot="title" >
                <i :class="iconsObject[it.id]"></i>
                <span>{{it.title}}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!--主题部分-->
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "Home",
  // 类似onload
  created() {
    this.getMenuList();
    // this.activePath = window.sessionStorage.getItem('activePath');// 取出session里的访问路径
  },
  data() {
    return {
      // 左侧菜单
      menuList: [],
      iconsObject: {
        '100':'iconfont iconguanliyuan',
        '200':'iconfont iconsport',
        '101':'iconfont icondenglu',
        '102':'iconfont iconmima',
        '103':'iconfont iconsport',
        '104':'iconfont iconshangpin',
        '201':'iconfont iconshu',
        '202':'iconfont iconkaluli',
        '203':'iconfont iconshiwu',
        '204':'iconfont icondenglu',
      },
      isCollapse:false,
      // 被激活的连接
      activePath:'',
    }
  },
  methods: {
    logout() {
      window.sessionStorage.clear();//清除session
      this.$router.push("/login"); //回到登录页
    },
    // 获取所有的导航菜单
    async getMenuList(){
      console.log("getmenulist");
      const {data:res} = await this.$http.get("menus");
      console.log(res.data);
      if( res.status != 200) return this.$message.error("操作失败！！！");
      this.menuList = res.data;
    },
    // 切换菜单折叠与展开
    toggleCollapase(){
      this.isCollapse = !this.isCollapse;
    },
    // 保存二级菜单的路径
    saveNavState(activePath){
      window.sessionStorage.setItem('activePath',activePath);// 存放点击的二级菜单
      this.activePath = activePath;// 给点击的菜单添加高亮
    },
  }
}
</script>

<style lang='less' scoped>

.home-container {
  height: 100%;
}

.el-header {
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  color: #7f97ba;
  font-size: 20px;

  > div {
    display: flex;
    align-items: center;

    span {
      margin: 15px 0 15px 0;
    }
  }
}

.el-aside {
  background-color: #333744;
  .el-menu{
    border-right: none;// 对其右边框
  }
}

.el-main {
  background-color: #eaedf1
}

.iconfont{
  margin-right: 10px;
}
.toggle-button{
  background-color:#4A5064;
  font-size: 10px;
  line-height: 24px;
  color:#fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;// 显示鼠标指针为：小手
}
</style>