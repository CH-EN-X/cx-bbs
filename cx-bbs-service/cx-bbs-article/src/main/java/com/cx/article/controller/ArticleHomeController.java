package com.cx.article.controller;

import com.cx.article.service.ArticleService;
import com.cx.common.constants.ArticleConstants;
import com.cx.model.article.dtos.ArticleHomeDto;
import com.cx.model.article.dtos.RecommendDto;
import com.cx.model.article.vo.RecommendVO;
import com.cx.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/article")
public class ArticleHomeController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto dto) {
        return articleService.load2(dto, ArticleConstants.LOADTYPE_LOAD_MORE,true);
    }

    @PostMapping("/interest/{id}")
    public ResponseResult<RecommendVO> interest(@PathVariable("id") Integer id){
        return articleService.interest(id);
    }


    @PostMapping("/loadmore")
    public ResponseResult loadMore(@RequestBody ArticleHomeDto dto) {
        return articleService.load(ArticleConstants.LOADTYPE_LOAD_MORE,dto);
    }

    @PostMapping("/loadnew")
    public ResponseResult loadNew(@RequestBody ArticleHomeDto dto) {
        return articleService.load(ArticleConstants.LOADTYPE_LOAD_NEW,dto);
    }

    @PostMapping("/recommend")
    public ResponseResult<RecommendVO> recommendList(@RequestBody RecommendDto dto){
        return articleService.recommendList(dto);
    }



//    @PostMapping("/content")
//    public ResponseResult loadContent(@PathParam("id") Integer id) {
//        return articleService.loadContent(id);
//    }

//    @PostMapping("/load")
//    public ResponseResult load(@RequestBody ArticleHomeDto dto) {
//        return null;
//    }
//
//    @PostMapping("/loadfollow")
//    public ResponseResult loadMore(@RequestBody ArticleHomeDto dto) {
//        return null;
//    }
//
//    @PostMapping("/loadghot")
//    public ResponseResult loadNew(@RequestBody ArticleHomeDto dto) {
//        return null;
//    }


}