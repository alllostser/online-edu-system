package com.online.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class EduLeavenMsg implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 电话
     */
    private String userPhone;

    /**
     * 留言内容
     */
    private String leaveMessage;

    /**
     * 删除标识
     */
    private Integer isDeleted;


}
