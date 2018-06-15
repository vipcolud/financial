package com.do1.seller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.do1.entity.Product;
import com.do1.seller.service.ProductRpcService;

/**
 * 产品相关
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRpcService productRpcService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findOne(@PathVariable String id){
        return productRpcService.findOne(id);
    }
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Product> findAll(){
        return productRpcService.findAll();
    }
}

