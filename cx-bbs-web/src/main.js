import { createApp } from 'vue'
// import './style.css'
import App from './App.vue'
import router from './router/index.js' //./同级 ../ 上一级  @/ 根目录  src
import './assets/css/common.css'
import './assets/css/index.css'
import './assets/font/iconfont.css'
import './assets/font/iconfont.js'
import './assets/css/details.css'
import 'ant-design-vue/dist/reset.css';

import { DatePicker } from 'ant-design-vue';
const app = createApp(App)
app.use(DatePicker);
createApp(App).use(router).mount('#app')
// import { createPinia } from 'pinia';
// import * as Elicons from '@element-plus/icons-vue';

// //引入Elmessage和Elloading的css样式文件
import 'element-plus/theme-chalk/el-loading.css';
import 'element-plus/theme-chalk/el-message.css';
//
// const app = createApp(App);
// const pinia = createPinia();
// 全局注册elementplus icon
// Object.keys(Elicons).forEach((key) => {
//     app.component(key, Elicons[key as keyof typeof Elicons]);
// });
// app.use(router);
// app.use(pinia);
// app.mount('#app');

