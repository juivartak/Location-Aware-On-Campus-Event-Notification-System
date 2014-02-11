package edu.sjsu.cmpe.users;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsHeadersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            httpServletResponse.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:3030");
            httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.addHeader("Access-Control-Expose-Headers", "true");
 
            if ("OPTIONS".equals(httpServletRequest.getMethod())) {
                httpServletResponse.addHeader("Access-Control-Allow-Headers", "Content-Type, X-Requested-With");
                httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
 
            }
        }
        chain.doFilter(request, response);
    }
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
 
    @Override
    public void destroy() {}
}