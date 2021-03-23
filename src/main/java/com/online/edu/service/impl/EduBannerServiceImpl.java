package com.online.edu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.EduBanner;
import com.online.edu.mapper.EduBannerMapper;
import com.online.edu.service.EduBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-22
 */
@Service
public class EduBannerServiceImpl extends ServiceImpl<EduBannerMapper, EduBanner> implements EduBannerService {
    @Autowired
    private EduBannerMapper eduBannerMapper;

    /**
     * 首页轮播图列表
     * @param page
     * @param banner
     * @return
     */
    @Override
    public Page<EduBanner> listPage(Page<EduBanner> page, EduBanner banner) {
        return eduBannerMapper.listPage(page,banner);
    }
}
