package com.lsy.platform.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: gaoxinfu
 * @Date: 2020-10-27 18:03
 */
@FeignClient("business")
public interface OpenfeignConsumerService {

    @RequestMapping(value="tAActivity/getById?id={id}",method = RequestMethod.GET)
    String getActivityId(@PathVariable("id") int id);

    @RequestMapping(value="tAActivity/saveActivityInfo",method = RequestMethod.PUT)
    boolean saveActivityInfo();

}
