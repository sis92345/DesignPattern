# IteratorPattern

# 1. Iterator Patten 이란

**반복자 패턴**이란 (Iterator Pattern) **컬렉션의 구현 방법을 노출하지 않으면서 집합체 내의 모든 항목에 접근하는 방법을 제공**합니다.



## 1-2. Iterator Pattern을 구현한 코드와 비교

```java
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

  Iterator pancakeIterator = this.pancakeHouseMenu.createIterator();
  Iterator dinerIterator = this.dinerMenu.createIterator();

  System.out.println( "===== 아침 메뉴 =====" );
  printMenu( pancakeIterator );

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

  List<MenuItem> menuItemList = this.pancakeHouseMenu.getMenuItems();
  MenuItem[] menuItems = this.dinerMenu.getMenuItems();

  menuItemList.forEach( menuItem -> {
    System.out.print( menuItem.getName() + "," );
    System.out.print( menuItem.getPrice() + "--" );
    System.out.print( menuItem.getDescription() );
    System.out.println("");
  });

  System.out.println( "===== 저녁 메뉴 =====" );
  for ( MenuItem menuItem : menuItems ) {
    System.out.print( menuItem.getName() + "," );
    System.out.print( menuItem.getPrice() + "--" );
    System.out.print( menuItem.getDescription() );
    System.out.println("");
  }
}
```



# 2. Iterator Pattern 구현

![1](https://user-images.githubusercontent.com/68282095/181517984-56f7f3db-289b-4ad3-b032-d144b27d9ea9.png)

- Iterator : 모든 반복자가 구현해야 하는 인터페이스를 제공한다. 기본적으로 제공하는 Iterator Interface를 사용하고 싶지않다면 직접 구현 가능
- ConcreteIterator : Iterator 구현체, 반복 작업 중 현재 위치를 관리한다.
- Aggreate : 반복할 객체 컬렉션이 들어있는곳, 이곳의 컬렉션을 Iterator로 반환하는 createIterater 메소드를 구현해야 한다.

# 3. 디자인 원칙 7 : 단일 역할 원칙

어떤 클래스에서 맡고 있는 모든 역할은 나중에 코드 변화를 불러올 수 있다. 따라서 역할이 2개이상 있다면, 바뀔 수 있는 부분이 2개 이상 있는 것이다. 이 원칙에 따라 **하나의 클래스에는 하나의 역할만 맡아야 한다.**