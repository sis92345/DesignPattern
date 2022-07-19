package design.pattern.main;

import design.pattern.adaptor.Turkey.Turkey;
import design.pattern.adaptor.Turkey.WildTurkey;
import design.pattern.adaptor.Turkey.adaptor.DuckAdaptor;
import design.pattern.adaptor.duck.Duck;
import design.pattern.adaptor.duck.MallardDuck;
import design.pattern.adaptor.duck.adaptor.TurkeyAdapter;
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
import design.pattern.facade.HomeTheaterFacade;
import design.pattern.facade.dto.*;
import design.pattern.factory.abstractfactory.factory.CaliforniaPizzaFactory;
import design.pattern.factory.abstractfactory.factory.SeoulPizzaFactory;
import design.pattern.factory.abstractfactory.product.CheesePizza;
import design.pattern.factory.abstractfactory.product.Pizza;
import design.pattern.factory.simplefactory.Logic.PizzaStore;
import design.pattern.factory.simplefactory.factory.ChicagoPizzaFactory;
import design.pattern.factory.simplefactory.factory.NyPizzaFactory;
import design.pattern.factory.simplefactory.factory.SimplePizzaFactory;
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
				
				//System.out.println( "================ 데코레이터 패턴" );
				//testDecoratorPattern();
				
				System.out.println( "================ 펙토리 패턴" );
				testFactoryPattern();
				
				System.out.println( "================ 어댑터 패턴" );
				testAdaptorPattern();
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
				Beverage whipSoyEspresso = new Espresso(); // beverage
				whipSoyEspresso.setSize( Beverage.Size.TALL );
				whipSoyEspresso = new Soy( whipSoyEspresso ); // soy -> beverage
				whipSoyEspresso = new Mocha( whipSoyEspresso ); // mocha -> soy -> beverage
				
				System.out.println( whipSoyEspresso.getDescription() + " $ " + whipSoyEspresso.cost() );
				
		}
		
		/**
		 * 디자인 패턴 테스트 : 펙토리 패턴
		 *
		 * */
		public static void testFactoryPattern() {
				
				// 여러 팩토리를 사용하는  예
				PizzaStore nyBranch = new PizzaStore( new NyPizzaFactory() );
				PizzaStore chicagoBranch = new PizzaStore( new ChicagoPizzaFactory() );
				
				nyBranch.orderPizza( "cheese" );
				chicagoBranch.orderPizza( "cheese" );
				
				// 정적 메소드를 사용하는 예
				SimplePizzaFactory.createFastPizza( "pepperoni" );
				
				// 추상 팩토리
				Pizza cheesePizza = new CheesePizza( new CaliforniaPizzaFactory() );
				cheesePizza.prepare();
				cheesePizza.cut();
				cheesePizza.box();
				
				Pizza potatoPizza = new CheesePizza( new SeoulPizzaFactory() );
				potatoPizza.prepare();
				potatoPizza.cut();
				potatoPizza.box();
				System.out.println( cheesePizza.toString() );
				System.out.println( potatoPizza.toString() );
		}
		
		/**
		 * 어댑터 패턴
		 * */
		public static void testAdaptorPattern() {
				
				Duck duck = new TurkeyAdapter( new WildTurkey() );
				
				duck.quack();
				duck.fly();
				
				Turkey turkey = new DuckAdaptor( new MallardDuck() );
				turkey.gobble();
				turkey.fly();
		}
		
		/**
		 * 파사드 패턴
		 * */
		public static void testFacadePattern() {
				
				Amplifier amp = new Amplifier("Top-O-Line Amplifier");
				Tuner tuner = new Tuner();
				DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
				CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
				Projector projector = new Projector("Top-O-Line Projector", dvd);
				TheaterLights lights = new TheaterLights( "test" );
				Screen screen = new Screen("Theater Screen");
				PopcornPopper popper = new PopcornPopper("Popcorn Popper");
				
				HomeTheaterFacade homeTheater =
							new HomeTheaterFacade(amp, tuner, dvd, cd,
										projector, screen, lights, popper);
				
				homeTheater.watchMovie( "무비이" );
		}
}
