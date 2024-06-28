<script setup>
import { ref } from 'vue';
import {reactive} from "vue";

const comments = reactive([
  {
    author: "柏小陌",
    avatarSrc: "https://s2.loli.net/2024/06/25/71qVLWasyFZckpX.png",
    altText: "Han Solo",
    content: "碎前上周生产，碎后商周生产。",
    comments: [
      {
        author: "百福生",
        avatarSrc: "https://s2.loli.net/2024/06/25/71qVLWasyFZckpX.png",
        altText: "Han Solo",
        content: "关键是真有百分之一碎片是商周文物，至于其他碎片按照商周文物估价"
      },

    ]
  },
  {
    author: "冰二锅",
    avatarSrc: "https://s2.loli.net/2024/06/25/71qVLWasyFZckpX.png",
    altText: "Han Solo",
    content: "要是真是稀罕货，不会这样堆在这",
    comments: [
    ]
  },
]);


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

// 假设的发送评论方法
const sendReply = (comment) => {
  // 这里你可以使用 axios 或其他 HTTP 客户端发送评论
  // 使用 replyText.value 作为评论内容，comment 作为评论对象（可能还需要其他数据）
  // 发送成功后，清空 replyText 和关闭回复状态
  // 示例：
  // axios.post('/api/comments', { text: replyText.value, commentId: comment.id })
  //   .then(response => {
  //     // 处理发送成功后的逻辑
  //     replyText.value = '';
  //     toggleReply(comment);
  //   })
  //   .catch(error => {
  //     // 处理发送失败后的逻辑
  //   });

  // 这里为了演示，我们只是简单地清空并关闭回复状态
  replyText.value = '';
  toggleReply(comment);
};
</script>


<template>
  <div>
    <a-comment v-for="comment in comments" :key="comment.author">
      <template #actions>
        <!--        <span key="comment-nested-reply-to" @click="">回复</span>-->
        <span v-if="!isReplying(comment)" key="comment-nested-reply-to" @click="toggleReply(comment)">回复</span>
        <el-input v-if="isReplying(comment)"
                  key="comment-nested-reply-input"
                  v-model="replyText"
                  @blur="toggleReply(comment)"
                  placeholder="回复..."
                  @keyup.enter="sendReply(comment)"  />

      </template>
      <template #author>
        <a>{{ comment.author }}</a>
      </template>
      <template #avatar>
        <a-avatar :src="comment.avatarSrc" :alt="comment.altText" />
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
                        v-model="replyText"
                        @blur="toggleReply(nestedComment)"
                        placeholder="回复..."
                        @keyup.enter="sendReply(nestedComment)"/>
            </template>
            <template #author>
              <a>{{ nestedComment.author }}</a>
            </template>
            <template #avatar>
              <a-avatar :src="nestedComment.avatarSrc" :alt="nestedComment.altText" />
            </template>
            <template #content>
              <p>{{ nestedComment.content }}</p>
            </template>
          </a-comment>
        </div>
      </template>
    </a-comment>
  </div>
</template>

