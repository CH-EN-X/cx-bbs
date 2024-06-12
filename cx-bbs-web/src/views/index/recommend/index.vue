<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const topstorylist = ref([
  {
    // query: "高考真的能决定我们的未来吗",
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    title: '高考真的能决定我们的未来吗', //query
    articleitem: '请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀。',
    id: 1,
    favour: 88,
    like: false,
  }
])
const dialogVisible = ref(false);
//跳转到详情页
const router = useRouter();
function goDetails (v) {
  router.push('/details')
}
function yuedu () {
  //TODO:通过点击按钮，在当前页面查看文章
}
</script>

<template>
  <div class="Topstory-content">
    <ul>
      <li v-for="v in topstorylist" :key="v.id">
        <!-- <div @click="goDetails(v)"> -->
        <div>
          <div class="topstory-hd">
            <!-- <img :src="v.img" alt=""> -->
            <span>{{ v.name }}</span>
          </div>
          <h2 class="topstory-title">{{ v.title }}</h2>
          <div class="topstory-articleitem">
            {{ v.articleitem }}
          </div>
        </div>
        <div class="topstory-actions">
          <ul>
            <li>
              <div>
                <i class="iconfont icon-xiangshang1"></i>赞成{{ v.favour }}
              </div>
              <div>
                <i class="iconfont icon-xiangxia2"></i>
              </div>
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
      </li>
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

<style scoped></style>
