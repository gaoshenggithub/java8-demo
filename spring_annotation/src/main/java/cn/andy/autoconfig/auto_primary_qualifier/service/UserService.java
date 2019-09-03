package cn.andy.autoconfig.auto_primary_qualifier.service;

import cn.andy.autoconfig.auto_primary_qualifier.mapper.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Qualifier("userMapper2")
    @Autowired
    private UserMapper userMapper;

}
