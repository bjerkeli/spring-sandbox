package com.proteuz.sandbox.spring;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BogusConfig.class)
public class ConfigTest {
    @Resource
    private ServiceB serviceB;

    @Test
    public void verifyConfig() {
        assertThat(serviceB, IsNull.notNullValue());
    }
}
