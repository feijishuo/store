package cx.studio.store.model;

/*
 * 订单表
 */
public class Orders {
	private int id;
	private String order_id;
	private double money;
	private String product_id;
	private int number;
	private String telephone;
	private String address;
	private int deliver_state;
	private int ispay;
	private int order_date;
	private int isReceiving;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String orderId) {
		order_id = orderId;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String productId) {
		product_id = productId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDeliver_state() {
		return deliver_state;
	}

	public void setDeliver_state(int deliverState) {
		deliver_state = deliverState;
	}

	public int getIspay() {
		return ispay;
	}

	public void setIspay(int ispay) {
		this.ispay = ispay;
	}

	public int getOrder_date() {
		return order_date;
	}

	public void setOrder_date(int orderDate) {
		order_date = orderDate;
	}

	public int getIsReceiving() {
		return isReceiving;
	}

	public void setIsReceiving(int isReceiving) {
		this.isReceiving = isReceiving;
	}

}
