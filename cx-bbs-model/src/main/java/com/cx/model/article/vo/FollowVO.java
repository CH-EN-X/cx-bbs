package com.cx.model.article.vo;

import com.cx.model.article.pojos.Question;
import com.cx.model.article.vo.ArticleVO;
import com.cx.model.article.vo.QuestionVO;
import com.cx.model.user.vo.UserVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowVO {

    private UserVO user;

    //回答了的问题集
    private List<RecommendVO> questions;
}
