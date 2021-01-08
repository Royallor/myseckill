<template>
  <el-table
      :data="tableData"
      border
      style="width: auto">
    <el-table-column
        fixed
        prop="id"
        label="id"
        width="150">
    </el-table-column>
    <el-table-column
        prop="username"
        label="姓名"
        width="120">
    </el-table-column>
    <el-table-column

        label="操作"
        width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  methods: {
    handleClick(row) {
      console.log(row);
    }
  },

  data() {
    return {
      tableData: [
        {
          id: 1,
          username: "张三"
        }
      ]
    }
  }
}
</script>