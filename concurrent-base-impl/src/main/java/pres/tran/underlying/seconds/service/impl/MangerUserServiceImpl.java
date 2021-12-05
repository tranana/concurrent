package pres.tran.underlying.seconds.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.tran.underlying.seconds.bean.MangerUser;
import pres.tran.underlying.seconds.dao.MangerUserDAO;
import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;
import pres.tran.underlying.seconds.service.MangerUserService;

import java.util.HashMap;

@Service
public class MangerUserServiceImpl implements MangerUserService {


    @Autowired
    private MangerUserDAO mangerUserDAO;

    @Override
    public UserResultDTO loginUser(UserParamDTO paramDTO) throws Exception {
        UserResultDTO resultDTO = new UserResultDTO();
        QueryWrapper<MangerUser> wrapper = new QueryWrapper<>();
        HashMap<String, String> query = new HashMap<>();
        query.put("user_phone",paramDTO.getPhone());
        query.put("user_password",paramDTO.getPassword());
        wrapper.allEq(query);
        MangerUser mangerUser = mangerUserDAO.selectOne(wrapper);
        if (null == mangerUser){
            return null;
        }else {
            resultDTO.setName(mangerUser.getUserName());
            resultDTO.setPhone(mangerUser.getUserPhone());
        }
        return resultDTO;
    }
}
