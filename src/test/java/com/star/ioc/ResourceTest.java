package com.star.ioc;

import cn.hutool.core.io.IoUtil;
import com.star.core.io.DefaultResourceLoader;
import com.star.core.io.FileSystemResource;
import com.star.core.io.Resource;
import com.star.core.io.UrlResource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: zzStar
 * @Date: 03-22-2021 23:21
 */
public class ResourceTest {

    /**
     * 测试三种资源加载
     *
     * @throws Exception
     */
    @Test
    public void testResourceLoader() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // classpath
        Resource resource = resourceLoader.getResource("classpath:starry.txt");
        InputStream is = resource.getInputStream();
        String content = IoUtil.readUtf8(is);
        System.out.println(content);
        // assertThat(content).isEqualTo("zzStar");

        // 加载文件系统资源
        resource = resourceLoader.getResource("src/test/resources/starry.txt");
        System.out.println(assertThat(resource instanceof FileSystemResource).isTrue());
        is = resource.getInputStream();
        content = IoUtil.readUtf8(is);
        System.out.println(content);
        // System.out.println(assertThat(content).isEqualTo("zzStar love"));

        // 加载url资源
        resource = resourceLoader.getResource("https://taobao.com");
        System.out.println(assertThat(resource instanceof UrlResource).isTrue());
        is = resource.getInputStream();
        content = IoUtil.readUtf8(is);
        System.out.println(content);
    }

}
