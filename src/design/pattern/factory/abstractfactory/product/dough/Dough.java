package design.pattern.factory.abstractfactory.product.dough;

public class Dough {
		
		protected String name;
		
		public Dough(){}
		
		public Dough( String name ) {
				this.name = name;
		}
		
		public String getName() {
				return name;
		}
}
