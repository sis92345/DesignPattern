package design.pattern.observer.display;

import design.pattern.observer.observer.Observer;

/**
 * 현재 날씨를 표시하는 디스플레이
 * */
public class StatisticDisplay implements Observer , Displayable {
		
		private double temp;
		private double humidity;
		private double pressure;
		
		@Override
		public void update( double temp , double humidity , double pressure ) {
			
				this.temp = temp;
				this.humidity = humidity;
				this.pressure = pressure;
				display();
		}
		
		@Override
		public void display() {
				System.out.println( "===============평균 날씨===============" );
				System.out.println( "기온 : " + this.temp );
				System.out.println( "습도 : " + this.humidity );
				System.out.println( "기압 : " + this.pressure );
				System.out.println( "=====================================" );
		}
}
