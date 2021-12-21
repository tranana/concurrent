package pres.tran.underlying.overall;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrResultDTO<T>  extends ResultDTO {


    /**
     * 信息
     */
    private T data;


    // 全局码 5002XX --- 5003XX 用户信息
    public static ResultDTO SECONDS_LOGIN = ResultDTO.ok(500210,"请重新登录");
    public static ResultDTO SECONDS_LOGIN_SUCCEED = ResultDTO.ok(500200,"登录成功");
    public static ResultDTO SECONDS_LOGIN_ERROR = ResultDTO.ok(500201,"用户名密码错误");
    public static ResultDTO SECONDS_LOGIN_DATE = ResultDTO.ok(500202,"请输入用户名密码");
    public static ResultDTO SECONDS_LOGIN_SIGN = ResultDTO.ok(500203,"请先进行注册");
    public static ResultDTO SECONDS_SIGN_SUCCEED = ResultDTO.ok(500300,"注册成功");
    public static ResultDTO SECONDS_SIGN_DATE = ResultDTO.ok(500301,"缺少信息");
    public static ResultDTO SECONDS_SIGN_PHONE = ResultDTO.ok(500302,"手机号格式不正确");
    public static CurrResultDTO SECONDS_USER_INFO = new CurrResultDTO(500302,"获取成功");

    public CurrResultDTO(Integer code, String info) {
        super(code, info);
    }

    public CurrResultDTO(Integer code, String info,T data) {
        super(code, info);
        this.data = data;
    }

}
