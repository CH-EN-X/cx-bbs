<script setup>
import {ref} from 'vue'
import axios from "axios";
import {ElMessage} from "element-plus";

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
  },
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

function load(){
  axios.get("http://localhost:51802/api/question/waiting").then(response=>{
    if (response.data.code === 200){
      questions.value=response.data.data;
    }else {
      ElMessage.error(response.data.message);
    }
  })
}
load()
</script>

<template>
  <div class="content-left">
    <div class="card">

      <div id="waiting" class="Topstory-content" style="display: block;">
        <ul>
          <!--      :key=v.id点击获取id-->
          <li v-for="(v,index) in questions" :key="v.id" style="padding-bottom: 20px;padding-top: 20px;">
            <!--            <div @click="goDetails(v.questionId)">-->
            <div>
              <div class="topstory-hd">
                <!-- <img :src="v.img" alt=""> -->
                <span>{{ v.name }}</span>
              </div>
              <h2 class="topstory-title">
                {{ v.title }}
                <el-button style="float: right;margin-right: 30px;" type="primary">
                  <svg class="Zi Zi--Edit Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor" height="1.2em"
                       viewBox="0 0 24 24" width="1.2em">
                    <path
                        d="m7.841 20.043-4.328 1.18a.6.6 0 0 1-.737-.736l1.18-4.324a1.2 1.2 0 0 1 .314-.539l8.094-7.995a.9.9 0 0 1 1.268.003l2.736 2.736a.9.9 0 0 1 .004 1.268l-7.196 7.296-.802.802a1.2 1.2 0 0 1-.533.31ZM19.703 4.81l-.514-.513a2.542 2.542 0 0 0-3.595 0l-.999 1.067a.9.9 0 0 0 .02 1.252l2.77 2.768a.9.9 0 0 0 1.25.02l1.068-.999a2.542 2.542 0 0 0 0-3.594Z"></path>
                  </svg>
                  <p>写回答</p>
                </el-button>
              </h2>
            </div>
          </li>
        </ul>
      </div>
      <router-view/>
    </div>
  </div>
</template>

<style scoped></style>
