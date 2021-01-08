<template>
  <div>
    <table>
      <tr>
        <td>id</td>
        <td>用户名</td>
      </tr>
      <tr v-for="item in users">
        <td>{{item.id}}</td>
        <td>{{item.username}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "User",
  data(){
    return{
      msg:"hello vue",
      users:[
        {
          id:0,
          username:"李四"
        }
      ]
    }
  },
  created() {
    const _this=this
    axios.get("http://localhost:8888/users/findAll").then(function (resp){
        _this.users=resp.data
    })
  }
}
</script>

<style scoped>

</style>