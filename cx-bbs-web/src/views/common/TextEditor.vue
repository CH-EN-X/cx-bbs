<script setup lang="ts">
import '@wangeditor/editor/dist/css/style.css' // 引入 css

import { onBeforeUnmount, ref, shallowRef, onMounted } from 'vue'
import { Editor, Toolbar } from '@wangeditor/editor-for-vue'

//声明属性
const props = defineProps({
  modelValue:{
    type: String,
    default: ""
  }
})

//声明事件消息
const emits = defineEmits<{
  (e:"update:modelValue",value:string):void
}>()

//提交输入内容
const submit = () =>{
  // topstorylist.value.content =
  // console.log(valueHtml._rawValue)
  console.log("@子组件----我被调用了");
}

// 编辑器实例，必须用 shallowRef
const editorRef = shallowRef()

// 内容 HTML
const valueHtml = ref('<p></p>')

// 模拟 ajax 异步获取内容 //编辑功能能用
onMounted(() => {
  // setTimeout(() => {
  //   valueHtml.value = '<p>模拟 Ajax 异步设置内容</p>'
  // }, 1500)
})

const toolbarConfig = {}
const editorConfig = { placeholder: '请输入内容...' }

// 组件销毁时，也及时销毁编辑器
onBeforeUnmount(() => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})

const handleCreated = (editor) => {
      editorRef.value = editor // 记录 editor 实例，重要！
    }


defineExpose({
  valueHtml,
  submit
});
</script>

<template>
  <div style="border: 1px solid #ccc">
    <Toolbar
        style="border-bottom: 1px solid #ccc"
        :editor="editorRef"
        :defaultConfig="toolbarConfig"
        :mode="mode"
    />
    <Editor
        style="height: 500px; overflow-y: hidden;"
        v-model="valueHtml"
        :defaultConfig="editorConfig"
        :mode="mode"
        @onCreated="handleCreated"
    />

  </div>

</template>


<style scoped>
.select-button{
  font-size: 15px;
}
</style>
