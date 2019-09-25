package cn.edu.mju.enums;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/25
 */
public interface BaseEnum {

    int getStatus();

    String getDesc();

    /**
     * 根据status获取Enum实例
     * @param status
     * @param clazz
     * @param <T>
     * @return
     */
    default <T extends BaseEnum> T statusOfEnum(int status,Class<T> clazz){

        for (T item:clazz.getEnumConstants()){

            if(item.getStatus()==status){
                return item;
            }

        }

        return null;
    }

}
