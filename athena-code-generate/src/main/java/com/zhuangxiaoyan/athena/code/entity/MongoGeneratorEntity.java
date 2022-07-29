package com.zhuangxiaoyan.athena.code.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description mysql一张表只需要一个表信息和列名信息,但是mongo一张表可能需要多个实体类  所以单独用一个bean封装
 * @date: 2022/7/29 12:03
 * @author: xjl
*/
@Data
public class MongoGeneratorEntity {

    /**
     * 表信息
    */
    private Map<String, String> tableInfo;

    /**
     * 主类的列名信息
     */
    private List<Map<String, String>> columns;

    public TableEntity toTableEntity() {
        TableEntity tableEntity = new TableEntity();
        Map<String, String> tableInfo = this.tableInfo;
        tableEntity.setTableName(tableInfo.get("tableName"));
        tableEntity.setComments("");
        return tableEntity;
    }
}
