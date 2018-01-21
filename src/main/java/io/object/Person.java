package io.object;

import java.io.Serializable;

/**
 * @Author chenlei10
 * @Date 2017/10/13 17:44
 */
public class Person implements Serializable{
    private String name;
    private Integer age;
    private Double height;

    public Person(String name, Integer age, Double height){
        super();
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String toString(){
        return "This is " + getName() + ", age is " + getAge() + ", height is " + getHeight();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
