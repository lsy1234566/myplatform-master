package com.lsy.platform.business.service;

import com.lsy.platform.business.model.TAActivity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 活动基本信息表 服务类
 * </p>
 *
 * @author lsy
 * @since 2022-03-14
 */
public interface ITAActivityService extends IService<TAActivity> {

    TAActivity getActivityInfo(int id);

    boolean transUpdateActivityInfo();
}
