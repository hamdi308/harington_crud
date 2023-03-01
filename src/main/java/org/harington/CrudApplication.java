package org.harington;

import org.harington.config.CrudAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CrudAppConfig.class)
public class CrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class,args);
    }}