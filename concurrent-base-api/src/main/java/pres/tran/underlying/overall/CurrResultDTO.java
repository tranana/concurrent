package pres.tran.underlying.overall;

import lombok.Getter;

@Getter
public class CurrResultDTO {


    /**
     * 提示 code
     */
    private Integer code;


    /**
     * 信息
     */
    private String info;

    // 全局错误码
    public static CurrResultDTO SECONDS_ERROR = new CurrResultDTO(500200,"系统错误，请联系管理员");
    public static CurrResultDTO SECONDS_LOGIN = new CurrResultDTO(500210,"请重新登录");

    public CurrResultDTO(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public CurrResultDTO fill(Object...param){
        this.code = code;
        String  info = String.format(this.info,param);
        return new CurrResultDTO(code,info);
    }

}
