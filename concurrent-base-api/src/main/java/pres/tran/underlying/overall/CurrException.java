package pres.tran.underlying.overall;

import lombok.Data;
import lombok.Getter;

/**
 * 系统自定义异常
 */
@Getter
public class CurrException extends RuntimeException{

    private ErrorResultDTO errorResultDTO;

    public CurrException(ErrorResultDTO errorResultDTO){
        super();
        this.errorResultDTO = errorResultDTO;
    }

}
