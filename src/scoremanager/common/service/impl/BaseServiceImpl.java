package scoremanager.common.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import scoremanager.common.dao.BaseDao;
import scoremanager.common.service.BaseService;
import scoremanager.common.util.Pagination;

@Service("baseService")
public class BaseServiceImpl implements BaseService {

	@Autowired
	@Qualifier("baseDao")
	private BaseDao baseDao;
	
	/**
	 * 注入一个sessionFactory属性, 并注入到父类(HibernateDalSupport)
	 */
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		// 事务必须是开启(Required)的, 否则获取不到
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public <T> void saveOrUpdate(T entity) {
		this.baseDao.saveOrUpdate(entity);
	}

	@Override
	public <T> void save(T entity) {
		this.baseDao.save(entity);
	}

	@Override
	public <T> void saveBatch(List<T> entities) {
		for (int i = 0; i < entities.size(); i++) {
			Object object = entities.get(i);
			getSession().save(object);
			// 20个对象才清理缓存写入数据库
			if (i % 20 == 0) {
				getSession().flush();
				getSession().clear();
			}
		}
		// 最后清理一下, 防止最后少于20个对象的组没被保存
		getSession().flush();
		getSession().clear();
	}

	@Override
	public <T> void update(T entity) {
		this.baseDao.update(entity);
	}

	@Override
	public <T> void delete(T entity) {
		this.baseDao.delete(entity);
	}

	@Override
	public <T> T get(Class<T> entityClass, String id) {
		return this.baseDao.get(entityClass, id);
	}

	@Override
	public <T> Pagination<T> getPageData(DetachedCriteria condition, int page, int rows) {
		Pagination<T> pagination = new Pagination<T>(page, rows);
		int total = this.baseDao.getRowCountByDetachedCriteria(condition);
		pagination.setTotalCount(total);
		condition.setProjection(null);
		if (total != 0) {
			List<T> datas = this.baseDao.findByDetachedCriteria(condition, page, rows);
			pagination.setDatas(datas);
		}
		return pagination;
	}

	@Override
	public <T> List<T> getQueryData(DetachedCriteria condition) {
		List<T> resultList = this.baseDao.findByDetachedCriteriaNoPage(condition);
		return resultList;
	}

}
