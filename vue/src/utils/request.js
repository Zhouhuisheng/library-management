import axios from 'axios'
import Cookies from "js-cookie";
import router from '@/router'



const request = axios.create({
    baseURL: 'http://localhost:8081',
    timeout: 5000
})

// request拦截器
// 可以对请求发送前做一些处理，比如统一价token、对请求参数加密
request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';

    const admin = Cookies.get('admin')
    if (!admin) {
        router.push('/login')
    }


    // config.headers['token'] = user.token;   // 设置请求头
    return config;
},error => {
    return Promise.reject(error)
});

// response拦截器
// 可以在接口响应统一处理结果
request.interceptors.response.use(
    response => {
        let res = response.data
        console.log(res)
        // 兼容服务端返回的字符串数据
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error => {
        console.log('err' + error)
        return Promise.reject(error)
    }
)

export default request
