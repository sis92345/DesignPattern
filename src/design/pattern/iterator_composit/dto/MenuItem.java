package design.pattern.iterator_composit.dto;

public class MenuItem {
		
		String name;
		String description;
		boolean isVegetarian;
		double price;
		
		public MenuItem( String name , String description , boolean isVegetarian , double price ) {
				
				this.name = name;
				this.description = description;
				this.isVegetarian = isVegetarian;
				this.price = price;
		}
		
		// 아래 Getter로 각 필드에 접근할 수 있다.
		public String getName() {
				return name;
		}
		
		public String getDescription() {
				return description;
		}
		
		public double getPrice() {
				return price;
		}
		
		public boolean isVegetarian() {
				return isVegetarian;
		}
}
