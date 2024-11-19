/*package com.aviation.core;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
*/
package com.aviation.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
//@EnableJpaRepositories(basePackages = "com.aviation.repository")
public class FlightConfiguration {
//может быть пустой,если я всё сделала авто в application.properties
}