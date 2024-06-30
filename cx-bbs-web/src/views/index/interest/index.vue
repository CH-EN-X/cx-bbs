<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios  from "axios";
//TODO:点赞、赞成、收藏记录（连表查询？根据当前登录用户，将查询的文章数据中的这些值进行替换？）

const topstorylist = ref([
  {
    user:{
      img: '/src/assets/image/pic5.png',
      name: '喵先生',
      title: '标题一',
    },
    questions:[{
      content: '请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀。',
      id: 1,
      favour:false,
      disfavour:false,
      likes: 88,
      like: false,
    },
      {
        articleitem: '请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀。',
        id: 1,
        favour:false,
        disfavour:false,
        likes: 88,
        like: false,
      }]
  },
  {
    user:{
      img: '/src/assets/image/pic5.png',
      name: '喵先生',
      title: '标题一',
    },
    questions:[]
  }
])
const dialogVisible = ref(false);
//跳转到详情页
const router = useRouter();
function goDetails(v) {
  router.push({
    name: 'details',
    params: {id: v}
  });
}
function yuedu () {
  //TODO:通过点击按钮，在当前页面查看文章
}

function loadFollow(){
  const id = localStorage.getItem("id")
  axios.post("http://localhost:51802/api/article/interest/"+id).then(response=>{
    if (response.data.code === 200){
      topstorylist.value = response.data.data
    }
  })
}
loadFollow()
// function favourUp(){
//   axios.post("/..../api/v4/answers/3409557692/voters",{type:"up"}).then(
//
//   )
// }
// function favourDown(){
//   axios.post("/..../api/v4/answers/3409557692/voters",{type:"down"}).then(
//
//   )
// }

</script>

<template>
  <div class="Topstory-content">
    <ul v-for="u in topstorylist">
<!--      <li v-for="v in u.questions" :key="v.id">-->
      <li v-for="v in u.questions" >
        <div @click="goDetails(v.questionId)">
          <!-- <div> -->
          <div class="topstory-hd">
            <img :src="u.user.image" alt="">
            <span>{{ u.user.name }}</span>
          </div>
          <h2 class="topstory-title">{{ v.title }}</h2>
          <div class="topstory-articleitem">
            <p v-html="v.content"></p>
          </div>
        </div>
        <div class="topstory-actions">
          <ul>
            <li>

              <el-button style="line-height: 30px;padding: 0 12px;border: none;" type="primary" @click="v.likes--;v.favour=false" v-if="v.favour">
                <i class="iconfont icon-xiangshang1"></i>已赞成{{ v.likes }}
              </el-button>
              <el-button style="line-height: 30px;padding: 0 12px;border: none;" @click="v.likes++;v.favour=true;v.disfavour=false;favourUp()" v-else="v.favour">
                <i class="iconfont icon-xiangshang1"></i>赞成{{ v.likes }}
              </el-button>
              <el-button style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;" @click="v.likes--;v.disfavour=true;v.favour=false" v-if="!v.disfavour">
                <i class="iconfont icon-xiangxia2"></i>
              </el-button>
              <el-button style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;" @click="v.likes++;v.disfavour=false;favourUp()" type="primary" v-else>
                <i class="iconfont icon-xiangxia2"></i>
              </el-button>
            </li>
            <li>
              <i class="iconfont icon-xiaoxi"></i>
              <span>11条评伦</span>
            </li>
            <li>
              <i class="iconfont icon-fenxiang"></i>
              <span>分享</span>
            </li>
            <li @click="dialogVisible = true">
              <i class="iconfont icon-shoucang"></i>
              <span>收藏</span>
            </li>
            <li :class="v.like ? 'approve-like' : ''" @click="v.like = !v.like">
              <i class="iconfont icon-icon-"></i>
              <span>{{ v.like ? '取消喜欢' : '喜欢' }}</span>
            </li>
          </ul>
        </div>
      </li >
    </ul>
    <!-- 对话框  -->
    <el-dialog v-model="dialogVisible" title="添加收藏" width="30%" :before-close="handleClose">
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

</style>
