package com.zhuangxiaoyan.athena.code.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @description MongoCondition
 * @date: 2022/7/29 12:26
 * @author: xjl
 */
public class MongoCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String database = context.getEnvironment().getProperty("athena.database");
        return "mongodb".equalsIgnoreCase(database);
    }
}