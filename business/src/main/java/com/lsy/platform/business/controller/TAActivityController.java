package com.lsy.platform.business.controller;


import com.lsy.platform.business.model.TAActivity;
import com.lsy.platform.business.service.ITAActivityService;
import com.lsy.platform.springconfig.config.aop.SysMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.management.ManagementFactory;

/**
 * <p>
 * 活动基本信息表 前端控制器
 * </p>
 *
 * @author lsy
 * @since 2022-03-14
 */
@RestController
@RequestMapping("/tAActivity")
public class TAActivityController {

    @Resource(name = "tAActivityServiceImpl")
    public ITAActivityService itaActivityService;

    @GetMapping("/getById")
    public String getActivityInfo(int id) {
        TAActivity byId = itaActivityService.getById(id);
        return byId.toString();
    }

    @PutMapping("/saveActivityInfo")
    public boolean saveActivityInfo() {
        return itaActivityService.transUpdateActivityInfo();
    }

    @GetMapping("/getPid")
    public String getPid() {
        // get name representing the running Java virtual machine.
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
// get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        return pid;
    }


}

