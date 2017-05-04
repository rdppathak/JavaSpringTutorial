package org.springcore;

import java.util.List;

public class Restaurant {
	private IHotDrink iHotDrink;
	private List restaurantWaitersList;
	
	public void setRestaurantWaitersList(List restaurantWaitersList){
		this.restaurantWaitersList = restaurantWaitersList;
	}
	
	public void displayRestaurantWaitersList(){
		System.out.println("List of waiters in restaurant are: "+this.restaurantWaitersList);
	}
	
	public void setIHotDrink(IHotDrink iHotDrink){
		this.iHotDrink = iHotDrink;
	}
	
	public void prepareHotDrink(){
		this.iHotDrink.prepareHotDrink();
	}
}
