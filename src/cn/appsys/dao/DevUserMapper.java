package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
      //通过编码查询
	public List<DevUser> getUserBydevCode(@Param("devCode")String devCode);
	  //查询所有app信息
	public List<AppInfo> getAppInfoList();
	
	//查询总数量
	public int getAppInfoListCount(@Param("softwareName")String softwareName,
			@Param("status")String status,
			@Param("flatformId")String flatformId,
			@Param("categoryLevel1")String categoryLevel1,
			@Param("categoryLevel2")String categoryLevel2,
			@Param("categoryLevel3")String categoryLevel3);
	
	
}
