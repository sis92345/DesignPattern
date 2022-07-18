package design.pattern.factory.abstractfactory.product;

import design.pattern.factory.abstractfactory.factory.PizzaIngredientFactory;

public class CheesePizza extends Pizza{
		
		PizzaIngredientFactory pizzaIngredientFactory;
		
		public CheesePizza() {}
		
		public CheesePizza( PizzaIngredientFactory pizzaIngredientFactory ) {
				this.pizzaIngredientFactory = pizzaIngredientFactory;
		}
		
		@Override
		public void prepare() {
				
				cheese = pizzaIngredientFactory.createCheese();
				dough = pizzaIngredientFactory.createDough();
				sauce = pizzaIngredientFactory.createSauce();
		}
}
