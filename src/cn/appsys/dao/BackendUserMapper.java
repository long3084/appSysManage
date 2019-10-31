package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;


public interface BackendUserMapper {
   
	public List<BackendUser> getUserByuserCode(@Param("userCode")String userCode);
}
