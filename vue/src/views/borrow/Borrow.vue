<template>
    <div>
        <!--搜索表单-->
        <div style="margin-bottom:1px">
            <el-input style="width: 240px" placeholder="请输入借书图书名" v-model="params.bookName"></el-input>
            <el-input style="width: 240px" placeholder="请输入借书用户" v-model="params.userName"></el-input>
            <el-button style="margin-left: 10px" type="primary" @click="load">搜索</el-button>
            <el-button style="margin-left: 10px" type="warning" @click="reset">重置</el-button>
        </div>

        <el-table :data="tableData" stripe>
            <el-table-column prop="bookName" label="图书名"></el-table-column>
            <el-table-column prop="userName" label="借书人用户名"></el-table-column>
            <el-table-column prop="createTime" label="创建时间"></el-table-column>
            <el-table-column prop="updateTime" label="更新时间"></el-table-column>
            <el-table-column label="操作">
                <!--scope.row就是行数据-->
                <template v-slot="scope">
                    <el-popconfirm title="您确定还书吗？" @confirm="del(scope.row.id)" style="margin-left: 10px">
                        <el-button type="danger" slot="reference">还书</el-button>
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
    name: 'Borrow',
    data() {
        return {
            tableData: [],
            total: 2,
            params: {
                pageNum: '1',
                pageSize: '5',
                bookId: '',
                bookName: '',
                userId: '',
                userName: '',
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
            request.get('/borrows/page', {
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
            this.params.bookName = '';
            this.params.userName = '';
            this.load();
        },
        // 分页
        handleCurrentChange(pageNum) {
            this.params.pageNum = pageNum
            this.load()
        },
        del(id) {
            request.delete("/borrows/" + id).then(res => {
                if (res.code === '200') {
                    this.$notify.success('还书成功');
                    this.load();
                } else {
                    this.$notify.error(msg);
                    this.load();
                }
            })
            this.load();
        }
    }
}
</script>
