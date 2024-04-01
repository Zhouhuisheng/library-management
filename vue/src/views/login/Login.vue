<template>
    <div style="height: 100vh; overflow: hidden">
        <div style="width: 500px; height: 400px; background-color: white;
        border-radius: 10px; margin: 150px auto; padding: 50px">
            <div style="margin: 30px; text-align: center; font-size: 30px; font-weight: bold">登录</div>
            <el-form :model="admin" ref="loginForm">
                <el-form-item prop="userName">
                    <el-input placeholder="请输入账号" prefix-icon="el-icon-user" size="medium" v-model=admin.userName></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input placeholder="请输入密码" show-password prefix-icon="el-icon-lock" size="medium" v-model=admin.password></el-input>
                </el-form-item>
                <el-form-button>
                    <el-button style="width: 100%" size="medium" type="primary" @click="login">登录</el-button>
                </el-form-button>
            </el-form>
        </div>
    </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from 'js-cookie'
export default {
    name: "Login",
    data() {
        return {
            admin: {}
        }
    },
    methods: {
        login() {
            request.post("/admins/login", this.admin).then(res => {
                // 登录成功
                if (res.code === '200') {
                    this.$notify.success('登录成功');

                    // 存储cookie
                    if (res.data !== null) {
                        Cookies.set('admin', JSON.stringify(res.data))
                    }

                    this.$router.push('/')
                } else {    //登录失败
                    this.$notify.error(res.msg);
                }
            })
        }
    }
}
</script>

<style scoped>

</style>
