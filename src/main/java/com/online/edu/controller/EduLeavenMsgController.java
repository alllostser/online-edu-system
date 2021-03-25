package com.online.edu.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduLeavenMsg;
import com.online.edu.service.EduLeavenMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  留言前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-24
 */
@RestController
@RequestMapping("/edu-leaven-msg")
public class EduLeavenMsgController {
    @Autowired
    private EduLeavenMsgService eduLeavenMsgService;

    /**
     * 留言
     * @param eduLeavenMsg
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody EduLeavenMsg eduLeavenMsg){
        boolean save = eduLeavenMsgService.save(eduLeavenMsg);
        return R.ok(save);
    }

    /**
     * 留言列表
     * @param page
     * @return
     */
    @GetMapping("/list")
    public R list(Page<EduLeavenMsg> page){
        Page<EduLeavenMsg> page1 = eduLeavenMsgService.page(page);
        return R.ok(page1);
    }

    /**
     * 删除留言
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R delete(Integer id){
        boolean b = eduLeavenMsgService.removeById(id);
        return R.ok(b);
    }
}

