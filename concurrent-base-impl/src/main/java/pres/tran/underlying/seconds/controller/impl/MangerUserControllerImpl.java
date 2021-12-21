package pres.tran.underlying.seconds.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pres.tran.underlying.overall.CurrResultDTO;
import pres.tran.underlying.overall.ResultDTO;
import pres.tran.underlying.seconds.controller.MangerUserController;
import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;
import pres.tran.underlying.seconds.service.MangerUserService;
import pres.tran.underlying.tranconfig.adapter.CurrLetOff;
import pres.tran.underlying.tranutil.jwt.CurrJwtUtil;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sign")
@ResponseBody
public class MangerUserControllerImpl implements MangerUserController {


    @Autowired
    MangerUserService mangerUserService;

    @Override
    @PostMapping("/login")
    @CurrLetOff
    public ResultDTO loginUser(HttpServletResponse response , UserParamDTO paramDTO) throws Exception {
        return mangerUserService.loginUser(response ,paramDTO);
    }

    @Override
    @PostMapping("/sign")
    @CurrLetOff
    public ResultDTO signUser(HttpServletResponse response , UserParamDTO paramDTO) throws Exception {
        return mangerUserService.signUser(paramDTO);
    }

    @Override
    @PostMapping("/info")
    public CurrResultDTO<UserResultDTO> getUserInfo(String token) throws Exception {
        return mangerUserService.getUserInfo(token);
    }

}
