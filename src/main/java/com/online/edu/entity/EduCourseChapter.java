package com.online.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
public class EduCourseChapter implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 章节类型0章节1小节
     */
    private Integer chapterType;

    /**
     * 小节父章节
     */
    private Integer parentId;

    /**
     * 小节排序
     */
    private Integer chapterOrder;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 视频时长
     */
    private String videoDuration;

    /**
     * 是否已删除
     */
    private Integer isDeleted;


    /**
     * 子章节列表
     */
    @TableField(exist = false)
    private List<EduCourseChapter> childrenChapterList;
}
