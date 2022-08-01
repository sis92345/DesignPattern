package design.pattern.state.state;

public interface State {
		
		// 아래는 상태를 전환하는 메소드 : 서브 클래스에서는 상태 클래스이며, 아래 동작을 구현해서 사용
		
		// 동전을 넣는다.
		public void insertQuarter();
		
		// 동전을 반환받는다.
		public void ejectQuarter();
		
		// 레버를 돌린다.
		public void turnCrank();
		
		// 알맹이를 반환한다.
		public void dispense();
}
