package design.pattern.template.template;

public class Tea extends CaffeineBeverage{
		
		@Override
		void brew() {
			System.out.println( "찻잎을 우려내는 중" );
		}
		
		@Override
		void addCondiments() {
			System.out.println( "레몬 추가" );
		}
}
