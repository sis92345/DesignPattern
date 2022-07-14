package design.pattern.observer.display;

import design.pattern.observer.observer.Observer;

/**
 * 현재 날씨를 표시하는 디스플레이
 * */
public class ForecastDisplay implements Observer , Displayable {
		
		private double temp;
		private double humidity;
		private double pressure;
		
		@Override
		public void update( double temp , double humidity , double pressure ) {
			
				this.temp = temp;
				this.pressure = pressure;
				display();
		}
		
		public void showNotCondition() {
		
		}
		
		@Override
		public void display() {
				System.out.println( "===============일기 예보===============" );
				System.out.println( "기온 : " + this.temp );
				System.out.println( "기압 : " + this.pressure );
				System.out.println( "=====================================" );
		}
}
