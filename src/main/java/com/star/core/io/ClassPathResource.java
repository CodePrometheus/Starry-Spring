package com.star.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类路径下的资源
 *
 * @Author: zzStar
 * @Date: 03-22-2021 22:41
 */
public class ClassPathResource implements Resource {

    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }


}
