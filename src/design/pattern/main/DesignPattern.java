package design.pattern.main;

import design.pattern.command.Invoker;
import design.pattern.command.command.GarageDownCommand;
import design.pattern.command.command.GarageUpCommand;
import design.pattern.command.command.LightOffCommand;
import design.pattern.command.command.LightOnCommand;
import design.pattern.command.receiver.Garage;
import design.pattern.command.receiver.Light;

public class DesignPattern {
		
		public static void main( String[] args ) {
		
				// 1. 디자인 패턴 테스트 : 커멘드 패턴
				testCommandPattern();
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
}
