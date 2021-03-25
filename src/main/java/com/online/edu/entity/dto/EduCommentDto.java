package com.online.edu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: online-edu-system
 * @description: 用户评论dto
 * @created: 2021/03/24 16:32
 */
@Data
public class EduCommentDto implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论分数
     */
    private Integer commentScore;

    /**
     * 评论时间
     */
    private LocalDateTime commentTime;


}
