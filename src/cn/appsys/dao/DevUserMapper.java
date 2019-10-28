package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
      
	public List<DevUser> getUserBydevCode(@Param("devCode")String devCode);
}
