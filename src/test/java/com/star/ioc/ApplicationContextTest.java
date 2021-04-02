package com.star.ioc;

import com.star.beans.BeansException;
import com.star.beans.Beer;
import com.star.beans.Starry;
import com.star.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Author: zzStar
 * @Date: 04-02-2021 22:06
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Starry starry = applicationContext.getBean("starry", Starry.class);
        System.out.println(starry.getName());

        // 由于后置处理器
        assertThat(starry.getName()).isEqualTo("star");

        Beer beer = applicationContext.getBean("beer", Beer.class);
        System.out.println(beer.getTsingTao());

        System.out.println(assertThat(beer.getTsingTao()).isEqualTo("Budweiser"));
    }

}
