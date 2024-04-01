<template>
    <div>
        <div style="padding: 20px; text-align: center">新增管理员</div>
        <el-form :inline="true" :model="form" label-width="100px">
            <el-form-item label="用户名">
                <el-input style="width: 250px" placeholder="请输入用户名" v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input style="width: 250px" placeholder="请输入密码" v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
                <el-input style="width: 250px" placeholder="请输入邮箱" v-model="form.email"></el-input>
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
    name: "AddAdmin",
    data() {
        return {
            form: {
                userName: '',
                password: '',
                email: '',
            }
        }
    },
    methods: {
        add() {
            request.post('/admins', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('Admin')
                } else {
                    this.$notify.error(res.msg);
                }
            })
        },
        reset() {
            this.form.userName = '';
            this.form.password = '';
            this.form.email = '';
        }
    }
}
</script>

<style>

</style>
