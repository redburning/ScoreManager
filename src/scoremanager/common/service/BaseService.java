package scoremanager.common.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import scoremanager.common.util.Pagination;

public interface BaseService {

	/**
	 * 保存/更新 实体信息
	 * @param <T>
	 * @param entity
	 */
	public <T> void saveOrUpdate(T entity);
	
	/**
	 * 保存实体
	 * @param <T>
	 * @param entity
	 */
	public <T> void save(T entity);
	
	/**
	 * 批量保存实体
	 * @param <T>
	 * @param entities
	 */
	public <T> void saveBatch(List<T> entities);
	
	/**
	 * 更新实体
	 * @param <T>
	 * @param entity
	 */
	public <T> void update(T entity);
	
	/**
	 * 删除实体
	 * @param <T>
	 * @param entity
	 */
	public <T> void delete(T entity);
	
	/**
	 * 根据类名称和主键获取实体信息
	 * @param <T>
	 * @param entityClass 类
	 * @param id 主键
	 * @return
	 */
	public <T> T get(Class<T> entityClass, String id);
	
	/**
	 * 获取分页查询数据
	 * @param <T>
	 * @param condition 查询条件
	 * @param page 页码
	 * @param rows 行数
	 * @return
	 */
	public <T> Pagination<T> getPageData(DetachedCriteria condition, int page, int rows);
	
	/**
	 * 获取查询数据
	 * @param <T>
	 * @param condition 查询条件
	 * @return
	 */
	public <T> List<T> getQueryData(DetachedCriteria condition);
	
}
