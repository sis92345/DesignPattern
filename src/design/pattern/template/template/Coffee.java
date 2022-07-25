package design.pattern.template.template;

public class Coffee extends CaffeineBeverage{
		
		@Override
		void brew() {
			System.out.println( "핕터에 커피를 내리는 중" );
		}
		
		@Override
		void addCondiments() {
			System.out.println( "설탕 및 시럽 추가" );
		}
		
		@Override
		boolean isAddCondiments() {
				
				return true;
		}
}
