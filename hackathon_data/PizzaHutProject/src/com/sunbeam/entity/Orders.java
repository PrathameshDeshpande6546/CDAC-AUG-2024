package com.sunbeam.entity;

import java.sql.Date;
import java.sql.Time;

public class Orders {
	int id;
	int customerId;
	Date orderTime ;
	String status;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int id, int customerId, Date orderTime, String status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderTime = orderTime;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerId=" + customerId + ", orderTime=" + orderTime + ", status=" + status
				+ "]";
	}
	

}
