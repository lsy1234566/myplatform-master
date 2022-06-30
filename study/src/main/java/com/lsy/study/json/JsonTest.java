package com.lsy.study.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class JsonTest {

    String str = "{'Switch_1':{\"null\":null,\"date\":2021-06-01T12:23:00.235+08:00,\"age\":1.22},\"女生\":{\"id\":null,\"name\":\"李四\",\"age\":24}}";

    @Test
    public void deSerial() {
        /*Jackson*/
        ObjectMapper mapper = new ObjectMapper();
        /*区别FastJson的配置,并赋予调整至和FastJson一致配置代码*/
        /*反序列化*/
        //是否识别不带引号的key-默认关闭，FastJson默认开启
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        //是否识别单引号的key-默认关闭，FastJson默认开启
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //浮点数类型-默认double，FastJson默认BigDecimal
        mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        //默认开启Json@type指定类型解析，FastJson默认关闭
        //mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        /*序列化*/
        //默认key或value是null时也输出(只对VO起作用，Map List不起作用)，FastJson默认不输出
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);


        Map<String, User> map2 = null;
        try {
            map2 = mapper.readValue(str, new TypeReference<Map>() {
            });
        } catch (IOException e) {
            System.out.println("解析失败");
        }
        System.out.println("Jackson字符串转map：" + map2);
        /*FastJson*/
        Map map = JSON.parseObject(str);
        /*区别Jackson的配置*/
        //key字符串默认会调用key.intern()加入常量池
        //序列化枚举时会使用枚举名-默认开启

        System.out.println("FastJson字符串转map：" + map);
    }



    @Test
    public void serial() {
        User user = new User(10, "钟无常", new Date(),new LinkedList(),"350913156158164165x");

        /*Jackon序列化*/
        ObjectMapper mapper = new ObjectMapper(); // jackson的核心类
        //默认都是时间对象都是时间戳输出
        //mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //默认输出transient字段，FastJson默认不输出
        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        //默认不开启排序，FastJson根据字典排序（指定order除外）
        mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);

        // java对象转json字符串
        String jacksonStr;
        try {
            jacksonStr = mapper.writeValueAsString(user);
            System.out.println("Jackson对象转Json：" + jacksonStr);
        } catch (JsonProcessingException e) {
            System.out.println("解析失败");
        }

        /*FastJson序列化*/
        String fastJsonStr = JSON.toJSONString(user);
        System.out.println("FastJson对象转Json:" + fastJsonStr);
    }


    @Test
    public void bugTest1() throws IOException {
        String jsonString="{\"data\":\"testFastjson\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        //解析json
        ObjectNode jsonNodes = objectMapper.readValue(jsonString, ObjectNode.class);
        //获取字段
        JsonNode data = jsonNodes.get("data");
        System.out.println(data);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private int id;
        private String name;
        private Date birthDay;
        private List  feature;
        private transient String idCard;
    }

    @Test
    public void bugTest2() {
        String jsonString="{\"id\":11,\n" +
                "  \"name\":\"钟无艳\",\n" +
                "        \"birthDay\":\"2021-06-01T12:23:00.235+08:00\",\n" +
                "        \"feature\":[],\n" +
                "        \"idCard\":\"35092312316514\",\n" +
                "\"other\":null\n" +
                "}";
        //Jackson解析json
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            User user  = objectMapper.readValue(jsonString, User.class);
            System.out.println("Jackson解析结果："+user);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //FastJson解析
        User user1 = JSON.parseObject(jsonString, User.class);
        System.out.println("FastJson解析结果："+user1);
    }
}
