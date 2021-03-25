package com.online.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduCourse;
import com.online.edu.entity.EduUser;
import com.online.edu.entity.EduUserComment;
import com.online.edu.entity.dto.EduCommentDto;
import com.online.edu.service.EduCourseService;
import com.online.edu.service.EduUserCommentService;
import com.online.edu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-24
 */
@RestController
@RequestMapping("/edu-comment")
public class EduUserCommentController {
    @Autowired
    private EduUserCommentService eduUserCommentService;

    /**
     * 用户评论
     * @param eduUserComment
     * @return
     */
    @PostMapping("/comment")
    public R comment(@RequestBody EduUserComment eduUserComment){
        if (ObjectUtils.isEmpty(eduUserComment.getUserId())){
            return R.failed("用户id不能为空");
        }
        if (ObjectUtils.isEmpty(eduUserComment.getCourseId())){
            return R.failed("课程id不能为空");
        }
        eduUserComment.setCommentTime(LocalDateTime.now());
        boolean save = eduUserCommentService.save(eduUserComment);
        return R.ok(save);
    }

    @Autowired
    private EduUserService eduUserService;
    @Autowired
    private EduCourseService eduCourseService;
    /**
     * 获取评论列表
     * @param page
     * @param courseId
     * @return
     */
    @GetMapping("/listByCourseId")
    public R list(Page<EduUserComment> page,Integer courseId){
        Page<EduUserComment> page1 = eduUserCommentService.page(page, new LambdaQueryWrapper<EduUserComment>().eq(EduUserComment::getCourseId, courseId).orderByDesc(EduUserComment::getCommentTime));
        List<EduUserComment> records = page1.getRecords();
        List<EduCommentDto> eduCommentDtoList = new ArrayList<>();
        for (EduUserComment record : records) {
            EduCommentDto eduCommentDto = new EduCommentDto();
            eduCommentDto.setCommentContent(record.getCommentContent());
            eduCommentDto.setCommentTime(record.getCommentTime());
            eduCommentDto.setId(record.getId());
            eduCommentDto.setCommentScore(record.getCommentScore());
            EduUser byId = eduUserService.getById(record.getUserId());
            eduCommentDto.setRealName(byId.getRealName());
            EduCourse byId1 = eduCourseService.getById(record.getCourseId());
            eduCommentDto.setCourseName(byId1.getCourseName());
            eduCommentDtoList.add(eduCommentDto);
        }
        IPage<EduCommentDto> iPage = new Page<>();
        iPage.setTotal(eduCommentDtoList.size());
        iPage.setSize(30);
        iPage.setRecords(eduCommentDtoList);
        return R.ok(iPage);
    }

}

