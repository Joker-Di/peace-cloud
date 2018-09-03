package pep.pesoftware.gwg.filter;

import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import pep.pesoftware.coc.jwt.JWTUserInfo;
import pep.pesoftware.gwg.common.constant.GetWayConstant;
import pep.pesoftware.gwg.service.IWebClient;

import javax.servlet.http.HttpServletRequest;

public class GetWayFilter extends ZuulFilter {

    @Autowired
    private IWebClient webClient;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        if (("/api/web/peace/validateEmail".equals(uri) || "/api/web/peace/confirm".equals(uri)
                ||"/api/web/peace/replyPwd".equals(uri)
                || "/api/web/peace/register".equals(uri) || "/api/web/peace".equals(uri) || "/api/admin/peace".equals(uri))
                && Http.HttpMethod.POST.toString().equals(request.getMethod())) {
            return null;
        }
        String token = request.getHeader(GetWayConstant.AOKEN_KEY);
        if (token == null || token.length() == 0) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
        JWTUserInfo auth = null;
        if (uri.contains("/api/web/")) {
            // 前台验证
            auth = webClient.auth(token);
        } else {
            // 后台验证
//            auth = adminClient.auth(token);
        }
        if (auth == null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        } else {
            context.addZuulRequestHeader(GetWayConstant.USER_ID_KEY, auth.getUserId());
        }
        return null;
    }
}
