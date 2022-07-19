package design.pattern.facade.dto;

public class Tuner {
		
		protected Amplifier amplifier;
		
		public void on() {
				System.out.println( "튜너를 킵니다." );
		}
		
		public void off() {
				System.out.println( "튜너를 끕니다." );
		}
		
		public void setFM() {
				System.out.println( "FM으로 설정" );
		}
		
		public void setAM() {
				System.out.println( "AM으로 설정" );
		}
		
		public void setFrequency( double frequency ) {
				System.out.println( "현재 Frequency" + frequency );
		}
		
		public void setAmplifier( Amplifier amplifier ) {
				this.amplifier = amplifier;
		}
		
		public Amplifier getAmplifier() {
				return amplifier;
		}
}
