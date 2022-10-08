package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SeckillSessionEntity;
import com.zhuangxiaoyan.athena.coupon.service.SeckillSessionService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description 秒杀活动场次
 * @date: 2022/7/28 15:41
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/seckillsession")
public class SeckillSessionController {

    @Autowired
    private SeckillSessionService seckillSessionService;

    /**
     * @description 查询的最近三天的活动
      * @param:
     * @date: 2022/10/7 19:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @GetMapping(value = "/Lates3DaySession")
    public Result getLates3DaySession(){
        List<SeckillSessionEntity> sessionEntities=seckillSessionService.getLates3DaySession();
        return Result.ok().setData(sessionEntities);
    }


    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 15:41
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillsession:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = seckillSessionService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 15:41
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillsession:info")
    public Result info(@PathVariable("id") Long id) {
        SeckillSessionEntity seckillSession = seckillSessionService.getById(id);
        return Result.ok().put("seckillSession", seckillSession);
    }

    /**
     * @description 保存数据
     * @param: seckillSession
     * @date: 2022/7/28 15:42
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillsession:save")
    public Result save(@RequestBody SeckillSessionEntity seckillSession) {
        seckillSessionService.save(seckillSession);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: seckillSession
     * @date: 2022/7/28 15:42
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:seckillsession:update")
    public Result update(@RequestBody SeckillSessionEntity seckillSession) {
        seckillSessionService.updateById(seckillSession);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:42
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillsession:delete")
    public Result delete(@RequestBody Long[] ids) {
        seckillSessionService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
