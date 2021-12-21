package pres.tran.underlying.seconds.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.tran.underlying.common.CurrCommon;
import pres.tran.underlying.overall.CurrException;
import pres.tran.underlying.overall.CurrResultDTO;
import pres.tran.underlying.overall.ResultDTO;
import pres.tran.underlying.seconds.bean.MangerUser;
import pres.tran.underlying.seconds.common.UserKey;
import pres.tran.underlying.seconds.controller.impl.MangerUserControllerImpl;
import pres.tran.underlying.seconds.dao.MangerUserDAO;
import pres.tran.underlying.seconds.dto.UserParamDTO;
import pres.tran.underlying.seconds.dto.UserResultDTO;
import pres.tran.underlying.seconds.service.MangerUserService;
import pres.tran.underlying.tranutil.jwt.CurrJwtUtil;
import pres.tran.underlying.tranutil.redis.CurrRedisService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Service
public class MangerUserServiceImpl implements MangerUserService {

    private final Logger logger = LoggerFactory.getLogger(MangerUserControllerImpl.class);

    @Autowired
    private MangerUserDAO mangerUserDAO;

    @Autowired
    private CurrRedisService currRedisService;

    @Override
    public ResultDTO loginUser(HttpServletResponse response , UserParamDTO paramDTO) throws Exception {

        ResultDTO resultDTO = null;
        if (StrUtil.isNotBlank(paramDTO.getPhone()) && StrUtil.isNotBlank(paramDTO.getPassword())){
            // 取MD5加密密码
            String pass = SecureUtil.md5(CurrCommon.SALT + paramDTO.getPassword());
            QueryWrapper<MangerUser> wrapper = new QueryWrapper<>();
            HashMap<String, String> query = new HashMap<>();
            query.put("user_phone",paramDTO.getPhone());
            wrapper.allEq(query);
            int count = mangerUserDAO.selectCount(wrapper);
            if (0 == count){
                throw new CurrException(CurrResultDTO.SECONDS_LOGIN_SIGN);
            }
            query.put("user_password",pass);
            MangerUser user = mangerUserDAO.selectOne(wrapper);

            if (pass.equals(user.getUserPassword())){
                resultDTO = CurrResultDTO.SECONDS_LOGIN_SUCCEED;
                // 写入 token
                UserResultDTO userInfo = new UserResultDTO();
                userInfo.setPhone(user.getUserPhone());
                userInfo.setUserHead(user.getUserHead());
                userInfo.setName(user.getUserName());
                userInfo.setStart(user.getUserStart());
                String refToken = IdUtil.simpleUUID();
                userInfo.setToken(refToken);
                // TODO 目前不加权限
                String token = CurrJwtUtil.createToken(paramDTO.getPhone(),null,userInfo);
                response.setHeader(CurrJwtUtil.TOKEN_HEADER,CurrJwtUtil.TOKEN_PREFIX+token);
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                // 向redis中存入token
                currRedisService.set(UserKey.getToken,refToken,token);
                user.setUpdateTime(DateUtil.date().toString());
                mangerUserDAO.updateById(user);
            }else {
                throw new CurrException(CurrResultDTO.SECONDS_LOGIN_ERROR);
            }
        }else {
            throw new CurrException(CurrResultDTO.SECONDS_LOGIN_DATE);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO signUser(UserParamDTO paramDTO){
        ResultDTO resultDTO = null;
        if (StrUtil.isNotBlank(paramDTO.getPhone()) && StrUtil.isNotBlank(paramDTO.getName())){
            // TODO 没有验证手机号 ID生成没有使用序列值 状态值也没有给
            MangerUser user = new MangerUser();
            user.setUserID(IdUtil.simpleUUID());
            user.setUserName(paramDTO.getName());
            user.setUserStart("0");
            user.setCreateTime(DateUtil.date().toString());
            user.setUserPhone(paramDTO.getPhone());
            user.setUserPassword(SecureUtil.md5(CurrCommon.SALT + paramDTO.getPassword()));
            mangerUserDAO.insert(user);
            resultDTO = CurrResultDTO.SECONDS_SIGN_SUCCEED;
        }else {
            throw new CurrException(CurrResultDTO.SECONDS_LOGIN_ERROR);
        }
        return null;
    }

    @Override
    public CurrResultDTO<UserResultDTO> getUserInfo(String token) throws Exception {
        CurrResultDTO<UserResultDTO> resultDTO = null;
        try {
            resultDTO = CurrResultDTO.SECONDS_USER_INFO;
            resultDTO.setData(CurrJwtUtil.getUser(token,UserResultDTO.class));
        }catch (Exception e){
            throw new CurrException(CurrResultDTO.SECONDS_SIGN_DATE);
        }
        return resultDTO;
    }

}
