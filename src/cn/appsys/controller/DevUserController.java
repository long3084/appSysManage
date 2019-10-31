package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppInfo;
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
    
    
    @RequestMapping(value="dev/login",method=RequestMethod.GET)
    public String devlogin(){
		
    	return "devlogin";
    }

    @RequestMapping(value="/dologin",method=RequestMethod.POST)
    public String dologin(@RequestParam(required=false)String devCode,@RequestParam(required=false)String devPassword,HttpSession session){
		DevUser devUser=devUserService.login(devCode, devPassword);
    	if(devUser!=null){
    		session.setAttribute("devUserSession",devUser);
    		return "redirect:/sys/main.html";
    	}else{
    	    return "devlogin";
    	}
    }
    
    @RequestMapping(value="/sys/main.html")
    public String main(){
 	    return "developer/main";
    }
    
    //app基本信息页
    @RequestMapping("/appinfolist.html")
    public String appList(){
		
    	return "developer/appinfolist";
    }
    
    //app基本信息添加
    @RequestMapping("/appinfoadd.html")
    public String appinfoadd( @RequestParam(required=false)String querySoftwareName,
    		@RequestParam(required=false)String queryStatus,
    		@RequestParam(required=false)String queryFlatformId,
    		@RequestParam(required=false)String queryCategoryLevel1,
    		@RequestParam(required=false)String queryCategoryLevel2,
    		@RequestParam(required=false)String queryCategoryLevel3,
			   @RequestParam(required=false) String pageIndex,
			   Model model
    		){
		   int pageNo=1;
		   if(pageIndex!=null && pageIndex!=""){
			   pageNo=Integer.parseInt(pageIndex);
		   }
    	
	
    	return "developer/appinfoadd";
    }
    
    
}
