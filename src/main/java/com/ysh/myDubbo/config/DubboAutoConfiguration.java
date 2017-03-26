package com.ysh.myDubbo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;


@Configuration
@EnableConfigurationProperties(DubboProperties.class)
@ConditionalOnClass({AnnotationBean.class,ApplicationConfig.class,ProtocolConfig.class,RegistryConfig.class})
public class DubboAutoConfiguration {

	@Autowired
	private DubboProperties prop;
	
	@Bean
	@ConditionalOnMissingBean(AnnotationBean.class)//if the container have not this class, then set in this class
	public static AnnotationBean annotationBean(@Value("${dubbo.packageName}")String packageName) {
	    AnnotationBean annotationBean = new AnnotationBean();
	    annotationBean.setPackage(packageName);
	    return annotationBean;
	}

	@Bean
	@ConditionalOnMissingBean(ApplicationConfig.class)//if the container have not this class, then set in this class
	public ApplicationConfig applicationConfig() {
	    ApplicationConfig applicationConfig = new ApplicationConfig();
	    applicationConfig.setName(prop.getApplication().getName());
	    return applicationConfig;
	}

	@Bean
	@ConditionalOnMissingBean(ProtocolConfig.class)//if the container have not this class, then set in this class
	public ProtocolConfig protocolConfig() {
	    ProtocolConfig protocolConfig = new ProtocolConfig();
	    protocolConfig.setName(prop.getProtocol().getName());
	    protocolConfig.setPort(prop.getProtocol().getPort());
	    return protocolConfig;
	}

	@Bean
	@ConditionalOnMissingBean(RegistryConfig.class)//if the container have not this class, then set in this class
	public RegistryConfig registryConfig() {
	    RegistryConfig registryConfig = new RegistryConfig();
	    registryConfig.setAddress(prop.getRegistry().getAddress());
	    return registryConfig;
	}
	
}
