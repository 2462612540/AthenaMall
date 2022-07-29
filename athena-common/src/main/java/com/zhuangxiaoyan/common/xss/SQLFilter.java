/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.zhuangxiaoyan.common.xss;

import com.zhuangxiaoyan.common.utils.AthenaException;
import org.apache.commons.lang.StringUtils;

/**
 * @description SQL过滤
 * @date: 2022/3/19 18:38
 * @author: xjl
 */
public class SQLFilter {

    /**
     * @description sqlInject(String str)
     * @param: str
     * @date: 2022/7/27 22:11
     * @return: java.lang.String
     * @author: xjl
     */
    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        // 去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");
        // 转换成小写
        str = str.toLowerCase();
        // 非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};
        // 判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                throw new AthenaException("包含非法字符");
            }
        }
        return str;
    }
}
