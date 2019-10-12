package cn.edu.mju.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {

    private Integer pages;

    private Integer pageSize;

    private Integer current;

    private Integer total;

    private Object data;



}
