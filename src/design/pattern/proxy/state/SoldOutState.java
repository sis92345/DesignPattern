package design.pattern.proxy.state;

import design.pattern.proxy.GumballMachine;

/**
 * 동전이 없는 상태
 *
 * */
public class SoldOutState implements State {
		
		GumballMachine gumballMachine;
		
		public SoldOutState( GumballMachine gumballMachine ) {
				this.gumballMachine = gumballMachine;
		}
		
		@Override
		public void insertQuarter() {
			
				System.out.println( "동전을 넣으셨습니다." );
				gumballMachine.setState( gumballMachine.getNoQuarterState() );
		}
		
		@Override
		public void ejectQuarter() {
				System.out.println( "동전을 넣어주세요." );
		}
		
		@Override
		public void turnCrank() {
				System.out.println( "매진되었습니다. 다음에 이용해주세요." );
		}
		
		@Override
		public void dispense() {
				System.out.println( "동전을 넣어주세요." );
		}
}
