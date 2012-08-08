package com.proteuz.sandbox.spring;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ServiceA {
    @Resource
    private ServiceB serviceB;
}
