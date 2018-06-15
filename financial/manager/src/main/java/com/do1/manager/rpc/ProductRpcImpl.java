package com.do1.manager.rpc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.do1.api.ProductRpc;
import com.do1.api.domain.ParamInf;
import com.do1.api.domain.ProductRpcReq;
import com.do1.entity.Product;
import com.do1.manager.service.ProductService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

/**
 * rpc服务实现类
 */

@AutoJsonRpcServiceImpl
@Service
public class ProductRpcImpl implements ProductRpc {
    private static Logger LOG = LoggerFactory.getLogger(ProductRpcImpl.class);

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> query(ProductRpcReq req) {
        LOG.info("查询多个产品,请求:{}", req);
        
        Pageable pageable = new PageRequest(0,1000,Sort.Direction.DESC,"rewardRate");
        Page<Product> result = productService.query(req.getIdList(), req.getMinRewardRate(), req.getMaxRewardRate(), req.getStatusList(), pageable);
        LOG.info("查询多个产品,结果:{}", result);
        return result.getContent();
    }

    @Override
    public Product findOne(String id) {
    	Assert.notNull(id, "需要产品编号参数");
        LOG.info("查询产品详情,请求:{}", id);
        Product result = productService.findOne(id);
        LOG.info("查询产品详情,结果:{}", result);
        return result;
    }

	
}
