package org.harington;

import org.harington.config.CrudAppConfig;
//import org.harington.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Import({CrudAppConfig.class})
@EnableAutoConfiguration
//@EnableSwagger2
public class CrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class,args);
    }}