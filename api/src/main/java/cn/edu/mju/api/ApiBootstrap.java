package cn.edu.mju.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ApiBootstrap {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ApiBootstrap.class).run(args);

    }

}
