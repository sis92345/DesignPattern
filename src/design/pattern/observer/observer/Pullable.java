package design.pattern.observer.observer;

/**
 * 기존 Observer는 Subject에서 Observer로 통지해 주는 방식
 * 반대로 Observer에서 요청하는 Pull 방식의 옵저버 구현 인터페이스
 *
 * 다만 이 방식을 사용하면 결합도가 높아질 수 있음
 * */
public interface Pullable {
		
		public void pull();
}
