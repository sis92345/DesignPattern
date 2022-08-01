package design.pattern.state.state;

import design.pattern.state.GumballMachine;

/**
 * 동전이 없는 상태
 *
 * */
public class NoQuarterState implements State {
		
		GumballMachine gumballMachine;
		
		public NoQuarterState( GumballMachine gumballMachine ) {
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
				System.out.println( "동전을 넣어주세요." );
		}
		
		@Override
		public void dispense() {
				System.out.println( "동전을 넣어주세요." );
		}
}
