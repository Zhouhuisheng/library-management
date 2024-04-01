<template>
    <div>
        <div style="padding: 20px; text-align: center">新增用户</div>
        <el-form :inline="true" :model="form" label-width="100px">
            <el-form-item label="姓名">
                <el-input style="width: 250px" placeholder="请输入姓名" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="用户名">
                <el-input style="width: 250px" placeholder="请输入用户名" v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="年龄">
                <el-input style="width: 250px" placeholder="请输入年龄" v-model="form.age"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-select v-model="form.sex" placeholder="请选择性别" style="width: 250px">
                    <el-option label="男" value="男"></el-option>
                    <el-option label="女" value="女"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="联系方式">
                <el-input style="width: 250px" placeholder="请输入联系方式" v-model="form.phone"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <el-input style="width: 250px" placeholder="请输入地址" v-model="form.address"></el-input>
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
    name: "AddUser",
    data() {
        return {
            form: {
                name: '',
                userName: '',
                age: '',
                sex: '',
                phone: '',
                address: ''
            }
        }
    },
    methods: {
        add() {
            request.post('/users', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('User')
                } else {
                    this.$notify.error(res.msg);
                }
            })
        },
        reset() {
            this.form.name = '';
            this.form.userName = '';
            this.form.age = '';
            this.form.sex = '';
            this.form.phone = '';
            this.form.address = '';
        }
    }
}
</script>

<style>

</style>
