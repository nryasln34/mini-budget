package com.minibudget;

import com.minibudget.config.WebConfig;
import com.minibudget.service.impl.MiniBudgetService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.minibudget.config.WebConfig;

@Configuration
@ComponentScan({ "com.minibudget" })
public class MiniBudgetApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MiniBudgetApplication.class);
		SessionFactory sf = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
		new WebConfig(ctx.getBean(MiniBudgetService.class),sf);
		ctx.registerShutdownHook(); //Spring Framework'ün bir web application'u kapatma methodu(Application Context'le çalışmakta)


	}

}
