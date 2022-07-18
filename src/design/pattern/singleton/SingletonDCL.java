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
public class SingletonDCL {
		
		// volatile 키워드를 사용하면 멀티 쓰레드 환경에서도 uniqueInstance 변수가 초기화 되는 과정이 올바르게 진행
		private volatile static SingletonDCL uniqueInstance;
		
		// 생성자 접근 제한자를 public으로 둠으로서 new로 인스턴스 생성을 제한
		private SingletonDCL() {}
		
		// 유일한 인스턴스 생산 : 정적 메소드
		
		private static SingletonDCL getInstance() {
				
				// 인스턴스가 없다면
				if ( uniqueInstance == null ) {
						
						// 동기화 블록으로 처리
						synchronized (SingletonDCL.class ) {
								
								// 다시 한번 여기서 처리
								if ( uniqueInstance == null ) {
										uniqueInstance = new SingletonDCL();
								}
						}
				}
				
				return uniqueInstance;
		}
}

