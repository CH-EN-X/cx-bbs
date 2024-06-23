package com.cx.article.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.QuestionsMapper;
import com.cx.article.service.QuestionsService;
import com.cx.model.article.pojos.Question;
import org.springframework.stereotype.Service;

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

}
