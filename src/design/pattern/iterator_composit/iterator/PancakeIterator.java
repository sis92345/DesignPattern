package design.pattern.iterator_composit.iterator;

import design.pattern.iterator_composit.dto.MenuItem;
import java.util.List;

/**
 *
 * @deprecated List는 Iterator를 사용하므로 사용 안함
 * */
public class PancakeIterator implements Iterator {
		
		List<MenuItem> menuItems;
		
		int position = 0;
		
		public PancakeIterator( List<MenuItem> list ) {
				
				this.menuItems = list;
		}
		@Override
		public boolean hasNext() {
		
				return menuItems.size() > position;
		}
		
		@Override
		public MenuItem next() {
				
				MenuItem menuItem = this.menuItems.get( position );
				position+=1;
				return menuItem;
		}
		
		@Override
		public void remove() {
				throw new UnsupportedOperationException( "메뉴 항목은 지우면 안 됩니다" );
		}
}
