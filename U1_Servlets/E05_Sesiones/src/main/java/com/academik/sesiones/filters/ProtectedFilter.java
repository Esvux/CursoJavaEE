package com.academik.sesiones.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author esvux
 */
@WebFilter("/protected/*")
public class ProtectedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;
        
        boolean isCookieLoggedUser = false;
        Cookie[] allCookies = httpReq.getCookies();
        if(allCookies != null) {
            for(Cookie cookie : httpReq.getCookies()) {
                if("logged-user".equals(cookie.getName())) {
                    isCookieLoggedUser = true;
                    break;
                }
            }
        }
        
        boolean isSessionLoggedUser = false;
        HttpSession session = httpReq.getSession(false);
        if(session != null) {
            if(session.getAttribute("logged-user") != null) {
                isSessionLoggedUser = true;
            }
        }
        
        if(isSessionLoggedUser || isCookieLoggedUser) {
            chain.doFilter(request, response);
            return;
        }

        httpRes.sendRedirect(httpReq.getContextPath());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }
    
}
