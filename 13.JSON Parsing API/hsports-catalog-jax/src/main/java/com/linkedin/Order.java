package com.linkedin;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

public class Order {

	private long orderId;

	private String storeName;

	private Customer customer;

	private List<InventoryItem> items;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<InventoryItem> getItems() {
		return items;
	}

	@JsonbProperty("inventoryItems")
	public void setItems(List<InventoryItem> items) {
		this.items = items;
	}

}
