package com.online.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduUser;
import com.online.edu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@RestController
@RequestMapping("/user")
public class EduUserController {
    @Autowired
    private EduUserService eduUserService;

    /**
     * 用户列表
     * @param page
     * @param eduUser
     * @return
     */
    @GetMapping("/list")
    public R list(Page<EduUser> page){
        Page<EduUser> page1 = eduUserService.page(page);
        return R.ok(page1);
    }

    /**
     * 添加用户
     * @param eduUser
     * @return
     */
    @PostMapping("/add")
    public R insert(@RequestBody EduUser eduUser){
        if (StringUtils.checkValNull(eduUser.getPassword())){
            eduUser.setPassword("123456");
        }
        eduUser.setCreateTime(LocalDateTime.now());
        boolean save = eduUserService.save(eduUser);
        return R.ok(save);
    }

    /**
     * 更新用户
     * @param eduUser
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody EduUser eduUser){
        boolean b = eduUserService.updateById(eduUser);
        return R.ok(b);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R delete(Integer id){
        boolean b = eduUserService.removeById(id);
        return R.ok(b);
    }
}

