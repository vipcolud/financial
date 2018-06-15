package com.do1.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.do1.entity.Order;
import com.do1.seller.params.OrderParam;
import com.do1.seller.service.OrderService;

/**
 * 订单相关
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 下单
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public Order apply(@RequestHeader String authId,@RequestHeader String sign, @RequestBody OrderParam param) {
        LOG.info("申购请求:{}", param);
        Order order = new Order();
        BeanUtils.copyProperties(param,order);
        order = orderService.apply(order);
        LOG.info("申购结果:{}", order);
        return order;
    }
}
