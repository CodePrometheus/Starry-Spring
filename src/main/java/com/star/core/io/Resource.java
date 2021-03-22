package com.star.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源的抽象和访问接口
 *
 * @Author: zzStar
 * @Date: 03-22-2021 22:22
 */
public interface Resource {


    /**
     * 流
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;

}
