package design.pattern.factory.abstractfactory.product;

import design.pattern.factory.abstractfactory.factory.PizzaIngredientFactory;

public class PotatoPizza extends Pizza{
		
		PizzaIngredientFactory pizzaIngredientFactory;
		
		public PotatoPizza() {}
		
		public PotatoPizza( PizzaIngredientFactory pizzaIngredientFactory ) {
				this.pizzaIngredientFactory = pizzaIngredientFactory;
		}
		
		@Override
		public void prepare() {
				
				// pizza에 있는 인스턴스 변수에 피지에 사용할 특정 소스의 참고값을 대입,
				// 추상 펙토리에 앚기만 한다면 사용 가능
				cheese = pizzaIngredientFactory.createCheese();
				dough = pizzaIngredientFactory.createDough();
				sauce = pizzaIngredientFactory.createSauce();
		}
}
