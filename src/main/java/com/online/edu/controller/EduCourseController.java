package com.online.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduCourse;
import com.online.edu.entity.dto.EduCourseDto;
import com.online.edu.service.EduCourseService;
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
@RequestMapping("/course")
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 课程列表
     * @param page
     * @param eduCourse
     * @return
     */
    @GetMapping("/list")
    public R list(Page<EduCourse> page,EduCourse eduCourse){
        IPage<EduCourse> pageList = eduCourseService.listPage(page,eduCourse);
        return R.ok(pageList);
    }

    /**
     * 后台课程列表
     * @param page
     * @param eduCourse
     * @return
     */
    @GetMapping("/list2")
    public R listForAdmin(Page<EduCourse> page,EduCourse eduCourse){
        Page<EduCourse> pageList = null;
        if (StringUtils.checkValNull(eduCourse.getCourseName())){
             pageList = eduCourseService.page(page, new LambdaQueryWrapper<EduCourse>());

        }else {
             pageList = eduCourseService.page(page, new LambdaQueryWrapper<EduCourse>().like(EduCourse::getCourseName, eduCourse.getCourseName()));

        }
        return R.ok(pageList);
    }
    /**
     * 获取课程详情
     * @param courseId
     * @return
     */
    @GetMapping("/getCourseInfo")
    public R getCourseInfo(Integer courseId){
        if (courseId == null){
            return R.failed("参数为空！");
        }
        EduCourseDto eduCourseDto = eduCourseService.getCourseInfo(courseId);
        return R.ok(eduCourseDto);
    }

    /**
     * 添加课程
     * @param eduCourse
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody EduCourse eduCourse){
        eduCourse.setCourseDate(LocalDateTime.now());
        boolean save = eduCourseService.save(eduCourse);
        return R.ok(save);
    }

    /**
     * 修改课程
     * @param eduCourse
     * @return
     */
    @PostMapping("/update")
    public R updateById(@RequestBody EduCourse eduCourse){
        EduCourse byId = eduCourseService.getById(eduCourse.getCourseId());
        eduCourse.setCourseDate(byId.getCourseDate());
        boolean b = eduCourseService.updateById(eduCourse);
        return R.ok(b);
    }

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    @DeleteMapping("/deleteById")
    public R delete(Integer courseId){
        boolean b = eduCourseService.removeCourse(courseId);
        return R.ok(b);
    }
}

