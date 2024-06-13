<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const topstorylist = ref([
  {
    // "id": 634287230,
    // type: "question",
    // title: "有没有高质量的规则类怪谈？",
    // "created": 1702275608,
    //"bound_topic_ids": [
    //     1125,
    //     3646,
    //     10819,
    //     57837
    //           ],
    excerpt: "【你已进入西游世界，请遵守以下规则。】 【小心队伍里的第五个人。】 【大师兄会保护你，不要拒绝他的要求。】 【八戒说散伙时，尽快给他大量血肉。】 【绝对不要和沙僧说话！】 【隐藏你的真实身份，你不是唐僧。】 1 头痛，快要裂开地痛。 我睁开眼，三张带着腥气的怪脸瞬间凑了过来。 猴，猪，头陀，还有身上的袈裟，我这是……穿越到西游世界了？ 「师父，你醒啦？」满脸须发的头陀率先关切。 「……」我刚想回话，想起了第…",
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    title: "有没有高质量的规则类怪谈？", //query
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
            {{ v.excerpt }}
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

            <li :class="v.like ? 'approve-like' : ''" @click="v.like = !v.like">
              <i class="iconfont icon-icon-"></i>
              <span>{{ v.like ? '取消喜欢' : '喜欢' }}</span>
            </li>
            <li @click="dialogVisible = true">
              <i class="iconfont icon-shoucang"></i>
              <span>收藏</span>
            </li>

            <li>
              <i class="iconfont icon-fenxiang"></i>
              <span>分享</span>
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
