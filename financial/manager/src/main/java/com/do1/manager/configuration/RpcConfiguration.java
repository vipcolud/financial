package com.do1.manager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;

/**
 * rpc相关配置
 * @author MrChen
 *
 */
@Configuration
public class RpcConfiguration {
	
	@Bean
	public AutoJsonRpcServiceImplExporter rpcServiceImplExporter(){
		return new AutoJsonRpcServiceImplExporter();
		
	}

}
