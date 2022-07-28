package design.pattern.iterator_composit.dto;


import java.util.Iterator;

public class Waitress {

		Menu pancakeHouseMenu;
		Menu dinerMenu;
		
		public Waitress( Menu pancakeHouseMenu , Menu dinerMenu ) {
				this.pancakeHouseMenu = pancakeHouseMenu;
				this.dinerMenu = dinerMenu;
		}
		
		/**
		 * 반복자 패턴으로 구혙
		 *
		 * 1. 각 객체는 캡슐화한 컬렉션의 반복자를 제공한다. 캡슐화
		 * 2. 단일 책임 원칙에 따라 객체와 그 객체의 반복자 클래스를 분리하여 역할 분리
		 * 3. 이 클래스는 하위 클래스의 컬렉션의 세부 정보를 몰라도 된다.
		 * 4. 중복 코드를 제거
		 * 5. 구현이 아닌 인터페이스에 집중
		 * */
		public void printMenu() {
				
				Iterator<MenuItem> menuItemIterator = this.pancakeHouseMenu.createIterator();
				Iterator<MenuItem> dinerIterator = this.dinerMenu.createIterator();
				
				System.out.println( "===== 아침 메뉴 =====" );
				printMenu( menuItemIterator );
				
				System.out.println( "===== 저녁 메뉴 =====" );
				printMenu( dinerIterator );
		}
		
		/**
		 * 반복자 패턴을 적용하지 않은 경우
		 *
		 * 1. 객체를 사용하는 클래스에서 해당 클래스의 컬렉션 구현, 정보를 알아야 한다. 캡슐화가 안된다.
		 * 2. 각 객체의 반복 구현 방법이 다르다. 따라서 이 클래스에서 반복코자 객체의 컬렉션 정보를 알아야 한다.
		 * */
		public void badPrintMenu() {
				
//				List<MenuItem> menuItemList = this.pancakeHouseMenu.getMenuItems();
//				MenuItem[] menuItems = this.dinerMenu.getMenuItems();
//
//				menuItemList.forEach( menuItem -> {
//						System.out.print( menuItem.getName() + "," );
//						System.out.print( menuItem.getPrice() + "--" );
//						System.out.print( menuItem.getDescription() );
//						System.out.println("");
//				});
//
//				System.out.println( "===== 저녁 메뉴 =====" );
//				for ( MenuItem menuItem : menuItems ) {
//						System.out.print( menuItem.getName() + "," );
//						System.out.print( menuItem.getPrice() + "--" );
//						System.out.print( menuItem.getDescription() );
//						System.out.println("");
//				}
		}
		
		private void printMenu( Iterator<MenuItem> iterator ) {
				
				while ( iterator.hasNext() ) {
						
						MenuItem menuItem = iterator.next();
						System.out.print( menuItem.getName() + "," );
						System.out.print( menuItem.getPrice() + "--" );
						System.out.print( menuItem.getDescription() );
						System.out.println("");
				}
		}
}
