package com.online.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EduUserComment implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 课程id
     */
    private Integer courseId;

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

    /**
     * 是否删除
     */
    private Integer isDeleted;


}
