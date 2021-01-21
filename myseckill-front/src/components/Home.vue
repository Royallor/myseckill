<template>
  <el-container class="home-container">
    <!--头部-->
    <el-header>
      <div>
        <img src="../assets/e0ab266497850f64.gif" height="60" width="70" alt />
        <span>狗的商城</span>
      </div>
      <el-button type="info" @click="logout">安全退出</el-button>
    </el-header>

    <el-container>
      <!--侧边栏-->
      <el-aside width="200px">Aside</el-aside>
      <!--主题部分-->
      <el-main>Main</el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
name: "Home",
  methods:{
    logout() {
      window.sessionStorage.clear();//清除session
      this.$router.push("/login"); //回到登录页
    }
  }
}
</script>

<style lang='less' scoped>

.home-container{
  height: 100%;
}
.el-header{
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  color: #7f97ba;
  font-size: 20px;
  >div{
    display: flex;
    align-items: center;
    span{
      margin: 15px 0 15px 0;
    }
  }
}
.el-aside{
  background-color: #333744;
}
.el-main{
  background-color: #eaedf1
}
</style>