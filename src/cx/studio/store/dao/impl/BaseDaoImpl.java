package cx.studio.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.utils.JdbcUtil;

public class BaseDaoImpl implements BaseDao {
	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	// 添加（成功是1，失败是0）

	// 删除

	// 修改
	public int BaseUpdate(String sql, Object[] param) {
		int result = 0;
		try {
			result = queryRunner.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 批量删除
	public int DeleteBatch(String sql, String ids) {
		Connection conn = null;
		PreparedStatement ps = null;
		String[] IDarray = ids.split("_");
		// id由字符串拼接而来(_拼接)
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < IDarray.length; i++) {
				int id = Integer.parseInt(IDarray[i]);
				ps.setInt(1, id);
				ps.execute();
			}
			conn.commit();
		} catch (Exception e) {
			// 批量删除失败
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return 0;
	}
	/*
	 * public List<T> BaseListSelect(Class<?> clazz, String sql, Object[] param)
	 * { List<T> list = new ArrayList<T>(); try { if (param != null) { list =
	 * queryRunner.query(sql, param, new BeanListHandler<T>( T.class)); } else {
	 * list = queryRunner.query(sql, new BeanListHandler<T>(T.class)); } } catch
	 * (SQLException e) { e.printStackTrace(); } return list; }
	 */
}
