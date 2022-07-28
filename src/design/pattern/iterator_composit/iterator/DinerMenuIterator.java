package design.pattern.iterator_composit.iterator;

import design.pattern.iterator_composit.dto.MenuItem;

import java.util.Iterator;

/**
 * Array인 경우 Iterator 구현이 필요하므로 따로 구현
 *
 * 단 직접 구현한 Iterator이므로, 향상된 For문 사용 불가능
 * */
public class DinerMenuIterator implements Iterator<MenuItem> {
		
		MenuItem[] items;
		int position = 0;
		
		/**
		 * 배열의 다음 원소를 리턴하고 position 변수값을 1 증가시킵니다.
		 * */
		public DinerMenuIterator( MenuItem[] items ) {
				this.items = items;
		}
		
		/**
		 * 배열에 있는 모든 원소를 돌았는지 확인한 다음, 더 돌아야 할 원소가 있으면 true를 반환합니다.
		 * */
		@Override
		public boolean hasNext() {
				
				return position < items.length && items[position] != null;
		}
		
		@Override
		public MenuItem next() {
				MenuItem menuItem = items[position];
				position+=1;
				return menuItem;
		}
		
		@Override
		public void remove() {
				throw new UnsupportedOperationException( "메뉴 항목은 지우면 안 됩니다" );
		}
}
