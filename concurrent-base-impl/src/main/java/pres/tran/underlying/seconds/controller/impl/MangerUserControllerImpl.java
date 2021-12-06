package pres.tran.underlying.seconds.controller.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pres.tran.underlying.overall.ResultDTO;
import pres.tran.underlying.seconds.controller.MangerUserController;
import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;
import pres.tran.underlying.seconds.service.MangerUserService;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
@ResponseBody
public class MangerUserControllerImpl implements MangerUserController {


    @Autowired
    MangerUserService mangerUserService;

    @Override
    @PostMapping("/login")
    public ResultDTO loginUser(HttpServletResponse response , UserParamDTO paramDTO) throws Exception {
        return mangerUserService.loginUser(response ,paramDTO);
    }
}
