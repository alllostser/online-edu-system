package com.online.edu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: online-edu-system
 * @description:
 * @created: 2021/03/24 18:25
 */
@Data
public class EduCourseItemDto implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String realName;

    /**
     * 课程id
     */
    private String courseName;


    /**
     * 是否已经签到
     */
    private Integer signedNumber;


}
