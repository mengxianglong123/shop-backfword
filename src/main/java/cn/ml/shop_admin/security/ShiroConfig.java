package cn.ml.shop_admin.security;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 获取自定义Relam
     */
    // 交给Spring的IOC容器管理
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        UserRealm realm = new UserRealm();
        return realm;
    }

    //自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        return mySessionManager;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        // @Qualifier("") 传入的参数要与getRealm()的@Bean的name属性一致
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        // 自定义session管理
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        // @Qualifier的值也要对应上

        // 创建对象
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        // 关联securityManager
        filterFactoryBean.setSecurityManager(securityManager);

        // 设置自定义的过滤器
        Map<String, Filter> filters = filterFactoryBean.getFilters();
        filters.put("authc", new CustomFormAuthenticationFilter());
        filters.put("perms", new RestAuthorizationFilter());

        // 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       roles: 该资源必须得到角色权限才可以访问
         */
        // 为了保证配置的次序，使用LinkedHashMap
        Map<String,String> filterMap = new LinkedHashMap<>();
        // 放行登录请求
        filterMap.put("/login","anon");
        //拦截其余所有请求
        filterMap.put("/**","authc");


        filterFactoryBean.setFilterChainDefinitionMap(filterMap);


        // 修改跳转的登录页面
        filterFactoryBean.setLoginUrl("/unLogin");


        return filterFactoryBean;
    }
}
