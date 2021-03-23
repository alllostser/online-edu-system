package com.online.edu.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduBanner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
public interface EduBannerMapper extends BaseMapper<EduBanner> {

    Page<EduBanner> listPage(Page<EduBanner> page, EduBanner banner);
}
