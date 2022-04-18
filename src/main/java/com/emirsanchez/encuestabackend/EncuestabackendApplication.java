package com.emirsanchez.encuestabackend;

import com.emirsanchez.encuestabackend.security.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@Slf4j
public class EncuestabackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncuestabackendApplication.class, args);
        log.info("FUNCIONANDO!!");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();

    }

    @Bean(name = "AppProperties")
    public AppProperties getAppProperties() {

        return new AppProperties();

    }

}
