package design.pattern.proxy.state;

import design.pattern.proxy.GumballMachine;

/**
 * 동전이 없는 상태
 *
 * */
public class HasQuarterState implements State {
		
		GumballMachine gumballMachine;
		
		public HasQuarterState( GumballMachine gumballMachine ) {
				this.gumballMachine = gumballMachine;
		}
		
		@Override
		public void insertQuarter() {
			
				System.out.println( "동전이 이미 있습니다." );
		}
		
		@Override
		public void ejectQuarter() {
				
				System.out.println( "동전이 반환되었습니다." );
				gumballMachine.setState( gumballMachine.getNoQuarterState() );
		}
		
		@Override
		public void turnCrank() {
				
				System.out.println( "레버를 돌립니다." );
				gumballMachine.setState( gumballMachine.getSoldState() );
		}
		
		@Override
		public void dispense() {
				System.out.println( "동전을 넣어주세요." );
		}
}
