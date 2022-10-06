package com.zhuangxiaoyan.athena.order.interceptor;


import com.zhuangxiaoyan.athena.order.constant.OrderConstant;
import com.zhuangxiaoyan.common.vo.MemberRespVo;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description 用户登入的拦截器
  * @param: null
 * @date: 2022/9/6 8:17
 * @return:
 * @author: xjl
*/
@Component
public class LoginUserInterceptor implements HandlerInterceptor {

    public static ThreadLocal<MemberRespVo> loginuserthreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        // 允许放行
        boolean match = antPathMatcher.match("/order/order/status/**", uri);
        boolean match1 = antPathMatcher.match("/payed/notify", uri);
        if (match || match1) {
            return true;
        }
        //获取登录的用户信息
        MemberRespVo attribute = (MemberRespVo) request.getSession().getAttribute(OrderConstant.SESSION_LOGIN_KEY);
        if (attribute != null) {
            //把登录后用户的信息放在ThreadLocal里面进行保存
            loginuserthreadLocal.set(attribute);
            return true;
        } else {
            //未登录，返回登录页面
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('请先进行登录，再进行后续操作！');location.href='http://sso.athena.com/login.html'</script>");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
