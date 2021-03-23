package com.online.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EduCourse implements Serializable {

    private static final long serialVersionUID=1L;

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
     * 创建人
     */
    private String courseMaster;

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
     * 创建日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime courseDate;

    /**
     * 总章节
     */
    private Integer chapterCount;

    /**
     * 是否可用
     */
    private Integer isEnable;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

    /**
     * 排序
     */
    @TableField(exist = false)
    private String orderBy;

}
