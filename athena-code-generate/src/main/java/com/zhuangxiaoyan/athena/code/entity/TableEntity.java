package com.zhuangxiaoyan.athena.code.entity;

import lombok.Data;

import java.util.List;

/**
 * @description 表数据
  * @param: null
 * @date: 2022/7/29 11:56
 * @return:
 * @author: xjl
*/
@Data
public class TableEntity {

    /**
     * 表的名称
    */
    private String tableName;

    /**
     * 表的备注
     */
    private String comments;

    /**
     * 表的主键
     */
    private ColumnEntity pk;

    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnEntity> columns;

    /**
     * 类名(第一个字母大写)，如：sys_user => SysUser
     */
    private String className;

    /**
     * 类名(第一个字母小写)，如：sys_user => sysUser
     */
    private String classname;
}
