package com.star.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 资源接口
 *
 * @Author: zzStar
 * @Date: 03-22-2021 22:22
 */
public interface Resource {

    /**
     * 是否存在
     *
     * @return
     */
    boolean exists();

    /**
     * 获取File
     *
     * @return
     * @throws IOException
     */
    File getFile() throws IOException;

    /**
     * 流
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;

    /**
     * 获取URL
     *
     * @return
     * @throws IOException
     */
    URL getURL() throws IOException;
}
