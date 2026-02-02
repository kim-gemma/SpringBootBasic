package spring.anno.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderController {

	@Autowired
	ShopDaoInter shopInter;
	
	int cnt=20;
	String name="김나나";
	
	public void jumunInsert(String sang,int p)
	{
		shopInter.insertShop(sang, p);
		System.out.println(name+"님이 "+cnt+"개 주문함!!!!");
	}
	
	public void jumunSelect(String sang,int p)
	{
		shopInter.selectShop(sang, p);
		System.out.println("주문자: "+name);
		System.out.println("주문개수: "+cnt+"개");
	}
}
