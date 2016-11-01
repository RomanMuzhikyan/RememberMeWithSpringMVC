package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entities.*;
import model.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by seriozhik on 11/1/2016.
 */
@Controller
@RequestMapping(value = "account")
public class AccountController {
    @RequestMapping(method = RequestMethod.GET)
    public String index()
    {
        return "redirect:account/login.html";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap modelMap,
                        HttpSession session,HttpServletRequest request)
    {
        Account acc = checkCookie(request);
        if (acc==null)
        {
            modelMap.put("account",new Account());
            return "index";
        }
       else
        {
            AccountModel accModel = new AccountModel();
            if (accModel.login(acc.getUsername(),acc.getPassword()))
            {
                session.setAttribute("username",acc.getUsername());
                return "welcome";
            }
            else
            {
                modelMap.put("error","Accounts Invalid");
                return "index";
            }
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "account")Account account,
                        ModelMap modelMap, HttpSession session,
                        HttpServletRequest request, HttpServletResponse response)
    {
        AccountModel accModel = new AccountModel();
        if (accModel.login(account.getUsername(),account.getPassword()))
        {
            session.setAttribute("username",account.getUsername());
            if (request.getParameter("remember")!=null)
            {
                Cookie ckUsername= new Cookie("username",account.getUsername());
                ckUsername.setMaxAge(3600);
                response.addCookie(ckUsername);
                Cookie ckPassword = new Cookie("password", account.getPassword());
                ckPassword.setMaxAge(3600);
                response.addCookie(ckPassword);
            }
            return "welcome";
        }
        else
        {
            modelMap.put("error","Account's Invalid");
            return "index";
        }
    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session,
                         HttpServletRequest request ,HttpServletResponse response)
    {
        //jnjum e session
        session.removeAttribute("username");
        //jnjum e cookie
        for (Cookie ck: request.getCookies())
        {
            if (ck.getName().equalsIgnoreCase("username"))
            {
                ck.setMaxAge(0);;
                response.addCookie(ck);
            }
            if (ck.getName().equalsIgnoreCase("password"))
            {
                ck.setMaxAge(0);
                response.addCookie(ck);
            }
        }
        return "redirect:login.html";
    }

    public Account checkCookie(HttpServletRequest request)
    {
        Cookie [] cookies = request.getCookies();
        Account account =null;
        String username = "";
        String password = "";
        for (Cookie ck:cookies) {
            if (ck.getName().equalsIgnoreCase("username"))
                username=ck.getValue();
            if (ck.getName().equalsIgnoreCase("password"))
                password=ck.getValue();
        }
        if (!username.isEmpty()&& !password.isEmpty())
            account = new Account(username,password);
        return account;
    }
}
