package com.lsy.platform.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Hashtable;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.20
 */

public class CollectionTest {


    @Test
    public void t1(){
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put("1",2);
    }
}
