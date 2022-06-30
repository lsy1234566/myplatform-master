package com.lsy.study.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liqiye
 * @description 测试fastjson
 * @date 2019/4/10
 */
public class FastJsonTest {

    // java对象转json字符串
    @Test
    public void objectTOJson(){
        // 简单java类转json字符串
        User user = new User("liqiye", 23);
        String UserJson = JSON.toJSONString(user);
        System.out.println("简单java类转json字符串:"+UserJson);

        // List<Object>转json字符串
        User user1 = new User("张三", 23);
        User user2 = new User("李四", 24);
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        String ListUserJson = JSON.toJSONString(users);
        System.out.println("List<Object>转json字符串:"+ListUserJson);

        //复杂java类转json字符串
        UserGroup userGroup = new UserGroup("用户组", users);
        String userGroupJson = JSON.toJSONString(userGroup);
        System.out.println("复杂java类转json字符串:"+userGroupJson);
    }

    // json格式字符串转java对象
    @Test
    public void JsonTOObject(){
        // json字符串转简单java对象
        String jsonStr1 = "{'name':'王五','age': 23}";
        User user = JSON.parseObject(jsonStr1, User.class);
        System.out.println("json字符串转简单java对象:"+user.toString());

        // json字符串转List<Object>对象
        String jsonStr2 = "[{'name':'张三','age':23},{'name':'李四','age':24}]";
        List<User> users = JSON.parseArray(jsonStr2, User.class);
        System.out.println("json字符串转List<Object>对象:"+users.toString());

        // json字符串转复杂java对象
        String jsonStr3 = "{'name':'用户组','users':[{'name':'张三','age':23},{'name':'李四','age':24}]}";
        UserGroup userGroup = JSON.parseObject(jsonStr3, UserGroup.class);
        System.out.println("json字符串转复杂java对象:"+userGroup);
    }

    // map转json字符串
    @Test
    public void mapToJson(){
        Map<String, User> map = new HashMap<String, User>();
        map.put("男生",new User("张三",23));
        map.put("女生",new User("李四",24));
        String mapJson = JSON.toJSONString(map);
        System.out.println("map转json字符串:"+mapJson);
    }

    // json字符串转map(复杂map,其实就是一层一层拆分，同样用的都只是JSON的toJSONString方法和parseObject方法)
    @Test
    public void jsonToMap(){
        String str = "{\"男生\":{\"age\":23,\"name\":\"张三\"},\"女生\":{\"age\":24,\"name\":\"李四\"}}";
        Map map = JSON.parseObject(str);
        for (Object obj : map.keySet()){
            System.out.println("map的key为："+obj+"、值为："+map.get(obj));
            //  map的每一个都是一个JSONObject对象，先将它转成json字符串
            String s = JSON.toJSONString(map.get(obj));
            // 再将json字符串转自定义对象
            User user = JSON.parseObject(s, User.class);
            System.out.println(user);
        }
    }


}
