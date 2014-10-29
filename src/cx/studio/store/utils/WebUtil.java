package cx.studio.store.utils;

import java.util.Random;
import java.util.UUID;

import cx.studio.store.model.Orders;

public class WebUtil {

	// 生成订单号
	public String getOrderId() {
		UUID uuid = UUID.randomUUID();
		int hashcode = Math.abs(uuid.hashCode());
		String code = hashcode + "";
		code = code.substring(1, 8);
		String orderNumber = "";
		String[] array = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			int n = r.nextInt(52);
			orderNumber += array[n];
		}
		orderNumber = orderNumber + code;
		System.out.println(orderNumber);
		return orderNumber;
	}

	// 得到单个订单总额
	public double getOrderTotalMoney(int number, double price) {
		return number * price;
	}

	// 得到购物车的总金额
	public double getShopTotalMoney(Orders[] orders) {
		double totalMoney = 0;
		for (int i = 0; i < orders.length; i++) {
			double money = orders[i].getMoney();
			totalMoney += money;
		}
		return totalMoney;

	}
}
