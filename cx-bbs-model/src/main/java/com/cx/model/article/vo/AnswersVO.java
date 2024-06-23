package com.cx.model.article.vo;

import com.cx.model.user.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswersVO {
    //问题
    private QuestionVO question;

    //作者
    private UserVO author;

    //回答的集合
    private List<ArticleVO> articles;

    //评论集合
    private List<CommentVO> comments;


//    private favour;//like
//    private disfavou;//丢弃，当摆设
//    private favours;//count()
//    private like;//不要了，改成favour(因为喜欢点了好像没太大用，都没喜欢集)
//    private comments;//需要个评论实体


//问题id
//    private Long id;
//    //问题内容
//    private String content;
//    //当前longinUser是否关注
//    private boolean follow;
    /*
  {
  content: '<p>是有这种情况啊，不然为什么抖音那些博主干一年就买房了，或者不声不响就提车了？再不济也能不上班靠着发视频养活自己。</p><p>注意，我说的是博主！！<strong>由于普通人和博主之间有信息差，用着一个app相当于在两个世界</strong>，他们发视频就能赚钱，你发视频可能有点赞，有播放，但就是不能赚钱。</p><p>由于工作原因，<strong>我接触博主挺多，分享几个抖音发就能赚钱的视频形式</strong>，你肯定刷到过，很常见的视频：</p><p>1.风景文案视频</p><p><img src="https://picx.zhimg.com/50/v2-7490283665ab02ecb0a204ffca29780e_720w.jpg?source=2c26e567" alt="" data-href="" style=""/></p><p><img src="https://picx.zhimg.com/80/v2-7490283665ab02ecb0a204ffca29780e_720w.webp?source=2c26e567" alt="" data-href="" style=""/></p><p>一段风景视频+音乐+文案</p><p>博主没开橱窗，没直播，视频中就是风景，没有商品广告</p><p>要不是我看到<strong>评论区的置顶</strong>，还以为他天天是在为爱发电呢</p>',
  author: {
    name: '喵先生',
    img: '/src/assets/image/1.png',
    follow: false,
  },
  private follow: false,
  private id: 1,
  private favour:false,
  private disfavour:false,
  private favours: 88,
  private like: false,
  private comments: 20,
  },
     */

}
