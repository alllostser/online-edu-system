package com.online.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程用户章节连接表
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EduCourseItem implements Serializable {

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
     * 最后一个播放得章节id
     */
    private Integer lastChapterId;

    /**
     * 最后播放到得时长
     */
    private String lastRunTime;

    /**
     * 签到次数
     */
    private Integer signedNumber;

    /**
     * 是否已删除
     */
    private Integer isDeleted;


}
