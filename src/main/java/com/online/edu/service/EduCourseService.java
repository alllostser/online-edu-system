package com.online.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.online.edu.entity.dto.EduCourseDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
public interface EduCourseService extends IService<EduCourse> {

    IPage<EduCourse> listPage(Page<EduCourse> page, EduCourse eduCourse);

    EduCourseDto getCourseInfo(Integer courseId);

    boolean removeCourse(Integer courseId);
}
