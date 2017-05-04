package org.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("restaurantBean");
		
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		
		propertyValues.addPropertyValue("welcomeNoteProperty", "Updated welcome note using Bean Factory..!!");
	}

}
