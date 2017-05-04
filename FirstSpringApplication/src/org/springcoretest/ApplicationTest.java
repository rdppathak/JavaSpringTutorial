package org.springcoretest;

import org.springcore.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {

	public static void main(String args[]){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Restaurant restaurantObj = (Restaurant) context.getBean("restaurantBean");
		restaurantObj.setWelcomeNoteProperty("Setting object1 welcome note...!!");
		restaurantObj.displayWelcomeNoteProperty();
		
		Restaurant restaurantObj2 = (Restaurant) context.getBean("restaurantBean");
		restaurantObj2.displayWelcomeNoteProperty();
	}
}