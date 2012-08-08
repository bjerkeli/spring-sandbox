package com.proteuz.sandbox.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkNotNull;

@Configuration
@ComponentScan("no.bbs.anvisning.config")
public class BogusConfig {
    @Resource
    private ServiceA serviceA;

    @Value("${somePlaceholder:jalla}")
    private String someValue;

    @Bean
    public ServiceB serviceB() {
        checkNotNull(someValue, "Value 'someValue' has not been set, this was unexpected, for me at least....");
        checkNotNull(serviceA);
        return new ServiceB();
    }

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws Exception {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
        configurer.setLocalOverride(true);
        return configurer;
    }
}
