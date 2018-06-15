package com.do1.api;

import java.util.List;

import com.do1.api.domain.ParamInf;
import com.do1.api.domain.ProductRpcReq;
import com.do1.entity.Product;
import com.googlecode.jsonrpc4j.JsonRpcService;

/**
 * 产品相关的rpc服务
 * 接口不能以/开始
 */
@JsonRpcService("rpc/products")
public interface ProductRpc {
    /**
     * 查询多个产品
     *
     * @param req
     * @return
     */
    List<Product> query(ProductRpcReq req);

    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    Product findOne(String id);
}
