package cn.ml.shop_admin.security;

import cn.ml.shop_admin.pojo.Result;
import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义认证过滤器
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    /**
     * 屏蔽OPTIONS请求
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        boolean accessAllowed = super.isAccessAllowed(request, response, mappedValue);
        if (!accessAllowed) {
            // 判断请求是否是options请求
            String method = WebUtils.toHttp(request).getMethod();
            if (StringUtils.equalsIgnoreCase("OPTIONS", method)) {
                return true;
            }
        }
        return accessAllowed;
    }

    /**
     * 解决未登录302问题
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Result result = new Result();
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            // 返回固定的JSON串
            WebUtils.toHttp(response).setContentType("application/json; charset=utf-8");
            WebUtils.toHttp(response).setHeader("Access-Control-Allow-Origin","*");
            ObjectMapper mapper = new ObjectMapper();
            result.setStatus(401);
            result.setMessage("未登录");
            String resp = mapper.writeValueAsString(result);
            WebUtils.toHttp(response).getWriter().print(resp);
            return false;
        }
    }
}
