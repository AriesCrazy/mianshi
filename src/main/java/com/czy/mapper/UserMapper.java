package com.czy.mapper;

import com.czy.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user")
    List<User> findAll();

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User findById(Long id);

    @Insert("INSERT INTO t_user (name, age) VALUES (#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Update("UPDATE t_user SET name = #{name}, age = #{age} WHERE id = #{id}")
    int update(User user);

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    int deleteById(Long id);
}