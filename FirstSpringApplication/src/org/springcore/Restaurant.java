package org.springcore;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Restaurant {
	private String welcomeNoteProperty;
	private IHotDrink iHotDrink;
	private List restaurantWaitersList;
	
	public void setWelcomeNoteProperty(String welcomeNoteProperty){
		this.welcomeNoteProperty = welcomeNoteProperty;
	}
	
	public void displayWelcomeNoteProperty(){
		System.out.println(this.welcomeNoteProperty);
	}
	
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
	
	@PostConstruct
	public void init(){
		System.out.println("Restaurant class object init method");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Restaurant class object destroy method");
	}
}
