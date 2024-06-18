<script lang="ts" setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import {ElMessage} from "element-plus";
import axios from "axios";

const dialogVisible = ref(false);
const router = useRouter();

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
      topstorylist.value=response.data.data[0] ;
      //将string转成json对象
      topstorylist.value.content = eval(response.data.data[0].content);
      // console.log(  eval(response.data.data[0].content))
    } else {
      ElMessage.error(response.data.message);
    }
  })
}
load()
</script>

<template>
  <div>
    <div data-za-detail-view-path-module="QuestionDescription"
         data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;type&quot;:&quot;Question&quot;,&quot;token&quot;:&quot;429151322&quot;}}}">
      <div class="QuestionHeader">
        <div class="QuestionHeader-content">
          <div class="QuestionHeader-main">
            <div class="QuestionHeader-tags">
              <div class="QuestionHeader-topics">
                <div class="Tag QuestionTopic css-ch8ocw" data-za-detail-view-path-module="TopicItem"
                     data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;type&quot;:&quot;Topic&quot;,&quot;token&quot;:&quot;19552330&quot;}}}">
                <span class="Tag-content"><a class="TopicLink" href="//www.zhihu.com/topic/19552330" target="_blank"><div
                    class="css-1gomreu">程序员</div></a></span></div>
                <div class="Tag QuestionTopic css-ch8ocw" data-za-detail-view-path-module="TopicItem"
                     data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;type&quot;:&quot;Topic&quot;,&quot;token&quot;:&quot;19554151&quot;}}}">
                <span class="Tag-content"><a class="TopicLink" href="//www.zhihu.com/topic/19554151" target="_blank"><div
                    class="css-1gomreu">调查类问题</div></a></span></div>
                <div class="Tag QuestionTopic css-ch8ocw" data-za-detail-view-path-module="TopicItem"
                     data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;type&quot;:&quot;Topic&quot;,&quot;token&quot;:&quot;19693942&quot;}}}">
                <span class="Tag-content"><a class="TopicLink" href="//www.zhihu.com/topic/19693942" target="_blank"><div
                    class="css-1gomreu">软件设计师</div></a></span></div>
                <div class="Tag QuestionTopic css-ch8ocw" data-za-detail-view-path-module="TopicItem"
                     data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;type&quot;:&quot;Topic&quot;,&quot;token&quot;:&quot;20022261&quot;}}}">
                <span class="Tag-content"><a class="TopicLink" href="//www.zhihu.com/topic/20022261" target="_blank"><div
                    class="css-1gomreu">码农新人</div></a></span></div>
              </div>
            </div>
            <h1 class="QuestionHeader-title">程序员有必要参加软考吗？</h1>
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
                  <div><span itemprop="text">软考有什么用？</span>
                    <button class="Button QuestionRichText-more FEfUrdfMIKpQDJDqkjte Button--plain fEPKGkUK5jyc4fUuT0QP"
                            type="button">
                      显示全部 <span style="display: inline-flex; align-items: center;">​<svg class="Zi Zi--ArrowDown"
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
            <div class="QuestionHeader-follow-status">
              <div class="QuestionFollowStatus">
                <div class="NumberBoard QuestionFollowStatus-counts NumberBoard--divider">
                  <div class="NumberBoard-item">
                    <div class="NumberBoard-itemInner">
                      <div class="NumberBoard-itemName">关注者</div>
                      <strong class="NumberBoard-itemValue" title="1061">1,061</strong></div>
                  </div>
                  <div class="NumberBoard-item">
                    <div class="NumberBoard-itemInner">
                      <div class="NumberBoard-itemName">被浏览</div>
                      <strong class="NumberBoard-itemValue" title="2312540">2,312,540</strong></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="QuestionHeader-footer">
          <div class="QuestionHeader-footer-inner">
            <div class="QuestionHeader-main QuestionHeader-footer-main">
              <div class="QuestionButtonGroup">
                <button
                    class="Button FollowButton FEfUrdfMIKpQDJDqkjte Button--primary Button--blue epMJl0lFQuYbC7jrwr_o JmYzaky7MEPMFcJDLNMG"
                    type="button">
                  关注问题
                </button>
                <a>
                  <button class="Button FEfUrdfMIKpQDJDqkjte Button--blue JmYzaky7MEPMFcJDLNMG" type="button"><span
                      style="display: inline-flex; align-items: center;">​<svg class="Zi Zi--Edit QuestionButton-icon"
                                                                               fill="currentColor" height="16"
                                                                               viewBox="0 0 24 24"
                                                                               width="16"><path
                      d="m7.841 20.043-4.328 1.18a.6.6 0 0 1-.737-.736l1.18-4.324a1.2 1.2 0 0 1 .314-.539l8.094-7.995a.9.9 0 0 1 1.268.003l2.736 2.736a.9.9 0 0 1 .004 1.268l-7.196 7.296-.802.802a1.2 1.2 0 0 1-.533.31ZM19.703 4.81l-.514-.513a2.542 2.542 0 0 0-3.595 0l-.999 1.067a.9.9 0 0 0 .02 1.252l2.77 2.768a.9.9 0 0 0 1.25.02l1.068-.999a2.542 2.542 0 0 0 0-3.594Z"></path></svg></span>写回答
                  </button>
                </a></div>
              <div class="QuestionHeaderActions">
                <button
                    class="Button FEfUrdfMIKpQDJDqkjte Button--grey Button--withIcon Button--withLabel ZdfrHW7Ef5ZjwFiiBJuS B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                    style="margin-right: 16px;"
                    type="button">
                <span style="display: inline-flex; align-items: center;">​<svg
                    class="Zi Zi--Invite Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                    height="1.2em"
                    viewBox="0 0 24 24"
                    width="1.2em"><path
                    clip-rule="evenodd"
                    d="M5.5 7.5A5.5 5.5 0 0 1 11 2a5.5 5.5 0 0 1 5.5 5.5A5.5 5.5 0 0 1 11 13a5.5 5.5 0 0 1-5.5-5.5Zm8.11 9.498c.404-.408.91-1 1.17-1.51.067-.133.13-.284.165-.442.034-.15.058-.373-.033-.602a.872.872 0 0 0-.545-.509 1.37 1.37 0 0 0-.604-.043c-.657.082-1.518.184-2.373.24-.867.055-1.68.058-2.254-.041-1.189-.204-2.045-.19-2.781.087-.722.272-1.25.773-1.804 1.302-1.533 1.462-2.434 3.311-2.65 4.831-.11.78.535 1.339 1.199 1.339h8.1a.96.96 0 0 0 .955-.929c.06-1.767.7-2.96 1.456-3.723Zm5.596-2.292a.706.706 0 0 0-1.412 0v2.588h-2.588a.706.706 0 0 0 0 1.412h2.588v2.588a.706.706 0 1 0 1.412 0v-2.588h2.588a.706.706 0 0 0 0-1.412h-2.588v-2.588Z"
                    fill-rule="evenodd"></path></svg></span>邀请回答
                </button>
                <div class="GoodQuestionAction">
                  <button
                      class="Button GoodQuestionAction-commonBtn FEfUrdfMIKpQDJDqkjte Button--plain Button--withIcon Button--withLabel fEPKGkUK5jyc4fUuT0QP B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                      type="button">
                  <span style="display: inline-flex; align-items: center;">​<svg
                      class="Zi Zi--Like Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                      height="1.2em"
                      viewBox="0 0 24 24"
                      width="1.2em"><path
                      d="M10.008 1.275c-.717-.07-1.238.482-1.323 1.066-.406 2.806-2 5.043-4.539 6.4-.85.453-1.496 1.334-1.495 2.389 0 .762.002 1.523.004 2.284.003 1.658.007 3.315.003 4.972a2.757 2.757 0 0 0 2.755 2.764h10.742a3.75 3.75 0 0 0 3.636-2.832l1.807-7.154a2.75 2.75 0 0 0-2.666-3.423h-5.59c.205-1.306.259-2.783-.167-4.007-.217-.627-.568-1.209-1.108-1.656-.543-.45-1.231-.724-2.059-.803Z"></path></svg></span>好问题
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
                      fill-rule="evenodd"></path></svg></span>11 条评论
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
                        d="M19.47 1.914a.8.8 0 0 1 1.204.778l-1.872 16.386a.9.9 0 0 1-1.204.743l-4.615-1.692a.7.7 0 0 0-.831.28l-1.927 3.02c-.43.674-1.474.369-1.474-.43v-3.865a.8.8 0 0 1 .179-.504l5.808-7.148a.595.595 0 0 0-.897-.781l-5.93 6.354a1.1 1.1 0 0 1-1.258.252L2.57 13.46a.8.8 0 0 1-.08-1.415l16.98-10.13Z"></path></svg></span>分享
                    </button>
                  </div>
                </div>
                <div class="Popover">
                  <button id="Popover5-toggle" aria-expanded="false" aria-haspopup="true" aria-label="更多"
                          class="Button FEfUrdfMIKpQDJDqkjte Button--plain Button--withIcon Button--iconOnly fEPKGkUK5jyc4fUuT0QP B46v1Ak6Gj5sL2JTS4PY hIwDV_tcL6XN1HprrnAq"
                          type="button">
                  <span style="display: inline-flex; align-items: center;">​<svg
                      class="Zi Zi--Dots Button-zi t2ntD6J1DemdOdvh5FB4" fill="currentColor"
                      height="1.2em"
                      viewBox="0 0 24 24"
                      width="1.2em"><path
                      d="M6 10.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3ZM10.5 12a1.5 1.5 0 1 1 3 0 1.5 1.5 0 0 1-3 0ZM16.5 12a1.5 1.5 0 1 1 3 0 1.5 1.5 0 0 1-3 0Z"></path></svg></span>
                  </button>
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

  <div class="Question-main">
    <div class="ListShortcut">
      <div class="Question-mainColumn" data-zop-questionanswerlist="true">
        <!--登录提醒-->
<!--        <div class="Question-mainColumnLogin">-->
<!--          <div class="Question-mainColumnLoginImg">-->
<!--            <svg fill="none" height="50" viewBox="0 0 43 50" width="43">-->
<!--              <path-->
<!--                  d="M23.376 45.237c-1.567 0-3.133.012-4.698 0a1.701 1.701 0 0 0-1.133.386 507.16 507.16 0 0 1-4.493 3.517 3.959 3.959 0 0 1-.694.449 1.305 1.305 0 0 1-1.792-1.537c.239-.737.477-1.47.744-2.192.158-.42.153-.597-.384-.68-1.963-.3-3.672-1.093-4.879-2.756a7.614 7.614 0 0 1-1.272-2.983c-.098-.477-.238-.455-.651-.317-.625.212-.783.568-.601 1.16.041.155.057.316.047.477a.988.988 0 0 1-.806 1.03.954.954 0 0 1-1.162-.589c-.115-.257-.189-.417-.527-.408a1.009 1.009 0 0 1-1.003-.701c-.188-.463.015-.828.337-1.112.238-.22.238-.356.067-.625a1.023 1.023 0 0 1 .238-1.432.98.98 0 0 1 1.377.203c.293.348.542.344.966.227 1.315-.365 1.974-1.088 1.99-2.534.015-1.239.346-2.467.494-3.706.158-1.314-.1-2.61-.258-3.905-.205-1.67-.477-3.34-.742-4.992-.136-.89.44-1.462 1.325-1.312 1.119.186 1.104.183 1.255-.955.224-1.689.45-3.376.715-5.058a1.102 1.102 0 0 0-.522-1.243C5.336 12.284 4.34 10.273 3.93 7.954c-.462-2.57.65-4.554 2.53-6.175C8.34.156 10.609-.166 12.993.068a11.67 11.67 0 0 1 3.884 1.028 5.311 5.311 0 0 1 2.147 1.728c.303.436.645.541 1.138.539 4.362-.017 8.721 0 13.08 0 1.776 0 3.415.413 4.813 1.563 2.04 1.67 2.784 3.87 2.558 6.442-.009.08-.023.16-.04.239-.178.954-.21 1.655.715 2.479a4.5 4.5 0 0 1 .386 6.15 13.421 13.421 0 0 1-2.2 2.246 1.322 1.322 0 0 0-.548.928c-.604 4.355-1.267 8.7-1.814 13.06-.539 4.327-3.407 7.65-7.566 8.59-.876.169-1.768.235-2.66.198H23.38l-.003-.021z"-->
<!--                  fill="#121212"></path>-->
<!--              <path-->
<!--                  d="M12.394 47.606c.441-1.293.809-2.417 1.21-3.526.136-.377 0-.442-.335-.444-.715 0-1.431-.019-2.147-.07-1.346-.095-2.458-.698-3.412-1.624a1.357 1.357 0 0 1-.425-1.105c.046-.93.062-1.863.062-2.794a.614.614 0 0 1 .492-.692c.513-.148 1.014-.338 1.517-.517.442-.156.642-.478.509-.929-.144-.477-.537-.532-.955-.41-.322.09-.64.21-.954.31-.403.13-.601 0-.592-.446.02-.89 0-1.782.024-2.675.05-2.944-.33-5.85-.775-8.751-.02-.117-.043-.239-.055-.351-.046-.535.086-.659.606-.53 1.095.267 2.2.504 3.278.833 1.67.51 3.329.365 4.975-.1 1.97-.559 3.798-1.473 5.64-2.343a1.038 1.038 0 0 0 .604-.955c.072-1.047.16-2.095.238-3.14.048-.61.184-.715.747-.477 1.625.628 3.252 1.25 4.865 1.909a3.12 3.12 0 0 0 2.195.074c1.73-.558 3.348-1.413 5.018-2.114.745-.306.768-.306 1.074.458.532 1.322 1.038 2.653 1.603 3.963.191.444.079.695-.265.954a37.672 37.672 0 0 1-4.576 2.976c-.833.463-.883.568-.716 1.517.838 4.57 1.217 9.189 1.556 13.813a1.209 1.209 0 0 1-.44 1.085c-1.631 1.494-3.552 2.148-5.752 2.148-3.101-.029-6.184 0-9.276 0a1.432 1.432 0 0 0-1 .374c-1.436 1.179-2.93 2.317-4.538 3.58z"-->
<!--                  fill="#FEFEFE"></path>-->
<!--              <path-->
<!--                  d="M32.376 15.823a3.172 3.172 0 0 0-.04-.366c-.284-1.171.035-2.087 1.026-2.834.584-.441.61-.926.293-1.403s-.78-.573-1.45-.239c-.24.122-.299.072-.356-.157a1.583 1.583 0 0 0-.212-.477.936.936 0 0 0-1.14-.408.995.995 0 0 0-.693 1.062c.023.211.06.42.112.627-.365-.05-.69-.239-1.05-.086a.99.99 0 0 0-.675.759.869.869 0 0 0 .415.973c.392.239.802.427 1.215.62a.548.548 0 0 1 .394.52c.023.655.076 1.308.133 1.957a.46.46 0 0 1-.327.542 2.832 2.832 0 0 1-2.343.05c-1.894-.8-3.817-1.517-5.743-2.26-.97-.376-1.536-.028-1.63 1.005-.114 1.262-.238 2.524-.312 3.791a.809.809 0 0 1-.51.78c-1.797.83-3.594 1.67-5.56 2.031a6.441 6.441 0 0 1-2.708-.06c-.752-.176-1.494-.398-2.248-.555-.36-.075-.439-.24-.39-.568.28-1.922.552-3.843.813-5.765.043-.322.183-.418.477-.336.424.112.871.104 1.29-.024.492-.132.82.045 1.163.365a8.126 8.126 0 0 0 3.209 1.849c.828.239 1.243-.11 1.08-.954-.142-.738-.262-1.482-.443-2.212a1 1 0 0 1 .334-1.093 17.656 17.656 0 0 0 2.758-3.34c.821-1.272 1.265-2.642.954-4.171-.083-.418.063-.506.451-.506 4.18.012 8.363 0 12.544.012 1.708 0 3.242.477 4.435 1.782 1.29 1.42 1.484 3.102 1.336 4.94-.095 1.176-.522 1.791-1.732 2.147-1.489.434-2.878 1.21-4.309 1.837-.17.1-.363.157-.56.165z"-->
<!--                  fill="#06F"></path>-->
<!--              <path-->
<!--                  d="M14.94 15.307c-.871-.3-1.477-.87-2.088-1.431-.318-.291-.685-.477-1.129-.392-1.88.404-3.219-.587-4.4-1.806-1.479-1.53-2.2-3.426-1.892-5.538.33-2.25 2.699-4.328 4.99-4.56 1.838-.206 3.7.034 5.425.702 2.83 1.107 3.775 3.844 2.207 6.442a15.454 15.454 0 0 1-3.102 3.656.992.992 0 0 0-.367 1.143c.153.56.231 1.147.356 1.784z"-->
<!--                  fill="#FEFEFE"></path>-->
<!--              <path-->
<!--                  d="M35.01 38.244a128.668 128.668 0 0 0-.763-7.824 60.35 60.35 0 0 0-.527-3.464.584.584 0 0 1 .324-.716c.842-.52 1.67-1.062 2.51-1.59.146-.09.296-.295.463-.197.167.098.088.36.064.544-.226 1.652-.455 3.299-.687 4.939-.362 2.507-.73 5.014-1.105 7.523a1.38 1.38 0 0 1-.279.785z"-->
<!--                  fill="#06F"></path>-->
<!--              <path d="M37.792 17.19c-.238-.239-.353-.392-.303-.6 0-.03.13-.073.139-.061a.98.98 0 0 1 .164.66z"-->
<!--                    fill="#B7B7B6"></path>-->
<!--              <path-->
<!--                  d="M20.92 27.309c.025.954-.488 1.479-1.43 1.5-.943.022-1.633-.615-1.64-1.56-.007-.945.697-1.53 1.804-1.546.9-.012 1.231.42 1.267 1.606z"-->
<!--                  fill="#121212"></path>-->
<!--              <path-->
<!--                  d="M11.938 5.575c.172-.137.35-.265.537-.382a.804.804 0 0 1 1.178.294c.378.652.654 1.358.816 2.094.1.38-.176.432-.43.492-.252.06-.522.112-.6-.265-.094-.444-.172-.895-.308-1.329-.079-.255-.131-.656-.563-.518-.396.124-.477.416-.31.802.183.44.312.897.491 1.336.217.535-.2.623-.518.728-.317.105-.749.339-.93-.239a33.209 33.209 0 0 1-.897-3.567c-.098-.477.26-.553.584-.651.325-.098.575-.045.673.348.072.289.074.6.277.857zM9.266 9.09l.954-.356c.191-.067.356-.048.442.165a.32.32 0 0 1-.047.376.322.322 0 0 1-.11.077 9.983 9.983 0 0 1-2.172.775c-.446.093-.675-.238-.525-.715.22-.697.477-1.38.733-2.09-.332-.077-.616.095-.912.166-.186.046-.358.074-.453-.143a.354.354 0 0 1 .179-.5c.67-.302 1.4-.445 2.133-.42.415.018.551.338.422.737-.196.591-.398 1.188-.644 1.927zm6.461-1.544c-.289.043-.458-.096-.55-.39-.15-.477-.238-.954-.355-1.43-.152-.597.208-.74.626-.862.46-.136.57.212.684.537.115.324.253.715.377 1.059.25.704-.002 1.064-.782 1.086z"-->
<!--                  fill="#444"></path>-->
<!--              <path-->
<!--                  d="M15.037 3.055a.77.77 0 0 1 .75.77.728.728 0 0 1-.779.745.716.716 0 0 1-.741-.751c.028-.485.324-.707.77-.764z"-->
<!--                  fill="#4A4B4A"></path>-->
<!--            </svg>-->
<!--          </div>-->
<!--          <div class="Question-mainColumnLoginContent">-->
<!--            <div class="Question-mainColumnLoginTitle">登录后你可以</div>-->
<!--            <div class="Question-mainColumnLoginDes">-->
<!--              <span class="Question-mainColumnLoginDesIcon">-->
<!--                <svg fill="none"-->
<!--                     height="14"-->
<!--                     viewBox="0 0 14 14"-->
<!--                     width="14">-->
<!--                  <mask-->
<!--                      id="id-628033106-a" height="14" maskUnits="userSpaceOnUse" width="14" x="0" y="0">-->
<!--                    <path-->
<!--                        clip-rule="evenodd"-->
<!--                        d="M.001.014h13.985V14H.001V.014z"-->
<!--                        fill="#fff"-->
<!--                        fill-rule="evenodd">-->
<!--                    </path>-->
<!--                  </mask>-->
<!--                  <g mask="url(#id-628033106-a)">-->
<!--                    <path clip-rule="evenodd"-->
<!--                          d="M2.543 8.278a.636.636 0 0 1 0 1.272h-.636A1.907 1.907 0 0 1 0 7.643V1.92C0 .868.854.014 1.907.014H7.63c1.053 0 1.907.854 1.907 1.907v.636a.636.636 0 0 1-1.271 0V1.92a.636.636 0 0 0-.636-.636H1.907a.636.636 0 0 0-.636.636v5.722c0 .35.285.635.636.635h.636zm3.814-3.814h5.722c1.053 0 1.907.854 1.907 1.907v5.722A1.907 1.907 0 0 1 12.08 14H6.357a1.907 1.907 0 0 1-1.907-1.907V6.37c0-1.053.854-1.907 1.907-1.907zm0 1.271a.636.636 0 0 0-.635.636v5.722c0 .35.284.636.635.636h5.722a.636.636 0 0 0 .636-.636V6.37a.636.636 0 0 0-.636-.636H6.357z"-->
<!--                          fill="#121212"-->
<!--                          fill-rule="evenodd">-->

<!--                    </path>-->
<!--                  </g>-->
<!--                </svg>不限量看优质回答</span>-->
<!--              <span-->
<!--                  class="Question-mainColumnLoginDesIcon"><svg fill="none" height="14" viewBox="0 0 15 14" width="15"><path-->
<!--                  clip-rule="evenodd"-->
<!--                  d="M3.55 14c-.106 0-.159 0-.265-.053a.583.583 0 0 1-.318-.53v-2.225H.954A.95.95 0 0 1 0 10.238V.965A.95.95 0 0 1 .954.01h12.982a.95.95 0 0 1 .954.954v9.273a.95.95 0 0 1-.954.954H7.418l-3.497 2.702c-.106.053-.212.106-.37.106zm-2.49-3.921h2.437c.318 0 .53.212.53.53v1.854l2.914-2.225c.106-.053.212-.106.318-.106h6.518V1.124H1.06v8.955z"-->
<!--                  fill="#121212"-->
<!--                  fill-rule="evenodd">-->
<!--              </path>-->
<!--                <path clip-rule="evenodd"-->
<!--                      d="M3.709 4.515h7.948v-1.06H3.71v1.06zm0 3.18h4.239v-1.06H3.709v1.06z"-->
<!--                      fill="#121212"-->
<!--                      fill-rule="evenodd">-->
<!--                </path>-->
<!--              </svg>私信答主深度交流</span>-->
<!--              <span-->
<!--                  class="Question-mainColumnLoginDesIcon">-->
<!--              <svg fill="none" height="16" viewBox="0 0 16 16" width="16">-->
<!--                <mask-->
<!--                    id="id-95574191-a" height="16" maskUnits="userSpaceOnUse" width="16" x="0" y="0"><path-->
<!--                    clip-rule="evenodd"-->
<!--                    d="M.001.016h15.983V16H.001V.016z"-->
<!--                    fill="#fff"-->
<!--                    fill-rule="evenodd">-->
<!--              </path>-->
<!--              </mask>-->
<!--                <g mask="url(#id-95574191-a)">-->
<!--              <path clip-rule="evenodd"-->
<!--                    d="M7.992.016C3.585.016 0 3.6 0 8.008a7.96 7.96 0 0 0 1.344 4.435.521.521 0 0 0 .867-.58 6.915 6.915 0 0 1-1.169-3.855 6.958 6.958 0 0 1 6.95-6.95 6.958 6.958 0 0 1 6.95 6.95 6.958 6.958 0 0 1-6.95 6.95 6.917 6.917 0 0 1-3.865-1.175.522.522 0 0 0-.58.866A7.956 7.956 0 0 0 7.992 16c4.407 0 7.992-3.585 7.992-7.992S12.4.016 7.992.016zM5.046 8.368c-.221 0-.332-.096-.332-.29V7.29c0-.216.111-.323.332-.323h2.167a4.28 4.28 0 0 1-.394 1.401H5.046zm3.14-1.401h2.746a.47.47 0 0 1 .28.071c.058.041.086.125.086.252v.845c0 .155-.12.233-.366.233H7.873a8.4 8.4 0 0 0 .314-1.401zm-2.964 3.316c-.386.266-.945.508-1.677.727v.822c.301-.032.542-.069.722-.11a4.708 4.708 0 0 0 1.63-.774c.558-.409 1.07-.976 1.54-1.701h.712v1.615c0 .33.098.572.294.727.178.143.404.214.68.214h3.206V10.9H9.426c-.126 0-.218-.023-.275-.07-.054-.045-.079-.142-.076-.29l.005-1.293h2.166a.98.98 0 0 0 .703-.261c.155-.149.233-.376.233-.68V7.03c0-.311-.085-.545-.256-.704-.105-.098-.268-.172-.49-.223l.252-.58c.073-.168.11-.308.11-.422a.823.823 0 0 0-.276-.608c-.187-.187-.444-.28-.77-.28h-5.14l.137-.47h-.893c-.161.449-.327.778-.498.987-.206.257-.447.412-.723.466v.907a2.96 2.96 0 0 0 .908-.404 3 3 0 0 0 .622-.608h5.221c.188 0 .304.013.352.038.073.038.109.092.109.162s-.03.175-.095.318l-.21.46H5.09c-.478 0-.805.083-.983.248-.187.177-.28.43-.28.76V8.26c0 .491.202.804.607.94.096.032.288.048.576.048h1.287c-.37.46-.728.805-1.074 1.036z"-->
<!--                    fill="#121212"-->
<!--                    fill-rule="evenodd"></path></g></svg>精彩内容一键收藏-->
<!--              </span>-->
<!--            </div>-->
<!--          </div>-->
<!--          <div class="Question-mainColumnLoginRightButton">-->
<!--            <div>-->
<!--              <button class="Button Question-mainColumnLoginButton FEfUrdfMIKpQDJDqkjte" type="button">登录</button>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
        <!--内容-->
          <div style="padding-left: 33px;padding-right: 33px;line-height: 24px;background: white;padding-top: 22px;">
            <div >
              <div v-for="(item,i) in topstorylist.content" :key="item.type" >
                <template v-if="item.type === 'text'">
                  <p>{{ item.value }}</p>
                </template>
                <br/>
              </div>
            </div>

          </div>

        <div class="Card ViewAll" data-za-detail-view-path-module="MessageItem"
             data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;item_num&quot;:295}}}"><a
            class="QuestionMainAction ViewAll-QuestionMainAction" data-za-detail-view-element_name="ViewAll"
            href="/question/429151322">查看全部 295 个回答</a></div>
      </div>
    </div>
    <!--右侧栏-->
    <div class="Question-sideColumn Question-sideColumn--sticky css-1qyytj7"
         data-za-detail-view-path-module="RightSideBar"
         data-za-extra-module="{&quot;card&quot;:{&quot;content&quot;:{&quot;member_hash_id&quot;:&quot;1e740b94b3f99f82d64e6cf52011efca&quot;}}}">
      <a aria-keyshortcuts="Shift+S" aria-label="边栏锚点" class="css-h9cq7d"></a>
      <div></div>
      <div style="position: relative; top: -0.00000286102px;">
        <div aria-label="关于作者" class="Card AnswerAuthor" role="complementary">
          <div class="Card-header AnswerAuthor-title">
            <div class="Card-headerText">关于作者</div>
          </div>
          <div class="Card-section">
            <div class="AnswerAuthor-user">
              <div class="AnswerAuthor-user-avatar"><span class="UserLink"><a
                  class="UserLink-link" data-za-detail-view-element_name="User"
                  href="//www.zhihu.com/people/moonlight-18-87-50"
                  target="_blank"><img alt="Moonlight"
                                       class="Avatar UserLink-avatar css-cy0ax3"
                                       src="https://pica.zhimg.com/v2-d982868455d25e2f0b968c4bf0725f37_l.jpg?source=32738c0c"
                                       srcset="https://pica.zhimg.com/v2-d982868455d25e2f0b968c4bf0725f37_xl.jpg?source=32738c0c 2x"></a></span>
              </div>
              <div class="AnswerAuthor-user-content">
                <div class="AnswerAuthor-user-name"><span class="UserLink"><a
                    class="UserLink-link" data-za-detail-view-element_name="User"
                    href="//www.zhihu.com/people/moonlight-18-87-50"
                    target="_blank">Moonlight</a></span></div>
                <div class="AnswerAuthor-user-headline">
                  <div class="ztext">平平淡淡，简简单单。</div>
                </div>
              </div>
            </div>
          </div>
          <div class="Card-section"></div>
          <div class="Card-section">
            <div class="AnswerAuthor-counts">
              <div class="NumberBoard"><a
                  class="Button NumberBoard-item FEfUrdfMIKpQDJDqkjte Button--plain fEPKGkUK5jyc4fUuT0QP"
                  data-za-detail-view-element_name="Answer"
                  href="/people/moonlight-18-87-50/answers"
                  type="button">
                <div class="NumberBoard-itemInner">
                  <div class="NumberBoard-itemName">回答</div>
                  <strong class="NumberBoard-itemValue" title="31">31</strong></div>
              </a><a class="Button NumberBoard-item FEfUrdfMIKpQDJDqkjte Button--plain fEPKGkUK5jyc4fUuT0QP"
                     data-za-detail-view-element_name="Post"
                     href="/people/moonlight-18-87-50/posts"
                     type="button">
                <div class="NumberBoard-itemInner">
                  <div class="NumberBoard-itemName">文章</div>
                  <strong class="NumberBoard-itemValue" title="6">6</strong></div>
              </a><a class="Button NumberBoard-item FEfUrdfMIKpQDJDqkjte Button--plain fEPKGkUK5jyc4fUuT0QP"
                     data-za-detail-view-element_name="Follower"
                     href="/people/moonlight-18-87-50/followers"
                     type="button">
                <div class="NumberBoard-itemInner">
                  <div class="NumberBoard-itemName">关注者</div>
                  <strong class="NumberBoard-itemValue" title="1606">1,606</strong></div>
              </a></div>
            </div>
            <div class="MemberButtonGroup AnswerAuthor-buttons">
              <button
                  class="Button FollowButton FEfUrdfMIKpQDJDqkjte Button--primary Button--blue epMJl0lFQuYbC7jrwr_o JmYzaky7MEPMFcJDLNMG"
                  type="button">
                <span style="display: inline-flex; align-items: center;">
                  ​<svg class="Zi Zi--Plus FollowButton-icon"
                        fill="currentColor"
                        height="1.2em"
                        viewBox="0 0 24 24"
                        width="1.2em"><path
                    clip-rule="evenodd"
                    d="M13.25 3.25a1.25 1.25 0 1 0-2.5 0v7.5h-7.5a1.25 1.25 0 1 0 0 2.5h7.5v7.5a1.25 1.25 0 1 0 2.5 0v-7.5h7.5a1.25 1.25 0 0 0 0-2.5h-7.5v-7.5Z"
                    fill-rule="evenodd"></path></svg>
                </span>关注她
              </button>
              <button
                  class="Button FEfUrdfMIKpQDJDqkjte Button--grey Button--withIcon Button--withLabel ZdfrHW7Ef5ZjwFiiBJuS B46v1Ak6Gj5sL2JTS4PY RuuQ6TOh2cRzJr6WlyQp"
                  type="button">
                <span style="display: inline-flex; align-items: center;">
                  ​
                  <svg class="Zi Zi--Comments Button-zi t2ntD6J1DemdOdvh5FB4"
                       fill="currentColor"
                       height="1.2em"
                       viewBox="0 0 24 24"
                       width="1.2em"><path
                      clip-rule="evenodd"
                      d="M2 11c0 1.79.553 3.45 1.498 4.82L2.6 18.667a.6.6 0 0 0 .751.753l3.07-.96A8.5 8.5 0 1 0 2 11Zm11.46 9.414c-.457.16-.506.794-.034.904A6.96 6.96 0 0 0 15 21.5c1.148 0 2.422-.31 3.444-.912.357-.217.658-.378 1.043-.252l1.414.42c.357.112.679-.168.574-.546l-.47-1.57a.736.736 0 0 1 .05-.632c.602-1.108.945-2.32.945-3.498 0-1.07-.248-2.11-.7-3.046-.21-.435-.815-.25-.872.23-.47 3.954-3.211 7.394-6.968 8.72Z"
                      fill-rule="evenodd"></path></svg>
                </span>发私信
              </button>
            </div>
          </div>
        </div>

      </div>
    </div>

  </div>

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




