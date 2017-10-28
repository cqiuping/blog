/*   
 * Copyright (c) 2017年10月25日 by XuanWu Wireless Technology Co., Ltd 
 *             All rights reserved  
 */
package com.boot.test.demo.service;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:chengqiuping@wxchina.com ">qiuping.Cheng</a>
 * @Description
 * @Date 2017/10/25
 * @Version 1.0.0
 */
@Component
public class OnApplicationETest implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LogManager.getLogger(OnApplicationETest.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            logger.info("applicationContext是:{}" , contextRefreshedEvent.getApplicationContext().getDisplayName());
            logger.info("applicationContext booted ...");
        }

    }
}
