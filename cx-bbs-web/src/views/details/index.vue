<script lang="ts" setup xmlns="">
import TextEditor from "../common/TextEditor.vue"


import {ref, onMounted, createVNode, reactive} from 'vue';
import {useRouter} from 'vue-router'
import {ElMessage} from "element-plus";
import axios from "axios";

const showAnswer = ref(true);

const toAnswer = () => {
  showAnswer.value = !showAnswer.value;
};


const dialogVisible = ref(false);
const router = useRouter();

const topstorylist = ref([
  {
    img: '/src/assets/image/pic5.png',
    // name: '喵先生',
    title: "有没有高质量的规则类怪谈？", //query
    content: "<p><br></p><p>最近有几例相关的咨询：客户是程序员，不想再做软件开发了，想干点别的，但不知道做什么。因为我做过十几年的软件研发和研发管理工作，对程序员的职业发展非常了解，就结合自己的经验和咨询的情况，整理了这篇文章，来聊一聊“<strong>不做程序员了，还可以做什么</strong>”。</p><p>主要内容分为五部分：</p><ul><li>搞清楚你为什么要转型</li><li>两种转型策略：关联转型与另起炉灶</li><li>关联转型的9类岗位</li><li>另起炉灶的3种方法</li><li>关于职业转型的两个关键认知</li></ul><p>在展开叙述前，要声明一点：<strong>本文的目的是引发思考，而非详尽说明每一种转行可能性</strong>，因此如果你想要从程序员转向别的职业，需要在我所提供信息的基础上，进一步思考分析。</p><h2><strong>一、搞清楚你为什么要转型</strong></h2><p>像转型这种重大人生决策，一定要搞清楚为什么，梳理出你想通过转型来满足的需求。不然的话，就很容易进入频繁换工作的怪圈。</p><p>需求不要太多，找到最重要的三个就好，把它们列出来，保存到你容易看到、能时时提醒你的地方。比如冰箱，床头柜等。</p><p>我原来是程序员，现在是自由职业者，围绕职业生涯，做咨询、写文章、写书、经营课程，算是大跨度的转行了。当年我在考虑转行时，最重要的三个需求是：</p><ul><li>工作中要尽可能多地做喜欢的事</li><li>工作时间和内容要足够自主，能掌舵生活</li><li>更喜欢一对一咨询带来的意义感<br></li></ul>",
    id: 1,
    favour: 88,
    like: false,
  }
])
const userData = reactive({
  name: '喵先生',
  age: 25,
  img: '/src/assets/image/1.png',
  follow:false,

});
const question = reactive({
  title: "有没有高质量的规则类怪谈？",
  content: "<p><br></p><p>最近有几例相关的咨询：客户是程序员，不想再做软件开发了，想干点别的，但不知道做什么。因为我做过十几年的软件研发和研发管理工作，对程序员的职业发展非常了解，就结合自己的经验和咨询的情况，整理了这篇文章，来聊一聊“<strong>不做程序员了，还可以做什么</strong>”。</p><p>主要内容分为五部分：</p><ul><li>搞清楚你为什么要转型</li><li>两种转型策略：关联转型与另起炉灶</li><li>关联转型的9类岗位</li><li>另起炉灶的3种方法</li><li>关于职业转型的两个关键认知</li></ul><p>在展开叙述前，要声明一点：<strong>本文的目的是引发思考，而非详尽说明每一种转行可能性</strong>，因此如果你想要从程序员转向别的职业，需要在我所提供信息的基础上，进一步思考分析。</p><h2><strong>一、搞清楚你为什么要转型</strong></h2><p>像转型这种重大人生决策，一定要搞清楚为什么，梳理出你想通过转型来满足的需求。不然的话，就很容易进入频繁换工作的怪圈。</p><p>需求不要太多，找到最重要的三个就好，把它们列出来，保存到你容易看到、能时时提醒你的地方。比如冰箱，床头柜等。</p><p>我原来是程序员，现在是自由职业者，围绕职业生涯，做咨询、写文章、写书、经营课程，算是大跨度的转行了。当年我在考虑转行时，最重要的三个需求是：</p><ul><li>工作中要尽可能多地做喜欢的事</li><li>工作时间和内容要足够自主，能掌舵生活</li><li>更喜欢一对一咨询带来的意义感<br></li></ul>",
  img: '/src/assets/image/1.png',
  follow:false,
  id: 1,
  favour: 88,
  like: false,
});


let articleContent  = '<p>是有这种情况啊，不然为什么抖音那些博主干一年就买房了，或者不声不响就提车了？再不济也能不上班靠着发视频养活自己。</p><p>注意，我说的是博主！！<strong>由于普通人和博主之间有信息差，用着一个app相当于在两个世界</strong>，他们发视频就能赚钱，你发视频可能有点赞，有播放，但就是不能赚钱。</p><p>由于工作原因，<strong>我接触博主挺多，分享几个抖音发就能赚钱的视频形式</strong>，你肯定刷到过，很常见的视频：</p><p>1.风景文案视频</p><p><img src="https://picx.zhimg.com/50/v2-7490283665ab02ecb0a204ffca29780e_720w.jpg?source=2c26e567" alt="" data-href="" style=""/></p><p><img src="https://picx.zhimg.com/80/v2-7490283665ab02ecb0a204ffca29780e_720w.webp?source=2c26e567" alt="" data-href="" style=""/></p><p>一段风景视频+音乐+文案</p><p>博主没开橱窗，没直播，视频中就是风景，没有商品广告</p><p>要不是我看到<strong>评论区的置顶</strong>，还以为他天天是在为爱发电呢</p>';

let content = ref(null);

onMounted(() => {
  content.value.innerHTML = articleContent;
});



//提交输入内容
const textEditor : any = ref(null);
const submit = () =>{
  // topstorylist.value.content = textEditor.value.valueHtml
  // textEditor.value.submit();
  console.log(textEditor.value.valueHtml)
  axios.post("",{


  }).then(response=>{

  })

}


function load() {
  axios.post("http://localhost:51802/api/article/load", {
    maxBehotTime: "",
    minBehotTime: "",
    size: 25,
    tag: null
  }).then(response => {
    // 处理登录成功的逻辑
    if (response.data.code === 200) {
      // response.data.data.content = response.data.data.content.slice(1, -1);
      topstorylist.value = response.data.data[0];
      //将string转成json对象
      // topstorylist.value.content = eval(response.data.data[0].content);
      articleContent = response.data.data[0].content
       console.log(  response.data.data[0].content)
    } else {
      ElMessage.error(response.data.message);
    }
  })
}

//加载页面调用
load()
</script>

<template>
  <div>
    <div data-za-detail-view-path-module="QuestionDescription"
         data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;type&quot;:&quot;Question&quot;,&quot;token&quot;:&quot;429151322&quot;}}}">
      <div class="QuestionHeader">
        <div class="QuestionHeader-content">
          <div class="QuestionHeader-main">

            <h1 class="QuestionHeader-title">抖音只要发视频就能赚钱吗 ？</h1>
            <div class="css-1uovyp5"></div>
            <div class="css-1rpg5c6">
              <div class="css-moxmo5"></div>
            </div>
            <div class="css-dojgf2"></div>
            <div class="css-4cffwv">
              <div class="LabelContainer-wrapper"></div>
            </div>
            <div>
              <div class="css-eew49z">
                <div class="QuestionRichText QuestionRichText--expandable QuestionRichText--collapsed">
                  <div><span itemprop="text">抖音只要发视频就能赚钱吗 ？</span>
                    <button class="Button QuestionRichText-more FEfUrdfMIKpQDJDqkjte Button--plain fEPKGkUK5jyc4fUuT0QP"
                            type="button">
                      显示全部
                      <span style="display: inline-flex; align-items: center;">​<svg class="Zi Zi--ArrowDown"
                                                                                          fill="currentColor"
                                                                                          height="24"
                                                                                          viewBox="0 0 24 24"
                                                                                          width="24"><path
                        clip-rule="evenodd"
                        d="M17.776 10.517a.875.875 0 0 1-.248 1.212l-5.05 3.335a.875.875 0 0 1-.964 0L6.47 11.73a.875.875 0 1 1 .965-1.46l4.56 3.015 4.568-3.016a.875.875 0 0 1 1.212.248Z"
                        fill-rule="evenodd"></path></svg></span></button>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="QuestionHeader-side">
            <!--          后期有时间再优化-->
<!--            <div class="QuestionHeader-follow-status">-->
<!--              <div class="QuestionFollowStatus">-->
<!--                <div class="NumberBoard QuestionFollowStatus-counts NumberBoard&#45;&#45;divider">-->
<!--                  <div class="NumberBoard-item">-->
<!--                    <div class="NumberBoard-itemInner">-->
<!--                      <div class="NumberBoard-itemName">关注者</div>-->
<!--                      <strong class="NumberBoard-itemValue" title="1061">1,061</strong></div>-->
<!--                  </div>-->
<!--                  <div class="NumberBoard-item">-->
<!--                    <div class="NumberBoard-itemInner">-->
<!--                      <div class="NumberBoard-itemName">被浏览</div>-->
<!--                      <strong class="NumberBoard-itemValue" title="2312540">2,312,540</strong></div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </div>-->
          </div>

        </div>
        <div class="QuestionHeader-footer">
          <div class="QuestionHeader-footer-inner">
            <div class="QuestionHeader-main QuestionHeader-footer-main">
              <div class="QuestionButtonGroup">
                <el-button
                    class="Button FollowButton FEfUrdfMIKpQDJDqkjte Button--primary Button--blue epMJl0lFQuYbC7jrwr_o JmYzaky7MEPMFcJDLNMG"
                     type="primary" style="margin-bottom: 4px;" v-if="!question.follow" @click="question.follow=true">
                  关注问题
                </el-button>
                <el-button
                    class="Button FollowButton FEfUrdfMIKpQDJDqkjte Button--primary Button--blue epMJl0lFQuYbC7jrwr_o JmYzaky7MEPMFcJDLNMG"
                     style="margin-bottom: 4px;" v-if="question.follow" @click="question.follow=false" >
                  已关注
                </el-button>
                <a>
                  <el-button @click="toAnswer" class="Button FEfUrdfMIKpQDJDqkjte Button--blue JmYzaky7MEPMFcJDLNMG" type="button">
                    <span
                        style="display: inline-flex; align-items: center;">​<svg class="Zi Zi--Edit QuestionButton-icon" fill="currentColor" height="16" viewBox="0 0 24 24" width="16">
                    <path
                        d="m7.841 20.043-4.328 1.18a.6.6 0 0 1-.737-.736l1.18-4.324a1.2 1.2 0 0 1 .314-.539l8.094-7.995a.9.9 0 0 1 1.268.003l2.736 2.736a.9.9 0 0 1 .004 1.268l-7.196 7.296-.802.802a1.2 1.2 0 0 1-.533.31ZM19.703 4.81l-.514-.513a2.542 2.542 0 0 0-3.595 0l-.999 1.067a.9.9 0 0 0 .02 1.252l2.77 2.768a.9.9 0 0 0 1.25.02l1.068-.999a2.542 2.542 0 0 0 0-3.594Z"></path>
                  </svg>
                  </span>
                    <span v-if="showAnswer">写回答</span>
                    <span v-else>返回</span>

                  </el-button>
                </a>
              </div>
              <div class="QuestionHeaderActions">

                <div class="GoodQuestionAction">
                  <button
                      class="Button GoodQuestionAction-commonBtn FEfUrdfMIKpQDJDqkjte Button--plain Button--withIcon Button--withLabel fEPKGkUK5jyc4fUuT0QP B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                      type="button">
                  <span style="display: inline-flex; align-items: center;">​<svg
                      class="Zi Zi--Like Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                      height="1.2em"
                      viewBox="0 0 24 24"
                      width="1.2em"><path
                      d="M10.008 1.275c-.717-.07-1.238.482-1.323 1.066-.406 2.806-2 5.043-4.539 6.4-.85.453-1.496 1.334-1.495 2.389 0 .762.002 1.523.004 2.284.003 1.658.007 3.315.003 4.972a2.757 2.757 0 0 0 2.755 2.764h10.742a3.75 3.75 0 0 0 3.636-2.832l1.807-7.154a2.75 2.75 0 0 0-2.666-3.423h-5.59c.205-1.306.259-2.783-.167-4.007-.217-.627-.568-1.209-1.108-1.656-.543-.45-1.231-.724-2.059-.803Z"></path></svg></span>
                    好问题
                    23
                  </button>
                </div>
                <div class="QuestionHeader-Comment">
                  <button
                      class="Button FEfUrdfMIKpQDJDqkjte Button--plain Button--withIcon Button--withLabel fEPKGkUK5jyc4fUuT0QP B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                      type="button">
                  <span style="display: inline-flex; align-items: center;">​<svg
                      class="Zi Zi--Comment Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                      height="1.2em"
                      viewBox="0 0 24 24"
                      width="1.2em"><path
                      clip-rule="evenodd"
                      d="M12 2.75a9.25 9.25 0 1 0 4.737 17.197l2.643.817a1 1 0 0 0 1.25-1.25l-.8-2.588A9.25 9.25 0 0 0 12 2.75Z"
                      fill-rule="evenodd"></path></svg></span>
                    11 条评论
                  </button>
                </div>
                <div class="Popover ShareMenu">
                  <div id="Popover4-toggle" aria-expanded="false" aria-haspopup="true" class="ShareMenu-toggler">
                    <button
                        class="Button FEfUrdfMIKpQDJDqkjte Button--plain Button--withIcon Button--withLabel fEPKGkUK5jyc4fUuT0QP B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                        type="button">
                    <span style="display: inline-flex; align-items: center;">​<svg
                        class="Zi Zi--Share Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                        height="1.2em"
                        viewBox="0 0 24 24"
                        width="1.2em"><path
                        d="M19.47 1.914a.8.8 0 0 1 1.204.778l-1.872 16.386a.9.9 0 0 1-1.204.743l-4.615-1.692a.7.7 0 0 0-.831.28l-1.927 3.02c-.43.674-1.474.369-1.474-.43v-3.865a.8.8 0 0 1 .179-.504l5.808-7.148a.595.595 0 0 0-.897-.781l-5.93 6.354a1.1 1.1 0 0 1-1.258.252L2.57 13.46a.8.8 0 0 1-.08-1.415l16.98-10.13Z"></path></svg>
                    </span>
                      分享
                    </button>
                  </div>
                </div>

              </div>
              <div class="QuestionHeader-actions"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <br/>

  <div id="AnswerFormPortalContainer" class="css-1mgcfmo"></div>

<!--发布回答-->
  <div v-if="!showAnswer">
    <TextEditor   class="max-width" ref="textEditor"/>
    <div  class="max-width" style="width: 100%;height: 34px;border-color: rgb(206, 206, 206);;border-style: solid;border-width: 0px 1px 1px 1px;">
      <el-button @click="submit" style="float: right;">提交回答</el-button>
    </div>
  </div>


  <div class="Question-main" >

    <div class="ListShortcut">
      <div class="Question-mainColumn" data-zop-questionanswerlist="true">
        <!--内容-->
        <div style="padding-left: 33px;padding-right: 33px;line-height: 24px;background: white;padding-top: 22px;">
          <el-avatar shape="square" :size="45" :fit="fill" :src="userData.img" />
          {{userData.name}}
          <div>
            <div ref="content"></div>
          </div>

        </div>

<!--        <div >还没有回答呢</div>-->

      </div>




    </div>


<!--    <div class="Question-right" style="width:20%;background: #1a1a1a">-->

<!--    </div>-->
    <!--右侧栏-->
    <div class="Question-sideColumn Question-sideColumn--sticky css-1qyytj7" style="background: white;height: auto;margin-right: 350px;">
      <a aria-keyshortcuts="Shift+S" aria-label="边栏锚点" class="css-h9cq7d"></a>
      <div></div>
      <div style="position: relative; top: -0.00000286102px;">
        <div aria-label="关于作者" class="Card AnswerAuthor" style="width: 200px;">
          <div class="Card-header AnswerAuthor-title">
            <div class="Card-headerText">关于作者</div>
          </div>
          <div style="width: 70%; margin-left: 29px;">
<!--            <img style="display: inline-block;" :src="userData.img">-->
            <el-avatar shape="square" :size="100" :fit="fill" :src="userData.img" />
          </div>
          <div >
            <p>{{userData.name}}</p>
          </div>
          <el-button v-if="!userData.follow" @click="userData.follow=true" type="primary">关注ta</el-button>
          <el-button v-else @click="userData.follow=false">已关注</el-button>
          <el-button>私信ta</el-button>
        </div>

      </div>
    </div>

  </div>




<!--  <el-button @click="submit2">submit2</el-button>-->

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
</template>

<style>
.Question-sideColumn p{
  font-size: 15px;
  text-align: center;
}
.max-width{
  max-width: 1000px;
  margin: 0 auto;
  width: 100%;
}
.select-button{
  font-size: 15px;
}
p {
  margin-bottom: 13px;
}

.Question-sideColumn {
  font-size: 30px;
  height: 100px;
  float: right;
  margin-left: 28px;
}
</style>



