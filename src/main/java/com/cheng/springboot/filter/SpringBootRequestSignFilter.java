package com.cheng.springboot.filter;

import com.cwhlj.common.utils.JsonUtil;
import com.cwhlj.common.utils.lang.StringUtils;
import com.cwhlj.common.web.filter.AbstractRequestFilter;
import com.cwhlj.common.web.handler.ExceptionResponseBuilder;
import com.cwhlj.common.web.handler.MessageHandler;
import com.cwhlj.common.web.response.HttpResponse;
import com.cwhlj.common.web.response.ServletResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chengwei
 * @date 2019-08-29 10:29
 */
@WebFilter(urlPatterns = "/*", filterName = "SpringBootRequestSignFilter")
@Configuration
public class SpringBootRequestSignFilter extends AbstractRequestFilter {
    @Autowired
    private MessageHandler messageHandler;

    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doSelfFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals(request.getMethod(), "OPTIONS")) {
            response.setHeader("Access-Control-Allow-Headers",
                    "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization,Accept,Authorization,Host,Origin");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,PATCH,OPTIONS");
            response.setHeader("Access-Control-Expose-Headers", "content-disposition");
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public void triggerWithError(Exception e, HttpServletRequest request, HttpServletResponse response) {
        super.triggerWithError(e, request, response);

        HttpResponse httpResponse = ExceptionResponseBuilder.buildBody(messageHandler, e, HttpStatus.BAD_REQUEST, (code, value, type) -> new HttpResponse(Integer.valueOf(code), value));

        ServletResponseUtils.responseJson(response, HttpStatus.BAD_REQUEST.value(), JsonUtil.jsonFromObject(httpResponse));
    }
}
