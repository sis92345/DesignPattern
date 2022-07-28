package design.pattern.iterator_composit.dto;

import java.util.Iterator;

public interface Menu {
		
		public Iterator<MenuItem> createIterator();
}
