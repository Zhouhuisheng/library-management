<template>
    <div>
        <div style="padding: 20px; text-align: center">新增图书分类</div>
        <el-form :inline="true" :model="form" label-width="100px">
            <el-form-item label="用户名">
                <el-input style="width: 250px" placeholder="请输入图书分类名" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input style="width: 250px" placeholder="请输入备注" v-model="form.remark"></el-input>
            </el-form-item>
            <el-form-item label="分类编号">
                <el-input style="width: 250px" placeholder="请输入分类编号" v-model="form.pid"></el-input>
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
    name: "AddCategory",
    data() {
        return {
            form: {
                name: '',
                remark: '',
                pid: '',
            }
        }
    },
    methods: {
        add() {
            request.post('/categories', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('Category')
                } else {
                    this.$notify.error(res.msg);
                }
            })
        },
        reset() {
            this.form.name = '';
            this.form.remark = '';
            this.form.pid = '';
        }
    }
}
</script>

<style>

</style>
