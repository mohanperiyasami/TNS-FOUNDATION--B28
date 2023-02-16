package com.tns.orderdetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {
private int id;
private float total;
private String customerid;
private String paymentmode;
private String date;
private String shopid;
public OrderDetails() {

}

public OrderDetails(int id, float total, String customerid, String paymentmode, String date, String shopid) {
	this.id = id;
	this.total = total;
	this.customerid = customerid;
	this.paymentmode = paymentmode;
	this.date = date;
	this.shopid = shopid;
}
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public String getCustomerid() {
	return customerid;
}
public void setCustomerid(String customerid) {
	this.customerid = customerid;
}
public String getPaymentmode() {
	return paymentmode;
}
public void setPaymentmode(String paymentmode) {
	this.paymentmode = paymentmode;
}
public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getShopid() {
	return shopid;
}

public void setShopid(String shopid) {
	this.shopid = shopid;
}

@Override
public String toString() {
	return "OrderDetails [id=" + id + ", total=" + total + ", customerid=" + customerid + ", paymentmode=" + paymentmode
			+ ", date=" + date + ", shopid=" + shopid + "]";
}



}

