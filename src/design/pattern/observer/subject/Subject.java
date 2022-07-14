package design.pattern.observer.subject;

import design.pattern.observer.observer.Observer;

/**
 * Observer를 관리하는 Subject Interface
 *
 * 옵저버에게 통지하는 모든 객체는 이 Subject를 구현해야 한다.
 * */
public interface Subject {
		public Subject registerObserver ( Observer observer );
		public Subject removeObserver ( Observer observer );
		public void notifyObserver ();
}
