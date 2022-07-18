package design.pattern.factory.abstractfactory.factory;

import design.pattern.factory.abstractfactory.product.cheese.Cheese;
import design.pattern.factory.abstractfactory.product.cheese.ReggianoCheese;
import design.pattern.factory.abstractfactory.product.dough.Dough;
import design.pattern.factory.abstractfactory.product.dough.ThinCrustDough;
import design.pattern.factory.abstractfactory.product.sauce.PlumTomatoSauce;
import design.pattern.factory.abstractfactory.product.sauce.Sauce;

public class SeoulPizzaFactory implements PizzaIngredientFactory{
		
		@Override
		public Dough createDough() {
				return new ThinCrustDough();
		}
		
		@Override
		public Sauce createSauce() {
				return new PlumTomatoSauce();
		}
		
		@Override
		public Cheese createCheese() {
				return new ReggianoCheese();
		}
}
