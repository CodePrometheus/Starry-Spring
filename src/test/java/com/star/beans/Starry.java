package com.star.beans;

/**
 * @Author: zzStar
 * @Date: 03-22-2021 21:52
 */
public class Starry {

    private String name;

    private Integer age;

    private Beer beer;

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    @Override
    public String toString() {
        return "Starry{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
