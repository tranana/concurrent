package pres.tran.underlying.seconds.dto;

import lombok.Data;

@Data
public class UserResultDTO {

    /**
     * 名称
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态
     */
    private String start;

    /**
     * 头像
     */
    private String userHead;

    /**
     * token 用于刷新redis中的token
     */
    private String token;
}
