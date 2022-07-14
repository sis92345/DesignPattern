package design.pattern.observer.display;

import design.pattern.observer.observer.Observer;
import design.pattern.observer.observer.Pullable;
import design.pattern.observer.subject.WeatherData;

/**
 * 현재 날씨를 표시하는 디스플레이
 * */
public class CurrentConditionDisplay implements Observer , Displayable , Pullable {
		
		private double temp;
		private double humidity;
		private double pressure;
		
		private WeatherData weatherData;
		
		public CurrentConditionDisplay() {}
		
		public CurrentConditionDisplay( WeatherData weatherData ) {
				this.weatherData = weatherData;
		}
		
		public WeatherData getWeatherData() {
				return weatherData;
		}
		
		@Override
		public void update( double temp, double humidity, double pressure ) {
				
				this.temp = temp;
				this.humidity = humidity;
				this.display();
		}
		
		@Override
		public void display() {
				
				System.out.println( "===============현재 날씨===============" );
				System.out.println( "기온 : " + this.temp );
				System.out.println( "습도 : " + this.humidity );
				System.out.println( "=====================================" );
		}
		
		@Override
		public void pull() {
			this.temp = this.getWeatherData().getTemperature();
			this.humidity = this.getWeatherData().getHumidity();
			display();
		}
}
