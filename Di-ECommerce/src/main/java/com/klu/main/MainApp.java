package com.klu.main;
import com.klu.config.*;
import com.klu.model.ProductOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductOrder pr=(ProductOrder)context.getBean("order");
		pr.display();
		ApplicationContext c1=new AnnotationConfigApplicationContext(AppConfig.class);
		ProductOrder pr1=c1.getBean(ProductOrder.class);
		pr1.display();
	}

}