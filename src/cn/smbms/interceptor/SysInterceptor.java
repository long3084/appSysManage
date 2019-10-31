package cn.smbms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;

public class SysInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		DevUser user=(DevUser)request.getSession().getAttribute("devUserSession");
		BackendUser backendUser=(BackendUser)request.getSession().getAttribute("userSession");
	  if(user!=null||backendUser!=null){
		return true; //将请求放行
	  }else{
		  response.sendRedirect(request.getContextPath()+"/403.jsp");
		return false;   //请求终止
	  }
	}

}
