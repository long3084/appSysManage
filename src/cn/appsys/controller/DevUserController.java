package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserService;
@Controller
public class DevUserController {
    @Resource
	private DevUserService devUserService;
    @RequestMapping("index.html")
    public String begin(){
		
    	return "index";
    }
    
    @RequestMapping(value="manager/login",method=RequestMethod.GET)
    public String backendlogin(){
		
    	return "backendlogin";
    }
    
    @RequestMapping(value="dev/login",method=RequestMethod.GET)
    public String devlogin(){
		
    	return "devlogin";
    }

    @RequestMapping(value="/dologin",method=RequestMethod.POST)
    public String dologin(@RequestParam(required=false)String devCode,@RequestParam(required=false)String devPassword,HttpSession session){
		DevUser devUser=devUserService.login(devCode, devPassword);
		System.out.println(devUser);
    	if(devUser!=null){
    		session.setAttribute("devUser",devUser);
    		return "redirect:/sys/main.html";
    	}else{
    	    return "devlogin";
    	}
    }
    
    @RequestMapping(value="/sys/main.html")
    public String main(){
 	    return "developer/main";
    }
}
