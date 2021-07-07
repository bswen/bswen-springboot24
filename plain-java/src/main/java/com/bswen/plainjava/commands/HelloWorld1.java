package com.bswen.plainjava.commands;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * demo a simple java program that run in springboot app automatically.
 */
@Component
public class HelloWorld1 implements CommandLineRunner {
    private static Log log = LogFactory.getLog(HelloWorld1.class);

    public static void main(String[] args) {
        log.info("hello");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("run a test function here");
    }
}
