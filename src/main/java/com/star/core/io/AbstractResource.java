package com.star.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 实现Resource接口
 *
 * @Author: zzStar
 * @Date: 03-22-2021 22:25
 */
public abstract class AbstractResource implements Resource {

    @Override
    public boolean exists() {
        try {
            return getFile().exists();
        } catch (IOException e) {
            try {
                InputStream inputStream = getInputStream();
                inputStream.close();
                return true;
            } catch (Throwable isExists) {
                return false;
            }
        }
    }

    @Override
    public File getFile() throws IOException {
        throw  new FileNotFoundException("resource cannot be resolved to absolute file path");
    }


    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException("resource cannot be resolved to URL");
    }
}
