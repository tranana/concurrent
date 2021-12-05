package pres.tran.underlying.seconds.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pres.tran.underlying.seconds.controller.MangerUserController;
import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;
import pres.tran.underlying.seconds.service.MangerUserService;

@Controller
@RequestMapping("/")
@ResponseBody
public class MangerUserControllerImpl implements MangerUserController {

    @Autowired
    MangerUserService mangerUserService;

    @Override
    @PostMapping("/login")
    public UserResultDTO loginUser(UserParamDTO paramDTO) throws Exception {
        return mangerUserService.loginUser(paramDTO);
    }
}
