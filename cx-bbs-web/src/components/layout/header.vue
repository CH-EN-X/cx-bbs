
<template>
<div class="header">
    <div class="appheader">
        <Menu />
        <div class="header-item">
            <div class="header-search">
                <input type="text" placeholder="请输入内容">
                <button class="iconfont icon-sousuo"></button>
            </div>
            <el-button type="primary" @click="askDialog=true" round>提问</el-button>
        </div>
        <div class="heaer-userinfo">
            <div class="popover">
                <i class="iconfont icon-xiaoxizhongxin"></i>
                <div class="popover-num">10</div>
                <p>消息</p>
            </div>
            <div class="popover">
                <i class="iconfont icon-xiaoxi1"></i>
                <div class="popover-num">10</div>
                <p>私信</p>
            </div>
            <div class="popover">
                <i class="iconfont icon-jurassic_edit-user"></i>
                <p>创作中心</p>
            </div>
            <div class="header-profile">
                  <el-dropdown>
                        <img src="@/assets/image/1.png" alt="">
                        <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item><i class="iconfont icon-gerenzhongxin"></i>个人中心</el-dropdown-item>
                            <el-dropdown-item @click="$router.push('/login')"><i class="iconfont icon-tuichu"></i>退出</el-dropdown-item>
                        </el-dropdown-menu>
                        </template>
                    </el-dropdown>
            </div>
        </div>

      <el-dialog
          v-model="askDialog"
          title="提问"
          width="500"
          :close-on-click-modal="false">
<!--        给dialog加上点击空白处不关闭的属性-->
        <el-form :model="form" label-width="auto" style="max-width: 600px">
          <el-form-item >
            <el-input v-model="form.title" placeholder="写下你的问题" />
          </el-form-item>

          <el-form-item v-if="!form.title==''">
            <el-input v-model="form.content" placeholder="请输入详情（选填）" type="textarea" />
          </el-form-item>

        </el-form>
        <template #footer>
          <div class="dialog-footer">
            <el-button @click="askDialog = false">取消</el-button>
            <el-button type="primary" @click="onSubmit">
              发布问题
            </el-button>
          </div>
        </template>
      </el-dialog>
    </div>

</div>
</template>

<script setup lang="ts">
import Menu from './menu.vue'
import {useRouter} from 'vue-router'
import AskDialog from "../../views/common/AskDialog.vue"

import { ref } from 'vue'
import {ElMessage, ElMessageBox} from 'element-plus'
import { reactive } from 'vue'
import axios from "axios";

const form = ref({
  title: '',

  content: '',
})

const askDialog = ref(false)

const onSubmit = () => {
  // console.log('submit!')
  axios.post("http://localhost:51802/api/question/add" ,
    form.value
  ).then(response => {
    // 处理登录成功的逻辑
    if (response.data.code === 200) {
      ElMessage.success(response.data.message);
      askDialog.value = false;
    } else {
      ElMessage.error(response.data.message);
    }
  })
}

const handleClose = (done: () => void) => {
  // ElMessageBox.confirm('Are you sure to close this dialog?')
  //     .then(() => {
  //       done()
  //     })
  //     .catch(() => {
  //       // catch error
  //     })
}

const router = useRouter();

</script>


<style scoped>

</style>
