package pres.tran.underlying.overall;

import lombok.Getter;

@Getter
public class ErrorResultDTO<T> extends ResultDTO{



    /**
     * 异常信息
     */
    private T errorInfo;


    // 全局异常处理
    public static ResultDTO SECONDS_ERROR = ErrorResultDTO.error(100000,"系统错误，请联系管理员");


    public ErrorResultDTO(Integer code, String resMsg, Integer start) {
        super(code,resMsg,start);
    }

    public ErrorResultDTO(Integer code, String info,T errorInfo ) {
        super(code, info);
        this.errorInfo = errorInfo;
    }

}
