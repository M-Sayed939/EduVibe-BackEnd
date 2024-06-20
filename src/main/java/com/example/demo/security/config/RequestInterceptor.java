package com.example.demo.security.config;

import com.example.demo.Registration.token.AccessTokenService;
import io.netty.handler.codec.HeadersUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.util.Iterator;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    // Request is intercepted by this method before reaching the Controller

    private AccessTokenService accessTokenService;
    public RequestInterceptor(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //* Business logic just when the request is received and intercepted by this interceptor before reaching the controller
            if (request.getRequestURI().equals("/api/login") || request.getRequestURI().equals("/api/v1/registration")) {
                return true;
            }
            String token = request.getHeader("authorization");
            boolean isValid = accessTokenService.validateToken(token);
            if (!isValid) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return isValid;

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //* Do Nothing
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //* Do Nothing
    }
}
