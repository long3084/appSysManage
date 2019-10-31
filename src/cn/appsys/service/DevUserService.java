package cn.appsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DevUser;

public interface DevUserService {
     //通过用户编码和密码登陆
	public DevUser login(String devCode,String devPassword);
	
	//查询所有的app信息
	public List<AppInfo> getAppInfoList();
}
