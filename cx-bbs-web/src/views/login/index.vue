<script  lang="ts" setup>
import axios from 'axios';
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from "element-plus";
const router = useRouter();
const form = reactive({
  phone: '',
  password: '',
  input3: '',
  input4:'',
  input5: '',
})
const activeName = ref('first')

import { ElLoading } from 'element-plus';

let loadingInstance: any;
const startLoading = () => {
  loadingInstance = ElLoading.service({
    lock: true,
    text: '加载中……',
    background: 'rgba(0, 0, 0, 0.7)'
  });
};
function endLoading() {
  loadingInstance.close();
}

function toIndex () {
  router.push('/index')
  startLoading()
  endLoading()
}

//验证码
const code = ref()
function sendCode(){
  axios.get("http://localhost:51801/api/user/sendCode").then(res=>{
    if (res.data.code === 200){
      code.value = res.data.data;
      console.log(code.value)
      console.log(res.data.data)
    }
  })
}

function reg () {
  if (form.input4 !== code.value){
    return ElMessage.error("验证码错误")
  }
  axios.post("http://localhost:51801/api/user/reg", { phone: form.input3, password: form.input5 })
      .then(response => {
        const router = useRouter();
        // 处理登录成功的逻辑
        if (response.data.code === 200) {
          ElMessage.success("注册成功")
        } else {
          ElMessage.error(response.data.message);
        }
      })
      .catch(error => {

      });
}

function login () {


  axios.post("http://localhost:51801/api/user/login/login_auth", { phone: form.phone, password: form.password })
    .then(response => {
      const router = useRouter();
      // 处理登录成功的逻辑
      if (response.data.code === 200) {
        ElMessage.success("登录成功")
        localStorage.setItem("id",response.data.data.user.id)
        localStorage.setItem("name",response.data.data.user.name)
        localStorage.setItem("image",response.data.data.user.image)
        // localStorage.setItem('token', response.data.data.token)
        axios.defaults.headers.common['token'] = response.data.data.token;
        axios.defaults.headers.common['userId'] = response.data.data.user.id;
        toIndex();
      } else {
        ElMessage.error(response.data.message);
      }
    })
    .catch(error => {

    });

}

</script>


<template>
  <div class="login">
    <el-form :model="form" label-width="120px">
      <div class="login-img">
<!--        <img src="@/assets/image/logo2.svg" alt="">-->
      </div>
      <div class="login-item">
<!--        <div class="loginleft">-->
<!--          <p class="loginleft-title">晨曦问答</p>-->
<!--&lt;!&ndash;          <div class="loginleft-erm">&ndash;&gt;-->
<!--&lt;!&ndash;            <img src="@/assets/image/ITM920.jpg" alt="">&ndash;&gt;-->
<!--&lt;!&ndash;          </div>&ndash;&gt;-->
<!--&lt;!&ndash;          <p class="loginleft-message">其他扫码方式：微信</p>&ndash;&gt;-->
<!--&lt;!&ndash;          <ul>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><el-button round>下载知乎App</el-button></li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><el-button round>开通机构号</el-button></li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><el-button round>无障碍模式</el-button></li>&ndash;&gt;-->
<!--&lt;!&ndash;          </ul>&ndash;&gt;-->
<!--        </div>-->
        <div class="loginright">
          <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
            <el-tab-pane label="账号登录" name="first">
              <el-input v-model="form.phone" placeholder="请输入手机/用户名" />
              <el-input v-model="form.password" type="password" placeholder="请输入密码" />
              <el-button :plain="true" type="primary" @click="login">登录</el-button>
              <div class="otherwise">
                <div class="otherwise-title">其他方式登录</div>
                <ul>
                  <li>
                    <svg class="icon-font">
                      <use xlink:href="#icon-weixin"></use>
                    </svg>
                  </li>
                  <li>
                    <svg class="icon-font">
                      <use xlink:href="#icon-QQ"></use>
                    </svg>
                  </li>
                  <li>
                    <svg class="icon-font">
                      <use xlink:href="#icon-shejiaotubiao-06"></use>
                    </svg>
                  </li>
                </ul>
              </div>
            </el-tab-pane>
            <el-tab-pane label="注册" name="second" >
              <el-input v-model="form.input3" placeholder="请输入用户名" />
<!--              <el-input v-model="form.input3" placeholder="请输入邮箱号" />-->
              <div class="code-btn">
                <el-input v-model="form.input4" placeholder="请输入验证码" />
                <el-link type="primary" @click="sendCode">获取验证码</el-link>
              </div>
              <el-input v-model="form.input5" type="password" placeholder="请输入密码" />
              <el-button type="primary" @click="reg">注册</el-button>
              <p class="agreement" style="font-size: 14px;">注册即代表同意用户协议</p>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
    </el-form>
  </div>
</template>




<style scoped></style>
