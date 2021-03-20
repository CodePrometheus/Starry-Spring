package com.star.beans;

import com.star.util.Nullable;

/**
 * @Author: zzStar
 * @Date: 03-20-2021 12:21
 */
@SuppressWarnings("serial")
public class BeansException extends RuntimeException {

    /**
     * Create a new BeansException with the specified message.
     *
     * @param msg the detail message
     */
    public BeansException(String msg) {
        super(msg);
    }

    /**
     * 信息 & 原因
     *
     * @param msg
     * @param cause
     */
    public BeansException(@Nullable String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }


}
