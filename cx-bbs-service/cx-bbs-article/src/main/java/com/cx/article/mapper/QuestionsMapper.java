package com.cx.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.model.article.pojos.Question;
import com.cx.model.article.vo.QuestionVO;

import java.util.List;

/**
 * <p>
 * 提问表，发布的提问 Mapper 接口
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
public interface QuestionsMapper extends BaseMapper<Question> {

    List<QuestionVO> waiting();

}
