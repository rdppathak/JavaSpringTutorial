package org.springcore;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Restaurant implements InitializingBean, DisposableBean{
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
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Restaurant class object destroy method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Restaurant class object init using Initialzing Bean");
		
	}
}
