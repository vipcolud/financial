package com.do1.seller.configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.do1.api.ProductRpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcClientProxyCreator;

/**
 * rpc相关配置
 * @author MrChen
 *
 */
@Configuration
@ComponentScan(basePackageClasses ={ProductRpc.class})
public class RpcConfiguration {
	private static Logger LOG = LoggerFactory.getLogger(RpcConfiguration.class);
	
    @Bean
    public AutoJsonRpcClientProxyCreator rpcClientProxyCreator(@Value("${rpc.manager.url}") String url) {
        AutoJsonRpcClientProxyCreator creator = new AutoJsonRpcClientProxyCreator();
        try {
            creator.setBaseUrl(new URL(url));
        } catch (MalformedURLException e) {
            LOG.error("创建rpc服务地址错误", e);
        }
        creator.setScanPackage(ProductRpc.class.getPackage().getName());
        return creator;
    }
	

}
