package com.lsy.study.json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liqiye
 * @description 测试Jackson
 * @date 2019/4/10
 */
public class JacksonTest {

    // json字符串和java对象、字节流、文件 之间的转换
    @Test
    public void test1() throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // jackson的核心类
        User user = new User("张三", 23);
        // java对象转json字符串
        String text = mapper.writeValueAsString(user);
        System.out.println("java对象转json字符串:"+text);
        // json字符串转java对象
        String str = "{\"id\":null,\"name\":\"李四\",\"age\":24}";
        User user1 = mapper.readValue(text, User.class);
        System.out.println("json字符串转java对象:"+user1);
        // java对象转为json文件，（在根目录生成）
        mapper.writeValue(new File("user.json"), user);
        // java对象转为字节流
        byte[] bytes = mapper.writeValueAsBytes(user);
        // 字节流转java对象
        User user2 = new User();
        user2 = mapper.readValue(bytes, User.class);
        System.out.println("字节流转java对象"+user2);
        // json文件转java对象
        User user3 = new User();
        user3 = mapper.readValue(new File("user.json"), User.class);
        System.out.println("json文件转java对象"+user3);
    }

    // json字符串与map之间的相互转化
    @Test
    public void test2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // map转json字符串
        Map<String, User> map = new HashMap<>();
        map.put("男生", new User("张三",23));
        map.put("女生", new User("李四",24));
        String text = mapper.writeValueAsString(map);
        System.out.println("map转json字符串："+text);
        // json字符串转map
        String str = "{\"男生\":{\"id\":null,\"name\":\"王五\",\"age\":25},\"女生\":{\"id\":null,\"name\":\"李四\",\"age\":24}}";
        Map<String, User> map2 = mapper.readValue(str, new TypeReference<Map<String, User>>() {});
        System.out.println("json字符串转map："+map2);
        // 复杂map一层一层拆分转化即可
        for (Object obj : map2.keySet()){
            // 这里与fastJson不同，jackson转成map时已指定里面的类型
            User user = map2.get(obj);
            System.out.println("map里面的value："+user);

        }
    }

    // json字符串与list之间的相互转化
    @Test
    public void test3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // list转json字符串
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("张三",23));
        list.add(new User("李四",24));
        String text = mapper.writeValueAsString(list);
        System.out.println("list转json字符串："+text);
        // json字符串转list
        String str = "[{\"id\":null,\"name\":\"王五\",\"age\":25},{\"id\":null,\"name\":\"李四\",\"age\":24}]";
        List<User> list2 = mapper.readValue(str,new TypeReference<List<User>>() {});
        System.out.println("json字符串转list："+list2);
    }

}
