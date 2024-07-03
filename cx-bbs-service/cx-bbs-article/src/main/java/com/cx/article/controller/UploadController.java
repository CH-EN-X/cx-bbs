package com.cx.article.controller;


import com.cx.common.qiniu.util.QiniuOssUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UploadController {

    @Resource
    private QiniuOssUtil imageUtils;

    @PostMapping("/image/upload")
    public  Map<String, List<String>> uploadImage(@RequestParam(value = "file",required = false) MultipartFile[] multipartFile){
//        if(ObjectUtils.isEmpty(multipartFile)){
//            return null;
//        }
        Map<String, List<String>> uploadImagesUrl = imageUtils.uploadImages(multipartFile);
        return uploadImagesUrl;
    }

}
