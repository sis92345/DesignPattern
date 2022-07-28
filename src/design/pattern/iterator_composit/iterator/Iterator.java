package design.pattern.iterator_composit.iterator;

import design.pattern.iterator_composit.dto.MenuItem;

/**
 * 반복자 패턴을 위한 이터레이터 구현
 * */
public interface Iterator {
		
		boolean hasNext();
		MenuItem next();
		
		void remove();
}
