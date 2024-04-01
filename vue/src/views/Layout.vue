<template>
    <div>
        <!-- 头部区域 -->
        <div style="height: 60px; line-height: 60px; background-color: white; margin-bottom: 2px; display: flex">
            <div style="width: 300px">
                <img src="@/assets/logo.png" style="width: 40px; position: relative; top:10px; left: 10px">
                <span style="margin-left: 20px; font-size: 30px">图书管理系统</span>
            </div>
            <div style="flex: 1; text-align:right; padding-right: 20px">
                <el-dropdown>
                    <span class="el-dropdown-link">
                        {{ admin.userName }}<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>
                            <div @click="logout">退出</div>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>

        <!-- 侧边栏和主体 -->
        <div style="display: flex">
            <!-- 侧边栏 -->
            <div style="width: 200px; min-height: calc(100vh - 62px); overflow: hidden; margin-right: 2px; background-color: white">
                <el-menu :default-active="$route.path" :default-openeds="['/']" router class="el-menu-demo">
                    <el-menu-item index="/">
                        <i class="el-icon-eleme"></i>
                        <span>首页</span>
                    </el-menu-item>
                    <el-submenu index="/user">
                        <template slot="title">
                            <i class="el-icon-info"></i>
                            <span>用户管理</span>
                        </template>
                        <el-menu-item index="/addUser">用户添加</el-menu-item>
                        <el-menu-item index="/user">用户列表</el-menu-item>
                    </el-submenu>

                    <el-submenu index="/admin">
                        <template slot="title">
                            <i class="el-icon-user"></i>
                            <span>管理员管理</span>
                        </template>
                        <el-menu-item index="/addAdmin">管理员添加</el-menu-item>
                        <el-menu-item index="/admin">管理员列表</el-menu-item>
                    </el-submenu>

                    <el-submenu index="/category">
                        <template slot="title">
                            <i class="el-icon-s-operation"></i>
                            <span>图书分类管理</span>
                        </template>
                        <el-menu-item index="/addCategory">图书分类添加</el-menu-item>
                        <el-menu-item index="/Category">图书分类列表</el-menu-item>
                    </el-submenu>

                    <el-submenu index="/book">
                        <template slot="title">
                            <i class="el-icon-notebook-2"></i>
                            <span>图书管理</span>
                        </template>
                        <el-menu-item index="/addBook">图书添加</el-menu-item>
                        <el-menu-item index="/Book">图书列表</el-menu-item>
                    </el-submenu>

                    <el-submenu index="/borrow">
                        <template slot="title">
                            <i class="el-icon-notebook-1"></i>
                            <span>借书管理</span>
                        </template>
                        <el-menu-item index="/addBorrow">借书</el-menu-item>
                        <el-menu-item index="/Borrow">待还列表</el-menu-item>
                    </el-submenu>
                </el-menu>


            </div>

            <!-- 数据展示区 -->
            <div style="flex: 1">
                <router-view/>
            </div>
        </div>

    </div>

</template>

<script>
import Cookies from "js-cookie";
export default {
    name: "Layout",
    data() {
      return {
          admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}
      }
    },
    methods: {
        logout() {
            // 清除浏览器用户数据
            Cookies.remove('admin')

            this.$router.push("/login");
        }
    }
}
</script>

<style scoped>

</style>
