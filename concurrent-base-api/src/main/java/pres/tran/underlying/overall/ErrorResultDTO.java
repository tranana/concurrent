package pres.tran.underlying.overall;

import lombok.Data;

@Data
public class ErrorResultDTO {
    /**
     * 异常
     */
    private String error;

    /**
     * 提示信息
     */
    private  CurrResultDTO currResultDTO;


}
