package com.one.place.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.place.entity.User;
import com.one.place.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends ServiceImpl<UserMapper,User> {

}
