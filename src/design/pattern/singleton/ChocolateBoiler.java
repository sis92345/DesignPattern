package design.pattern.singleton;

public class ChocolateBoiler {
		
		private static ChocolateBoiler chocolateBoiler;
		
		private boolean empty;
		private boolean boiled;
		
		private ChocolateBoiler() {
				empty = true;
				boiled = false;
		}
		
		public void fill() {
				
				if ( isEmpty() ) {
						empty = false;
						boiled = false;
				}
		}
		
		public void drain() {
				
				if ( !isEmpty() && isBoiled() ) {
						boiled = true;
				}
				
		}
		
		public boolean isBoiled() {
				return boiled;
		}
		
		public boolean isEmpty() {
				return empty;
		}
		
		public static synchronized ChocolateBoiler getInstance() {
				
				if ( chocolateBoiler == null ) {
						chocolateBoiler = new ChocolateBoiler();
				}
				
				return chocolateBoiler;
		}
}