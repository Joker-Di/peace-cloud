package pep.pesoftware.wew.service;

import pep.pesoftware.coc.jwt.JWTUserInfo;
import pep.pesoftware.wew.form.SysUserForm;

public interface ILoginService {
    SysUserForm logIn(String username, String password);
    boolean logOut(String userId);
    JWTUserInfo auth(String token);
}
