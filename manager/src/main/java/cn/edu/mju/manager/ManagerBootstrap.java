package cn.edu.mju.manager;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/8
 */

@SpringBootApplication(scanBasePackages = "cn.edu.mju")
public class ManagerBootstrap {


    public static void main(String[] args) {


        new SpringApplicationBuilder(ManagerBootstrap.class).run(args);

    }


}
