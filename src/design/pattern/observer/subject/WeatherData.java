package design.pattern.observer.subject;

import design.pattern.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
		
		private double temperature;
		private double humidity;
		private double pressure;
		
		private List<Observer> observerList = new ArrayList<>();
		
		public double getTemperature() {
				return this.temperature;
		}
		
		public double getHumidity() {
				return this.humidity;
		}
		
		public double getPressure() {
				return this.pressure;
		}
		
		@Override
		public Subject registerObserver( Observer observer ) {
			observerList.add( observer );
			return this;
		}
		
		@Override
		public Subject removeObserver( Observer observer ) {
			observerList.remove( observer );
			return this;
		}
		
		@Override
		public void notifyObserver() {
			
				observerList.forEach( observer -> {
						observer.update( temperature , humidity , pressure );
				});
		}
		
		public void measurementsChanged() {
				this.notifyObserver();
		}
		
		public void setMeasurements( double temp, double humidity , double pressure ) {
				
				this.temperature = temp;
				this.humidity = humidity;
				this.pressure = pressure;
				measurementsChanged();
		}
}
