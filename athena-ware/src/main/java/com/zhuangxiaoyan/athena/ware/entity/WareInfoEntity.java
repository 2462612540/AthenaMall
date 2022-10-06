package com.zhuangxiaoyan.athena.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 仓库信息
 * @date: 2022/7/30 23:57
 * @author: xjl
 */

@Data
@TableName("wms_ware_info")
public class WareInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 仓库名
     */
    private String name;
    /**
     * 仓库地址
     */
    private String address;
    /**
     * 区域编码
     */
    private String areacode;

}