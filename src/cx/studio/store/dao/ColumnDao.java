package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Columns;

public interface ColumnDao {
	// 新增栏目
	public int insertColumn(Columns column);

	// 删除栏目（删除之后所有的栏目里面内容都没了）
	public boolean deleteColum(String columnId);

	// 查找所有栏目
	public List<Columns> searchAllColumn();

}
