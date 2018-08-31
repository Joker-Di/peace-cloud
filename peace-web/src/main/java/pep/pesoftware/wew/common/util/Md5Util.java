package pep.pesoftware.wew.common.util;

import org.springframework.util.DigestUtils;
import pep.pesoftware.wew.common.constant.UserConstant;

import java.io.UnsupportedEncodingException;

public class Md5Util {

    /**
     * 密码MD5加密
     * @param passWord
     *          明文密码
     * @return
     *          加密后的密码
     */
    public static String md5(String passWord){
        if(passWord == null){
            return null;
        }
        String rePassWord;
        try {
            rePassWord = DigestUtils.md5DigestAsHex(
                    passWord.getBytes(UserConstant.USER_STRING_CHARSET));
        }catch (UnsupportedEncodingException e){
            rePassWord = null;
        }
        return rePassWord;
    }
}