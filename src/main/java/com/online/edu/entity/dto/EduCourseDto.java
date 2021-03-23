package com.online.edu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.online.edu.entity.EduCourseChapter;
import lombok.Data;

import java.util.List;

/**
 * @program: online-edu-system
 * @description:
 * @created: 2021/03/22 18:31
 */
@Data
public class EduCourseDto {
    /**
     * 主键
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程主图
     */
    private String courseImgUrl;

    /**
     * 参加人数 人气
     */
    private Integer coursePopularity;

    /**
     * 课程介绍（详情）
     */
    private String courseInfo;

    /**
     * 章节列表
     */
    private List<EduCourseChapter> chapterList;
}
