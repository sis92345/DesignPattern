package design.pattern.state;

import design.pattern.state.state.*;

/**
 * 이 코드는 아래와 같은 점 때문에 좋지 않다.
 *
 * 1, OCP를 지키지 않고 있다.
 * 2. 객체 지향 디자인이 아니다.
 * 3. 상태 전환이 복잡한 조건문 속에 숨어 있어서 분명하게 드러나지 않는다.
 * 4. 바뀌는 부분을 캡슐화 하고 있지 않다.
 * 5. 사이드 이펙트!
 * */
public class GumballMachine {
		
		State soldOutState;
		State noQuarterState;
		
		State hasQuarterState;
		
		State soldState;
		
		State state;
		
		int count = 0;
		public GumballMachine( int numberGumballs ) {
				
				noQuarterState = new NoQuarterState( this );
				soldState = new SoldState( this );
				soldOutState = new SoldOutState( this );
				hasQuarterState = new HasQuarterState( this );
				
				this.count = numberGumballs;
				
				if ( numberGumballs > 0 ) {
						state = noQuarterState;
				}
				else {
						state = soldOutState;
				}
		}
		
		/** 실제 동작 메소드 */
		public void insertQuarter() {
				state.insertQuarter();
		}
		
		public void ejectQuarter() {
				state.ejectQuarter();
		}
		
		public void turnCrank() {
				state.turnCrank();
				state.dispense();
		}
		
		/** Getter Setter */
		
		public void setState( State state ) {
				this.state = state;
		}
		
		public State getState() {
				return state;
		}
		
		public State getNoQuarterState() {
				return noQuarterState;
		}
		
		public State getHasQuarterState() {
				return hasQuarterState;
		}
		
		public State getSoldOutState() {
				return soldOutState;
		}
		
		public State getSoldState() {
				return soldState;
		}
		
		public int getCount() {
				return count;
		}
}
