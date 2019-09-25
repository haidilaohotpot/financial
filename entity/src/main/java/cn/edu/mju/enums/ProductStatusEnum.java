package cn.edu.mju.enums;

import lombok.Data;

/**
 * 产品状态
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/25
 */
public enum ProductStatusEnum implements BaseEnum{

    AUDITING(1,"审核中"),
    IN_SELL(2,"销售中"),
    LOCKED(3,"暂停销售"),
    FINISHED(4,"已结束");

    private int status;

    private String desc;

    ProductStatusEnum(int status,String desc){
        this.status = status;
        this.desc = desc;
    }


    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
