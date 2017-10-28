package com.boot.test.demo;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class DemoApplication {
	private static final Logger logger = LogManager.getLogger(DemoApplication.class);

	static{
		String log4jPath = DemoApplication.class.getClassLoader().getResource("").getPath() + "log4j.properties";
		logger.warn("log4jPath:" + log4jPath);
//		PropertyConfigurator.configure();
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		logger.debug("main 方法执行...");
	}
}
