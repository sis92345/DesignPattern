package design.pattern.factory.abstractfactory.product.sauce;

public class Sauce {
		
		protected String name;
		
		public Sauce(){}
		
		public Sauce( String name ) {
				this.name = name;
		}
		
		public String getName() {
				return name;
		}
}
