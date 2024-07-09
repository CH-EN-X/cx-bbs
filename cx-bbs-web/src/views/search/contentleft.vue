<script setup>
import {ref} from 'vue'
import axios from "axios";
import {ElLoading, ElMessage} from "element-plus";
import router from "../../router/index.js";
import {useRoute} from "vue-router";

const questions = ref([
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    id: 1,
    title: "有没有高质量的规则类怪谈？", //query
    content: '有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？',
    favour: 88,
    like: true,
    comments: 11,
  },
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    id: 1,
    title: "有没有高质量的规则类怪谈？", //query
    content: '有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？有没有高质量的规则类怪谈？',
    favour: 88,
    like: true,
    comments: 11,
  }
])


let loadingInstance;
const startLoading = () => {
  loadingInstance = ElLoading.service({lock: true, text: '加载中……', background: 'rgba(0, 0, 0, 0.7)'});
};
const endLoading = () => {
  loadingInstance.close();
};
function goDetails(id){
  if (localStorage.getItem("id")===null){
    router.push({
      name: 'login'})
    ElMessage.warning("请先登录")
    return;
  }
  router.push({
    name: 'details',
    params: {
      id: id,
    }
  });
}

const route = useRoute();
const word = route.query.q;


function load(){
  console.log(word)
  // if (word){
    axios.post("http://localhost:51802/api/v1/article/search/search", {
      searchWords: word,
      "pageNum": 0,
      "pageSize": 5
    }).then(res => {
      questions.value = res.data.data;
      // resolve(res.data);
    }).catch(error => {
    });
  // }else {
  //   axios.post("http://localhost:51802/api/article/recommend", {
  //     page:0
  //   }).then(res => {
  //     questions.value = res.data.data;
  //     // resolve(res.data);
  //   }).catch(error => {
  //   });
  //
  // }

}
load()
</script>

<template>
  <div class="content-left">
    <div class="card">
      <div id="waiting" class="Topstory-content" style="display: block;">
        <ul>
          <li v-for="(v,index) in questions" :key="v.id" style="padding-bottom: 20px;padding-top: 20px;">
            <div @click="goDetails(v.id)">

              <h2 class="topstory-title" v-html="v.h_title" v-if="v.h_title"></h2>
              <h2 class="topstory-title" v-html="v.title" v-else></h2>
              <div class="topstory-articleitem">
                <p v-html="v.content"></p>
              </div>
            </div>

            <div class="topstory-actions">
              <ul>
                <li>

                  <el-button v-if="v.like" style="line-height: 30px;padding: 0 12px;border: none;"
                             type="primary" @click="v.likes--;v.like=false">
                    <i class="iconfont icon-xiangshang1"></i>已赞成{{ v.likes }}
                  </el-button>
                  <el-button v-else="v.like"
                             style="line-height: 30px;padding: 0 12px;border: none;" @click="v.likes++;v.like=true;v.dislike=false;likeUp()">
                    <i class="iconfont icon-xiangshang1"></i>赞成{{ v.likes }}
                  </el-button>
                  <el-button v-if="!v.dislike"
                             style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;" @click="v.likes--;v.dislike=true;v.like=false">
                    <i class="iconfont icon-xiangxia2"></i>
                  </el-button>
                  <el-button v-else
                             style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;" type="primary" @click="v.likes++;v.dislike=false;likeUp()">
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
                <!--            <li :class="v.like ? 'approve-like' : ''" @click="v.like = !v.like">-->
                <!--              <i class="iconfont icon-icon-"></i>-->
                <!--              <span>{{ v.like ? '取消喜欢' : '喜欢' }}</span>-->
                <!--            </li>-->
              </ul>
            </div>

          </li>
        </ul>
      </div>
      <router-view/>
    </div>
  </div>
</template>

<style scoped></style>
