package com.cx.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.model.article.pojos.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper  extends BaseMapper<Question> {
}
