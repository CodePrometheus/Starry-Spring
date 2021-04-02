package com.star.ioc;

import com.star.beans.Beer;
import com.star.beans.Starry;
import com.star.beans.factory.support.DefaultListableBeanFactory;
import com.star.beans.factory.xml.XmlBeanDefinitionReader;
import com.star.ioc.common.CustomBeanFactoryPostProcessor;
import com.star.ioc.common.CustomerBeanPostProcessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Author: zzStar
 * @Date: 03-28-2021 22:06
 */
public class BeanFactoryPostProcessorAndBeanPostProcessorTest {

    @Test
    public void testBeanFactoryPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        definitionReader.loadBeanDefinitions("classpath:spring.xml");
        // 在所有BeanDefinition加载完成后，但在bean实例化之前，修改BeanDefinition的属性值
        CustomBeanFactoryPostProcessor postProcessor = new CustomBeanFactoryPostProcessor();
        postProcessor.postProcessBeanFactory(beanFactory);

        Starry starry = (Starry) beanFactory.getBean("starry");
        System.out.println("BeanFactoryPostProcessor之后 " + starry.getName());
        System.out.println(assertThat(starry.getName()).isEqualTo("star"));
    }


    @Test
    public void testBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        definitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 添加bean实例化之后的处理器
        CustomerBeanPostProcessor postProcessor = new CustomerBeanPostProcessor();
        beanFactory.addBeanPostProcessor(postProcessor);

        Beer beer = (Beer) beanFactory.getBean("beer");
        System.out.println("BeanPostProcessor处理之后" + beer.getTsingTao());
        System.out.println(assertThat(beer.getTsingTao()).isEqualTo("Budweiser"));
    }
}
