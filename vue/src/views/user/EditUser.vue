<template>
    <div>
        <div style="padding: 20px">编辑用户</div>
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="姓名">
                <el-input style="width: 240px" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="用户名">
                <el-input style="width: 240px" v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="年龄">
                <el-input style="width: 240px" v-model="form.age"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-select v-model="form.sex" placeholder="请选择性别">
                    <el-option label="男" value="男"></el-option>
                    <el-option label="女" value="女"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="联系方式">
                <el-input style="width: 240px" v-model="form.phone"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <el-input style="width: 240px" v-model="form.address"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">立即更新</el-button>
                <el-button @click="$router.push('User')">取消</el-button>
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
                name: '',
                userName: '',
                age: '',
                sex: '',
                phone: '',
                address: ''
            }
        }
    },
    created() {
        this.load();
    },
    methods: {
        onSubmit() {
            request.put('/users', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('User')
                } else {
                    this.$notify.error(res.msg);
                }
            })
        },
        load() {
            const id = this.$route.query.id;

            request.get('/users/' + id).then(res => {
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
