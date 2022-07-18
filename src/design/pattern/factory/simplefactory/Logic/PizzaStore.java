package design.pattern.factory.simplefactory.Logic;

import design.pattern.factory.simplefactory.dto.Pizza;
import design.pattern.factory.simplefactory.factory.SimplePizzaFactory;

public class PizzaStore {
		
		SimplePizzaFactory simplePizzaFactory;
		
		public PizzaStore(){}
		
		public PizzaStore( SimplePizzaFactory simplePizzaFactory ) {
				this.simplePizzaFactory = simplePizzaFactory;
		}
		
		public Pizza orderPizza( String menu ) {
				
				return simplePizzaFactory.createPizza( menu ).makePizza();
		}
}
