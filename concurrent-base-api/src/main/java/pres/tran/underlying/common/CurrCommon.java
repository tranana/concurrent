package pres.tran.underlying.common;

/**
 * 常量
 */
public class CurrCommon {

    /**************系统常量**************/


    /**
     * yes
     */
    public static final String CURR_YES = "0";

    /**
     * no
     */
    public static final String CURR_NO = "1";


    /**
     * SALT
     */
    public static final String SALT = "tran";

    /**************Redis模块命名**************/

    /**
     * SALT
     */
    public static final String TOKEN_PR = "USER:";

    /**************RabbitMQ队列**************/

    /**
     * 处理发送消息的队列
     */
    public static final String CURR_QUEUE_MESSAGE = "curr.top.message.qe";

    /**
     * 处理发送消息的队列--死信
     */
    public static final String CURR_QUEUE_MESSAGE_DE = "curr.top.message.de";

    /**
     * 处理发送消息的队列--交换机
     */
    public static final String CURR_QUEUE_MESSAGE_KE = "curr.top.message.ke";



}
