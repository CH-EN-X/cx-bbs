<script setup>
import {ref, onMounted, createVNode, reactive} from 'vue';
import {useRouter} from 'vue-router'
import axios from "axios";
// import axios from "../../../api/axios.js"
import {ElLoading, ElMessage} from "element-plus";

const questions = ref([
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    id: 1,
    title: "有没有高质量的规则类怪谈？", //query
    content: '有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？',
    favour: 88,
    like: true,
    comments: 11,
  },
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    id: 1,
    title: "有没有高质量的规则类怪谈？", //query
    content: '有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？',
    favour: 88,
    like: true,
    comments: 11,
  },
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    id: 1,
    title: "有没有高质量的规则类怪谈？", //query
    content: '有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？',
    favour: 88,
    like: true,
    comments: 11,
  }
  ,
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    id: 1,
    title: "有没有高质量的规则类怪谈？", //query
    content: '有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？',
    favour: 88,
    like: true,
    comments: 11,
  }
  ,
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    id: 1,
    title: "有没有高质量的规则类怪谈？", //query
    content: '有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？',
    favour: 88,
    like: true,
    comments: 11,
  }
])

const articleContent = ''//'<p>是有这种情况啊，不然为什么抖音那些博主干一年就买房了，或者不声不响就提车了？再不济也能不上班靠着发视频养活自己。</p><p>注意，我说的是博主！！<strong>由于普通人和博主之间有信息差，用着一个app相当于在两个世界</strong>，他们发视频就能赚钱，你发视频可能有点赞，有播放，但就是不能赚钱。</p><p>由于工作原因，<strong>我接触博主挺多，分享几个抖音发就能赚钱的视频形式</strong>，你肯定刷到过，很常见的视频：</p><p>1.风景文案视频</p><p><img src="https://picx.zhimg.com/50/v2-7490283665ab02ecb0a204ffca29780e_720w.jpg?source=2c26e567" alt="" data-href="" style=""/></p><p><img src="https://picx.zhimg.com/80/v2-7490283665ab02ecb0a204ffca29780e_720w.webp?source=2c26e567" alt="" data-href="" style=""/></p><p>一段风景视频+音乐+文案</p><p>博主没开橱窗，没直播，视频中就是风景，没有商品广告</p><p>要不是我看到<strong>评论区的置顶</strong>，还以为他天天是在为爱发电呢</p>';
const content = ref([]);

let loadingInstance;
const startLoading = () => {
  loadingInstance = ElLoading.service({lock: true, text: '加载中……', background: 'rgba(0, 0, 0, 0.7)'});
};
const endLoading = () => {
  loadingInstance.close();
};

const dialogVisible = ref(false);
//跳转到详情页
const router = useRouter();

function goDetails(v) {
  router.push({
    name: 'details',
    params: {id: v}
  });
  startLoading()
  endLoading()
}

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



function load() {
  axios.post("http://localhost:51802/api/article/load", {
    maxBehotTime: "",
    minBehotTime: "",
    size: 25,
    tag: null
  }).then(response => {
    // if (response.data.code === 401 || response.data.code === 1){
    //   router.push({
    //     name: 'login'
    //   });
    //   return ElMessage.warning("请先登录")
    // }
    // 处理登录成功的逻辑
    if (response.data.code === 200) {
      questions.value = response.data.data;
    } else {
      ElMessage.error(response.data.message);
    }
  })
}

load()

</script>

<template>
  <div class="Topstory-content">
    <ul>
      <li v-for="(v, index) in questions" :key="v.id" :class="{ 'colored': index < 3 }" style="padding-bottom: 19px;">
        <div @click="goDetails(v.questionId)">
          <span>{{ index + 1 }}</span>
          <h2 class="topstory-title">{{ v.title }}</h2>
          <div class="topstory-articleitem" style="margin-left: 30px;  margin-top: -9px;">
            <p v-html="v.content"></p>
          </div>
        </div>
      </li>
    </ul>


    <!-- 对话框  -->
    <el-dialog v-model="dialogVisible" :before-close="handleClose" title="添加收藏" width="30%">
      <span>你可以创建多个收藏夹，将答案分类收藏</span>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="dialogVisible = false">
            收藏
          </el-button>
        </span>
      </template>
    </el-dialog>

  </div>
</template>

<style scoped>
.topstory-articleitem p img {
  display: none;
}
.topstory-title {
  display: inline-block;
  margin-left: 10px; /* 根据需要调整间距 */
}

.colored span {
  color: white; /* 文本颜色设置为白色（如果背景色较暗的话） */
  padding: 0 5px;
  border-radius: 5px;
}

.colored:nth-child(1) span {
  background-color: red; /* 第一个元素背景为红色 */
}

.colored:nth-child(2) span {
  background-color: orange; /* 第二个元素背景为橙色 */
}

.colored:nth-child(3) span {
  background-color: rgba(255, 234, 0, 0.62); /* 第三个元素背景为黄色 */
}
</style>
