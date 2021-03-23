package com.online.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduBanner;
import com.online.edu.service.EduBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@RestController
@RequestMapping("/banner")
public class EduBannerController {
    @Autowired
    private EduBannerService eduBannerService;

    /**
     * 后台轮播图记录列表
     * @param page
     * @param banner
     * @return
     */
    @GetMapping("/list")
    public R list(Page<EduBanner> page, EduBanner banner){
        Page<EduBanner> pages = eduBannerService.listPage(page, banner);
        return R.ok(pages);
    }

    /**
     * 首页轮播图展示
     * @return
     */
    @GetMapping("/display")
    public R display(){
        List<EduBanner> list = eduBannerService.list(new LambdaQueryWrapper<EduBanner>().eq(EduBanner::getIsEnable,1).orderByDesc(EduBanner::getBannerOrder));
        return R.ok(list);
    }

    /**
     * 添加banner
     * @param tbBanner
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody EduBanner tbBanner){
        tbBanner.setCreateTime(LocalDateTime.now());
        tbBanner.setUpdateTime(LocalDateTime.now());
        boolean save = eduBannerService.save(tbBanner);
        return R.ok(save);
    }

    /**
     * 根据id修改banner
     * @param tbBanner
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody EduBanner tbBanner){
        tbBanner.setUpdateTime(LocalDateTime.now());
        boolean result = eduBannerService.updateById(tbBanner);
        return R.ok(result);
    }

    /**
     * 根据id删除banner
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
    public R delete(String ids){
        boolean result = eduBannerService.removeByIds(Arrays.asList(ids.split(",")));
        return R.ok(result);
    }

}

