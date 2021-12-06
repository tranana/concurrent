package pres.tran.underlying.overall;

import lombok.Data;

@Data
public class ResultDTO {

    /**
     * 提示 code
     */
    private Integer code;

    /**
     * 信息
     */
    private String resMsg;

    /**
     * 状态
     */
    private Integer start;

    public ResultDTO(Integer code, String resMsg, Integer start) {
        this.code = code;
        this.resMsg = resMsg;
        this.start = start;
    }


    public ResultDTO(Integer code, String resMsg) {
        this.start = 0;
        this.code = code;
        this.resMsg = resMsg;
    }

    public static ResultDTO error(Integer code, String resMsg) {
        ResultDTO resultDTO = new ResultDTO(code,resMsg,1);
        return resultDTO;
    }

    public static ResultDTO ok(Integer code, String resMsg) {
        ResultDTO resultDTO = new ResultDTO(code,resMsg,0);
        return resultDTO;
    }

}
