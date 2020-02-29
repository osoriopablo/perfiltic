package com.perfiltic.test.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * DozerConfig
 */
@Configuration
public class DozerConfig {

    @Bean
	public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(
			@Value("classpath*:dozer/*-mapping.xml") Resource[] resources) throws Exception {
		final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
		dozerBeanMapperFactoryBean.setMappingFiles(resources);
		return dozerBeanMapperFactoryBean;
	}
}