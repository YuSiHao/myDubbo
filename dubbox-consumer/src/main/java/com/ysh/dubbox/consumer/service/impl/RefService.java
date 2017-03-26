package com.ysh.dubbox.consumer.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ysh.dubbox.provide.service.BaseService;

@Service("refService")
public class RefService {
	
	@Reference(group="helloServiceImpl", version="1.0")
	private BaseService baseService;
	
	public String sayHello(String name){
		return baseService.build(name);
	}
	
}
