package pep.pesoftware.wew.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import pep.pesoftware.coc.jwt.JWTUserInfo;
import pep.pesoftware.fwf.redis.RedisClient;
import pep.pesoftware.fwf.repository.mapper.SysUserMapper;
import pep.pesoftware.fwf.repository.model.SysUser;
import pep.pesoftware.fwf.util.JwtTokenUtil;
import pep.pesoftware.wew.common.constant.UserConstant;
import pep.pesoftware.wew.form.SysUserForm;
import pep.pesoftware.wew.service.ILoginService;

import java.io.UnsupportedEncodingException;

@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    @Autowired()
    @Qualifier("redisUtil")
    RedisClient redisUtil;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Value("${custom.token.secret.key}")
    private String key;
    @Value("${custom.token.expire}")
    private Integer expire;
    @Value("${custom.session.timeOut}")
    private Integer timeOut;

    @Override
    public SysUserForm logIn(String username, String password) {
        SysUserForm reForm;
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return null;
        }
//        String passWord;
//        try {
//            passWord = DigestUtils.md5DigestAsHex(password.getBytes(UserConstant.USER_STRING_CHARSET));
//        } catch (UnsupportedEncodingException e) {
//            log.error(UserConstant.HANDLE_ERROR, e);
//            return null;
//        }
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf("1"));
        String userRedisKey = UserConstant.USER_SESSION_KEY.concat(sysUser.getUserId().toString());
            redisUtil.set(userRedisKey, sysUser.getUserId().toString());
            redisUtil.expire(userRedisKey, timeOut);
            String token = JwtTokenUtil
                    .generateToken(new JWTUserInfo(sysUser.getUserId().toString(), sysUser.getUsername(), sysUser.getName()),
                            expire, key);
            reForm = new SysUserForm();
            reForm.setToken(token);
        return reForm;
    }

    @Override
    public boolean logOut(String userId) {
        redisUtil.del(UserConstant.USER_SESSION_KEY.concat(userId));
        return true;
    }

    @Override
    public JWTUserInfo auth(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        JWTUserInfo userInfo = JwtTokenUtil.getInfoFromToken(token, key);
        if (userInfo == null) {
            return null;
        }
        String userRedisKey = UserConstant.USER_SESSION_KEY.concat(userInfo.getUserId());
        if (redisUtil.exists(userRedisKey)) {
            redisUtil.expire(userRedisKey, timeOut);
            return userInfo;
        } else {
            return null;
        }

    }


}
