package org.example.forum.Config;

import org.example.forum.Service.PrototypeHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public PrototypeHelper prototypeHelper() {
        return new PrototypeHelper();
    }
}
