package com.cx.article.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.ArticleContentMapper;
import com.cx.article.mapper.ArticleMapper;
import com.cx.article.mapper.QuestionMapper;
import com.cx.article.service.ArticleService;
import com.cx.common.constants.ArticleConstants;
import com.cx.model.article.dtos.ArticleDto;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.dtos.ArticleHomeDto;
import com.cx.model.article.pojos.Question;
import com.cx.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    // 单页最大的数字
    private final static short MAX_PAGE_SIZE = 50;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleContentMapper articleContentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 根据参数加载文章列表
     *
     * @param loadtype 1为加载  2为加载
     * @param dto
     * @return
     */
    @Override
    public ResponseResult load(Short loadtype, ArticleHomeDto dto) {
        //1.校验参数
        //类型参数检验
        if(!loadtype.equals(ArticleConstants.LOADTYPE_LOAD_MORE)&&!loadtype.equals(ArticleConstants.LOADTYPE_LOAD_NEW)){
            loadtype = ArticleConstants.LOADTYPE_LOAD_MORE;
        }
        //文章频道校验
        if(StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstants.DEFAULT_TAG);
        }
        //时间校验
        if(dto.getMaxBehotTime() == null) dto.setMaxBehotTime(new Date());
        if(dto.getMinBehotTime() == null) dto.setMinBehotTime(new Date());
        //2.查询数据
        List<ArticleDto> articles = articleMapper.loadArticleList(dto, loadtype);
        //3.结果封装
        ResponseResult responseResult = ResponseResult.okResult(articles);
        return responseResult;
    }

//    @Override
//    public ResponseResult loadContent(Integer id) {
//        //查询到提问
//        Questions questions = questionMapper.selectById(id);
//        //查询该问题下的所有回答 , 条件构造器QueryWrapper构建条件查询
//        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("question_id", questionId); // 添加查询条件：question_id = questionId
//        List<Article> articleList = articleMapper.selectList(queryWrapper);
//        //内容
//
//        ArticleContent articleContent = articleContentMapper.selectById(id);
//        return null;
//    }

}
