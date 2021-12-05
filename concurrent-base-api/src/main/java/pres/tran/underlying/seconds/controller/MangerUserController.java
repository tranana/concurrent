package pres.tran.underlying.seconds.controller;


import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;

/**
 * 用户操作Controller
 */
public interface MangerUserController {

    /**
     * 用户登录
     * @param paramDTO
     * @return
     * @throws Exception
     */
    UserResultDTO loginUser(UserParamDTO paramDTO) throws Exception;
}
