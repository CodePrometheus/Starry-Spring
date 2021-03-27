package com.star.ioc;

import com.star.beans.Beer;
import com.star.beans.Starry;
import com.star.beans.factory.support.DefaultListableBeanFactory;
import com.star.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Author: zzStar
 * @Date: 03-27-2021 19:26
 */
public class XmlFileDefineBeanTest {


    @Test
    public void testXmlFile() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
        xmlReader.loadBeanDefinitions("classpath:spring.xml");

        Starry starry = (Starry) beanFactory.getBean("starry");
        System.out.println(starry);

        System.out.println(assertThat(starry.getName()).isEqualTo("zzStar"));
        System.out.println(assertThat(starry.getAge()).isEqualTo(12));
        System.out.println(assertThat(starry.getBeer().getTsingTao()).isEqualTo("laoShan"));

        Beer beer = (Beer) beanFactory.getBean("beer");
        System.out.println(beer);
        System.out.println(assertThat(beer.getTsingTao()).isEqualTo("laoShan"));
    }
}
