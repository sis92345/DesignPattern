package design.pattern.template.dto;

public class Tea {
		
		public void prepareRecipe() {
				boilWater();
				steepTeaBag();
				pourInCup();
				addLemon();
		}
		
		// 아레 메소드들은 알고리즘의 각 단계를 구현하고 있다 -> Tea와 중복된 코드가 존쟅
		public void boilWater() {
				System.out.println( "물 끓이는 중" );
		}
		
		public void steepTeaBag() {
				System.out.println( "찻잎을 우려내는 중" );
		}
		
		public void addLemon() {
				System.out.println( "레몬을 추가하는 중" );
		}
		
		public void pourInCup() {
				System.out.println( "컵에 따르는 중" );
		}
}
