package cx.studio.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.UserDao;
import cx.studio.store.model.Users;
import cx.studio.store.utils.JdbcUtil;

public class UserDaoImpl implements UserDao {
	BaseDao baseDao = new BaseDaoImpl();
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	// 批量删除用户
	public int BatchDeleteUser(String ids) {
		String sql = "delete from users where id=?";
		return baseDao.DeleteBatch(sql, ids);
	}

	public List<Users> allUsers() {
		String sql = "select * from users";
		try {
			return queryRunner.query(sql, new BeanListHandler<Users>(
					Users.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除用户
	public int deleteUser(int id) {
		String sql = "delete from users where id=?";
		Object[] param = { id };
		return baseDao.BaseUpdate(sql, param);
	}

	// 根据id查询用户
	public Users findById(int id) {
		String sql = "select * from users where id=?";
		try {
			Object[] param = { id };
			return queryRunner.query(sql, param, new BeanHandler<Users>(
					Users.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 用户注册
	public int insertUser(Users user) {
		String sql = "insert into users values(?,?,?,?,?,?)";
		Object[] param = { null, user.getUsername(), user.getPassword(),
				user.getEmail(), user.getAddress(), user.getTelephone() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 会员注册
	public int updateUser(Users user) {
		String sql = "update users set username=?,password=?,email=?,address=?,telephone=? where id=?";
		Object[] param = { user.getUsername(), user.getPassword(),
				user.getEmail(), user.getAddress(), user.getTelephone(),
				user.getId() };
		return baseDao.BaseUpdate(sql, param);
	}

}
