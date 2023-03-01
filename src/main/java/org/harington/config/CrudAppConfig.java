package org.harington.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "org.harington")
@EnableJpaRepositories(basePackages = {"org.harington.repository"})
public class CrudAppConfig {
}
