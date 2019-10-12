package cn.edu.mju.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/12
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private SwaggerInfo swaggerInfo;

    @Bean
    public Docket controllerApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerInfo.getGroupName())
                .apiInfo(apiInfo())
                .select()
                .build();

    }


    private ApiInfo apiInfo() {

        return new ApiInfo(swaggerInfo.getTitle(),swaggerInfo.getDescription(),"2.0","http://springfox.io","mju",swaggerInfo.getLicense(),"https://github.com/springfox/springfox");

    }


}
