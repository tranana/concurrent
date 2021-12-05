package pres.tran.underlying.tranconfig.allerror;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pres.tran.underlying.overall.CurrException;
import pres.tran.underlying.overall.CurrResultDTO;
import pres.tran.underlying.overall.ErrorResultDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * 对全局异常做处理
 */
@ControllerAdvice
@ResponseBody
public class CurrExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ErrorResultDTO exceptionHandler(HttpServletRequest request, Exception e){
        if (e instanceof CurrException){
            CurrException currException = (CurrException)e;
            return currException.getErrorResultDTO();
        }else {
            ErrorResultDTO resultDTO = new ErrorResultDTO();
            resultDTO.setCurrResultDTO(CurrResultDTO.SECONDS_ERROR);
            resultDTO.setError(e.getMessage());

            return resultDTO;
        }
    }


}
