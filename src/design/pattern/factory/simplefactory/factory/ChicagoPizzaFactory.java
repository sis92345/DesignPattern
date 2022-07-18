package design.pattern.factory.simplefactory.factory;

import design.pattern.factory.simplefactory.dto.Pizza;
import design.pattern.factory.simplefactory.dto.ny.ChicagoCheesePizza;
import design.pattern.factory.simplefactory.dto.ny.ChicagoPepperoniPizza;

public class ChicagoPizzaFactory extends SimplePizzaFactory{
		
		// 여러 팩토리를 묶어 프레임워크로 사용하기 위해 정적 메소드 사용 X
		public SimplePizzaFactory createPizza( String menu ) {
				
				Pizza pizza = null;
				
				if ( "cheese".equals( menu ) ) {
						
						pizza = new ChicagoCheesePizza();
				}
				else if ( "pepperoni".equals( menu ) ) {
						
						pizza = new ChicagoPepperoniPizza();
				}
				else {
						pizza = new Pizza();
				}
				
				super.pizza = pizza;
				
				return this;
		}
		
		@Override
		public Pizza makePizza() {
				System.out.println( "시카고 피자 공장 가동!" );
				return super.pizza.prepare().bake().cut().box();
		}
}
