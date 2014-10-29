package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Orders;
import cx.studio.store.model.ProductInfo;

public interface OrderDao {
	// 查看未发货订单
	public List<Orders> checkUnDeliverOrders(int deliver_state);

	// 查看未付款订单
	public List<Orders> checkUnPayOrders(int ispay);

	// 前台的添加订单
	public int addOrder(Orders order);

	// 删除订单
	public int deleteOrder(int id);

	// 批量删除订单
	public int batchDeleteOrder(String ids);

	// 根据订单号查询订单
	public ProductInfo findByProductId(String orderId);

}
