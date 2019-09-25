package cn.edu.mju.enums;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/25
 */
public enum OrderTypeEnum implements BaseEnum {

    APPLY(11,"申购"),
    REDEEM(12,"赎回");

    private int status;

    private String desc;

    OrderTypeEnum(int status, String desc) {
        this.desc = desc;
        this.status = status;
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
