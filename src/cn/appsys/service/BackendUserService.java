package cn.appsys.service;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
     
	//根据用户编码查询
	public BackendUser login(String userCode,String userPassword);
}
