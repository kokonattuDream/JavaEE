package com.linkedin.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.linkedin.CatalogItem;
import com.linkedin.CatalogLocal;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable {

	@EJB
	private CatalogLocal catalogBean;
	
	private CatalogItem item = new CatalogItem();

	private List<CatalogItem> items = new ArrayList<>();

	public String addItem() {
		long itemId = this.catalogBean.getItems().size() + 1;

		this.catalogBean.addItem(new CatalogItem(itemId, this.item.getName(), this.item.getManufacturer(),
				this.item.getDescription(), this.item.getAvailableDate()));
		
		this.catalogBean.getItems().stream().forEach(item ->{
			System.out.println(item.toString());
		});
		
		return "list?faces-redirect=true";
	}
	
	public void init() {
		this.items = this.catalogBean.getItems();
	}

	public CatalogItem getItem() {
		return item;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}

	public List<CatalogItem> getItems() {
		return items;
	}

	public void setItems(List<CatalogItem> items) {
		this.items = items;
	}

}
