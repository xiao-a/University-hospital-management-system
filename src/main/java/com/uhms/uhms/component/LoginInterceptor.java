package com.uhms.uhms.component;

import com.uhms.uhms.utils.LogUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin=request.getSession().getAttribute("LoginInfo");
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        LogUtils.info("session最大链接会话时长"+maxInactiveInterval);
        if(admin==null)
        {
//            request.setAttribute("errorss","您没有访问权限，请先登录！");
            LogUtils.info("session为空！");
//            request.getRequestDispatcher("/link");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }else {
            LogUtils.info("session:"+admin);
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
