package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Users;

public interface UserDao {
	// 会员注册
	public int insertUser(Users user);

	// 会员修改信息
	public int updateUser(Users user);

	// 删除用户
	public int deleteUser(int id);

	// 批量删除
	public int BatchDeleteUser(String ids);

	// 查询所有用户
	public List<Users> allUsers();

	// 根据id查询用户
	public Users findById(int id);

}
