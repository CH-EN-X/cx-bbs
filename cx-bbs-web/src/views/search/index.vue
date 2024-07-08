<script setup>
import {ref, onMounted, createVNode, reactive} from 'vue';
import Contentright from '../index/contentright.vue'
import Contentleft from "./contentleft.vue";

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
</script>

<template>
  <div class="content">
    <Contentleft />
    <Contentright />
  </div>
</template>

<style scoped>

</style>
