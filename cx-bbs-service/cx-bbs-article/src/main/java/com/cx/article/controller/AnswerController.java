package com.cx.article.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cx.article.service.ArticleContentService;
import com.cx.article.service.ArticleService;
import com.cx.article.service.CommentService;
import com.cx.article.service.QuestionsService;
import com.cx.feign.client.UserClient;
import com.cx.model.article.dtos.AnswerDto;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.pojos.ArticleContent;
import com.cx.model.article.pojos.Comment;
import com.cx.model.article.pojos.Question;
import com.cx.model.article.vo.AnswersVO;
import com.cx.model.article.vo.ArticleVO;
import com.cx.model.article.vo.CommentVO;
import com.cx.model.article.vo.QuestionVO;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.vo.UserVO;
import com.cx.user.service.IUserService;
import com.cx.utils.common.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private QuestionsService questionService;

    @Resource
    private IUserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleContentService contentService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserClient userClient;

    @RequestMapping("/details/{id}")
    public ResponseResult<AnswersVO> details(@PathVariable("id") String id){
        //将问题数据封装vo (先通过关联的id查询)
        Question question = questionService.getById(id);
        //使用封装的数据类型转换器 将Entity转为VO
        QuestionVO questionVO = ConvertUtil.entityToVo(question, QuestionVO.class);

        //避免空指针
        UserVO userVO = new UserVO();
        if (question.getAuthorId()!=null){
            //将用户数据封装vo (先通过关联的id查询)
            userVO = userClient.getUser(question.getAuthorId()).getData();//userService.getById( question.getAuthorId() );
        }


        //将回答数据封装vo (先通过关联的id查询)
        List<Article> articles = articleService.list(new LambdaQueryWrapper<Article>().eq(Article::getQuestionId, question.getId()));
        List<ArticleVO> articleVOList =new ArrayList<ArticleVO>();
        if (articles.size() != 0){
            //将 List<Entity> 转换为List<Vo>
            articleVOList = ConvertUtil.entityToVoList(articles, ArticleVO.class);
            for (ArticleVO vo : articleVOList){
                UserVO u = userClient.getUser(vo.getAuthorId()).getData();
                ArticleContent content = contentService.getOne(new LambdaQueryWrapper<ArticleContent>().eq(ArticleContent::getArticleId, vo.getId()));
                List<Comment> comments = commentService.list(new LambdaQueryWrapper<Comment>().eq(Comment::getArticleId, vo.getId()));
                List<CommentVO> articleComments = ConvertUtil.entityToVoList(comments, CommentVO.class);
                vo.setAuthor(u);
                vo.setContent(content.getContent());
                vo.setComments(articleComments);
            }
        }

        //将评论数据封装vo (先通过关联的id查询)
        List<Comment> comments = commentService.list(new LambdaQueryWrapper<Comment>().eq(Comment::getArticleId, question.getId()));

        List<CommentVO> commentVOList = ConvertUtil.entityToVoList(comments, CommentVO.class);

        //封装VO返回给前端
        AnswersVO answers =AnswersVO.builder()
                .question(questionVO)
                .author(userVO)
                .articles(articleVOList)
                .comments(commentVOList)
                .build();
        return ResponseResult.okResult(answers);
    }

    @RequestMapping("/publish")
    public ResponseResult publish(@RequestBody AnswerDto dto){
        return articleService.publish(dto);
    }

}
