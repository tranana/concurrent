package pres.tran.underlying.tranconfig.allerror;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import pres.tran.underlying.overall.CurrException;
import pres.tran.underlying.overall.CurrResultDTO;
import pres.tran.underlying.overall.ErrorResultDTO;
import pres.tran.underlying.overall.ResultDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * 对全局异常做处理
 */
@ControllerAdvice
@ResponseBody
public class CurrExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultDTO exceptionHandler(HttpServletRequest request, Exception e){
        ResultDTO resultDTO = null;
        // 如果他是自定义的系统异常
        if (e instanceof CurrException){
            resultDTO = ((CurrException) e).getResultDTO();
        }else {
            // 打印异常
            e.printStackTrace();
            resultDTO = ErrorResultDTO.SECONDS_ERROR;
        }
        return resultDTO;
    }

}
