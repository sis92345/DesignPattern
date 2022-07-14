package design.pattern.observer.observer;

/**
 * Subject 로부터 통지를 받는 Observer 인터페이스
 *
 * 모든 옵저버 클래스는 Observer Interface를 구현해야 한다.
 * */
public interface Observer {
		
		public void update( double temp , double humidity , double pressure );
}
