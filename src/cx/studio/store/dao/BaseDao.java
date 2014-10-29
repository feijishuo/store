package cx.studio.store.dao;

public interface BaseDao {

	public int BaseUpdate(String sql, Object[] param);

	// 批量删除
	public int DeleteBatch(String sql, String ids);
	// public List<T> BaseListSelect(String sql, Object[] param);

}
