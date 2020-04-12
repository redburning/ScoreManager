package scoremanager.common.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao {

	/**
	 * 保存/更新
	 * @param <T>
	 * @param entity
	 */
	public <T> void saveOrUpdate(T entity);
	
	/**
	 * 保存
	 * @param <T>
	 * @param entity
	 */
	public <T> void save(T entity);
	
	/**
	 * 更新
	 * @param <T>
	 * @param entity
	 */
	public <T> void update(T entity);
	
	/**
	 * 删除
	 * @param <T>
	 * @param entity
	 */
	public <T> void delete(T entity);
	
	/**
	 * 根据主键id获取对应实体信息
	 * @param <T>
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> entityClass, String id);
	
	/**
	 * 根据入参参数类型获取到符合条件的所有实体信息条数
	 * @param condition
	 * @return
	 */
	public int getRowCountByDetachedCriteria(DetachedCriteria condition);
	
	/**
	 * 根据入参参数类型获取到符合条件的分页实体list
	 * @param <T>
	 * @param condition
	 * @param page
	 * @param rows
	 * @return
	 */
	public <T> List<T> findByDetachedCriteria(DetachedCriteria condition, int page, int rows);
	
	/**
	 * 根据入参参数类型获取到符合条件的所有实体list
	 * @param <T>
	 * @param condition
	 * @return
	 */
	public <T> List<T> findByDetachedCriteriaNoPage(DetachedCriteria condition);
	
}
