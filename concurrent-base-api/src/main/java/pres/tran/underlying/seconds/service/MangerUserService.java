package pres.tran.underlying.seconds.service;

import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;

public interface MangerUserService {

    /**
     * 用户登录
     * @param paramDTO
     * @return
     * @throws Exception
     */
    UserResultDTO loginUser(UserParamDTO paramDTO) throws Exception;

}
