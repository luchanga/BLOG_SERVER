package com.blog.app.controller;

import com.blog.Global;
import com.blog.app.domain.Blogger;
import com.blog.app.domain.User;
import com.blog.app.service.BloggerService;
import com.blog.util.TokenUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private BloggerService bloggerService = null;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Blogger login (@RequestBody User user,
                          HttpServletResponse res) {
        String userName = user.getUsername();
        String password = user.getPassword();
        try {
            Blogger blogger = bloggerService.getBloggerByUserName(userName);
            if(blogger != null && password.equals(blogger.getPassword())) {
                // 设置这个token的生命时间
                Date expiry = getExpiryDate(Global.TOKEN_EXPIRE_TIME);
                String jwtString = TokenUtil.getJWTString(userName, expiry, null);
                res.setHeader("Authorization", jwtString);
                return blogger;
            } else {
                throw new Exception("account error");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @RequestMapping(value = "/isLogin", method = RequestMethod.GET)
    @ResponseBody
    public boolean isLogin () {
        try{
            return true;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    private Date getExpiryDate(int days) {
        // 根据当前日期，来得到到期时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, days);

        return calendar.getTime();
    }
}
