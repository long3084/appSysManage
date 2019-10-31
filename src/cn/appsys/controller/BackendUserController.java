package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.BackendUserService;

@Controller
public class BackendUserController {
    @Resource  
	private BackendUserService backendUserService;
    
    @RequestMapping(value="manager/login",method=RequestMethod.GET)
    public String backendlogin(){
		
    	return "backendlogin";
    }
    @RequestMapping(value="/dologin.html",method=RequestMethod.POST)
    public String dologin(@RequestParam(required=false)String userCode,@RequestParam(required=false)String userPassword,HttpSession session){
		BackendUser backendUser =backendUserService.login(userCode, userPassword);
		if(backendUser!=null){
			session.setAttribute("userSession", backendUser);
	    	return "redirect:/sys/main2.html";
		}else{
	    	return "backendlogin";
		}

    }
    
    @RequestMapping(value="/sys/main2.html")
    public String main(){
 	    return "backend/main";
    }
    
}
