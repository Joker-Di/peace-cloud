package pep.pesoftware.wew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pep.pesoftware.coc.jwt.JWTUserInfo;
import pep.pesoftware.wew.exception.BaseException;
import pep.pesoftware.wew.form.SysUserForm;
import pep.pesoftware.wew.service.ILoginService;

@RestController()
@RequestMapping("/peace")
public class LoginController {
    /**
     * 处理登录的业务类
     */
    @Autowired
    private ILoginService loginService;

    /**
     * 用户登录操作
     * <p>通过用户名和密码验证是否登录成功，成功返回Token。
     * 登录成功把Token放到Redis中，方便以后对请求的验证。</p>
     * @param username
     * @param password
     *          传入的登录信息
     * @return
     *          返回发放的Token
     * @throws BaseException
     *          等用户名称或者密码不正确时，抛出异常。
     */
    @PostMapping("")
    public ResponseEntity logIn(String username, String password) throws BaseException {
        SysUserForm reForm = loginService.logIn(username, password);
        if(reForm == null){
            throw new BaseException("W0001","用户名不存在或密码错误", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reForm);
    }

    @DeleteMapping("")
    public ResponseEntity logOut(String userId){
        loginService.logOut(userId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody String token){
        JWTUserInfo auth = loginService.auth(token);
        return ResponseEntity.status(HttpStatus.OK).body(auth);
    }


}
