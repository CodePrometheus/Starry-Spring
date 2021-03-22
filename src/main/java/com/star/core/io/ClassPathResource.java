package com.star.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 类路径下的资源
 *
 * @Author: zzStar
 * @Date: 03-22-2021 22:41
 */
public class ClassPathResource extends AbstractResource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this.path = path;
        this.classLoader = ClassPathResource.class.getClassLoader();
    }

    public String getPath() {
        return path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = this.classLoader.getResourceAsStream(this.path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException("resource cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }

    @Override
    public URL getURL() throws IOException {
        URL url = this.classLoader.getResource(this.path);
        if (url == null) {
            throw new FileNotFoundException("resource cannot be resolved to URL because it does not exist");
        }
        return url;
    }

}
