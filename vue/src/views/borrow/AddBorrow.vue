<template>
    <div>
        <div style="padding: 20px; text-align: center">新增借书记录</div>
        <el-form :inline="true" :model="form" label-width="100px">
            <el-form-item label="可借图书" prop="bookId">
                <el-select style="width: 250px"
                           v-model="form.bookId"
                           clearble
                           filterable
                           @change="selBook"
                           placeholder="请选择图书">
                    <el-option
                            v-for="item in books"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id"
                    ></el-option>
                </el-select>
            </el-form-item>

            <!--<el-form-item label="图书" prop="bookName">-->
            <!--    <el-input v-model="form.bookName" placeholder="请输入图书名称"></el-input>-->
            <!--</el-form-item>-->

            <el-form-item label="借书用户" prop="userId">
                <el-select style="width: 250px"
                           v-model="form.userId"
                           clearble
                           filterable
                           @change="selUser"
                           placeholder="请选择借书用户">
                    <el-option
                            v-for="item in users"
                            :key="item.id"
                            :label="item.userName"
                            :value="item.id"
                    ></el-option>

                </el-select>
            </el-form-item>

            <!--<el-form-item label="用户名称" prop="userName">-->
            <!--  <el-input v-model="form.userName" placeholder="请输入用户名称"></el-input>-->
            <!--</el-form-item>-->
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
    name: "AddBorrow",
    created() {
      request.get('/books/listByStatus/1').then(res => {
          this.books = res.data
      });

      request.get('/users').then(res => {
          this.users = res.data
      });
    },
    data() {
        return {
            form: {

            },
            books: [],
            users: []
        }
    },
    methods: {
        add() {
            request.post('/borrows', this.form).then(res => {
                if (res.code === '200') {
                    this.$notify.success('新增成功');
                    this.$router.push('Borrow')
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
        selBook() {
            const book = this.books.find(v => v.id === this.form.bookId)
            console.log(book)
            this.form.bookName = book.name
        },
        selUser() {
            const user = this.users.find(v => v.id === this.form.userId)
            console.log(user)
            this.form.userName = user.name
        }
    }
}
</script>

<style>

</style>
