package design.pattern.iterator_composit.dto;

import design.pattern.iterator_composit.iterator.DinerMenuIterator;

import java.util.Iterator;

public class DinerMenu implements Menu{
	
		static final int MAX_ITEMS = 6;
		int numberOfItems = 0;
		MenuItem[] menuItems;
		
		public DinerMenu() {
		
				menuItems = new MenuItem[MAX_ITEMS];
				addItem( "채식주의자용 BLT" , "통밀 위에 콩고기 베이컨, 상추, 토마토를 얹은 메뉴" , true , 2.99 );
				addItem( " BLT" , "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴" , false , 2.99 );
				addItem( "오늘의 스프" , "감자 샐러드를 곁들인 오늘의 스프" , false , 3.29 );
				addItem( "핫도그" , "사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그" , false , 3.05 );
		}
		
		public void addItem( String name, String description , boolean isVegetarian , double price ) {
				
				if ( numberOfItems > MAX_ITEMS )  {
						System.err.println( "죄송합니다. 메뉴가 꽉찾습니다. 더 이상 추가할 수 없습니다." );
				}
				else {
						menuItems[numberOfItems] = new MenuItem( name , description , isVegetarian , price );
						this.numberOfItems+=1;
				}
		}
		
		public MenuItem[] getMenuItems() {
				return menuItems;
		}
		
		/**
		 * 저녁 메뉴들의 반복자를 생성해서 반환합니다.
		 * */
		public Iterator<MenuItem> createIterator() {
				
				return new DinerMenuIterator( this.menuItems );
		}
		
}
