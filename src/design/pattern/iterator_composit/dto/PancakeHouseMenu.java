package design.pattern.iterator_composit.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu {
	
		List<MenuItem> menuItems;
		
		public PancakeHouseMenu() {
				
				this.menuItems = new ArrayList<>();
				
				this.addMenu( "K&B 팬케이크 세트" , "스크램블 에그와 토스트가 곁들어진 팬케이크" , true , 2.99 );
				this.addMenu( "레귤러 팬케이크 세트" , "달걀 프라이와 소시지가 곁들여진 팬케이크" , false , 2.99 );
				this.addMenu( "블루베리 팬케이크" , "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크 세트" , true , 3.99 );
				this.addMenu( "와플" , "취향에 따라 블루베리나 딸기를 얹을 수 있는 와플" , true , 3.59 );
		}
		
		public void addMenu( String name, String description , boolean isVegetarian , double price ) {
				
				this.menuItems.add( new MenuItem( name , description , isVegetarian , price ) );
		}
		
		public List<MenuItem> getMenuItems() {
				return menuItems;
		}
		
		public Iterator<MenuItem> createIterator() {
				
				return menuItems.iterator();
		}
}
