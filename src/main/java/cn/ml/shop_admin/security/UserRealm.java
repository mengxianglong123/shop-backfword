package cn.ml.shop_admin.security;

        import cn.ml.shop_admin.mapper.shiro.ShiroMapper;
        import cn.ml.shop_admin.pojo.Admin;
        import org.apache.shiro.authc.*;
        import org.apache.shiro.authz.AuthorizationInfo;
        import org.apache.shiro.realm.AuthorizingRealm;
        import org.apache.shiro.subject.PrincipalCollection;

        import javax.annotation.Resource;

/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {
    @Resource
    private ShiroMapper shiroMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String name = token.getUsername();
        Admin admin = this.shiroMapper.selByAccount(name);
        if (admin == null) return null;

        return new SimpleAuthenticationInfo(admin.getAccount(),admin.getPassword(),getName());
    }
}
