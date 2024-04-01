<template>
    <div>
        <!--搜索表单-->
        <div style="margin-bottom:1px">
            <el-input style="width: 240px" placeholder="请输入名称" v-model="params.name"></el-input>
            <el-input style="width: 240px; margin-left: 5px" placeholder="请输入联系方式" v-model="params.phone"></el-input>
            <el-button style="margin-left: 10px" type="primary" @click="load">搜索</el-button>
            <el-button style="margin-left: 10px" type="warning" @click="reset">重置</el-button>
        </div>

        <el-table :data="tableData" stripe>
            <el-table-column prop="name" label="姓名"></el-table-column>
            <el-table-column prop="userName" label="用户名"></el-table-column>
            <el-table-column prop="age" label="年龄"></el-table-column>
            <el-table-column prop="sex" label="性别"></el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
            <el-table-column prop="phone" label="电话"></el-table-column>
            <el-table-column prop="createTime" label="创建时间"></el-table-column>
            <el-table-column prop="updateTime" label="更新时间"></el-table-column>
            <el-table-column label="操作">
                <!--scope.row就是行数据-->
                <template v-slot="scope">
                    <el-button type="primary" @click="$router.push('/editUser?id=' + scope.row.id)">编辑</el-button>
                    <el-popconfirm title="您确定删除这行数据吗？" @confirm="del(scope.row.id)" style="margin-left: 10px">
                        <el-button type="danger" slot="reference">删除</el-button>
                    </el-popconfirm>

                </template>
            </el-table-column>
        </el-table>

        <!--分页-->
        <div>
            <el-pagination
                    background
                    layout="prev, pager, next"
                    @current-change="handleCurrentChange"
                    :current-page="params.pageNum"
                    :page-size=params.pageSize
                    :total="total">
            </el-pagination>
        </div>
    </div>
</template>

<script>

import request from "@/utils/request";

export default {
    name: 'User',
    data() {
        return {
            tableData: [],
            total: 2,
            params: {
                pageNum: '1',
                pageSize: '5',
                name: '',
                phone: '',
                createTime: '',
                updateTime: ''
            }
        }
    },
    created() {
        this.load();
    },
    methods: {
        load() {
            // fetch('http://localhost:8081/user/list').then(res => res.json()).then(res => {
            //     console.log(res)
            //     this.tableData = res.data;
            // })
            request.get('/users/page', {
                params: this.params
            }).then(res => {
                console.log(res)
                if (res.code === '200') {
                    this.tableData = res.data.list;
                    this.total = res.data.total;
                }
            })
        },
        reset() {
            this.params.pageNum = 1;
            this.params.pageSize = 5;
            this.params.name = '';
            this.params.phone = '';
            this.load();
        },
        // 分页
        handleCurrentChange(pageNum) {
            this.params.pageNum = pageNum
            this.load()
        },
        del(id) {
            request.delete("/users/" + id).then(res => {
                if (res.code === '200') {
                    this.$notify.success('删除成功');
                    this.load();
                } else {
                    this.$notify.error(msg);
                    this.load();
                }
            })
        }
    }
}
</script>
