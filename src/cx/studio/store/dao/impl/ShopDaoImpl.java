package cx.studio.store.dao.impl;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.ShopDao;
import cx.studio.store.model.Shop;

public class ShopDaoImpl implements ShopDao {
	BaseDao baseDao = new BaseDaoImpl();

	// 添加购物车（当点击加入购物车的时候就生成订单，把订单放到购物车，总计是计算 出来的，每个订单的和）
	public int insertShopCar(Shop shop) {
		String sql = "insert into shop values(?,?,?)";
		Object[] param = { null, shop.getOrder_id(), shop.getOrder_id() };
		return baseDao.BaseUpdate(sql, param);
	}
}
