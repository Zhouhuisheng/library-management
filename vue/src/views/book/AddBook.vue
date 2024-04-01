<template>
    <div>
        <div style="padding: 20px; text-align: center">新增图书</div>
        <el-form :inline="true" :model="form" label-width="100px">
            <el-form-item label="图书名">
                <el-input style="width: 250px" placeholder="请输入图书名" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input style="width: 250px" placeholder="请输入备注" v-model="form.description"></el-input>
            </el-form-item>
            <el-form-item label="作者">
                <el-input style="width: 250px" placeholder="请输入作者" v-model="form.author"></el-input>
            </el-form-item>
            <el-form-item label="分类">
                <el-select style="width: 250px"
                           v-model="form.category"
                           placeholder="请选择分类">
                    <el-option
                            v-for="category in categories"
                            :key="category.name"
                            :label="category.name"
                            :value="category.name"
                    ></el-option>

                </el-select>
            </el-form-item>
        </el-form>

        <div style="text-align: center">
            <el-button style="margin-left: 10px" type="primary" @click="add">添加</el-button>
            <el-button style="margin-left: 10px" type="warning" @click="reset">重置</el-button>
        </div>
    </div>
</template>

<script>
import request from "@/utils/request"
export default {
    name: "AddBook",
    created() {
      request.get('/categories').then(res => {
          this.categories = res.data
      })
    },
    data() {
        return {
            form: {
                name: '',
                description: '',
                author: '',
                category: ''
            },
            categories: []
        }
    },
    methods: {
        add() {
            request.post('/books', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('Book')
                } else {
                    this.$notify.error(res.msg);
                }
            })
        },
        reset() {
            this.form.name = '';
            this.form.description = '';
            this.form.author = '';
            this.form.category = '';
        },
        handleChange(val) {
            console.log(val);
        }
    }
}
</script>

<style>

</style>
