package com.lsy.platform.consumer.controller;


import com.lsy.platform.consumer.service.OpenfeignConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class ConsumerController {

//    @Resource
//    private RestTemplate restTemplate;

    @Resource
    OpenfeignConsumerService openfeignConsumerService;


    @GetMapping("/getById")
    public String getActivityInfo(int id) {
//        return restTemplate.getForObject(serverUrl + "/tAActivity/getById?id=" + id, String.class);
        return openfeignConsumerService.getActivityId(id);
    }



    @PutMapping("/saveActivityInfo")
    public boolean saveActivityInfo() {
        return openfeignConsumerService.saveActivityInfo();
    }

    @GetMapping("/getPid")
    public String getPid() {
        // get name representing the running Java virtual machine.
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        return pid;
    }


}

