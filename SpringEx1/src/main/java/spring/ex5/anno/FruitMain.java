package spring.ex5.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FruitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ApplicationContext app=
    		  new ClassPathXmlApplicationContext("annoContext4.xml");
      
      Apple apple=(Apple)app.getBean("apple");
      apple.writeFruitName();
      System.out.println("==================================");
      MyFruit my=(MyFruit)app.getBean("myFruit");
      my.writeFruit();
	}

}
