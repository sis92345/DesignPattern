package design.pattern.factory.badcase;

import design.pattern.factory.simplefactory.dto.CheesePizza;
import design.pattern.factory.simplefactory.dto.PepperoniPizza;
import design.pattern.factory.simplefactory.dto.Pizza;

// 펙토리를 사용안한 경웉
public class OrderPizza {
		// BAD CASE : 피자 인스턴스를 만드는 코드가 메소드 안에 있음으로서 캡슐화 X, 재사용 X 등 모든 문제 발생
		private Pizza orderPizza_bad( String menu ) {
				
				Pizza pizza = null;
				
				// 만약 감자 피자가 추가된다면. 페페로니 피자가 없어진다면 이 코드를 매번 수정해야 한다.
				// 즉 상황이 변하면 이 코드가 반드시 변경되어야 한다 : OCP에 위반
				if ( "cheese".equals( menu ) ) {
						
						pizza = new CheesePizza();
				}
				else if ( "Pepperoni".equals( menu ) ) {
						
						pizza = new PepperoniPizza();
				}
				else {
						pizza = new Pizza();
				}
				
				return pizza.prepare().bake().cut().box();
		}
}
