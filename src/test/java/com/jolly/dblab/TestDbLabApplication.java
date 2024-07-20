package com.jolly.dblab;

import org.springframework.boot.SpringApplication;

public class TestDbLabApplication {

    public static void main(String[] args) {
        SpringApplication.from(DbLabApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
