package com.blog.filter;

import com.blog.util.TokenUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "TokenAuthenticationFilter",
        initParams = {@WebInitParam(name = "loginUri", value = "/login")})
public class TokenAuthenticationFilter implements Filter {
    private FilterConfig config;


    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        // 获取配置参数
        String loginUri = config.getInitParameter("loginUri");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        // 获取token
        String token = request.getHeader("Authorization");

        // 获取请求路径
        String requestUri = request.getRequestURI();
        if(!requestUri.contains(loginUri)){
            if(token == null || !TokenUtil.isValid(token)){
                return;
            } else {
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig var1) throws ServletException {
        this.config = var1;
    }

}
