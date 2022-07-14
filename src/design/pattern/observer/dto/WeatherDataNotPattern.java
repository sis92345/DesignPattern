package design.pattern.observer.dto;

import design.pattern.observer.display.CurrentConditionDisplay;
import design.pattern.observer.display.ForecastDisplay;
import design.pattern.observer.display.StatisticDisplay;

public class WeatherDataNotPattern {
	
	private double temperature;
	private double humidity;
	private double pressure;
	
	public void setTemperature( double temperature ) {
			this.temperature = temperature;
	}
	
	public void setHumidity( double humidity ) {
			
			this.humidity = humidity;
	}
		
	public void setPressure( double pressure ) {
			this.pressure = pressure;
	}
		
	
	public double getTemperature() {
			return this.temperature;
	}
	
	public double getHumidity() {
			return this.humidity;
	}
	
	public double getPressure() {
			return this.pressure;
	}
	
	/**
	 * 측정 값을 통지합니다.
	 * WeatherData의 필드 값이 변경시 호출됩나다.
	 *
	 * 위 코드는 아래와 같은 문제점을 지닌다
	 * 1. 인터페이스가 아닌 구체적인 구현을 바탕으로 코딩
	 * 2. 새로운 디스플레이 추가시 코드를 변경
	 * 3. 실행 중 디스플레이 항목을 추가하거나 제거할 수 없다.
	 * 4. 디스플레이 항목이 공통적인 인터페이스 구현 X
	 * 5. 바뀌는 부분 캡슐화 X
	 * 6. wheatherData 캡슐화 X
	 *
	 * 7, 강한 결합도를 보인다.
	 * */
	public void measurementsChanges_not_observer_pattern() {
	
		double temp = this.getTemperature();
		double humidity = this.getHumidity();
		double pressure = this.getPressure();
		
		CurrentConditionDisplay cur = new CurrentConditionDisplay();
		StatisticDisplay stat = new StatisticDisplay();
		ForecastDisplay fore = new ForecastDisplay();
		
		cur.update( temp , humidity , pressure );
		stat.update( temp , humidity , pressure );
		fore.update( temp , humidity , pressure );
	}
}
