package scoremanager.common.util;

import java.util.List;

/**
 * 分页实体信息
 * @author redburning
 *
 * @param <E>
 */
public class Pagination<E> {

	/**
	 * 开始页数
	 */
	private int start;
	
	/**
	 * 总数
	 */
	private int totalCount;
	
	/**
	 * 默认的分页大小
	 */
	private int pageSize = 10;
	
	/**
	 * 符合条件的实体对应信息
	 */
	private List<E> datas;
	
	public Pagination() {
		
	}
	
	public Pagination(int start, int pageSize) {
		this.start = start;
		this.pageSize = pageSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getDatas() {
		return datas;
	}

	public void setDatas(List<E> datas) {
		this.datas = datas;
	}
	
}
