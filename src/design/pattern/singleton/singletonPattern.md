#  Singleton Pattern

# 1. 싱글톤 패턴이란

로그 기록용 객체, 스레드 풀, 캐시 등 오히려 인스턴스가 2개 이상 있으면 문제가 발생하는 객체들이 있다. 이때 **싱글톤 패턴은 특정 클래스에 객체 인스턴스가 하나만 만들어지도록 해 주는 패턴이다.**  싱글톤 패턴을 사용하면 전역 변수 처럼 언제 어디에서든지 인스턴스를 참조할 수 있다.

- 싱글턴 패턴을 적용할 때는 클래스에서 단 하나뿐인 인스턴스를 관리하도록 하면된다.

  ```java
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
  ```

- 단 싱글톤 패턴으로 생성된 인스턴스는 어디에서든 접근할 수 있도록 전역 접근 지점을 제공해야 한다 (getInstance)

# 2. 싱글톤 패턴 사용시 멀티 쓰레드 문제

싱글턴 패턴을 게으른 인스턴스 생성 방식으로 사용할 경우 멀티쓰레드에 의해 두 인스턴스가 생성될 수 있다. 따라서 getInstance()의 속도가 중요하지 않다면 `synchronized` 키워드로 쓰레드를 동기화 시키거나 처음부터 인스턴스를 생성하면 된다.

```java
package design.pattern.singleton;

/**
 * 빠른 인스턴스 생성
 * */
public class Singleton2 {
		
		// Singleton 클래스의 하나뿐인 인스턴스를 저장하는 정적 변수
		private static Singleton2 uniqueInstance = new Singleton2();
		
		// 생성자 접근 제한자를 public으로 둠으로서 new로 인스턴스 생성을 제한
		private Singleton2() {}
		
		// 유일한 인스턴스 생산 : 정적 메소드
		private static synchronized Singleton2 getInstance() {
			
				return uniqueInstance;
				
		}
}
```

또는 DCL ( Double-Checked Locking)을 사용해서 처리할 수 있다.

```java
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
```

 