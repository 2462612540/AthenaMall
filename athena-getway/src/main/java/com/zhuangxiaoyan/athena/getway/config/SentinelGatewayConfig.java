package com.zhuangxiaoyan.athena.getway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.fastjson.JSON;
import com.zhuangxiaoyan.athena.getway.constant.ErrorCode;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description TODO 
  * @param: null
 * @date: 2022/10/9 10:41
 * @return: 
 * @author: xjl
*/

@Configuration
public class SentinelGatewayConfig {

    public SentinelGatewayConfig() {
        GatewayCallbackManager.setBlockHandler(new BlockRequestHandler() {
            //网关限流了请求，就会调用此回调
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {
                Result error = Result.error(ErrorCode.TO_MANY_REQUEST.getCode(), ErrorCode.TO_MANY_REQUEST.getMessage());
                String errorJson = JSON.toJSONString(error);
                Mono<ServerResponse> body = ServerResponse.ok().body(Mono.just(errorJson), String.class);
                return body;
            }
        });
    }
}
