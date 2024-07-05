import Vue from 'vue';
import axios from 'axios';
import qs from 'qs';
import router from "../router/index.js";

const baseURL = '/api';

axios.defaults.withCredentials = false;
axios.defaults.timeout = 2500;

// 请求拦截
axios.interceptors.request.use(
    config => {
        const token = localStorage.getItem("token")
        config.headers.Authoritization = token
        return config;
    },
    err => {
        return Promise.reject(err);
    }
)
// 响应拦截
axios.interceptors.response.use(
    response => {
        console.log('拦截器响应成功')
        return response
    },
    error => {
        console.log('拦截器响应失败')
        console.log(error)
        if(error.request){
            console.log(error.request)
        } else if(error.response){
            console.log(error.response.data);
            console.log(error.response.status);
        }
        if (error && error.response) {
            switch (error.response.status) {
                case 401: error.message = '未授权，请重新登录(401)';
                    router.push({
                        name: 'login'
                    });
                    break;
            }
        }else{
            error.message ='连接服务器失败!'
        }
        return Promise.reject(error)
    }
)

const fetch = (url, method, data) => {
    data = data ? data : {};

    let httpDefaultOpts = { //http默认配置
        method: method,
        url: baseURL + url,
        params:data,
        data:qs.stringify(data),
        headers: method=='get'?{
            "Accept": "application/json",
            "Content-Type": "application/json; charset=UTF-8"
        }:{
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }
    }

    if(method =='get'){
        delete httpDefaultOpts.data;
    }else{
        delete httpDefaultOpts.params;
    }

    let promise = new Promise(function(resolve, reject) {
        axios(httpDefaultOpts).then(
            res => {
                resolve(res);
            }
        ).catch(
            res => {
                reject(res);
            }
        )
    })
    return promise;
}

const fetchGet = (url, data) => {
    return fetch(url, "get", data);
}
const fetchPost = (url, data) => {
    return fetch(url, "post", data);
}

// Vue.prototype.fetchGet = fetchGet;
// Vue.prototype.fetchPost = fetchPost;
export default {
    fetchGet,
    fetchPost
};
