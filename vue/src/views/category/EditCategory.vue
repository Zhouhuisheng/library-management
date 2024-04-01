<template>
    <div>
        <div style="padding: 20px">编辑用户</div>
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="图书分类名">
                <el-input style="width: 240px" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input style="width: 240px" v-model="form.remark"></el-input>
            </el-form-item>
            <el-form-item label="分类编号">
                <el-input style="width: 240px" v-model="form.pid"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">立即更新</el-button>
                <el-button @click="$router.push('Category')">取消</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
import request from "@/utils/request"
export default {
    name: "EditCategory",
    data() {
        return {
            form: {
                name: '',
                remark: '',
                pid: ''
            }
        }
    },
    created() {
        this.load();
    },
    methods: {
        onSubmit() {
            request.put('/categories', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('Category')
                } else {
                    this.$notify.error(res.msg);
                }
            })
        },
        load() {
            const id = this.$route.query.id;

            request.get('/categories/' + id).then(res => {
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
