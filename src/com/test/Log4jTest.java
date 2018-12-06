package com.test;

import org.apache.log4j.Logger;

public class Log4jTest {

	public static void main(String[] args) {
		Logger logger=Logger.getLogger(Log4jTest.class);
		logger.info("log4j写入测试!");
		// 通过key获取指定的系统变量
		System.out.println(System.getProperty("user.dir"));
		// 获取所有的系统变量 (不包括隐藏的)
		System.out.println(System.getProperties());
	}
}
