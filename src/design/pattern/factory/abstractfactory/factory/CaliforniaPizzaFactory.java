package design.pattern.factory.abstractfactory.factory;

import design.pattern.factory.abstractfactory.product.cheese.Cheese;
import design.pattern.factory.abstractfactory.product.cheese.GoatCheese;
import design.pattern.factory.abstractfactory.product.dough.Dough;
import design.pattern.factory.abstractfactory.product.dough.ThickCrustDough;
import design.pattern.factory.abstractfactory.product.sauce.MarinaraSauce;
import design.pattern.factory.abstractfactory.product.sauce.Sauce;

public class CaliforniaPizzaFactory implements PizzaIngredientFactory{
		
		@Override
		public Dough createDough() {
				return new ThickCrustDough();
		}
		
		@Override
		public Sauce createSauce() {
				return new MarinaraSauce();
		}
		
		@Override
		public Cheese createCheese() {
				return new GoatCheese();
		}
}
