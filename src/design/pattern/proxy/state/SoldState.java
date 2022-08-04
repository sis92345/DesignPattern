package design.pattern.proxy.state;

import design.pattern.proxy.GumballMachine;

/**
 * 동전이 없는 상태
 *
 * */
public class SoldState implements State {
		
		GumballMachine gumballMachine;
		
		public SoldState( GumballMachine gumballMachine ) {
				this.gumballMachine = gumballMachine;
		}
		
		@Override
		public void insertQuarter() {
			
				System.out.println( "알맹이를 내보내고 있습니다. 잠시 기다려 주세요." );
		}
		
		@Override
		public void ejectQuarter() {
				System.out.println( "이미 알맹이를 뽑으셨습니다." );
		}
		
		@Override
		public void turnCrank() {
				System.out.println( "손잡이는 한 번만 돌려 주세요." );
		}
		
		@Override
		public void dispense() {
				
				System.out.println( "알맹이를 내보냈습니다." );
				
				if ( gumballMachine.getCount() > 0 ) {
						gumballMachine.setState( gumballMachine.getNoQuarterState() );
				}
				else  {
					gumballMachine.setState( gumballMachine.getSoldOutState() );
				}
				
				gumballMachine.setCount( gumballMachine.getCount()-1 );
		}
}
