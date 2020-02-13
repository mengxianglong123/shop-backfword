package cn.ml.shop_admin.security;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 自定义权限过滤器
 */
public class RestAuthorizationFilter extends PermissionsAuthorizationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/Json");
        response.setCharacterEncoding("UTF-8");
        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            response.getWriter().print("未登录");
        } else {
            String unauthorizedUrl = this.getUnauthorizedUrl();
            if (StringUtils.hasText(unauthorizedUrl)) {
                WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {
                response.getWriter().print("ResponseUtil.response(CodeAndMsgEnum.PERMISSION_FAILD, null)");
            }
        }

        return false;
    }

}
