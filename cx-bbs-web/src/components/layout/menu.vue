<script setup>
import { ref } from 'vue'
const useMenus = ref([
  { name: '首页', url: '/index' },
  { name: '知乎知学堂', url: '/education' },
  { name: '发现', url: '/explore' },
  { name: '等你来答', url: '/waiting' }
])
</script>

<template>
  <el-menu :default-active="$route.path" class="el-menu-demo" mode="horizontal" router>
    <el-menu-item index="">
      <!-- <img src="/src/assets/image/logo.png" alt="" style="width: 80px"> -->
      <svg width="80" height="40" xmlns="http://www.w3.org/2000/svg">
        <title>晨曦</title>
        <g id="Layer_1">
          <title>晨曦</title>
          <text font-weight="normal" font-style="normal" transform="matrix(1.17917 0 0 1.22203 -2.49767 -1.79278)"
            stroke="#000" xml:space="preserve" text-anchor="start" font-family="'Alumni Sans'" font-size="24" id="svg_1"
            y="25.28368" x="10.7686" stroke-width="0" fill="#007fff">晨曦</text>
        </g>
      </svg>
    </el-menu-item>
    <el-menu-item :index="v.url" v-for="v in useMenus" :key="v.url">
      <span>{{ v.name }}</span>
    </el-menu-item>
  </el-menu>
</template>

<style scoped></style>
