package cx.studio.store.dao;

import cx.studio.store.model.Shop;

public interface ShopDao {

	// 添加购物车
	public int insertShopCar(Shop shop);
}
