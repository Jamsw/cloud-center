package com.sparticles.gateway.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sparticles.common.model.Topic;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper extends BaseMapper<Topic> {

    Topic selectByTitle(@Param("title") String title);

}
