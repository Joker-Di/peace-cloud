package pep.pesoftware.gwg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pep.pesoftware.coc.jwt.JWTUserInfo;
import pep.pesoftware.gwg.service.impl.WebClientImpl;

@FeignClient(name = "PEACE-WEB",fallback= WebClientImpl.class)
public interface IWebClient {

    @RequestMapping(value = "/peace/auth",method = RequestMethod.POST)
    JWTUserInfo auth(@RequestBody String token);

}
