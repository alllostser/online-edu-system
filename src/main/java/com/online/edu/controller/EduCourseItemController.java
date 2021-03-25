package com.online.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.online.edu.entity.EduCourse;
import com.online.edu.entity.EduCourseItem;
import com.online.edu.entity.EduUser;
import com.online.edu.entity.dto.EduCourseItemDto;
import com.online.edu.service.EduCourseItemService;
import com.online.edu.service.EduCourseService;
import com.online.edu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private EduUserService userService;

    /**
     * 课程报名+签到
     * @param eduCourseItem-》userId courseId
     * @return
     */
    @PostMapping("/signed")
    public R courseApply(@RequestBody EduCourseItem eduCourseItem){
       if(StringUtils.checkValNull(eduCourseItem.getCourseId())){
           return R.failed("课程id不能为空");
       }
        if(StringUtils.checkValNull(eduCourseItem.getUserId())){
            return R.failed("用户id不能为空");
        }
        eduCourseItem.setSignedNumber(1);//设定课程签到状态为已签到
        EduCourseItem one = eduCourseItemService.getOne(new LambdaQueryWrapper<EduCourseItem>().eq(EduCourseItem::getCourseId, eduCourseItem.getCourseId()).eq(EduCourseItem::getUserId, eduCourseItem.getUserId()));
        if (ObjectUtils.isEmpty(one)){
            boolean save = eduCourseItemService.save(eduCourseItem);
        }else {
            boolean update = eduCourseItemService.update(eduCourseItem, new LambdaQueryWrapper<EduCourseItem>().eq(EduCourseItem::getCourseId, eduCourseItem.getCourseId()).eq(EduCourseItem::getUserId, eduCourseItem.getUserId()));
        }

        EduCourse eduCourse = eduCourseService.getById(eduCourseItem.getCourseId());
        eduCourse.setCoursePopularity(eduCourse.getCoursePopularity()+1);
        //为课程热度+1
        boolean b = eduCourseService.updateById(eduCourse);
        return R.ok(b);
    }

    /**
     * 后台签到详情
     * @param courseId
     * @return
     */
    @GetMapping("/list")
    public R list(Integer courseId){
        if (courseId==null){
            return R.failed("课程id不能为空");
        }
        List<EduCourseItem> list = eduCourseItemService.list(new LambdaQueryWrapper<EduCourseItem>().eq(EduCourseItem::getCourseId, courseId));
        List<EduCourseItemDto> eduCourseItemDtoList = new ArrayList<>();
        for (EduCourseItem eduCourseItem : list) {
            EduCourseItemDto eduCourseItemDto = new EduCourseItemDto();
            eduCourseItemDto.setId(eduCourseItem.getId());
            EduUser byId = userService.getById(eduCourseItem.getUserId());
            eduCourseItemDto.setRealName(byId.getRealName());
            EduCourse byId1 = eduCourseService.getById(eduCourseItem.getCourseId());
            eduCourseItemDto.setCourseName(byId1.getCourseName());
            eduCourseItemDto.setSignedNumber(eduCourseItem.getSignedNumber());
            eduCourseItemDtoList.add(eduCourseItemDto);
        }
        return R.ok(eduCourseItemDtoList);
    }

    /**
     * 获取签到状态
     * @param courseId
     * @param userId
     * @return
     */
    @GetMapping("/getStatus")
    public R list(Integer courseId, Integer userId) {
        if (courseId == null) {
            return R.failed("课程id不能为空");
        }
        if (userId == null) {
            return R.failed("用户id不能为空");
        }
        EduCourseItem eduCourseItem = eduCourseItemService.getOne(new LambdaQueryWrapper<EduCourseItem>().eq(EduCourseItem::getCourseId, courseId).eq(EduCourseItem::getUserId, userId));
        if (eduCourseItem==null){
            EduCourseItemDto eduCourseItemDto = new EduCourseItemDto();
            EduUser byId = userService.getById(userId);
            eduCourseItemDto.setRealName(byId.getRealName());
            EduCourse byId1 = eduCourseService.getById(courseId);
            eduCourseItemDto.setCourseName(byId1.getCourseName());
            eduCourseItemDto.setSignedNumber(0);
            return R.ok(eduCourseItemDto);
        }
        EduCourseItemDto eduCourseItemDto = new EduCourseItemDto();
        eduCourseItemDto.setId(eduCourseItem.getId());
        EduUser byId = userService.getById(eduCourseItem.getUserId());
        eduCourseItemDto.setRealName(byId.getRealName());
        EduCourse byId1 = eduCourseService.getById(eduCourseItem.getCourseId());
        eduCourseItemDto.setCourseName(byId1.getCourseName());
        eduCourseItemDto.setSignedNumber(eduCourseItem.getSignedNumber());
        return R.ok(eduCourseItemDto);
    }
//    //TOdo:签到
//    public R signedNumber()
//
//    //TOdo:保存播放状态
}
