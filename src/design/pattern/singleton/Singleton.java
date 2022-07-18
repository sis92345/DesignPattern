package design.pattern.singleton;

// 고전적인 싱글톤 패턴
/**
 * 고전적인 싱글톤 패턴
 * -- getInstance시 필요할 때 인스턴스가 생성되는 게으른 인스턴스 생성 방식이다.
 *
 * -- 문제점
 * 이 방법의 경우 멀티 쓰레드에서 getInstance를 동시에 했을 경우 인스턴스 동시 생성을 막는다 ( synchronized )
 * 하지만 동기화의 경우 인스턴스 생성을 제외한 나머지 순간에 필요 없기 때문에 불필요한 오버헤드를 남긴다.
 * */
public class Singleton {
		
		// Singleton 클래스의 하나뿐인 인스턴스를 저장하는 정적 변수
		private static Singleton uniqueInstance;
		
		// 생성자 접근 제한자를 public으로 둠으로서 new로 인스턴스 생성을 제한
		private Singleton() {}
		
		// 유일한 인스턴스 생산 : 정적 메소드
		private static synchronized Singleton getInstance() {
				
				if ( uniqueInstance == null ) {
						uniqueInstance = new Singleton();
				}
				
				return uniqueInstance;
				
		}
}

