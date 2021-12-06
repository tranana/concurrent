package pres.tran.underlying.overall;


import lombok.Getter;

/**
 * 系统自定义异常
 */
@Getter
public class CurrException extends RuntimeException{

    /**
     * 异常信息
     */
    private final ResultDTO resultDTO;

    public CurrException(ResultDTO resultDTO){
        super();
        this.resultDTO = resultDTO;
    }
}
