package com.star.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 实现ResourceLoader
 *
 * @Author: zzStar
 * @Date: 03-22-2021 22:54
 */
public class DefaultResourceLoader implements ResourceLoader {

    public static final String CLASSPATH_URL_PREFIX = "classpath:";


    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // classpath下的资源
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {

            try {
                // 当成url来处理
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 当成文件系统下的资源处理
                String filePath = location;
                if (location.startsWith("/")) {
                    filePath = location.substring(1);
                }
                return new FileSystemResource(location);
            }
        }
    }

}
