package com.gwf.concurrency;

import com.gwf.concurrency.example.threadlocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author gaowenfeng
 * @date
 */
@Slf4j
public class HttpFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do filter {},{}",Thread.currentThread().getId(),request.getServletPath());
        // 从session中获取用户的值

        // request.getSession().getAttribute("user");
        Long userid = 1L;
        RequestHolder.add(userid);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
