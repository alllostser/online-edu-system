package com.online.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduBanner;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
public interface EduBannerService extends IService<EduBanner> {

    Page<EduBanner> listPage(Page<EduBanner> page, EduBanner banner);
}
