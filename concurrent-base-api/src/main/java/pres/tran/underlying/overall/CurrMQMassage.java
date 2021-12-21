package pres.tran.underlying.overall;

import lombok.Data;

/**
 * 消息的格式
 */
@Data
public class CurrMQMassage<T> {

    /**
     * 消息ID
     */
    private String massageId;


    /**
     * 消息状态
     */
    private String state;

    /**
     * 消息内容 String
     */
    private T massage;

    /**
     * 构造函数
     * @param massageId
     * @param state
     * @param massage
     */
    public CurrMQMassage(String massageId, String state, T massage) {
        this.massageId = massageId;
        this.state = state;
        this.massage = massage;
    }

}
