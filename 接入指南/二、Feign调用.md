# 二、Feign调用

所有对外提供的接口必须通过实现类提供出去

## 服务提供者

### 先在**ipcdp-framework-api**项目中创建对外提供的接口

```java
package com.jintu.ipcdp.framework.api.producer;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/4/26.
 * @Modified By:
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_DEMO_PRODUCER,path = "producer/user",fallback = ProducerApiFallback.class)
public interface ProducerApi {

    @GetMapping("{userName}/{age}")
    CommonResponseResult<UserExt> saveUserName(@PathVariable("userName") String userName,@PathVariable("age") Integer age);
}

```

### 实现接口的**fallback**

```java
package com.jintu.ipcdp.framework.api.producer.fallback;

/**
 * @author 王金海
 * @Title: ProducerApiFallback
 * @ProjectName ipcdp
 * @Description: TODO
 * @date 2019/4/272:07
 */
@Component
public class ProducerApiFallback implements ProducerApi {
    @Override
    public CommonResponseResult<UserExt> saveUserName(String userName,Integer age) {
        return CommonResponseResult.SERVER_ANOMALY();
    }
}

```

### 在自己创建的项目中实现上述接口

```java
package com.jintu.demo.controller;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/4/26.
 * @Modified By:
 */
@Api(tags = "服务提供者")
@RestController
@RequestMapping("user")
public class ProducerController implements ProducerApi {

    @Autowired
    private UserService userService;

    @ApiOperation("保存用户")
    @Override
    public CommonResponseResult<UserExt> saveUserName(String userName,Integer age) {
       UserExt userExt=new UserExt();
        userExt.setUserName(userName);
        userExt.setUserAge(age);
        User save = userService.save(userExt);
        BeanUtils.copyProperties(save,userExt);
        return new CommonResponseResult<>(userExt);
    }
}

```

## 服务消费者

同上：

先在**ipcdp-framework-api**项目中创建对外提供的接口

在自己创建的项目中实现上述接口

### 引入依赖

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>com.jintu</groupId>
    <artifactId>ipcdp-framework-api</artifactId>
    <version>${project.version}</version>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

```



**重点**

```java
package com.jintu.demo.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.jintu.demo.dao.OrderDao;
import com.jintu.ipcdp.framework.api.producer.ProducerApi;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.consumer.Order;
import com.jintu.ipcdp.framework.model.consumer.req.OrderReq;
import com.jintu.ipcdp.framework.model.consumer.resp.OrderResp;
import com.jintu.ipcdp.framework.model.producer.ext.UserExt;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/5/5.
 * @Modified By:
 */
@Service
public class OrderService {

    //在消费者的service直接注入生产者提供的接口
    @Autowired
    private ProducerApi producerApi;

    @Autowired
    private OrderDao orderDao;

    @LcnTransaction
    @Transactional
    public OrderResp saveOrder(OrderReq orderReq){
        Order order = new Order();
        BeanUtils.copyProperties(orderReq,order);
        CommonResponseResult<UserExt> userExtCommonResponseResult = producerApi.saveUserName(orderReq.getUserName(), orderReq.getUserAge());
        if (!userExtCommonResponseResult.isSuccess()) {
            ExceptionCast.cast("订单添加失败");
        }
        Long userId = userExtCommonResponseResult.getT().getUserId();
        order.setUserId(userId);
        Order saveOrder = orderDao.save(order);
        OrderResp orderResp = new OrderResp();
        BeanUtils.copyProperties(userExtCommonResponseResult.getT(),orderResp);
        orderResp.setOrderId(saveOrder.getOrderId());
        orderResp.setOrderMoney(saveOrder.getOrderMoney());
        int i=1/orderReq.getOrderMoney();
        return orderResp;
    }
}

```



