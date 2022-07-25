package design.pattern.template.dto;

public class Coffee {
		
		public void prepareRecipe() {
				boilWater();
				brewCoffeeGrinds();
				pourInCup();
				addSugarAndMilk();
		}
		
		// 아레 메소드들은 알고리즘의 각 단계를 구현하고 있다. -> Coffee와 중복된 코드가 존재
		public void boilWater() {
				System.out.println( "물 끓이는 중" );
		}
		
		public void brewCoffeeGrinds() {
				System.out.println( "필터로 커피를 우려내는 중" );
		}
		
		public void pourInCup() {
				System.out.println( "컵에 따르는 중" );
		}
		
		public void addSugarAndMilk() {
				System.out.println( "설탕과 우유를 추가하는 중" );
		}
}
