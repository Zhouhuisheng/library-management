import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout.vue'

const routerPush = VueRouter.prototype.push;

VueRouter.prototype.push = function (location) {

    return routerPush.call(this, location).catch(err => {})

};


Vue.use(VueRouter)

const routes = [
    //  登录
    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/login/Login.vue')
    },
    // 主页
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: 'home',
        children: [
            {
                path: 'home',
                name: 'Home',
                component: () => import('@/views/home/HomeView.vue')
            },
            // User
            {
                path: 'user',
                name: 'User',
                component: () => import('@/views/user/User.vue')
            },
            {
                path: 'adduser',
                name: 'AddUser',
                component: () => import('@/views/user/AddUser.vue')
            },
            {
                path: 'editUser',
                name: 'EditUser',
                component: () => import('@/views/user/EditUser.vue')
            },
            // Admin
            {
                path: 'admin',
                name: 'Admin',
                component: () => import('@/views/admin/Admin.vue')
            },
            {
                path: 'addAdmin',
                name: 'AddAdmin',
                component: () => import('@/views/admin/AddAdmin.vue')
            },
            {
                path: 'editAdmin',
                name: 'EditAdmin',
                component: () => import('@/views/admin/EditAdmin.vue')
            },
            // Category
            {
                path: 'category',
                name: 'Category',
                component: () => import('@/views/category/Category.vue')
            },
            {
                path: 'addCategory',
                name: 'AddCategory',
                component: () => import('@/views/category/AddCategory.vue')
            },
            {
                path: 'editCategory',
                name: 'EditCategory',
                component: () => import('@/views/category/EditCategory.vue')
            },
            // Book
            {
                path: 'book',
                name: 'Book',
                component: () => import('@/views/book/Book.vue')
            },
            {
                path: 'addBook',
                name: 'AddBook',
                component: () => import('@/views/book/AddBook.vue')
            },
            {
                path: 'editBook',
                name: 'EditBook',
                component: () => import('@/views/book/EditBook.vue')
            },
            // Borrow
            {
                path: 'borrow',
                name: 'Borrow',
                component: () => import('@/views/borrow/Borrow.vue')
            },
            {
                path: 'addBorrow',
                name: 'AddBorrow',
                component: () => import('@/views/borrow/AddBorrow.vue')
            }
        ]
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
