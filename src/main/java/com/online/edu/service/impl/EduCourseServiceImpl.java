package com.online.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduCourse;
import com.online.edu.entity.EduCourseChapter;
import com.online.edu.entity.dto.EduCourseDto;
import com.online.edu.mapper.EduCourseChapterMapper;
import com.online.edu.mapper.EduCourseMapper;
import com.online.edu.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Autowired
    private EduCourseMapper eduCourseMapper;
    @Autowired
    private EduCourseChapterMapper eduCourseChapterMapper;
    /**
     * 课程列表
     * @param page
     * @param eduCourse
     * @return
     */
    @Override
    public IPage<EduCourse> listPage(Page<EduCourse> page, EduCourse eduCourse) {
        return  eduCourseMapper.listPage(page,eduCourse);
    }

    /**
     * 获取课程详情
     * @param courseId
     * @return
     */
    @Override
    public EduCourseDto getCourseInfo(Integer courseId) {
        EduCourse eduCourse = eduCourseMapper.selectById(courseId);
        EduCourseDto eduCourseDto = new EduCourseDto();
        eduCourseDto.setCourseId(eduCourse.getCourseId());
        eduCourseDto.setCourseName(eduCourse.getCourseName());
        eduCourseDto.setCoursePopularity(eduCourse.getCoursePopularity());
        eduCourseDto.setCourseImgUrl(eduCourse.getCourseImgUrl());
        eduCourseDto.setCourseInfo(eduCourse.getCourseInfo());
        List<EduCourseChapter> eduCourseChapters = eduCourseChapterMapper.selectList(new LambdaQueryWrapper<EduCourseChapter>().eq(EduCourseChapter::getCourseId, courseId).eq(EduCourseChapter::getParentId,0).orderByAsc(EduCourseChapter::getChapterOrder));
        if (eduCourseChapters.size()==0){
            return eduCourseDto;
        }
        for (EduCourseChapter eduCourseChapter : eduCourseChapters) {
            List<EduCourseChapter> childrenCourseChapter = eduCourseChapterMapper.selectList(new LambdaQueryWrapper<EduCourseChapter>().eq(EduCourseChapter::getCourseId, courseId).eq(EduCourseChapter::getParentId,eduCourseChapter.getId()).orderByAsc(EduCourseChapter::getChapterOrder));
            eduCourseChapter.setChildrenChapterList(childrenCourseChapter);
        }
        eduCourseDto.setChapterList(eduCourseChapters);
        return eduCourseDto;
    }

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    @Override
    @Transactional
    public boolean removeCourse(Integer courseId) {
        int i = eduCourseMapper.deleteById(courseId);
        int delete = eduCourseChapterMapper.delete(new LambdaQueryWrapper<EduCourseChapter>().eq(EduCourseChapter::getCourseId, courseId));
        if (i>0 && delete>0){
            return true;
        }
        return true;
    }
}
