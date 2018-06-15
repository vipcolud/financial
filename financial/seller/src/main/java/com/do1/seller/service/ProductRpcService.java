package com.do1.seller.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.do1.api.ProductRpc;
import com.do1.api.domain.ProductRpcReq;
import com.do1.api.events.ProductStatusEvent;
import com.do1.entity.Product;
import com.do1.entity.enums.ProductStatus;
/**
 * 产品相关服务
 */
@Service
public class ProductRpcService implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger LOG = LoggerFactory.getLogger(ProductRpcService.class);

    static final String MQ_DESTINATION = "Consumer.cache.VirtualTopic.PRODUCT_STATUS";

    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private ProductCache productCache;

    /**
     * 查询全部产品
     *
     * @return
     */
    public List<Product> findAll() {
        return productCache.readAllCache();
    }

    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    public Product findOne(String id) {
        Product product = productCache.readCache(id);
        if (product == null) {
            productCache.removeCache(id);
        }
        return product;
    }

    //@PostConstruct
    public void init() {
        findAll();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<Product> products = findAll();
        products.forEach(product -> {
            productCache.putCache(product);
        });
    }

   @JmsListener(destination = MQ_DESTINATION)
    void updateCache(ProductStatusEvent event) {
        LOG.info("收到消息:{}", event);
        productCache.removeCache(event.getId());
        if (ProductStatus.IN_SELL.equals(event.getStatus())) {
            productCache.readCache(event.getId());
        }
    }
}
