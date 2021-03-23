package com.online.edu.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.online.edu.entity.EduCourse;
import com.online.edu.entity.EduCourseItem;
import com.online.edu.service.EduCourseItemService;
import com.online.edu.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程用户章节连接表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@RestController
@RequestMapping("/course-item")
public class EduCourseItemController {
    @Autowired
    private EduCourseItemService eduCourseItemService;
    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 课程报名
     * @param eduCourseItem-》userId courseId
     * @return
     */
    @PostMapping("/apply")
    public R courseApply(@RequestBody EduCourseItem eduCourseItem){
       if(StringUtils.checkValNull(eduCourseItem.getCourseId())){
           return R.failed("课程id不能为空");
       }
        if(StringUtils.checkValNull(eduCourseItem.getUserId())){
            return R.failed("用户id不能为空");
        }
        boolean save = eduCourseItemService.save(eduCourseItem);
        EduCourse eduCourse = eduCourseService.getById(eduCourseItem.getCourseId());
        eduCourse.setCoursePopularity(eduCourse.getCoursePopularity()+1);
        //为课程热度+1
        boolean b = eduCourseService.updateById(eduCourse);
        return R.ok(b);
    }

    //TOdo:签到


    //TOdo:保存播放状态
}
