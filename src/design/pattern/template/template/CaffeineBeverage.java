package design.pattern.template.template;

/**
 * Tea와 Coffee 클래스를 추상화한 메소드 특히 prepareRecipe를 추상화하였다.
 *
 * 즉 Coffee와 tea를 일반화한 후 일부 단계를 서브클래스에 의존하는 방식
 * 이 방식은 슈퍼 클래스인 CaffeineBeverage에서 모든것을 관리
 * */
public abstract class CaffeineBeverage {
		
		// 이때 prepareRecipe는 템플릿 메소드 이다. 어떤 알고리즘의 템플릿 역할을 하기 때문
		// 즉 템플릿 메소드는 알고리즘의 각 단계를 정의하며 서브클래스에서 일부 단계를 구현할 수 있도록 한다.ㄴ
		public final void prepareRecipe() {
				
				boilWater();
				brew();
				pourInCup();
				
				if ( isAddCondiments() ) {
						addCondiments();
				}
		}
		
		// 서브 클래스가 구현해야 하는 메소드
		abstract void brew();
		
		abstract void addCondiments();
		
		// 아래는 상속받아서 사용하는 메소드
		void boilWater() {
				System.out.println( "물 끓이는 중" );
		}
		
		void pourInCup() {
				System.out.println( "컵에 따르는 중" );
		}
		
		boolean isAddCondiments () {
				return false;
		}
}
