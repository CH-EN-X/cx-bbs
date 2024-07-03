<script setup>
import { ref } from 'vue';
import {ElForm, ElFormItem, ElInput, ElButton, ElRadioGroup, ElRadio, ElMessage} from 'element-plus';
import axios from "axios";

const formData = ref({
  id:'',
  name: '',
  sex: 1,
  phone: '',
  uPwd: '********',
  oldPwd: '',
  newPwd1: '',
  newPwd2: '',
});

const flag = ref(false)
const flag2 = ref(0)

const rules = ref({
  name: [
    { required: true, message: '请输入昵称', trigger: 'blur' },
  ],
  phone: [
    { required: true, message: '请输入手机号', trigger: 'blur' },
    { pattern: /[0-9]{11}/, message: '手机号格式不正确', trigger: 'blur' },
  ],
  uPwd: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 6, message: '密码长度不能少于6位', trigger: 'blur' },
  ],
  code: [{required: true, message: '请输入验证码', trigger: 'blur'}],
  oldPwd: [{required: true, message: '请输入您的密码', trigger: 'blur'}],
  newPwd1: [{required: true, message: '请输入您的新密码', trigger: 'blur'}],
  newPwd2: [
    {required: true,
      message: '请再次输入您的新密码',
      validator: (rule, value, callback) => {
        if (value !== formData.value.newPwd1) {
          callback(new Error('两次输入密码不一致'));
        } else {
          callback();
        }
      },
      trigger: 'blur',
    }
  ],
});

const { readonlyPwd } = defineProps();

// const pwdEditMode = () => {
//   return readonlyPwd.value ? '修改' : '保存';
// };

const togglePwdEdit = () => {
  readonlyPwd.value = !readonlyPwd.value;
};

//发送验证码，倒计时60秒内不能再发
const counting = ref(false);
const countdown = ref(60);

const handleSendCode = () => {
  ElMessage.success("已发送验证码")
  if (!counting.value) {
    counting.value = true;
    let timer = setInterval(() => {
      countdown.value--;
      if (countdown.value === 0) {
        clearInterval(timer);
        counting.value = false;
        countdown.value = 60;
      }
    }, 1000);
  }
};

//提交修改信息
const submitForm = () => {
  axios.post("http://localhost:51801/api/user/update",{
    id:formData.value.id,
    sex:formData.value.sex,
    name:formData.value.name,
  }).then(res=>{
    if (res.data.code === 200){
      ElMessage.success(res.data.message)
    }
  })
};
//提交修改密码
const submit = () => {
  if (formData.value.newPwd1 !== formData.value.newPwd2){
    return ElMessage.error("两次密码不一致");
  }

  axios.post("http://localhost:51801/api/user/update",{
    id:formData.value.id,
    password:formData.value.oldPwd+','+formData.value.newPwd2,
  }).then(res=>{
    if (res.data.code === 200){
        ElMessage.success(res.data.message)
    }else {
      ElMessage.error(res.data.message)
    }
  })
};

//切换修改个人信息页
const updateInfo = () => {
  flag.value = false
  flag2.value = 0;
};

//修改密码
function updatePwd(){
  flag.value = true;
}
function submitCode(){
  // axios.post()
  if (true){
    flag2.value = 1
  }
}

//点击修改头像
const imageUrl = ref('');

const upload = () => {
  const input = document.createElement('input');
  input.type = 'file';

  input.onchange = async (event) => {
    const file = event.target.files[0];
    const formData1 = new FormData();
    formData1.append('file', file);

    try {
      axios.post('http://localhost:51802/api/image/upload', formData1).then(response=>{
        // 假设后端返回的链接在 response.data.url 中
        imageUrl.value = response.data.imageUrl;
        axios.post("http://localhost:51801/api/user/update",{
          id:formData.value.id,
          image:imageUrl.value[0]
        }).then(res=>{
          if (res.data.code === 200){
            ElMessage.success("修改成功")
          }
        })
      });


    } catch (error) {
      console.error(error);
    }
  };

  input.click();
};

function load()  {
  axios.get("http://localhost:51801/api/user/"+localStorage.getItem("id")).then(res=>{
    if (res.data.code === 200){
      formData.value = res.data.data;
      imageUrl.value = res.data.data.image
      formData.value.uPwd = "*******"
    }
  })
}
load()
</script>

<template>
<div id="ce" style="margin: 50px 0px 50px 350px">

  <aside class="sidebar">
    <div class="avatar" @click="upload" >
      <img
          :src="imageUrl"
          title="点击修改头像"/>
    </div>
    <nav class="nav">
      <a @click="updateInfo">个人信息</a>
      <a @click="updatePwd">修改密码</a>
    </nav>
  </aside>

  <div style="position: absolute; top: 50%; left: 54%; transform: translate(-50%, -50%);">
    <el-form :model="formData" :rules="rules" ref="userForm" label-width="80px">
      <el-form-item label="昵称" prop="name" v-if="!flag">
        <el-input v-model="formData.name" placeholder="请输入"></el-input>
      </el-form-item>

      <el-form-item label="性别" prop="sex" style="margin-bottom: 15px;" v-if="!flag">
        <el-radio-group class="radio-group" v-model="formData.sex">
          <el-radio label="1">男</el-radio>
          <el-radio label="2">女</el-radio>
          <el-radio label="0">保密</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="手机号" prop="phone" v-if="flag && flag2===0">
        <el-input v-model="formData.phone" placeholder="请输入手机号" style="width: 65%;"></el-input>
        <el-button
            style="margin-right: -78px; margin-left: 4px;"
            :disabled="counting"
            @click="handleSendCode"
        >
          {{ counting ? `已发送（${countdown}s）` : "发送验证码" }}
        </el-button>
      </el-form-item>

      <el-form-item label="验证码" prop="code"  v-if="flag && flag2===0" >
        <el-input v-model="formData.code" placeholder="请输入验证码" style="width: 65%;"></el-input>
        <el-button  @click="submitCode"  v-if="flag"
                   style="margin-right: -78px;margin-left: 4px;width: 75px;"
        >验证</el-button>
      </el-form-item>

      <el-form-item label="旧密码" prop="oldPwd" v-if="flag && flag2===1">
        <el-input v-model="formData.oldPwd" type="password" placeholder="请输入密码" :readonly="readonlyPwd" >
        </el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newPwd1" v-if="flag && flag2===1">
        <el-input v-model="formData.newPwd1" type="password" placeholder="请输入密码" :readonly="readonlyPwd" >
        </el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="newPwd2" v-if="flag && flag2===1">
        <el-input v-model="formData.newPwd2" type="password" placeholder="请输入密码" :readonly="readonlyPwd" >
        </el-input>
      </el-form-item>

      <el-form-item style="margin-top: 10px;margin-left: 40px;">
        <el-button type="primary" v-if="!flag" @click="submitForm">提交修改</el-button>
        <el-button type="primary" v-if="flag" @click="submit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
</template>


<style scoped>

/* - 侧边栏 */
.sidebar {
  top: 0;
  left: 0;
  bottom: 0;
  color: #fff;
  width: 250px;
  position: fixed;
  overflow: hidden;
  overflow-y: auto;
  background: #4b4b4b;
  margin-left: 175px;
  margin-top: 62px;
}

/* -- 头像 */
.sidebar .avatar {
  width: 160px;
  height: 160px;
  margin: 2em auto;
  background: #fff;
  border-radius: 100%;
  border: #fff 5px solid;
  transition: transform 0.5s;
}

.sidebar .avatar:hover {
  transform: rotate(1turn);
}

.sidebar .avatar img {
  border-radius: 100%;
}

/* -- 侧边栏导航 */
.sidebar .nav {
  margin: 0;
  display: flex;
  list-style: none;
  flex-direction: column;
}

.sidebar .nav a {
  color: #fff;
  padding: 1em;
  display: block;
  text-align: center;
  transition: background .3s, box-shadow .3s;
}
.avatar img {
  width: 100%;
  height: auto;
  aspect-ratio: 1 / 1;
  cursor: pointer;
}
.sidebar .nav a:hover {
  background: rgba(0, 0, 0, .2);
}

.radio-group > .el-radio {
  margin-right: 20px; /* 调整间距的大小 */
}
.nav a {
  cursor: pointer;
}
</style>
