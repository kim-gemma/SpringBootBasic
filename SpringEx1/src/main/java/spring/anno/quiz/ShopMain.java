package spring.anno.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //OrderController에 있는 메서드 2개를 호출하여 출력하시오
		
		ApplicationContext quiz=
				new ClassPathXmlApplicationContext("quizContext.xml");
		OrderController order=(OrderController)quiz.getBean("orderController");
		
		order.jumunInsert("아령", 28000);
		order.jumunSelect("요가나시", 55000);
	}

}
