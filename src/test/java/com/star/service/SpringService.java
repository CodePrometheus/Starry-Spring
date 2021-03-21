package com.star.service;

/**
 * @Author: zzStar
 * @Date: 03-20-2021 14:43
 */
public class SpringService {

    private String zzStar;

    private String starry;

    @Override
    public String toString() {
        return "SpringService{" +
                "zzStar='" + zzStar + '\'' +
                ", starry='" + starry + '\'' +
                '}';
    }

    public String getZzStar() {
        return zzStar;
    }

    public void setZzStar(String zzStar) {
        this.zzStar = zzStar;
    }

    public String getStarry() {
        return starry;
    }

    public void setStarry(String starry) {
        this.starry = starry;
    }

    public String saySpring() {
        System.out.println("spring");
        return "spring";
    }

}
