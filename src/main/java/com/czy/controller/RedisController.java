package com.czy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // set 值（字符串）
    @PostMapping("/set")
    public String setKey(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value, 60, TimeUnit.SECONDS); // 过期时间60秒
        return "设置成功: " + key + " = " + value;
    }

    // get 值
    @GetMapping("/get")
    public Object getKey(@RequestParam String key) {
        if (!redisTemplate.hasKey(key)) {
            return "key不存在";
        }
        return redisTemplate.opsForValue().get(key);
    }

    // delete
    @DeleteMapping("/delete")
    public String deleteKey(@RequestParam String key) {
        Boolean deleted = redisTemplate.delete(key);
        return deleted ? "删除成功: " + key : "删除失败或key不存在";
    }
}