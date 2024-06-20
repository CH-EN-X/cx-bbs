<script setup>
import { ref, onMounted, createVNode } from 'vue';
import { useRouter } from 'vue-router'
import axios from "axios";
import {ElMessage} from "element-plus";
const topstorylist = ref([
  {

    excerpt: "【你已进入西游世界，请遵守以下规则。】 【小心队伍里的第五个人。】 【大师兄会保护你，不要拒绝他的要求。】 【八戒说散伙时，尽快给他大量血肉。】 【绝对不要和沙僧说话！】 【隐藏你的真实身份，你不是唐僧。】 1 头痛，快要裂开地痛。 我睁开眼，三张带着腥气的怪脸瞬间凑了过来。 猴，猪，头陀，还有身上的袈裟，我这是……穿越到西游世界了？ 「师父，你醒啦？」满脸须发的头陀率先关切。 「……」我刚想回话，想起了第…",
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    title: "有没有高质量的规则类怪谈？", //query
    content: [],//[{"type":"text","value":"网易娱乐5月21日报道 最近，刘敏涛的新剧《生活家》在央八黄金频道热播中，刘敏涛和文淇饰演的“破产母女”引起了一大波观众的关注。剧中，刘敏涛饰演来自底层的单亲妈妈“邱晓霞”，文化程度不高，经济上也经常捉襟见肘，但她充满了底层人民的智慧，不管遇到什么样的生活难题，都能乐观面对、及时想出办法让问题迎刃而解。"},{"type":"text","value":"《生活家》的创作背景源自于编剧滕洋多年前在《萌芽》上发表的一篇短篇小说，艺术总监张巍介绍到：“当时就一眼相中了小说里的妈妈邱晓霞。邱晓霞孕期遭遇出轨、一个人把孩子拉扯大，怎么听都是一个凄惨的单身母亲，但邱晓霞偏不让自己和孩子过凄惨的生活，相反，她乐观豁达、积极向上，甚至经常自黑，充满了英剧中的女性气质。” 她还表示：邱晓霞在生活中其实有着巨大的局限性，她受困于穷人思维，总是无法过上较为宽裕的生活；但同时她又是一个非常强大的母亲，她调动一切有限的社会资源与个人智慧，给予邱冬娜最大的母爱，却从不将个人意志强加到孩子身上，不强迫孩子非要成为某种人，更不强迫把孩子塑造成跟她一样的人。这是中国电视剧史上罕见的一种母女关系。"},{"type":"text","value":"“邱晓霞”的人设的确有很多坚强而伟大的“中国母亲”的影子，我们常说的“为母则刚”就是邱晓霞这样吧。她的设定是小市民、充满市井气，一个人拉扯女儿长大，精打细算成了她必备的生活技能，吵吵闹闹是她需要的铠甲与武器，“小聪明多”则是她的文化程度里能达到的最高水平，但她更大的底色是乐观和坚强，也是她影响了女儿的性格。这样的母亲其实是很真实的。更别说邱晓霞善良、诚信、对女儿更是无条件支持，让人看了就倍感亲切。"},{"type":"text","value":"以往在作品里端庄大气的刘敏涛，这次演出了这个“破产妈妈”的感觉。有很多观众可能不太适应一向稳重的她突然变得如此跳脱，但正如主创所说，这个角色“受困于穷人思想，但又非常强大，调动一切有限的社会资源与个人智慧，给予女儿最大的母爱”。“邱晓霞”这个人物本身就是跳脱的、一直在和命运带给她的困难争斗，很久没有在影视剧里看到这么接地气的“市井妈妈”了。"},{"type":"text","value":"而戏外的刘敏涛也十分“跳脱”，剧中邱晓霞因为文化水平不足和急躁的性格屡屡被骗，刘敏涛和“女儿”文淇在微博上联动喊话邱晓霞“长点心”，刘敏涛更是还在微博中@了“邱晓霞”的微博“一片红霞0”。演员和角色在社交平台上梦幻联动，让人会心一笑。除此之外，随着弹幕里和网络上让邱晓霞长点心的观众越来越多，刘敏涛工作室还给刘敏涛安排了“520全心外卖大餐”，在520这天给刘敏涛送上全心宴：鸭心、鸡心、心形蛋糕、心形煎蛋等……要给邱晓霞“补补心”。刘敏涛替邱晓霞收下，豪气地表示“长心了“。也希望邱晓霞在接下去的剧情里真的”长了心“，别让刘敏涛也跟着着急了。"},{"type":"text","value":"对于跨度大的角色，用一种和自己以往表演方式截然不同的风格来演，表演大胆辛辣，而观众短暂的不适应，不也是刘敏涛“改头换面”演技出色的最好证明吗？在逐渐深入剧情、了解邱晓霞的性格特征和生活背景之后，确实感觉到了刘敏涛对角色融入了巧妙的构思，“邱晓霞”的性格，就是在一个个生动的表情和一句句朴实的生活感悟里，展现在观众面前，令人难忘。"},{"type":"text","value":"(责任编辑：金舒_NBJ4322)"}],
    articleitem: '请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀，可以拍请之旅吧，那叫一个坎坷呀。',
    id: 1,
    favour: 88,
    like: false,
  }
])

const articleContent  = '<p>是有这种情况啊，不然为什么抖音那些博主干一年就买房了，或者不声不响就提车了？再不济也能不上班靠着发视频养活自己。</p><p>注意，我说的是博主！！<strong>由于普通人和博主之间有信息差，用着一个app相当于在两个世界</strong>，他们发视频就能赚钱，你发视频可能有点赞，有播放，但就是不能赚钱。</p><p>由于工作原因，<strong>我接触博主挺多，分享几个抖音发就能赚钱的视频形式</strong>，你肯定刷到过，很常见的视频：</p><p>1.风景文案视频</p><p><img src="https://picx.zhimg.com/50/v2-7490283665ab02ecb0a204ffca29780e_720w.jpg?source=2c26e567" alt="" data-href="" style=""/></p><p><img src="https://picx.zhimg.com/80/v2-7490283665ab02ecb0a204ffca29780e_720w.webp?source=2c26e567" alt="" data-href="" style=""/></p><p>一段风景视频+音乐+文案</p><p>博主没开橱窗，没直播，视频中就是风景，没有商品广告</p><p>要不是我看到<strong>评论区的置顶</strong>，还以为他天天是在为爱发电呢</p>';
const content = ref(null);

onMounted(() => {
  content.value.innerHTML = articleContent;
});


const dialogVisible = ref(false);
//跳转到详情页
const router = useRouter();
function goDetails (v) {
  router.push('/details')
}
function yuedu () {
  //TODO:通过点击按钮，在当前页面查看文章
}

function load(){
  axios.post("http://localhost:51802/api/article/load",{
    maxBehotTime: "",
    minBehotTime: "",
    size: 25,
    tag: null
  }).then(response=>{
    // 处理登录成功的逻辑
    if (response.data.code === 200) {
      // response.data.data.content = response.data.data.content.slice(1, -1);
      topstorylist.value=response.data.data ;
      //将string转成json对象
      for (let i = 0; i < response.data.data.length; i++) {
        topstorylist.value[i].content = eval(response.data.data[i].content);
        articleContent = response.data.data[i].content;
      }
      // console.log(  eval(response.data.data[0].content))
    } else {
      ElMessage.error(response.data.message);
    }
  })
}
load()

</script>

<template>
  <div class="Topstory-content">
    <ul>
      <li v-for="v in topstorylist" :key="v.id">
         <div @click="goDetails(v)">
<!--        <div>-->
          <div class="topstory-hd">
            <!-- <img :src="v.img" alt=""> -->
            <span>{{ v.name }}</span>
          </div>
          <h2 class="topstory-title">{{ v.title }}</h2>
<!--          <div class="topstory-articleitem">-->
<!--            {{ v.content }}-->
<!--          </div>-->
           <div class="topstory-articleitem">
<!--             <div v-for="(item,i) in v.content" :key="item.type" >-->
<!--               <template v-if="item.type === 'text'">-->
<!--                 <p>{{ item.value }}</p>-->
<!--               </template>-->
<!--             </div>-->
             <div>
               <div ref="content"></div>
             </div>
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
