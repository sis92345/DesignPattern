package design.pattern.main;

import design.pattern.command.Invoker;
import design.pattern.command.command.GarageDownCommand;
import design.pattern.command.command.GarageUpCommand;
import design.pattern.command.command.LightOffCommand;
import design.pattern.command.command.LightOnCommand;
import design.pattern.command.receiver.Garage;
import design.pattern.command.receiver.Light;
import design.pattern.decorator.Beverage.Beverage;
import design.pattern.decorator.Beverage.Espresso;
import design.pattern.decorator.decorator.Mocha;
import design.pattern.decorator.decorator.Soy;
import design.pattern.decorator.decorator.Whip;
import design.pattern.observer.display.CurrentConditionDisplay;
import design.pattern.observer.display.ForecastDisplay;
import design.pattern.observer.display.StatisticDisplay;
import design.pattern.observer.subject.WeatherData;

public class DesignPattern {
		
		public static void main( String[] args ) throws InterruptedException {
				
				//System.out.println( "================ 커맨더 패턴" );
				// 1. 디자인 패턴 테스트 : 커멘드 패턴
				//testCommandPattern();
				
				//System.out.println( "================ 옵저버 패턴" );
				//testObserverPattern();
				
				System.out.println( "================ 데코레이터 패턴" );
				testDecoratorPattern();
		}
		
		/**
		 * 디자인 패턴 테스트 : 커멘드 패턴 클라이언트
		 * */
		private static void testCommandPattern() {
				
				Invoker invoker = new Invoker();
				LightOnCommand lightOnCommand = new LightOnCommand( new Light() );
				LightOffCommand lightOffCommand = new LightOffCommand( new Light() );
				GarageUpCommand garageUpCommand = new GarageUpCommand( new Garage() );
				GarageDownCommand garageDownCommand = new GarageDownCommand( new Garage() );
				
				invoker.setCommand( 0 , lightOnCommand , lightOffCommand );
				invoker.setCommand( 1 , garageUpCommand , garageDownCommand );
				invoker.pressedButton( 0 , "on" );
				invoker.pressedButton( 0 , "off" );
				invoker.pressedButton( 1 , "on" );
				invoker.pressedButton( 5 , "on" );
		}
		
		/**
		 * 디자인 패턴 테스트 : 옵저버 패턴
		 * */
		private static void testObserverPattern() throws InterruptedException {
				
				// Subject
				WeatherData weatherData = new WeatherData();
				
				CurrentConditionDisplay cur = new CurrentConditionDisplay();
				StatisticDisplay stat = new StatisticDisplay();
				ForecastDisplay fore = new ForecastDisplay();
				CurrentConditionDisplay pullableObservber = new CurrentConditionDisplay( weatherData );
				
				weatherData.registerObserver( cur )
							.registerObserver( stat )
							.registerObserver( fore );
				
				weatherData.setMeasurements( 21.7 , 3.1 , 4.0 );
				weatherData.setMeasurements( 27.3 , 2.0 , 5.2 );
				weatherData.setMeasurements( 31.5 , 7.1 , 7.1 );
				
				System.out.println( "PULL 방식 옵저버" );
				Thread.sleep( 2000 );
				pullableObservber.pull();
		}
		
		/**
		 * 디자인 패턴 테스트 : 데코레이터 패턴
		 *
		 * */
		private static void testDecoratorPattern() {
				
				// 데코레이터 없을때..
				Beverage deCaf = new Espresso();
				deCaf.setSize( Beverage.Size.VENTI );
				System.out.println( deCaf.getDescription() + " $ " + deCaf.cost() );
				
				// 데코레이터 : 두유에 휘핑 두번 추가
				Beverage whipSoyEspresso = new Espresso();
				whipSoyEspresso.setSize( Beverage.Size.TALL );
				whipSoyEspresso = new Soy( whipSoyEspresso );
				whipSoyEspresso = new Mocha( whipSoyEspresso );
				
				System.out.println( whipSoyEspresso.getDescription() + " $ " + whipSoyEspresso.cost() );
				
		}
}
