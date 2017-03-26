package com.ysh.dubbox.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.dubbox.consumer.service.impl.RefService;

@RestController
public class HelloController {

	@Autowired
	private RefService refService;

	@RequestMapping("/say")
	public String sayHello(String name) {
		return refService.sayHello(name);
	}

}
