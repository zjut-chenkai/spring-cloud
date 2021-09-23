package org.com.ck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class SpringBootMain {
    public static void main(final String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}
