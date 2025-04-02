package com.sunbeam.entity;

public class OrderDetails {
	int id;
	int orderId;
	int priceId;
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int id, int orderId, int priceId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.priceId = priceId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPriceId() {
		return priceId;
	}
	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", priceId=" + priceId + "]";
	}
	
	

}
