/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.zhuangxiaoyan.common.utils;

import lombok.Data;

/**
 * @description 自定义异常
 * @date: 2022/3/19 18:37
 * @author: xjl
 */
@Data
public class AthenaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * message
     */
    private String message;

    /**
     * code
     */
    private int code = 500;

    /**
     * @description RRException 构造函数
     * @param: msg
     * @date: 2022/7/27 22:01
     * @return:
     * @author: xjl
     */
    public AthenaException(String msg) {
        super(msg);
        this.message = msg;
    }

    /**
     * @description RRException 构造函数
     * @param: msg
     * @param: e
     * @date: 2022/7/27 22:02
     * @return:
     * @author: xjl
     */
    public AthenaException(String msg, Throwable e) {
        super(msg, e);
        this.message = msg;
    }

    /**
     * @description RRException 构造函数
     * @param: msg
     * @param: code
     * @date: 2022/7/27 22:03
     * @return:
     * @author: xjl
     */
    public AthenaException(String msg, int code) {
        super(msg);
        this.message = msg;
        this.code = code;
    }

    /**
     * @description RRException 构造函数
     * @param: msg
     * @param: code
     * @param: e
     * @date: 2022/7/27 22:03
     * @return:
     * @author: xjl
     */
    public AthenaException(String msg, int code, Throwable e) {
        super(msg, e);
        this.message = msg;
        this.code = code;
    }
}
