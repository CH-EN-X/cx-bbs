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
    content: [],
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

//赞成功能 0赞成 1取消赞成
function like(id,operation){
  console.log(id)
  axios.post("http://localhost:51805/api/v1/likes_behavior",{
    articleId: id,
    type: 0,
    operation: operation
  })
}
//不赞成功能 0不赞成 1取消不赞成
function unlike(id,type){
  axios.post("http://localhost:51805/api/v1/un_likes_behavior",{
    articleId: id,
    type: type,
  })
}

// axios.interceptors.response.use(
//     response => {
//       console.log('拦截器响应成功')
//       if (response.data.code === '1'){
//
//       }
//       return response
//     },
//     error => {
//       console.log('拦截器响应失败')
//       console.log(error)
//       if(error.request){
//         console.log(error.request)
//       } else if(error.response){
//         console.log(error.response.data);
//         console.log(error.response.status);
//       }
//       if (error && error.response) {
//         switch (error.response.status) {
//           case 401: error.message = '未授权，请重新登录(401)';
//             router.push({
//               name: 'login'
//             });
//             break;
//         }
//       }else{
//         error.message ='连接服务器失败!'
//       }
//       return Promise.reject(error)
//     }
// )



function load() {
  // axios.fetchPost("http://localhost:51802/api/article/recommend", {
  // const token = localStorage.getItem('token');
  // console.log(token)

  //Nginx+网关 // axios.post("/api/article/api/article/recommend", {
  axios.post("http://localhost:51802/api/article/recommend", {
    page: 0
  }).then(response => {
    if (response.data.code === 401){
      // router.push({
      //   name: 'login'
      // });
      return ElMessage.warning("请先登录")
    }
    // 处理登录成功的逻辑
    if (response.data.code === 200) {
      // response.data.data.content = response.data.data.content.slice(1, -1);
      questions.value = response.data.data;
      // //将string转成json对象
      // for (let i = 0; i < response.data.data.length; i++) {
      //   questions.value[i].content = response.data.data[i].content;
      // }
    } else {
      ElMessage.error(response.data.message);
    }
  })
}

load()


//--------------------------------评论-----------------------------------------//
const commentDialog = ref(false)
const toCommentId = ref(666)
function openComment(id){
  loadComments(id)
  toCommentId.value = id
  commentDialog.value = true

}
let state = reactive({
  comments: [
    {
      user: {
        name: "柏小陌",
        image: "https://s2.loli.net/2024/06/25/71qVLWasyFZckpX.png",
        altText: "Han Solo",
      },
      content: "碎前上周生产，碎后商周生产。",
      comments: [
        {
          user: {
            name: "百福生",
            image: "https://s2.loli.net/2024/06/25/71qVLWasyFZckpX.png",
            altText: "Han Solo",
          },
          content: "关键是真有百分之一碎片是商周文物，至于其他碎片按照商周文物估价"
        }
      ]
    },
    {
      user: {
        name: "冰二锅",
        image: "https://s2.loli.net/2024/06/25/71qVLWasyFZckpX.png",
        altText: "Han Solo",
      },
      content: "要是真是稀罕货，不会这样堆在这",
      comments: []
    },
  ],
  articleId:''
  // replyText: '',
  // replyingComment: '',
});

// //计算评论数量
// function getTotalSubCommentsLength(comments) {
//   let totalLength = comments.length;
//
//   comments.forEach(comment => {
//     if (comment.comments) {
//       totalLength += comment.comments.length;
//     }
//   });
//
//   return totalLength;
// }
// const totalCommentsLength = getTotalSubCommentsLength(state.comments);

// 定义 replyText 数据
const replyText = ref('');

const replyingComment = ref('');

const isReplying = (comment) => {
  return replyingComment.value === comment;
};

// 在 toggleReply 方法中清空或赋值 replyText
const toggleReply = (comment) => {
  if (isReplying(comment)) {
    replyingComment.value = null;
    replyText.value = ''; // 清空回复框内容
  } else {
    replyingComment.value = comment;
    replyText.value = ''; // 或者在回复时设置默认内容
  }
};


function loadComments(id){

  state.articleId = id
  axios.post("http://localhost:51802/api/comment/load",{
    articleId:id
  }).then(response=>{
    if (response.data.code === 200){
      state.comments = response.data.data
      // console.log(comments)
    }
  })
}
// 评论文章、问题(一级)
const reply = (comment) => {
  // 使用 replyText.value 作为评论内容，comment 作为评论对象（可能还需要其他数据）,type:0问题的 1评论别人的评论
  // 发送成功后，清空 replyText 和关闭回复状态
  // console.log(comment)
  axios.post('http://localhost:51802/api/comment/sendComment', {
    content: replyText.value,
    articleId: state.articleId,
    flag:0 ,
    userId:localStorage.getItem("id")
  }).then(response => {
    if (response.data.code === 200){
      // 处理发送成功后的逻辑
      // state.comments.push(replyText.value);
      replyText.value = '';
      toggleReply(comment);
    }
  })
      .catch(error => {
        // 处理发送失败后的逻辑
      });

  // 这里为了演示，我们只是简单地清空并关闭回复状态
  // replyText.value = '';
  toggleReply(comment);
};

// 回复评论（二级）
const sendReply = (comment) => {
  console.log(comment)
  // 使用 replyText.value 作为评论内容，comment 作为评论对象（可能还需要其他数据）,type:0问题的 1评论别人的评论
  // 发送成功后，清空 replyText 和关闭回复状态

  axios.post('http://localhost:51802/api/comment/sendComment', {
    content: comment.replyText,
    articleId: comment.id,
    flag:1,
    userId:localStorage.getItem("id")
  }).then(response => {
    // 处理发送成功后的逻辑
    replyText.value = '';
    toggleReply(comment);
  })
      .catch(error => {
        // 处理发送失败后的逻辑
      });

  // 这里为了演示，我们只是简单地清空并关闭回复状态
  // replyText.value = '';
  toggleReply(comment);
};
</script>

<template>
  <div class="Topstory-content">
    <ul>
      <!--      :key=v.id点击获取id-->
      <li v-for="(v,index) in questions" :key="v.id">
        <div @click="goDetails(v.questionId)">
          <div class="topstory-hd">
            <!-- <img :src="v.img" alt=""> -->
            <span>{{ v.name }}</span>
          </div>
          <h2 class="topstory-title">{{ v.title }}</h2>

          <div class="topstory-articleitem">
            <p v-html="v.content"></p>
          </div>
        </div>

        <div class="topstory-actions">
          <ul>
            <li>

              <el-button v-if="v.like" style="line-height: 30px;padding: 0 12px;border: none;"
                         type="primary" @click="v.likes--;v.like=false;like(v.articleId,1)">
                <i class="iconfont icon-xiangshang1"></i>已赞成{{ v.likes }}
              </el-button>
              <el-button v-else="v.like"
                         style="line-height: 30px;padding: 0 12px;border: none;" @click="v.likes++;v.like=true;v.dislike=false;like(v.articleId,0)">
                <i class="iconfont icon-xiangshang1"></i>赞成{{ v.likes }}
              </el-button>
              <el-button v-if="!v.dislike"
                         style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;" @click="v.likes--;v.dislike=true;v.like=false;unlike(v.articleId,0)">
                <i class="iconfont icon-xiangxia2"></i>
              </el-button>
              <el-button v-else
                         style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;" type="primary" @click="v.likes++;v.dislike=false;;unlike(v.articleId,1)">
                <i class="iconfont icon-xiangxia2"></i>
              </el-button>
            </li>
            <li @click="openComment(v.articleId)">
              <i class="iconfont icon-xiaoxi"></i>
              <span>2条评伦</span>
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

    <!--  commentDialog-->
    <el-dialog
        v-model="commentDialog"
        title="评论"
        width="700"
        ref="loadComments"
        :close-on-click-modal="false">
      <!--        给dialog加上点击空白处不关闭的属性-->
      <!--    <Component  :toCommentId="toCommentId" />-->
      <!--  评论-->
      <div>
        <a-comment v-for="comment in state.comments" :key="comment.user.name">
          <template #actions>
            <!--        <span key="comment-nested-reply-to" @click="">回复</span>-->
            <span v-if="!isReplying(comment)" key="comment-nested-reply-to" @click="toggleReply(comment)">回复</span>
            <el-input v-if="isReplying(comment)"
                      key="comment-nested-reply-input"
                      v-model="comment.replyText"
                      @blur="toggleReply(comment)"
                      placeholder="回复..."
                      @keyup.enter="sendReply(comment)"  />

          </template>
          <template #author>
            <a>{{ comment.user.name }}</a>
          </template>
          <template #avatar>
            <a-avatar :src="comment.user.image" :alt="comment.user.altText" />
          </template>
          <template #content>
            <p>{{ comment.content }}</p>
          </template>
          <template v-if="comment.comments">
            <div v-for="nestedComment in comment.comments" :key="nestedComment.author">
              <a-comment>
                <template #actions>
                  <span v-if="!isReplying(nestedComment)" @click="toggleReply(nestedComment)">回复</span>
                  <el-input v-if="isReplying(nestedComment)"
                            v-model="nestedComment.replyText"
                            @blur="toggleReply(nestedComment)"
                            placeholder="回复..."
                            @keyup.enter="sendReply(nestedComment)"/>
                </template>
                <template #author>
                  <a>{{ nestedComment.user.name }}</a>
                </template>
                <template #avatar>
                  <a-avatar :src="nestedComment.user.image" :alt="nestedComment.user.altText" />
                </template>
                <template #content>
                  <p>{{ nestedComment.content }}</p>
                </template>
              </a-comment>
            </div>
          </template>
        </a-comment>
      </div>
      <template #footer>
        <el-input v-model="replyText" placeholder="回复..." style="width: 90%"/>
        <el-button  @click="reply">发送</el-button>
      </template>
    </el-dialog>

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
</style>
