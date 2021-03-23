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
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EduBanner implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 轮播图标题
     */
    private String bannerTitle;

    /**
     * 轮播图url
     */
    private String bannerUrl;

    /**
     * 轮播图排序
     */
    private Integer bannerOrder;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否可用
     */
    private Integer isEnable;

    /**
     * 是否已经删除
     */
    private Integer isDeleted;


}
