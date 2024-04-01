<template>
    <div>
        <div style="padding: 20px">编辑用户</div>
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="用户名">
                <el-input style="width: 240px" v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input style="width: 240px" v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
                <el-input style="width: 240px" v-model="form.email"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">立即更新</el-button>
                <el-button @click="$router.push('Admin')">取消</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
import request from "@/utils/request"
export default {
    name: "EditUser",
    data() {
        return {
            form: {
                userName: '',
                password: '',
                email: ''
            }
        }
    },
    created() {
        this.load();
    },
    methods: {
        onSubmit() {
            request.put('/admins', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('Admin')
                } else {
                    this.$notify.error(res.msg);
                }
            })
        },
        load() {
            const id = this.$route.query.id;

            request.get('/admins/' + id).then(res => {
                if (res.code === '200') {
                    // this.$notify.success('查询成功');
                    this.form = res.data;
                } else {
                    this.$notify.error(res.msg);
                }
            })
        }
    }
}

</script>

<style scoped>

</style>
