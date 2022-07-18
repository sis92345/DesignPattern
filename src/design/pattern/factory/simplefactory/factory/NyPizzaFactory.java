package design.pattern.factory.simplefactory.factory;

import design.pattern.factory.simplefactory.dto.Pizza;
import design.pattern.factory.simplefactory.dto.chicago.NyCheesePizza;
import design.pattern.factory.simplefactory.dto.chicago.NyPepperoniPizza;

public class NyPizzaFactory extends SimplePizzaFactory {
		
		// 여러 팩토리를 묶어 프레임워크로 사용하기 위해 정적 메소드 사용 X
		public SimplePizzaFactory createPizza( String menu ) {
				
				Pizza pizza = null;
				
				if ( "cheese".equals( menu ) ) {
						
						pizza = new NyCheesePizza();
				}
				else if ( "pepperoni".equals( menu ) ) {
						
						pizza = new NyPepperoniPizza();
				}
				else {
						pizza = new Pizza();
				}
				
				super.pizza = pizza;
				return this;
		}
		
		@Override
		public Pizza makePizza() {
				System.out.println( "뉴욕 피자 공장 가동!" );
				return super.pizza.prepare().bake().cut().box();
		}
		
}
