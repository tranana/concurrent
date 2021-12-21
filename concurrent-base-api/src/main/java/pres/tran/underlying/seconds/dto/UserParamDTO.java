package pres.tran.underlying.seconds.dto;

import lombok.Data;

@Data
public class UserParamDTO {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 呢称
     */
    private String name;

    /**
     * 头像
     */
    private String userHead;

}
