package com.online.edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.online.edu.entity.EduUser;
import com.online.edu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: online-edu-system
 * @description: 登录控制层
 * @created: 2021/03/22 19:36
 */
@RestController
public class LoginController {
    @Autowired
    private EduUserService eduUserService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/admin")
    public R adminLogin(String username, String password) {
        EduUser one = eduUserService.getOne(new LambdaQueryWrapper<EduUser>().eq(EduUser::getUsername, username));
        if (ObjectUtils.isEmpty(one) || !one.getPassword().equals(password)) {
            return R.failed("用户名或密码错误");
        }
        if (one.getRoleId() != 1) {
            return R.failed("权限不足");
        }
        one.setPassword("");
        return R.ok(one);
    }

    /**
     * 学生登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public R login(String username, String password) {
        EduUser one = eduUserService.getOne(new LambdaQueryWrapper<EduUser>().eq(EduUser::getUsername, username));
        if (ObjectUtils.isEmpty(one) || !one.getPassword().equals(password)) {
            return R.failed("用户名或密码错误");
        }
        one.setPassword("");
        return R.ok(one);
    }
}
