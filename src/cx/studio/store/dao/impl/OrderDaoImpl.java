package cx.studio.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.OrderDao;
import cx.studio.store.model.Orders;
import cx.studio.store.model.ProductInfo;
import cx.studio.store.utils.JdbcUtil;

public class OrderDaoImpl implements OrderDao {
	BaseDao baseDao = new BaseDaoImpl();
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	// 查看未发货订单
	public List<Orders> checkUnDeliverOrders(int deliver_state) {
		String sql = "select * from orders where deliver_state=?";
		try {
			Object[] param = { deliver_state };
			return queryRunner.query(sql, param, new BeanListHandler<Orders>(
					Orders.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询未付款订单
	public List<Orders> checkUnPayOrders(int ispay) {
		String sql = "select * from orders where ispay=?";
		try {
			Object[] param = { ispay };
			return queryRunner.query(sql, param, new BeanListHandler<Orders>(
					Orders.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 添加订单
	public int addOrder(Orders order) {
		// 前在前面算好了
		String sql = "insert into orders values(?,?,?,?,?,?,?,?,?,?)";
		Object[] param = { null, order.getOrder_id(), order.getMoney(),
				order.getProduct_id(), order.getNumber(), order.getTelephone(),
				order.getAddress(), order.getDeliver_state(), order.getIspay(),
				order.getOrder_date(), order.getIsReceiving() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 根据id删除订单
	public int deleteOrder(int id) {
		String sql = "delete from orders where id=?";
		Object[] param = { id };
		return baseDao.BaseUpdate(sql, param);
	}

	// 批量删除订单
	public int batchDeleteOrder(String ids) {
		String sql = "delete from orders where id=?";
		return baseDao.DeleteBatch(sql, ids);

	}

	// 根据订单号查询订单
	public ProductInfo findByProductId(String orderId) {
		String sql = "select * from productInfo where product_id=?";
		try {
			Object[] param = { orderId };
			return queryRunner.query(sql, param, new BeanHandler<ProductInfo>(
					ProductInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
