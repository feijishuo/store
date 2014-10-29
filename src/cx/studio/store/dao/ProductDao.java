package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.ProductInfo;

public interface ProductDao {
	// 增添商品
	public int insertProduct(ProductInfo productInfo);

	// 修改商品
	public int updateProduct(ProductInfo productInfo);

	// 根据id查找商品
	public ProductInfo findById(int id);

	// 查找所有商品
	public List<ProductInfo> findAllProduct();

	// 查找栏目里面的商品
	public List<ProductInfo> selectColumnProduct(String columnId);

	// 根据id删除商品
	public int deleteProductById(int id);

	// 查找前N个产品为热门商品，暂时设置n=6
	public List<ProductInfo> getHotProduct(int n);

	// 根据编号查询商品
	public ProductInfo findByProductId(String product_id);
}
