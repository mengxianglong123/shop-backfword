package cn.ml.shop_admin.controller.shiro;

import cn.ml.shop_admin.pojo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin
@Controller
public class ShiroController {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login( String username, String password){
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            result.setStatus(200);
            result.setMessage("登录成功");
            String id = (String) SecurityUtils.getSubject().getSession().getId();
            result.setData(id);
            return result;
        }
        catch (Exception e){
            result.setStatus(403);
            result.setMessage("登录失败");
            return result;
        }
    }

    /**
     * 未登录
     * @return
     */
    @RequestMapping("/unLogin")
    @ResponseBody
    public Result unLogin(){
        Result result = new Result();
        result.setStatus(403);
        result.setMessage("未登录");
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result logout() {
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
        result.setStatus(200);
        result.setMessage("退出成功");
        return result;
    }

    }
