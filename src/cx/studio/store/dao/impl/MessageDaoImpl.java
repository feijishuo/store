package cx.studio.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.MessageDao;
import cx.studio.store.model.Messages;
import cx.studio.store.utils.JdbcUtil;

public class MessageDaoImpl implements MessageDao {
	BaseDao baseDao = new BaseDaoImpl();
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	// 查看未回复留言
	public List<Messages> checkMessage(int state) {
		String sql = "select * from messages where state=?";
		Object[] param = { state };
		try {
			return queryRunner.query(sql, new BeanListHandler<Messages>(
					Messages.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 回复留言（相当于添加一条留言，留言用户名显示店主，留言状态放在已回复留言处，不会被查出）
	public int AnswerMessage() {
		String sql = "insert into messages values(?,?,?,?,?)";
		Object param[] = { null, };
		baseDao.BaseUpdate(sql, param);
		return 0;
	}
}
