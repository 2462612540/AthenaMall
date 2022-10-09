# Athena系统子微服务设计

# 摘要
该章节将介绍athena系统中的子系统设计。对微服务的微服务的概要设计，其中包括了E-R图，微服务的依赖。微服务的接口的定义。
对微服务的的详细的设计，对微服务的部署说明。帮助大家更好学习和了解微服务的设计。

# 1、前端服务

服务启动
> - npm config set registry http://registry.npm.taobao.org/
> - npm run dev

![img.png](images/Athena前端服务设计/vue-dev.png)

解决方案：

由于的语法的检查有太严格，导致的运行的检查错误。


![img.png](images/Athena业务服务设计/athena-admin-login.png)


- 部署端口：9009


# 2、商品服务

服务启动

![img.png](images/Athena的微服务治理设计/MicroService.png)

商品服务的查询与三级分类功能实现

![img.png](images/Athena的搜索系统设计/commodity_search.png)

![img.png](images/Athena业务服务设计/商品的三级分类结果.png)

![img.png](images/Athena业务服务设计/商品的三级分类前端有问题.png)

![img.png](images/Athena业务服务设计/后端的数据的传递的有问题.png)

![img.png](images/Athena业务服务设计/商品的三级分类的功能完成.png)

![img.png](images/Athena业务服务设计/商品的属性分组.png)


商品的品牌管理

![img.png](images/Athena业务服务设计/商品的品牌管理.png)

![img.png](images/Athena业务服务设计/品牌管理的分页查询.png)

前后端参数检验

![img.png](images/Athena业务服务设计/异常校验.png)

![img.png](images/Athena业务服务设计/自定义的异常.png)

![img.png](images/Athena业务服务设计/分组校验.png)


![img.png](images/Athena业务服务设计/商品的属性分组有bug.png)

商品管理的模糊查询

![img.png](images/Athena业务服务设计/商品管理的模糊查询.png)

![img.png](images/Athena业务服务设计/关联分类功能.png)

商品屬性查詢

![img.png](images/Athena业务服务设计/商品屬性查詢.png)


# 3、支付服务

# 4、优惠服务

服务启动

![img.png](images/Athena的微服务治理设计/MicroService.png)

# 5、促销服务

# 6、财务服务

# 7、用户服务

# 8、仓储服务

服务启动

![img.png](images/Athena的微服务治理设计/MicroService.png)

# 9、秒杀服务

# 10、订单服务

服务启动

![img.png](images/Athena的微服务治理设计/MicroService.png)

# 11、检索服务

# 12、鉴权服务

# 13、购物车服务

# 14、推荐服务

# 15、后台管理系统

## 15.1 athena-admin概要设计


## 15.2 athena-admin详细设计


## 15.3 athena-admin生产部署环境


服务启动

- 部署端口：9000

![img.png](images/Athena业务服务设计/athena-admin.png)

注册到nacos

![img.png](images/Athena业务服务设计/athena-admin-naocs.png)

![img.png](images/Athena前端服务设计/admin-vue.jpg)

![img.png](images/Athena业务服务设计/admi-success.png)

# 16、直播服务

# 17、评论服务

# 18、仓储服务

# 19、调度服务

# 20、客服服务

# 21、物流服务

# 22、微服务的注册与配置中心

服务启动

```shell
docker restart 6c0e160aafa1
```

![img.png](images/Athena的微服务治理设计/nacos.png)

远程调用服务

![img.png](images/Athena的微服务治理设计/远程调用服务启动.png)

![img.png](images/Athena的微服务治理设计/远程调用.png)

配置中心

![img_1.png](images/Athena的微服务治理设计/nacos-dev.png)


# 23、会员服务

服务启动

![img.png](images/Athena的微服务治理设计/MicroService.png)

![img.png](images/Athena业务服务设计/会员服务查询.png)

![img.png](images/Athena业务服务设计/会员服务等级查询.png)


# 24、网关服务

![img.png](images/Athena的微服务治理设计/Springcloud-getway.png)

请求的转发

![img.png](images/Athena业务服务设计/服务请求转发.png)

# 25、OSS对象存储服务

![img.png](images/Athena的存储系统设计/aliyun-oss.png)

![img.png](images/Athena的存储系统设计/athena-oss测试成功.png)

![img.png](images/Athena的微服务治理设计/网关转发成功.png)

![img.png](images/Athena前端服务设计/oss错误.png)

需要在的你自己的OSS中设置允许跨域的方式。 


![img.png](images/Athena业务服务设计/表单校验.png)

统一的异常处理

分组校验的功能



# 博文参考