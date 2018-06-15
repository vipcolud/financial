package com.do1.manager.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.do1.api.events.ProductStatusEvent;
import com.do1.entity.enums.ProductStatus;

/**
 * 管理产品状态
 */
@Component
public class ProductStatusManager {
    static  final String MQ_DESTINATION = "VirtualTopic.PRODUCT_STATUS";
    static Logger LOG = LoggerFactory.getLogger(ProductStatusManager.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void changeStatus(String id, ProductStatus status){
        ProductStatusEvent event = new ProductStatusEvent(id,status);
        LOG.info("发送消息:{}",event);
        jmsTemplate.convertAndSend(MQ_DESTINATION,event);
    }
    
    //@PostConstruct   初始化执行
    public void init(){
    	
       changeStatus("001",ProductStatus.IN_SELL);
    }
}

