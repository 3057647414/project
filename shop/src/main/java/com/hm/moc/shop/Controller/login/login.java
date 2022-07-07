package com.hm.moc.shop.Controller.login;

import com.hm.moc.shop.Dao.Captcha;
import com.hm.moc.shop.Mapper.UserMapper;
import com.hm.moc.shop.Pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController

public class login {
    private Captcha c;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/token")
    public void token(HttpServletResponse res) throws IOException {
        c = new Captcha();
        ServletOutputStream outputStream = res.getOutputStream();
        c.write(outputStream);
    }

    @RequestMapping("/login")
    public Object login(String phone, String pwd, HttpServletResponse response, HttpServletRequest request, String token) {
        String captcha = c.getCaptcha();
        if (captcha == token) {
            UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
            User fanduserbyphone = mapper.fanduserbyphone(phone);
            String pwd1 = fanduserbyphone.getPwd();
            if (pwd == pwd1) {
                int gander = fanduserbyphone.getGander();
                if (gander!=0){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", fanduserbyphone);
                    return true;
                }else return "你的账号已被封禁";

            } else {
                return "密码错误，请确认后重试";
            }


        }else {
            return "验证码错误，请确认验证码";
        }

    }
    @RequestMapping("/adminlogin")
    public Object adminlogin(String phone, String pwd, HttpServletResponse response, HttpServletRequest request, String token) {
        String captcha = c.getCaptcha();
        if (captcha == token) {
            UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
            User fanduserbyphone = mapper.fanduserbyphone(phone);
            String pwd1 = fanduserbyphone.getPwd();
            if (pwd == pwd1) {
                int gander = fanduserbyphone.getGander();
                if (gander==5){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", fanduserbyphone);
                    return true;
                }else return "你的权限不足";

            } else {
                return false;
            }


        }else {
            return "验证码错误，请确认验证码";
        }

    }
    @RequestMapping("/shoplogin")
    public Object shoplogin(String phone, String pwd, HttpServletResponse response, HttpServletRequest request, String token) {
        String captcha = c.getCaptcha();
        if (captcha == token) {
            UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
            User fanduserbyphone = mapper.fanduserbyphone(phone);
            String pwd1 = fanduserbyphone.getPwd();
            if (pwd == pwd1) {
                int gander = fanduserbyphone.getGander();
                if (gander==4){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", fanduserbyphone);
                    return true;
                }else return "你的权限不足";

            } else {
                return false;
            }


        }else {
            return "验证码错误，请确认验证码";
        }

    }
}
