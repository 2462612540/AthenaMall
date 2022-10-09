package com.zhuangxiaoyan.athena.secondskill.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.zhuangxiaoyan.athena.secondskill.constant.ErrorCode;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 自定义阻塞返回方法
 * @param: null
 * @date: 2022/10/8 22:02
 * @return:
 * @author: xjl
 */

@Configuration
public class AthenaSentinelConfig {
    //构造方法
    public AthenaSentinelConfig() {
        WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
            @Override
            public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
                Result error = Result.error(ErrorCode.TO_MANY_REQUEST.getCode(), ErrorCode.TO_MANY_REQUEST.getMessage());
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().write(JSON.toJSONString(error));
            }
        });
    }
}
