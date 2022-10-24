package com.cxaou.thetestsystem.interceptor;

import com.cxaou.thetestsystem.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果我们的map有浏览器存过来的sessionid我们就任务他是已经登录了。
        log.info("拦截路径：    "+request.getRequestURI());
        String token = request.getHeader("token");
        if(TokenUtil.verify(token)){
            return true;
        }
        // 失败我们跳转新的页面
        request.setAttribute("msg","登录出错");
        request.getRemoteHost();
        request.getRequestDispatcher("/user/index").forward(request,response);
        return false;
    }

}
