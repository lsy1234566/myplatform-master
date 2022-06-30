package com.lsy.study.json;


import java.util.ArrayList;
import java.util.List;

/**
 * @author liqiye
 * @description 用户组
 * @date 2019/4/10
 */
public class UserGroup {
    private String name;
    private List<User> users = new ArrayList<User>();
    public UserGroup(){}
    public UserGroup(String name, List<User> users){
        this.name = name;
        this.users = users;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    @Override
    public String toString() {
        return "UserGroup [name=" + name + ", users=" + users + "]";
    }
}