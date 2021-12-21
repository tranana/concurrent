package pres.tran.underlying.seconds.controller;


import pres.tran.underlying.overall.CurrResultDTO;
import pres.tran.underlying.overall.ResultDTO;
import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;

import javax.servlet.http.HttpServletResponse;

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
    ResultDTO loginUser(HttpServletResponse response, UserParamDTO paramDTO) throws Exception;

    /**
     * 注册
     * @param response
     * @param paramDTO
     * @return
     * @throws Exception
     */
    ResultDTO signUser(HttpServletResponse response, UserParamDTO paramDTO) throws Exception;

    /**
     * 更具token获取用户信息
     * @param token
     * @return
     * @throws Exception
     */
    CurrResultDTO<UserResultDTO> getUserInfo(String token) throws Exception;
}
