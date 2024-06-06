<script setup>
import axios from 'axios';
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from "element-plus";
const router = useRouter();
const form = reactive({
  phone: '',
  password: '',
})
const activeName = ref('first')

function toIndex () {
  router.push('/index')
}

function login () {

  axios.post("http://localhost:51801/api/v1/login/login_auth", { phone: form.phone, password: form.password })
    .then(response => {
      const router = useRouter();
      console.log(response.data.message);
      // 处理登录成功的逻辑
      if (response.data.code === 200) {
        toIndex();
      } else {
        ElMessage("账号或密码错误");
      }
    })
    .catch(error => {

    });

}

</script>

<script>
import axios from 'axios';
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter();
export default {
  name: 'MyComponent',
  data () {
    return {
      form: {
        phone: '',
        password: '',
      }
    }
  },
  methods: {

    login () {
      this.$nextTick(() => {
        console.log('Phone:', this.form.phone.valueOf);
        console.log('Password:', this.form.password);
        // 在这里可以使用 this.form.phone 和 this.form.password 获取输入框的值
      });
      axios.post("http://localhost:51801/api/v1/login/login_auth", { phone: this.form.phone, password: this.form.password })
        .then(response => {
          const router = useRouter();
          console.log(response.data.message);
          // 处理登录成功的逻辑
          router.push('/index')
        })
      // .catch(error => {
      //   console.error(error.response.data.message);
      //   // 处理登录失败的逻辑
      // });

    }, fetchData () {
      axios.get('https://jsonplaceholder.typicode.com/posts')
        .then(response => {
          console.log(response.data);
        })
        .catch(error => {
          console.log(error);
        });
    },
  }
};
</script> -->


<template>
  <div class="login">
    <el-form :model="form" label-width="120px">
      <div class="login-img">
        <img src="@/assets/image/v2.png" alt="">
      </div>
      <div class="login-item">
        <div class="loginleft">
          <p class="loginleft-title">打开知乎App</p>
          <div class="loginleft-erm">
            <img src="@/assets/image/ITM920.jpg" alt="">
          </div>
          <p class="loginleft-message">其他扫码方式：微信</p>
          <ul>
            <li><el-button round>下载知乎App</el-button></li>
            <li><el-button round>开通机构号</el-button></li>
            <li><el-button round>无障碍模式</el-button></li>
          </ul>
        </div>
        <div class="loginright">
          <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
            <el-tab-pane label="账号登录" name="first">
              <el-input v-model="form.phone" placeholder="请输入手机/用户名" />
              <el-input v-model="form.password" type="password" placeholder="请输入密码" />
              <el-button type="primary" @click="login">登录</el-button>
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
            <el-tab-pane label="注册" name="second">
              <el-input v-model="form.input3" placeholder="请输入手机/用户名" />
              <div class="code-btn">
                <el-input v-model="form.input4" placeholder="请输入验证码" />
                <el-link type="primary">获取验证码</el-link>
              </div>
              <el-input v-model="form.input5" type="password" placeholder="请输入密码" />
              <el-button type="primary" @click="onSubmit">注册</el-button>
              <p class="agreement">注册即代表同意用户协议</p>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
    </el-form>
  </div>
</template>




<style scoped></style>
