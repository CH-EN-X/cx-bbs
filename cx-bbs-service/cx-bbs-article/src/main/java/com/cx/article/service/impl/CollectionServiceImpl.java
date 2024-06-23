package com.cx.article.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.CollectionMapper;
import com.cx.article.service.CollectionService;
import com.cx.model.article.pojos.Collection;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收藏信息表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {

}
