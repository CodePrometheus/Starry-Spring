package com.star.ioc;

import com.star.beans.Beer;
import com.star.beans.PropertyValue;
import com.star.beans.PropertyValues;
import com.star.beans.Starry;
import com.star.beans.factory.config.BeanDefinition;
import com.star.beans.factory.config.BeanReference;
import com.star.beans.factory.support.DefaultListableBeanFactory;
import com.star.service.SpringService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: zzStar
 * @Date: 03-22-2021 21:51
 */
public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testBeanPropertyValues() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues beerValues = new PropertyValues();
        beerValues.addPropertyValue(new PropertyValue("zzStar", "love u"));
        beerValues.addPropertyValue(new PropertyValue("starry", "handsome boy"));

        BeanDefinition starryBeanDefinition = new BeanDefinition(SpringService.class, beerValues);
        beanFactory.registerBeanDefinition("springService", starryBeanDefinition);



        SpringService springService = (SpringService) beanFactory.getBean("springService");
        System.out.println(springService.toString());

        System.out.println(assertThat(springService.getZzStar()).isEqualTo("love u"));
        System.out.println(assertThat(springService.getStarry()).isEqualTo("handsome boy"));
    }

    @Test
    public void testPopulateBeanWithBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册啤酒实例
        PropertyValues beerValues = new PropertyValues();
        beerValues.addPropertyValue(new PropertyValue("tsingTao", "LaoShan"));

        BeanDefinition beerBeanDefinition = new BeanDefinition(Beer.class, beerValues);
        beanFactory.registerBeanDefinition("beer", beerBeanDefinition);

        // 注册Starry实例
        PropertyValues starryValues = new PropertyValues();
        starryValues.addPropertyValue(new PropertyValue("name", "zzStar"));
        starryValues.addPropertyValue(new PropertyValue("age", 20));

        // Starry依赖Beer
        starryValues.addPropertyValue(new PropertyValue("beer", new BeanReference("beer")));

        BeanDefinition starryBeanDefinition = new BeanDefinition(Starry.class, starryValues);
        beanFactory.registerBeanDefinition("starry", starryBeanDefinition);

        Starry starry = (Starry) beanFactory.getBean("starry");
        System.out.println(starry);

        System.out.println(assertThat(starry.getName()).isEqualTo("zzStar"));
        System.out.println(assertThat(starry.getAge()).isEqualTo(20));

        Beer beer = starry.getBeer();
        System.out.println(assertThat(beer).isNotNull());

        System.out.println(assertThat(beer.getTsingTao()).isEqualTo("LaoShan"));
    }
}
