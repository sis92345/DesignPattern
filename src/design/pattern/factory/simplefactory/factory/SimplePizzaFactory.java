package design.pattern.factory.simplefactory.factory;

import design.pattern.factory.simplefactory.dto.CheesePizza;
import design.pattern.factory.simplefactory.dto.PepperoniPizza;
import design.pattern.factory.simplefactory.dto.Pizza;

public abstract class SimplePizzaFactory {
		
		protected Pizza pizza;
		// 여러 팩토리를 묶어 프레임워크로 사용하기 위해 정적 메소드 사용 X
		public SimplePizzaFactory createPizza( String menu ) {
				
				Pizza pizza = null;
				
				if ( "cheese".equals( menu ) ) {
						
						pizza = new CheesePizza();
				}
				else if ( "pepperoni".equals( menu ) ) {
						
						pizza = new PepperoniPizza();
				}
				else {
						pizza = new Pizza();
				}
				
				this.pizza = pizza;
				return this;
		}
		
		public abstract Pizza makePizza();
		// 정적 메소드로 구현한 사례
		// pizzamaker_bad의 인스턴스를 얻는 코드
		// 단순히 코드를 옮겼을 뿐이지만, Pizza 클래스를 만드는 부분을 캡슐화 했다는 점에서 엄청난 의미가 있다. 이 코드가 다른 메소드에 박혀있을 경우와 다르게 피자가 필요한 모든 곳에서 이 펙토리가 필요하다.
		// 보통 팩토리는 정적 메소드와 많이 사용한다.
		public static Pizza createFastPizza( String menu ) {
				
				Pizza pizza = null;
				
				if ( "cheese".equals( menu ) ) {
						
						pizza = new CheesePizza();
				}
				else if ( "pepperoni".equals( menu ) ) {
						
						pizza = new PepperoniPizza();
				}
				else {
						pizza = new Pizza();
				}
				
				return pizza;
		}
}
