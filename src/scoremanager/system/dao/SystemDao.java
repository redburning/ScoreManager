package scoremanager.system.dao;

import scoremanager.common.dao.BaseDao;
import scoremanager.system.entity.base.UserEntity;

public interface SystemDao extends BaseDao {

	public UserEntity getUserByNameAndPassword(UserEntity user);
	
}
