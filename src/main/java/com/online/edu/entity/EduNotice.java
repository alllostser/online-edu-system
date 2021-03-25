package com.online.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EduNotice implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 创建人
     */
    private String publisher;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;

    /**
     * 是否删除
     */
    private Integer isDeleted;


}
