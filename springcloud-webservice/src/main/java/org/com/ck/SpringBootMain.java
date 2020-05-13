package org.com.ck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 
 * 
 * @author zhuqun
 * @date 2020年1月15日 - 下午3:02:43
 * @history
 *          2020年1月15日 - 下午3:02:43 zhuqun create.
 */
@SpringBootApplication
public class SpringBootMain {
    public static void main(final String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}
