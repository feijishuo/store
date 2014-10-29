package cx.studio.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.ColumnDao;
import cx.studio.store.model.Columns;
import cx.studio.store.utils.JdbcUtil;

public class ColumnDaoImpl implements ColumnDao {
	BaseDao baseDao = new BaseDaoImpl();

	/*
	 * 增加栏目（今日免费。。。）
	 */
	// test right
	public int insertColumn(Columns column) {
		String sql = "insert into columns values(?,?,?)";
		Object param[] = { null, column.getColumnId(), column.getColumn() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 删除栏目（该栏目内的商品都删除）
	// test right
	public boolean deleteColum(String columnId) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		boolean result = false;

		try {
			boolean a = false;
			boolean b = false;
			conn = (Connection) JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql1 = "delete from columns where columnId=?";
			String sql2 = "delete from  productInfo where columnId=?";
			ps1 = conn.prepareStatement(sql1);
			ps2 = conn.prepareStatement(sql2);
			ps1.setString(1, columnId);
			ps2.setString(1, columnId);
			a = ps1.execute();
			// 已经成功删除，但是返回是false
			System.out.println(a);
			System.out.println(b);
			b = ps2.execute();
			result = a && b;
			conn.commit();
			return result;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (ps1 != null) {
					ps1.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps2 != null) {
						ps2.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}

		return result;
	}

	// 查询所以栏目主题
	public List<Columns> searchAllColumn() {
		String sql = "select * from columns";
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		try {
			return queryRunner.query(sql, new BeanListHandler<Columns>(
					Columns.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
