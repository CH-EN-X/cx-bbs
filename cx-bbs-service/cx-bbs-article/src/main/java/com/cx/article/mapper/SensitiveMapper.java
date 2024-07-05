package com.cx.article.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.model.article.pojos.Sensitive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 敏感词信息表 Mapper 接口
 * </p>
 *
 * @author cx
 * @since 2024-07-05
 */
@Mapper
public interface SensitiveMapper extends BaseMapper<Sensitive> {

    List<Sensitive> selectSensitives();

}
