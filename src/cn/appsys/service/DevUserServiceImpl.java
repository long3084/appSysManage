package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.DevUserMapper;
import cn.appsys.pojo.DevUser;
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
    @Resource
	private DevUserMapper devUserMapper;
	
	@Override
	public DevUser login(String devCode, String devPassword) {
		// TODO Auto-generated method stub
		List<DevUser> devUserList=devUserMapper.getUserBydevCode(devCode);
	if(devUserList!=null && devUserList.size()>0){
			DevUser devUser=devUserList.get(0);
			if(devUser!=null){
				if(devUser.getDevPassword().equals(devPassword)){
					return devUser;
				}
			}
		}
		return null;
	}

}
