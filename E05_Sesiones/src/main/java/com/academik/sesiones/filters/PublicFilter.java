package com.academik.sesiones.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
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
@WebFilter(urlPatterns = {
    "/login-with-cookies",
    "/login-with-session",
    "/index.html"
})
public class PublicFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;
        
        boolean isCookieLoggedUser = false;
        Cookie[] allCookies = httpReq.getCookies();
        if(allCookies != null) {
            for(Cookie cookie : allCookies) {
                if("logged-user".equals(cookie.getName())) {
                    isCookieLoggedUser = true;
                    break;
                }
            }
        }
        
        boolean isSessionLoggedUser = false;
        HttpSession session = httpReq.getSession(false);
        if(session != null) {
            if("logged-user".equals(session.getAttribute("logged-user"))) {
                isSessionLoggedUser = true;
            }
        }
        
        if(isSessionLoggedUser || isCookieLoggedUser) {
            httpRes.sendRedirect(httpReq.getContextPath() + "/protected/hello");
            return;
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }
    
}
