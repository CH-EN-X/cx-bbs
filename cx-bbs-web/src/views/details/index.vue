<script lang="ts" setup xmlns="">
import TextEditor from "../common/TextEditor.vue"
import {defineProps, inject, onBeforeMount, onMounted, reactive, ref} from 'vue';
import {useRoute, useRouter} from 'vue-router'
import {ElMessage} from "element-plus";
import axios from "axios";
import Component from "../common/Comment.vue"

const props = defineProps(['id']);

const showAnswer = ref(true);
onBeforeMount(() => {
  console.log('ID:', route.params.id);
  console.log('sign:', route.query);
  // if ()

});
onMounted(()=>{
  // if (route.params.sign === "true"){
  //   showAnswer.value = false
  // }
})


const toAnswer = () => {
  showAnswer.value = !showAnswer.value;
};

let isFollowed = ref(false)
const dialogVisible = ref(false);
const commentDialog = ref(false)
// 定义 replyText 数据
const replyText = ref('');

let userData = reactive({
  id: 2002102014,
  name: '',
  age: 25,
  img: '/src/assets/image/1.png',
  follow: false,
});
//先别删除
let question = ref({
  title: "",
  content: '',
  img: '',
  follow: false,
  id: 1,
  favour: 88,
  like: false,
  likes: 25,
  comments: 0,
});
let detailsData = reactive({
      question: {
        id: 1202862387124125691,
        content: "高考真的能决定我们的未来吗",
        title: "高考真的能决定我们的未来吗",
        authorId: null,
        likes: null,
        labels: null,
        publishTime: null
      },
      author: null,
      articles: [
        {
          id: 1404707620526362627,
          authorId: null,
          author: null,
          content: "<p><span style=\"color: rgb(25, 27, 31); background-color: rgb(255, 255, 255); font-size: 15px;\">被催更了，还一直被大家问最近的情况，我又来更新了，问我近况的实在是太多了，我再bb两句，拿到了美国TOP30的研究生录取，专业排名全美TOP3，不凡尔赛的说我知足了，至于能不能挣扎上藤校看命就好。</span></p><p><span style=\"color: rgb(25, 27, 31); background-color: rgb(255, 255, 255); font-size: 15px;\">美国疫情太严重啦，我offer延到2022年了，哈哈没有能很顺利的出国读研，但是我会坚持下去的，好好完成学业，请大家放心，就像鸣人一样，说到做到就是我的忍道</span></p><p><span style=\"color: rgb(25, 27, 31); background-color: rgb(255, 255, 255); font-size: 15px;\">这个回答每到高考之前就会被疯狂翻牌子，事实上我比较建议那些高一高二的小朋友，或者是总觉得自己没有学习动力的人，去高考考场看看（前提是不要影响正常的考试秩序哈）</span></p><p>我觉得高考特别精彩的时刻就在于一波一波的考生，神色各异的从考场中出来，有人开心雀跃，有人焦虑不安，有人紧张的崩溃大哭，有人轻松的吹着口哨。而出现这些表情的原因，往往就是一个人心理素质和努力程度最真实的写照，也许我不应该在这贩卖成功学的焦虑，但是如果你们愿意花点时间观察这些考生，包括家长，你真的会觉得非常有趣，这就是中国无数个家庭的最真实的一面，尤其是考完最后一科的时候，即便是那些最冷静最克制的人，情绪也会挣扎着扯破面皮，众生百态，可见一斑</p><p>高考完的夜晚，是最喧嚣，也是最平静的夜晚，那一顿饭，有人会吃的食不知味，有人也可能喝的酩酊大醉，也有人就好像以前千百个日夜一样，只是照常吃了一碗面，一口饭，但是每个考完的孩子都将在这个盛夏，迎来不同的命运</p><p>这个回答一直争议很大，我也无数次的收到过私信对我的谩骂和指责，其实这都是我最初写下文章时所没有预料到的，以前我总想着会要battle一下，但是现在我放弃这种想法了，有的话就只说给懂的人听吧，祝今年高考的小朋友们金榜题名！</p><p>———————————————————分割——————————————</p><p><br></p><p>原回答在下面，我想为我自己申辩几句。</p><p>这篇文章我好久没有修改了，因为评论里某些人真的是太恶心了，指责我大学不学无术，没有科研，在这和一群高中生找优越感，真的，我很难过，我不是特别聪明的人，确实在吉大，我根本算不上一个好学生，但是我修了双学位，参加了各种比赛，还拿了一些奖，假期也有参加实习，现在和老师一起做项目。</p><p>我从生物技术跨考转到商学院，我只能说我天资一般，我一直在努力，没有辜负我自己，而且大学难道要和高中一样学习？我不认同，我需要娱乐和发展自己的时间。我确实跟清华北大的大佬有很大很大的差距，感谢评论里支持鼓励我的人，但是我写这篇文章的目的，初心，是为了鼓励很多成绩尚且不理想的孩子，因为我都可以做到这种程度，只要你们努力，我相信你们都可以超过我，有的人真的是太恶意了，这种无缘无故的诋毁，我不接受。</p><p>我始终觉得，只有我们的年轻人，我们的下一代，越来越好，越来越优秀，全把我踩在脚下当垫脚石都行，我真心祝你们都好，希望你们狠狠的把我这个前浪拍在沙滩上，在高考，在各个考试的战场上一往无前，披荆斩棘。</p><p>现在键盘侠跟喷子太多了，这种对我无端的恶意揣测和攻击，甚至上升到我人品，品行的层次。我很生气，但是我想告诉所有看我文章的小朋友，我想告诉你们的始终是，你们要对自己有信心！你们是祖国的未来！是家庭的未来！你们每个人都是最棒的！不必在意别人说什么，今天是高考第一天，你们都是好样的！希望你们都超过我，分数一个比一个高，期待出成绩的时候你们狂轰滥炸我，祝捷报频频！</p><p><br></p><p>——————————-分割——————————</p><p><br></p><p>985在读大三本科生不请自来</p><p>今天刚刚从北京签了去美国留学的合同，希望哪怕有一个人看到我的回答，因此决定好好学习，都不枉我念叨这一小会。</p><p>对于我来说，高考帮我走上了人生的快车道，曾经很多跟我从小玩到大的朋友，我现在回头，发现人跟人的差距比人跟狗都大，详细的下面说。</p><p>说我自己，我是复读生，高一高二的时候，跟一帮混子在一起消磨时间，高二升高三考了3百多分，数学几十分，高三猛然醒悟，觉得真要好好学习了，可能也是因为我理科生，提分快，而且我确实不笨，真的是学到吐血那种不要命了，晚上两三点睡，早起六七点起，第一年考上了一个211，南昌大学。</p><p>然后本着不要脸的精神，非985不读，去复读了，我去复读之前，就有人跟我说，哎呀都是本一大学，985能比211高级到哪去，在复读一年没啥用。我其实说没有犹豫是假的，但是我属于那种主意特别正的孩子，就是当时去复读，被全世界的反对吧，但是我宁死不屈，跟家里说了，以后这样的亲戚来了，我就不见了，我“日理万机”哪有时间！？狗头保命哈哈哈哈哈。</p><p>中国人永远有一个差不多的思维，就是告诉你差不多得了，你没必要这么拼，还是个女孩子，以后差不多得了，我在这说一句讽刺的，往往这样差不多的人，混的都差的挺多的。</p><p>后来去复读了，真的是那种孤立无援，没有几个熟悉的同学，大家都背着书包开开心心去上大学，我在家里做理综套卷，这种心酸真的无法言说，因为我基本比我们学校的绝大多数人，考的都好，但是我还是坐在了复读班的教室里，但是就是这种拧巴的劲吧，不服输，虽然最后发挥的不是很好，但是还是来了吉林大学，哈哈哈哈野鸡985，狗头保命，爱我吉大。</p><p>我说说这个我说我自己走上快车道是啥意思，我们家五线城市，真的小，是那种往上数三代，大家没准祖坟都是一个坑里的小城市，除了经济条件还凑合之外，某种程度人们对学习的误解跟愚昧，会让一些大城市的人感觉特别可笑。</p><p>我来了吉大，这三年，吉大教会了我好多事情，我举个例子，大学的气氛太好了，就拿我们宿舍举例子，一个宿舍四个人，大家的家庭条件都不错，而且素质很高，大家关系融洽到，我父母来就要叫我舍友一起吃饭，我们宿舍一年一起吃饭好几十次（去外面饭店），基本上除了内裤大家啥都可以借，一个人有事全宿舍上，我年年是寝室给我买蛋糕过生日，感动的无以复加，最起码很多人说的宿舍烂事，我们寝室一件都没有。</p><p>再说说视野跟眼界方面，我上高中的时候，我们班主任跟我们说，去澳洲切牛肉，就是流水线上的工人一年能有十几万人民币（澳币可能也就三四万吧）拿，我们全班当时百分之80的人反应是，哇！一年十几万，不读书了，去澳洲切牛肉啊。现在想起来，哇的人真的都停留在一年工资几万块钱的水平上了，虽然工资或者挣的钱多少不代表是否幸福，但是我觉得年轻人应该是潜力无限的，怎么能因为这个十多万的切牛肉的工作，就放弃了追求知识，实现自己更高价值的道路呢，这个社会不能没有科学家，也不能没有人切牛肉，但是我希望我自己去做一点改变世界的事情，狗头！保！命！更何况我不能忍受单调重复的工作，我希望自己真正创造一点价值。</p><p>大学在商学院，有幸上过丁志国老师的课，可以自行百度一下这个老师多厉害，也是第一次有人跟我们讲，财富是怎样积累的、包括商学院很多优秀的老师，刘柏老师，我印象最深刻的就是刘柏老师跟我们说，他二十几岁垄断整个东南亚锻铁五金市场，你会觉得你自己就是一个小垃圾，身边全是比你厉害的人，但是每一天又充满希望，因为你确实在进步，正在成为更好的人，至少成为你自己</p><p>都说年轻的时候最怕没有见识，见过泰山，觉得登泰山小天下，殊不知世界上还有珠穆朗玛峰，有阿尔卑斯山脉，不是说泰山不好，至少你要知道世界上有比泰山更高大的山脉，你可以不经常登山，但是你心里应该有一座山峰，你告诉自己应该不停的往上走，往上走，永不停歇。</p><p>这个世界上没有那么多的童话故事，我的大部分同学，不努力读书的结果就是去工厂当了三班倒的工人，还有超市售货员，生活非常辛苦，不是说歧视工人，歧视这些社会底层勤劳工作的人，是当你年轻的时候，你应该有选择生活的权利，而不是被迫谋生。</p><p>我现在在准备去美国读书，想去看看外边更宽广的世界，可能也是纯粹出于好奇心吧，我想知道美国的月亮究竟是什么样的，我想知道为什么美国能领跑世界一百年，我想知道真实的美国究竟有多发达，我现在仍旧很恍惚，会回想起自己高中逃课出去喝奶茶看电影的日子，会想到那个时候的自己，听到一年切牛肉能挣十几万惊讶的样子。</p><p>我不知道高考究竟能不能决定一个人的未来，但是我知道，如果你打好高考这场仗，你的人生会走上一条快车道，你接触的资源，接触到的人事物，会指引你成为更好的自己，你会走的特别快，上升的特别快。可能是正值这几年吧，人成长起来也会特别的快，就好像到了高速路口，有人被中途截停了，有人拐入下道了，而有的人，跟他们的同伴一起，启程新的人生了。</p><p>我没有骄傲的意思，我想说，祝你们每一个人都好，祝中国的年轻人一代比一代好。</p>",
          likes: 7900,
          collection: null,
          comments: 0
        }
      ],
      comments: 0

    }
)


//点击好问题改变样式
const favourQuestion = () => {
  if (document.getElementById('likeButton').style.color !== "blue") {
    document.getElementById('likeButton').style.color = 'blue';
    question.likes++;
  } else {
    document.getElementById('likeButton').style.color = '';
    question.likes--;
  }
};



//提交输入内容
const textEditor: any = ref(null);
function submit  ()  {
  // topstorylist.value.content = textEditor.value.valueHtml
  // textEditor.value.submit();
  const data = ({
    authorId:localStorage.getItem("id"),
    authorName:localStorage.getItem("name"),
    images:localStorage.getItem("image"),
    questionId:detailsData.question.id,
    content:textEditor.value.valueHtml
  });
  console.log(textEditor.value.valueHtml)
  console.log(data)
  axios.post("http://localhost:51802/api/answers/publish",data
      ).then(response => {
        if (response.data.code === 200)
          ElMessage.success("回答成功");
        else
          ElMessage.error(response.data.message);
  })

}


// 获取当前路由对象和路由实例
const route = useRoute();
const router = useRouter()

function toLogin () {
  if (localStorage.getItem("id")===null){
    router.push({
      name: 'login'})
    ElMessage.warning("请先登录")
  }


}

// const loadComments = ref<any>();
// const getFileRef = () => {
//   loadComments.value.loadComments();
// };

const toCommentId = ref(666)
function openComment(id){
  toCommentId.value = id
  // getFileRef()
  commentDialog.value = true
  console.log(id)
  console.log(toCommentId.value)

}



function sendComment(){
  ElMessage.info()
}


function follow(id){
  if (!isFollowed.value){
    //未关注
    axios.post("http://localhost:51801/api/follow/toFollow",{
      userId:localStorage.getItem("id"),
      followId:id
    }).then(response => {
      if (response.data.code === 200){
        ElMessage.success(response.data.message);
        isFollowed.value = true
      }else {
        ElMessage.warning(response.data.message);
        // isFollowed.value = true
      }
    })
  }else {
    //已关注取消关注
    axios.post("http://localhost:51801/api/follow/unFollow",{
      userId:localStorage.getItem("id"),
      followId:id
    }).then(response => {
      if (response.data.code === 200){
        ElMessage.success(response.data.message);
        isFollowed.value = false;
      }else {
        ElMessage.error(response.data.message)
      }
    })
  }

}

const id = ref(null);
function load() {
  const id = route.params.id;
  axios.post("http://localhost:51802/api/answers/details/" + id).then(response => {
    // 处理登录成功的逻辑
    const newData = response.data.data;
    if (response.data.code === 200) {
      detailsData.question = newData.question
      detailsData.author = newData.author
      detailsData.articles = newData.articles
      detailsData.comments = newData.comments

      //热度最高的作者展示在侧边栏
      if (newData.articles.length !== 0){
        userData = newData.articles[0].author
      }

      console.log(userData);

    } else {
      ElMessage.error(response.data.message);
    }

    if(localStorage.getItem("id")!='' && detailsData.articles.length != 0){
      axios.post("http://localhost:51801/api/follow/ifFollow",{
        userId:localStorage.getItem("id"),
        followId:newData.articles[0].author.id
      }).then(response => {
        if (response.data.code === 200){
          isFollowed.value = true
        }
      })
    }
  });
  console.log(detailsData)


}

//加载页面调用
load()
// defineExpose({
//   valueHtml,
//   submit
// });
</script>

<template>
  <div>
    <div data-za-detail-view-path-module="QuestionDescription"
         data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;type&quot;:&quot;Question&quot;,&quot;token&quot;:&quot;429151322&quot;}}}">
      <div class="QuestionHeader">
        <div class="QuestionHeader-content">
          <div class="QuestionHeader-main">

            <h1 class="QuestionHeader-title">{{ detailsData.question.title }}</h1>
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
                  <div><span itemprop="text">{{ detailsData.question.content }}</span>
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
                    v-if="!question.follow"
                    class="Button FollowButton FEfUrdfMIKpQDJDqkjte Button--primary Button--blue epMJl0lFQuYbC7jrwr_o JmYzaky7MEPMFcJDLNMG"
                    style="margin-bottom: 4px;" type="" @click="question.follow=true">
                  关注问题
                </el-button>
                <el-button
                    v-if="question.follow"
                    class="Button FollowButton FEfUrdfMIKpQDJDqkjte Button--primary Button--blue epMJl0lFQuYbC7jrwr_o JmYzaky7MEPMFcJDLNMG"
                    style="margin-bottom: 4px;" @click="question.follow=false">
                  已关注
                </el-button>
                <a>
                  <el-button class="Button FEfUrdfMIKpQDJDqkjte Button--blue JmYzaky7MEPMFcJDLNMG" type="button"
                             @click="toAnswer">
                    <span
                        style="display: inline-flex; align-items: center;">​<svg class="Zi Zi--Edit QuestionButton-icon"
                                                                                 fill="currentColor" height="16"
                                                                                 viewBox="0 0 24 24" width="16">
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
                      id="likeButton"
                      class="Button GoodQuestionAction-commonBtn FEfUrdfMIKpQDJDqkjte Button--plain Button--withIcon Button--withLabel fEPKGkUK5jyc4fUuT0QP B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                      type="button" @click="favourQuestion">
                  <span style="display: inline-flex; align-items: center;">​<svg
                      class="Zi Zi--Like Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                      height="1.2em"
                      viewBox="0 0 24 24"
                      width="1.2em"><path
                      d="M10.008 1.275c-.717-.07-1.238.482-1.323 1.066-.406 2.806-2 5.043-4.539 6.4-.85.453-1.496 1.334-1.495 2.389 0 .762.002 1.523.004 2.284.003 1.658.007 3.315.003 4.972a2.757 2.757 0 0 0 2.755 2.764h10.742a3.75 3.75 0 0 0 3.636-2.832l1.807-7.154a2.75 2.75 0 0 0-2.666-3.423h-5.59c.205-1.306.259-2.783-.167-4.007-.217-.627-.568-1.209-1.108-1.656-.543-.45-1.231-.724-2.059-.803Z"></path></svg></span>
                    好问题
                    {{ question.likes }}
                  </button>
                </div>
                <div class="QuestionHeader-Comment">
                  <button
                      class="Button FEfUrdfMIKpQDJDqkjte Button--plain Button--withIcon Button--withLabel fEPKGkUK5jyc4fUuT0QP B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                      type="button" @click="openComment(detailsData.question.id)">
                  <span style="display: inline-flex; align-items: center;">​<svg
                      class="Zi Zi--Comment Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                      height="1.2em"
                      viewBox="0 0 24 24"
                      width="1.2em"><path
                      clip-rule="evenodd"
                      d="M12 2.75a9.25 9.25 0 1 0 4.737 17.197l2.643.817a1 1 0 0 0 1.25-1.25l-.8-2.588A9.25 9.25 0 0 0 12 2.75Z"
                      fill-rule="evenodd"></path></svg></span>
                    {{ detailsData.comments.length }} 条评论
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
    <TextEditor ref="textEditor" class="max-width"/>
    <div class="max-width"
         style="width: 100%;height: 34px;border-color: rgb(206, 206, 206);;border-style: solid;border-width: 0px 1px 1px 1px;">
      <el-button style="float: right;" @click="submit">提交回答</el-button>
    </div>
  </div>


  <div class="Question-main">

    <div class="ListShortcut">
      <div v-for="article in detailsData.articles" class="Question-mainColumn" data-zop-questionanswerlist="true">
        <!--内容-->
        <div style="padding-left: 33px;padding-right: 33px;line-height: 24px;background: white;padding-top: 22px;">
          <div style="display: flex; align-items: center;margin-bottom: 13px;">
            <el-avatar :fit="fill" :size="45" :src="userData.image" shape="square"/>
            <span style="display: flex; align-items: center;margin-left: 11px;">
              {{ userData.name }}
            </span>
          </div>
          <div>
            <p v-html="article.content"></p>
            <!--            <p>{{article.content | escapeHtml}}</p>-->
          </div>

        </div>

        <!--        <div >还没有回答呢</div>-->
        <div class="topstory-actions">
          <ul>
            <li>

              <el-button v-if="article.favour" style="line-height: 30px;padding: 0 12px;border: none;"
                         type="primary" @click="article.likes--;article.favour=false">
                <i class="iconfont icon-xiangshang1"></i>已赞成{{ article.likes }}
              </el-button>
              <el-button v-else="article.favour"
                         style="line-height: 30px;padding: 0 12px;border: none;"
                         @click="article.likes++;article.favour=true;article.disfavour=false;favourUp()">
                <i class="iconfont icon-xiangshang1"></i>赞成{{ article.likes }}
              </el-button>
              <el-button v-if="!article.disfavour"
                         style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;"
                         @click="article.likes--;article.disfavour=true;article.favour=false">
                <i class="iconfont icon-xiangxia2"></i>
              </el-button>
              <el-button v-else
                         style="line-height: 30px;padding: 0 12px;border: none;margin-left: 0px;" type="primary"
                         @click="article.likes++;article.disfavour=false;favourUp()">
                <i class="iconfont icon-xiangxia2"></i>
              </el-button>
            </li>
            <li @click="openComment(article.id)">
              <i class="iconfont icon-xiaoxi" ></i>
              <span>{{ article.comments.length }}条评论</span>
            </li>
              <li>
              <i class="iconfont icon-fenxiang"></i>
              <span>分享</span>
            </li>
            <li @click="dialogVisible = true">
              <i class="iconfont icon-shoucang"></i>
              <span>收藏</span>
            </li>
            <li :class="article.like ? 'approve-like' : ''" @click="article.like = !article.like">
              <i class="iconfont icon-icon-"></i>
              <span>{{ article.like ? '取消喜欢' : '喜欢' }}</span>
            </li>
          </ul>
        </div>
      </div>


    </div>


    <!--    <div class="Question-right" style="width:20%;background: #1a1a1a">-->

    <!--    </div>-->
    <!--右侧栏-->
    <div class="Question-sideColumn Question-sideColumn--sticky css-1qyytj7"
         style="background: white;height: auto;margin-right: 350px;" v-if="userData.name!==''">
      <a aria-keyshortcuts="Shift+S" aria-label="边栏锚点" class="css-h9cq7d"></a>
      <div></div>
      <div style="position: relative; top: -0.00000286102px;">
        <div aria-label="关于作者" class="Card AnswerAuthor" style="width: 200px;">
          <div class="Card-header AnswerAuthor-title">
            <div class="Card-headerText">关于作者</div>
          </div>
          <div style="width: 70%; margin-left: 29px;">
            <!--            <img style="display: inline-block;" :src="userData.img">-->
            <!--            <el-avatar :fit="fill" :size="100" :src="detailsData.articles[0].author.img" shape="square"/>-->
            <el-avatar :fit="fill" :size="100" :src="userData.image" shape="square"/>
          </div>
          <div>
            <!--            <p>{{ detailsData.articles[0].author.name }}</p>-->
            <p>{{ userData.name }}</p>
          </div>
          <!--          <el-button v-if="!detailsData.articles[0].author.follow" type="primary"-->
          <!--                     @click="detailsData.articles[0].author.follow=true">关注ta-->
          <!--          </el-button>-->
          <!--          <el-button v-else @click="detailsData.articles[0].author.follow=false">已关注</el-button>-->
          <el-button type="primary" @click="follow(userData.id);"
          >{{ isFollowed ? '已关注' : '关注ta' }}
          </el-button>
          <el-button>私信ta</el-button>
        </div>

      </div>
    </div>

  </div>

<!--  commentDialog-->
  <el-dialog
      v-model="commentDialog"
      title="评论"
      width="700"
      ref="loadComments"
      :close-on-click-modal="false">
    <!--        给dialog加上点击空白处不关闭的属性-->
    <Component  :toCommentId="toCommentId" />
    <template #footer>
      <el-input v-model="replyText" placeholder="回复..." style="width: 90%"/>
      <el-button>发送</el-button>
    </template>
  </el-dialog>

  <!-- 对话框  -->
<!--  <el-dialog v-model="dialogVisible" :before-close="handleClose" title="添加收藏" width="30%">-->
<!--    <span>你可以创建多个收藏夹，将答案分类收藏</span>-->
<!--    <template #footer>-->
<!--        <span class="dialog-footer">-->
<!--          <el-button @click="dialogVisible = false">取消</el-button>-->
<!--          <el-button type="primary" @click="dialogVisible = false">-->
<!--            收藏-->
<!--          </el-button>-->
<!--        </span>-->
<!--    </template>-->
<!--  </el-dialog>-->
</template>

<style scoped>

.Question-sideColumn p {
  font-size: 15px;
  text-align: center;
}

.max-width {
  max-width: 1000px;
  margin: 0 auto;
  width: 100%;
}

.select-button {
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

.topstory-actions {
  background: white;
  margin-top: -20px;
  margin-left: 0px;
  padding-left: 33px;
}

.topstory-actions ul {
  font-size: 15px;
}

.topstory-actions ul {
  display: flex;
  padding: 20px 0;
}

.topstory-actions ul li {
  display: flex;
  align-items: center;
  margin-right: 25px;
  color: #75849A;
  cursor: pointer;
}

.topstory-actions ul li i {
  margin-right: 5px;
}

/* 喜欢  */
.topstory-actions .approve-like {
  color: red;
}
</style>



