package design.pattern.factory.abstractfactory.product;

import design.pattern.factory.abstractfactory.product.cheese.Cheese;
import design.pattern.factory.abstractfactory.product.dough.Dough;
import design.pattern.factory.abstractfactory.product.sauce.Sauce;

public abstract class Pizza {
		
		protected Dough dough;
		protected Sauce sauce;
		protected Cheese cheese;
		protected String name;
		
		public abstract void prepare();
		
		public void bake() {
				System.out.println( "175도에서 25분 간 굽기" );
		}
		
		public void cut() {
				System.out.println( "피자를 8조각으로 자르기" );
		}
		
		public void box() {
				System.out.println( "피자를 박스에 담기" );
		}
		
		public String toString() {
				
				return dough.getName() + sauce.getName() + cheese.getName() + "피자";
		}
}
