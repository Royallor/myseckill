<template>

  <el-row>
    <!--居中-->
    <el-col :span="8" :offset="8">
      <div id="login">
        <h3 style="text-align: center">登录页面</h3>
        <el-form ref="form" label-width="100px">
          <el-form-item label="用户名">
            <el-input v-model="username" class="input" ></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="password" class="input" type="password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="login()">登录</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-col>
  </el-row>
</template>

<script>
import Qs from 'qs'
export default {
  name: "Login",
  data(){
    return {
      username:"",
      password:""
    }
  },
  methods:{
    login(){
      const _this=this
      //登录
    this.axios({
      method:"POST",
      url:"http://localhost:8888/user/login",
      transformRequest: [function(data){
        return Qs.stringify(data)
      }],
      data:{
        username:this.username,
        password:this.password
      }
    }).then(function (resp){
      if(resp.data == "success"){
        //登录成功
        _this.$message({
          message: '登录成功！',
          type: 'success',
          duration: 1000
        });
        //跳转到首页
        _this.$router.push("/Home");
      }else {
        //登录失败
        _this.$message.error("用户名或密码错误");
      }
    });
    }
  }
}
</script>

<style scoped>
.input{
  width: 300px;
  min-width: 200px;
}
#login{
  margin-top: 100px;
  width: 500px;
  height: 300px;
  border: 1px solid deepskyblue;
  border-radius: 20px;
}
</style>