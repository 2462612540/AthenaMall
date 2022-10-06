package com.zhuangxiaoyan.athena.product.vo;

import com.zhuangxiaoyan.athena.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

/**
 * @description AttrGroupWithAttrsVo
 * @date: 2022/7/28 14:44
 * @author: xjl
*/

@Data
public class AttrGroupWithAttrsVo {

    /**
     * 分组id
     */
    private Long attrGroupId;

    /**
     * 组名
     */
    private String attrGroupName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 描述
     */
    private String descript;

    /**
     * 组图标
     */
    private String icon;

    /**
     * 所属分类id
     */
    private Long catelogId;

    /**
     * 所属分类属性
     */
    private List<AttrEntity> attrs;
}