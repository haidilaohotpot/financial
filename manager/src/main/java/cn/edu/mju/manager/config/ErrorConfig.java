package cn.edu.mju.manager.config;

import cn.edu.mju.manager.controller.BaseErrorController;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 错误请求处理
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/9
 */
@Configuration
public class ErrorConfig {


    @Bean
    public BaseErrorController basicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties,
                                                    ObjectProvider<List<ErrorViewResolver>> errorViewResolverProvider) {

        return new BaseErrorController(errorAttributes, serverProperties.getError(),
                errorViewResolverProvider.getIfAvailable());


    }


}
