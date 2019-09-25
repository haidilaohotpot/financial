package cn.edu.mju.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FinancialApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FinancialApplication.class).run(args);

    }

}
