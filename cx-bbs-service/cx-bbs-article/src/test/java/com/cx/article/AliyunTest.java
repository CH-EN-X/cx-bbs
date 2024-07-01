package com.cx.article;

import com.cx.article.ArticleApplication;
import com.cx.common.aliyun.GreenImageScan;
import com.cx.common.aliyun.GreenTextScan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest(classes = ArticleApplication.class)
@RunWith(SpringRunner.class)
public class AliyunTest {

    @Autowired
    private GreenTextScan greenTextScan;

    @Autowired
    private GreenImageScan greenImageScan;

    /**
     * 测试文本内容审核
     */
    @Test
    public void testScanText() throws Exception {
        Map map = greenTextScan.greeTextScan("123");
//        greenTextScan.greeTextScan("我是一个好人");
        if (map.get("labels") == null) {
            System.out.println("测试通过》。。。。。");
        }
        System.out.println("map:"+map + ", reason:" + map.get("reason") + ", labels:" + map.get("labels"));
    }
}
