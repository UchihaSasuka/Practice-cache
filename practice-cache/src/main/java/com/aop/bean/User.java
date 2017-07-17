package com.aop.bean;

/**
 * Created by zjl on 2017/7/17.
 */
public class User {
    private int id;
    private String name;

    public User(){
        super();
    }

    public User(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
