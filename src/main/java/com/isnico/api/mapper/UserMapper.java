package com.isnico.api.mapper;

import com.isnico.api.model.po.User;
import org.apache.ibatis.annotations.Param;
import org.nico.ourbatis.mapper.SimpleMapper;

public interface UserMapper extends SimpleMapper<User, String> {

    User findUserLock(@Param("id") Long id);

}
