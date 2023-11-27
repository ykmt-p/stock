package net.sample_sample.model;

import java.io.Serializable;

public class Shopping implements Serializable{
	
	private String user_id;
	private String product_name;
	private int quantity;
	private String store;
	
	public Shopping () {}
	
	public Shopping(String user_id, String product_name, int quantity, String store) {
		this.user_id = user_id;
	    this.product_name = product_name;
	    this.quantity = quantity;
	    this.store = store;

	  }
	  public String getUser_id() { return user_id; }
	  public String getProduct_name() { return product_name; }
	  public int getQuantity() { return quantity; }
	  public String getStore() { return store; }
	  
	 
}
