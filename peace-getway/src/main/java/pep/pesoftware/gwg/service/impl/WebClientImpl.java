package pep.pesoftware.gwg.service.impl;

import org.springframework.stereotype.Component;
import pep.pesoftware.coc.jwt.JWTUserInfo;
import pep.pesoftware.gwg.service.IWebClient;

@Component
public class WebClientImpl implements IWebClient {

    @Override
    public JWTUserInfo auth(String token) {
        System.out.println("发生熔断");
        return null;
    }

}
