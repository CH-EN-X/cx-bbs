package com.cx.article.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.QuestionsMapper;
import com.cx.article.service.QuestionsService;
import com.cx.model.article.dtos.QuestionDto;
import com.cx.model.article.pojos.Question;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.utils.common.ConvertUtil;
import org.springframework.stereotype.Service;
import sun.tools.asm.Cover;

import javax.annotation.Resource;

/**
 * <p>
 * 提问表，发布的提问 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class QuestionsServiceImpl extends ServiceImpl<QuestionsMapper, Question> implements QuestionsService {

    @Resource
    QuestionsMapper questionsMapper;

    @Override
    public ResponseResult add(QuestionDto questionDto) {
        if (questionDto.getTitle() == null || questionDto.getTitle().equals("")) {
            return ResponseResult.errorResult(400,"请输入你的问题");
        }
        Question question = ConvertUtil.entityToVo(questionDto,Question.class);
        questionsMapper.insert(question);
        return ResponseResult.okResult(200,"发布成功");
    }

    @Override
    public ResponseResult waiting() {
        return ResponseResult.okResult(questionsMapper.waiting());
    }
}
