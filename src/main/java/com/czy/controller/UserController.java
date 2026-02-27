package com.czy.controller;

import com.czy.entity.User;
import com.czy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userMapper.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userMapper.findById(id);
    }

    @PostMapping
    public String create(@RequestBody User user) {
        int rows = userMapper.insert(user);
        return rows > 0 ? "新增成功，ID: " + user.getId() : "新增失败";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        int rows = userMapper.update(user);
        return rows > 0 ? "更新成功" : "更新失败";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        int rows = userMapper.deleteById(id);
        return rows > 0 ? "删除成功" : "删除失败";
    }
}