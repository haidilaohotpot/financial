package cn.edu.mju.swagger;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/12
 */
@Data
@Component
public class SwaggerInfo {

    private String groupName = "controller";

    private String basePackage;

    private String antPath;

    private String title = "HTTP API";

    private String description = "管理端接口";

    private String license = "Apache License Version 2.0";




}
