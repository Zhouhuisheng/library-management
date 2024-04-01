<template>
    <div>主页</div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie";

export default {
    name: "HomeView",
    data() {
        return {
            admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}
        }
    },
    created() {
        request.get('/admins/' + this.admin.id).then(res => {
            this.admin = res.data
        })
    }
}
</script>

<style scoped>

</style>
