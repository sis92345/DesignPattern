package design.pattern.factory.abstractfactory.factory;

import design.pattern.factory.abstractfactory.product.cheese.Cheese;
import design.pattern.factory.abstractfactory.product.dough.Dough;
import design.pattern.factory.abstractfactory.product.sauce.Sauce;

public interface PizzaIngredientFactory {
		
		public Dough createDough();
		public Sauce createSauce();
		public Cheese createCheese();
}
