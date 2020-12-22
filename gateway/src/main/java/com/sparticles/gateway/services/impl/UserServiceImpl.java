package com.sparticles.gateway.services.impl;

import com.sparticles.common.model.Topic;
import com.sparticles.common.model.User;
import com.sparticles.gateway.dao.TopicMapper;
import com.sparticles.gateway.dao.UserMapper;
import com.sparticles.gateway.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public int insert() {
        Topic t = topicMapper.selectByTitle("title1");
        return 1;
    }
}
