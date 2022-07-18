package design.pattern.factory.abstractfactory.product.cheese;

public class Cheese {
		
		protected String name;
		
		public Cheese(){}
		
		public Cheese( String name ) {
				this.name = name;
		}
		
		public String getName() {
				return name;
		}
}
