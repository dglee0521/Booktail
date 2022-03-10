package org.booktail.domain;

public class OrderDetailDTO {
	private int orderDetailsNum;
	private String orderId;
	private int gdsNum;
	private int carStock;
	
	public int getOrderDetailsNum() {
		return orderDetailsNum;
	}
	public void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public int getCarStock() {
		return carStock;
	}
	public void setCarStock(int carStock) {
		this.carStock = carStock;
	}
	
	@Override
	public String toString() {
		return "OrderDetailDTO [orderDetailsNum=" + orderDetailsNum + ", orderId=" + orderId + ", gdsNum=" + gdsNum
				+ ", carStock=" + carStock + "]";
	}
	
}
