<template>
  <div>
    <el-form :rules="loginRules" ref="loginForm" :model="loginForm" class="loginContainer">
      <h3 class="loginTitle">系统登录</h3>
      <el-form-item prop="username">
        <el-input type="text" v-model="loginForm.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="loginForm.password" placeholder="请输入密码"></el-input>
      </el-form-item>
<!--      <el-form-item prop="code">-->
<!--        <el-input type="text" v-model="loginForm.code" placeholder="点击图片更换验证码" style="width: 250px;margin-right: 5px"></el-input>-->
<!--        <img :src="captchaUrl" @click="updateCaptcha">-->
<!--      </el-form-item>-->
        <el-checkbox v-model="checked" class="loginRemember">记住我</el-checkbox>
        <el-button type="primary" style="width: 100%" @click="submitLogin">登录</el-button>

    </el-form>

    <router-view/>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      captchaUrl:"/captcha?time="+new Date(),
      loginForm: {
        username: "admin",
        password: "123456",
        code: ""
      },
      checked:true,
      loginRules:{
        username: [{required:true,message:"用户为必填项",trigger:'blur'},
          {min:3,max:10,message: "长度在3到10个字符之间",trigger: 'blur'}],
        password: [{required:true,message:"密码为必填项",trigger:'blur'},
          {min:6,max:20,message: "长度在6到20个字符之间",trigger: 'blur'}],
        code:[{required:true,message:"验证码为必填项",trigger:'blur'}]
      }
    }
  },
  methods:{
    updateCaptcha(){
      this.captchaUrl='/captcha?time='+new Date();
    },
    submitLogin(){
      this.$refs.loginForm.validate(async valid => {
        if (valid) {
          console.log(this.loginForm);
          const {data:res}= await this.$http.post('login',this.loginForm); //访问后端
          if(res.flag=="ok"){
            this.$message.success("登录成功");
            window.sessionStorage.setItem("user",res.user); //存储user对象
            this.$router.push('/');
          }else{
            this.$message.error("用户名或密码错误！");
          }
        } else {
          this.$message.error("用户名或密码错误！");
          this.$refs.loginForm.resetFields();
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>
  .loginContainer{
    border-radius: 15px;
    background-clip:padding-box;
    margin:100px auto;
    width: 350px;
    padding: 15px 35px 15px 35px;
    background:#fff;
    border:1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .loginTitle{
    margin:0 auto 40px auto;
    text-align: center;
  }
  .loginRemember{
    text-align: left;
    margin: 0 0 15px 0;
  }
</style>