package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.BackendUserMapper;
import cn.appsys.pojo.BackendUser;
@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
	private BackendUserMapper backendUserMapper;
	@Override
	public BackendUser login(String userCode,String userPassword) {
		// TODO Auto-generated method stub
		List<BackendUser> backendUserList=backendUserMapper.getUserByuserCode(userCode);
		if(backendUserList!=null && backendUserList.size()>0){
			BackendUser backendUser=backendUserList.get(0);
			if(backendUser.getUserPassword().equals(userPassword)){
				return backendUser;
			}
		}
		return null;
	}

}
