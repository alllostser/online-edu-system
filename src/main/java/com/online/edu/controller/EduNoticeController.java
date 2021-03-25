package com.online.edu.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduNotice;
import com.online.edu.service.EduNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-24
 */
@RestController
@RequestMapping("/edu-notice")
public class EduNoticeController {
    @Autowired
    private EduNoticeService eduNoticeService;

    /**
     * 公告列表
     * @param page
     * @return
     */
    @GetMapping("/list")
    public R list(Page<EduNotice> page){
        Page<EduNotice> pages = eduNoticeService.page(page);
        return R.ok(pages);
    }

    /**
     * 添加公告
     * @param eduNotice
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody EduNotice eduNotice){
        eduNotice.setCreateTime(LocalDateTime.now());
        boolean save = eduNoticeService.save(eduNotice);
        return R.ok(save);
    }

    /**
     * 修改公告
     * @param eduNotice
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody EduNotice eduNotice){
        Integer id = eduNotice.getId();
        EduNotice byId = eduNoticeService.getById(id);
        eduNotice.setCreateTime(byId.getCreateTime());
        boolean b = eduNoticeService.updateById(eduNotice);
        return R.ok(b);
    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R detele(Integer id){
        boolean b = eduNoticeService.removeById(id);
        return R.ok(b);
    }

}

