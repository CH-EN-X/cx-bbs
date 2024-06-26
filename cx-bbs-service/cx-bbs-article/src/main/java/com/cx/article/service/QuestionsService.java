package com.cx.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.model.article.dtos.AnswerDto;
import com.cx.model.article.dtos.QuestionDto;
import com.cx.model.article.pojos.Question;
import com.cx.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 提问表，发布的提问 服务类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
public interface QuestionsService extends IService<Question> {

    ResponseResult add(QuestionDto questionDto);

    ResponseResult waiting();

    ResponseResult write(AnswerDto dto);
}
