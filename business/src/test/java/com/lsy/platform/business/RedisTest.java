package com.lsy.platform.business;

import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.redisson.api.geo.GeoSearchNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.19
 */


@SpringBootTest
public class RedisTest {

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void t1() {

        RBucket<String> keyObject = redissonClient.getBucket("key");
        // 如果key存在，就设置key的值为新值value
        // 如果key不存在，就设置key的值为value
        keyObject.set("value");

//        RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter("BloomFilter");
//        bloomFilter.add(1);
//        bloomFilter.add(2);
//        bloomFilter.add(3);
//        bloomFilter.add(4);
        RBitSet appidBitSet = redissonClient.getBitSet("bitmap");
        for (int i = 0; i < 11; i++) {
            appidBitSet.set(i);
        }

        long cardinality = appidBitSet.cardinality();//为1的个数
        System.out.println(cardinality);

    }


    @Test
    public void t2() {

        /*geo*/
        RGeo<Object> geo = redissonClient.getGeo("geo");
        GeoEntry geoEntry1 = new GeoEntry(116.397128D, 39.916527D, 1);
        GeoEntry geoEntry2 = new GeoEntry(116.41910065624998D, 39.95022388520984D, 2);
        geo.add(geoEntry1);
        geo.add(geoEntry2);
//        GeoSearchNode geoSearchNode = new BaseOptionalGeoSearch();
        //距离
        System.out.println(geo.dist(1, 2, GeoUnit.METERS));
    }

    @Test
    public void t3() {
        RHyperLogLog<String> hyperLogLog = redissonClient.getHyperLogLog("hyperLogLog");
        for (int i = 0; i < 10000; i++) {
            hyperLogLog.add("瓜田李下 " + i);
        }

        RHyperLogLog<String> hyperLogLog2 = redissonClient.getHyperLogLog("hyperLogLog2");
        for (int i = 0; i < 10000; i++) {
            hyperLogLog2.add("海贼王 " + i);
        }

        System.out.println("hyperLogLog的数据量为：" + hyperLogLog.count());
        System.out.println("hyperLogLog2的数据量为：" + hyperLogLog2.count());
        System.out.println("hyperLogLog合并计算hyperLogLog2的数据量为：" + hyperLogLog.countWith("hyperLogLog2"));

        hyperLogLog.mergeWith("hyperLogLog2");

    }

}
