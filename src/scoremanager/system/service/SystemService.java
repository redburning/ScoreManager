package scoremanager.system.service;

import scoremanager.common.service.BaseService;
import scoremanager.system.entity.base.UserEntity;

public interface SystemService extends BaseService {

	public UserEntity getUserByNameAndPassword(UserEntity user);
	
}
