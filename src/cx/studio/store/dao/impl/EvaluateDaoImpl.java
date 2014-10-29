package cx.studio.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.EvaluateDao;
import cx.studio.store.model.Evaluate;
import cx.studio.store.utils.JdbcUtil;

public class EvaluateDaoImpl implements EvaluateDao {
	BaseDao baseDao = new BaseDaoImpl();
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	// 添加评论
	public int addEvaluate(Evaluate evaluate) {
		String sql = "insert into evaluate values(?,?,?,?)";
		Object[] param = { null, evaluate.getProduct_id(),
				evaluate.getContent(), evaluate.getUsername() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 查看所有评论
	public List<Evaluate> checkEvaluate() {
		String sql = "select * from evaluate";
		try {
			return queryRunner.query(sql, new BeanListHandler<Evaluate>(
					Evaluate.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除评论
	public int deleteEvaluate(int id) {
		String sql = "delete from evaluate where id=?";
		Object[] param = { id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 批量删除评论
	public int deleteBatchEvaluate(String ids) {
		String sql = "delete from evaluate where id=?";
		int result = baseDao.DeleteBatch(sql, ids);
		return result;
	}

}
