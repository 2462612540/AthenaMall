package com.zhuangxiaoyan.athena.secondskill.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description TODO 
  * @param: null
 * @date: 2022/10/7 17:03
 * @return: 
 * @author: xjl
*/

@Data
public class SeckillSessionWithSkusVo {

    private Long id;
    /**
     * 场次名称
     */
    private String name;
    /**
     * 每日开始时间
     */
    private Date startTime;
    /**
     * 每日结束时间
     */
    private Date endTime;
    /**
     * 启用状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

    private List<SeckillSkuVo> relationSkus;

}
