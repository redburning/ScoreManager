package scoremanager.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scoremanager.common.service.impl.BaseServiceImpl;
import scoremanager.system.dao.SystemDao;
import scoremanager.system.entity.base.UserEntity;
import scoremanager.system.service.SystemService;

@Service("systemService")
public class SystemServiceImpl extends BaseServiceImpl implements SystemService {

	@Autowired
	private SystemDao systemDao;
	
	@Override
	public UserEntity getUserByNameAndPassword(UserEntity user) {
		return systemDao.getUserByNameAndPassword(user);
	}

}
