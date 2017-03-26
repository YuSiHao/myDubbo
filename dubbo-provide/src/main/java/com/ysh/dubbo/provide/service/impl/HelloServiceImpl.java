package com.ysh.dubbo.provide.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ysh.dubbo.provide.service.BaseService;

@Service(group="helloServiceImpl", version="1.0")
public class HelloServiceImpl implements BaseService {

	public String build(String str) {
		return "hello "+str+" !";
	}

}