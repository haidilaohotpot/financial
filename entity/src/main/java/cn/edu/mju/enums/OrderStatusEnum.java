package cn.edu.mju.enums;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/25
 */
public enum  OrderStatusEnum implements BaseEnum {
    INIT(21,"初始化"),
    PROCESS(22,"处理中"),
    SUCCESS(23,"成功"),
    FAIL(24,"失败");

    private int status;

    private String desc;


    OrderStatusEnum(int status, String desc) {
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
