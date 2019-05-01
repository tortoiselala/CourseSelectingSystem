package cn.tortoise.interceptor;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.constant.InterceptorConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 请求的uri
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        for (String s : InterceptorConstant.DISINTERCEPTOR_URI_LIST) {
            if (requestURI.contains(s)) {
                return true;
            }
        }
        // 执行过滤
        Object user = request.getSession().getAttribute(CommonConstant.USER_CONTEXT);

        if (user == null) {
            logger.warn("redirect");
            response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }
        return true;
    }
}
