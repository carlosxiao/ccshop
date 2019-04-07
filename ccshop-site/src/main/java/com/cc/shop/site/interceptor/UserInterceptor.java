package com.cc.shop.site.interceptor;

import com.cc.shop.base.objects.WebUser;
import com.cc.shop.utils.CookieUtil;
import com.cc.shop.framework.base.context.SpringApplicationContext;
import com.cc.shop.groupon.cart.service.CartService;
import com.cc.shop.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户拦截器,处理页面显示的用户名\登陆状态信息
 */
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        //从cookie中取出用户信息
        WebUser webUser = CookieUtil.getLoginUser(request);
        if (null != webUser) {
            CookieUtil.setLoginUser(response, webUser);
        }

        if (null != modelAndView && null != webUser && StringUtils.isNotEmpty(webUser.getUsername())) {
            Long cartSize = SpringApplicationContext.getBean(CartService.class).getCartSize(webUser.getUserId());
            modelAndView.addObject("cartSize", cartSize);
            modelAndView.addObject("username", webUser.getUsername());
        }
        if (null != modelAndView && modelAndView.getViewName().startsWith("redirect:")) {
            modelAndView.getModel().clear();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}