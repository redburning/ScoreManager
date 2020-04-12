package scoremanager.system.dao.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import scoremanager.common.dao.impl.BaseDaoImpl;
import scoremanager.system.dao.SystemDao;
import scoremanager.system.entity.base.UserEntity;

@Repository
public class SystemDaoImpl extends BaseDaoImpl implements SystemDao {

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity getUserByNameAndPassword(UserEntity user) {
		Md5Hash md5Hash = new Md5Hash(user.getPassword());
		String password = md5Hash.toHex();
		String query = "from UserEntity u where u.username=:username and u.password=:password";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("username", user.getUsername());
		queryObject.setParameter("password", password);
		List<UserEntity> users = queryObject.list();
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}

}
