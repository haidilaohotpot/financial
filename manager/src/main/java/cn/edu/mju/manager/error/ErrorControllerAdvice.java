package cn.edu.mju.manager.error;

import cn.edu.mju.manager.enums.ErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 统一错误处理
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/9
 */
@ControllerAdvice(basePackages = "cn.edu.mju.manager")
public class ErrorControllerAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleException(Exception e) {

        Map<String, Object> attrs = new HashMap<>();

        String errorCode = e.getMessage();

        ErrorEnum errorEnum = ErrorEnum.getByCode(errorCode);
        attrs.put("message", errorEnum.getMessage());
        attrs.put("code", errorEnum.getCode());
        attrs.put("canRetry", errorEnum.isCanRetry());
        return new ResponseEntity(attrs, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
