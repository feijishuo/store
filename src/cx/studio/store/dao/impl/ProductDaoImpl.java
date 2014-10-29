package cx.studio.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.ProductDao;
import cx.studio.store.model.ProductInfo;
import cx.studio.store.utils.JdbcUtil;

public class ProductDaoImpl implements ProductDao {
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	BaseDao baseDao = new BaseDaoImpl();

	public int insertProduct(ProductInfo productInfo) {
		String sql = "insert into productInfo values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = { null, productInfo.getName(),
				productInfo.getProduct_id(), productInfo.getStart_number(), 0,
				productInfo.getPrice(), productInfo.getUnit(),
				productInfo.getImg(), productInfo.getRemark(),
				productInfo.getKeyword(), productInfo.getTypeId(),
				productInfo.getColumnId() };
		baseDao.BaseUpdate(sql, param);
		return 0;
	}

	// 修改商品信息
	public int updateProduct(ProductInfo productInfo) {
		String sql = "update productInfo set name=?,product_id=?,start_number=?,price=?,unit=?,img=?,remark=?,keyword=?,typeId=?,columnId=? where id=?";
		Object[] param = { productInfo.getName(), productInfo.getProduct_id(),
				productInfo.getStart_number(), productInfo.getPrice(),
				productInfo.getUnit(), productInfo.getImg(),
				productInfo.getRemark(), productInfo.getKeyword(),
				productInfo.getTypeId(), productInfo.getColumnId(),
				productInfo.getId() };
		baseDao.BaseUpdate(sql, param);
		return 0;
	}

	// 根据id删除商品
	public int deleteProductById(int id) {
		String sql = "delete * from productInfo where id=?";
		Object[] param = { id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 根据id查找商品详细信息
	public ProductInfo findById(int id) {
		String sql = "select * from productInfo where id=?";
		try {
			return queryRunner.query(sql, new BeanHandler<ProductInfo>(
					ProductInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查找栏目商品
	public List<ProductInfo> selectColumnProduct(String columnId) {
		String sql = "select * from productInfo where columnId=?";
		try {
			return queryRunner.query(sql, columnId,
					new BeanListHandler<ProductInfo>(ProductInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查找全部商品
	public List<ProductInfo> findAllProduct() {
		String sql = "select * from productInfo";
		try {
			return queryRunner.query(sql, new BeanListHandler<ProductInfo>(
					ProductInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询前n条记录
	// text right
	public List<ProductInfo> getHotProduct(int n) {
		String sql = "select * from productInfo order by count desc limit ?";
		try {
			Object[] param = { n };
			return queryRunner.query(sql, param,
					new BeanListHandler<ProductInfo>(ProductInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 根据编号查找商品
	public ProductInfo findByProductId(String productId) {
		String sql = "select * from productInfo where product_id=?";
		try {
			Object[] param = { productId };
			return queryRunner.query(sql, param, new BeanHandler<ProductInfo>(
					ProductInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
