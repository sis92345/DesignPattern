# Template Method Pattern

# TR;DR

- 템플릿 메소드는 알고리즘의 각 단계를 정의하여, 일부 단계를 서브 클래스에서 구현할 수 있다.
- 템플릿 메소드 패턴은 코드 재사용에 큰 도움이 된다.
- 템플릿 메소드가 들어있는 추상 클래스는 구상 메소드, 추상 메소드, 후크를 정의할 수 있다.
- 추상 메소드는 서브클래스에서 구현해야 한다.
- 후크는 추상 클래스에 들어있는 메소드로 아무 일도 하지 않거나 기본 행동만 정의한다. 서브클래스에서는 후크를 필요하다면 오버라이드해서 사용할 수 있다.
- 할리우드 원칙에 의하면, 저수준 모듈은 언제 어떻게 호출할지는 고수준 모듈에서 결정하는 것이 좋다.
- 템플릿 메소드 패턴은 실전에서도 꽤 자주 쓰이지만, 반드시 교과서적인 방식으로 적용되지는 않는다.
- 전략 패턴과 템플릿 메소드 패턴은 모두 알고리즘을 캡슐화하는 패턴이지만, 전략 패턴은 상속을, 템플릿 메소드 패턴은 구성을 사용한다.
- 팩토리 메소드 패턴은 특화된 템플릿 메소드 패턴이다.

# 1. Template Method Pattern 란?

 **템플릿 메소드 패턴이란 알고리즘의 골격을 정의한다**. *템플릿 메소드를 사용하면 알고리즘의 일부 단계를 서브클래스에서 구현할 수 있으며, 알고리즘의 구조는 그대로 유지하면서, 알고리즘의 특정 단계를 서브클래스에서 재정의할 수도 있다.*

- Template Method Pattern의 장점
  1. 실제 알고리즘 작업은 슈퍼 추상 클래스에서 처리한다. 즉 알고리즘을 독점한다.
  2. 슈퍼 클래스에서 작성한 코드를 재사용할 수 있다.
  3. 알고리즘이 한 군데에 모여 있다. 따라서 한 부분만 고치면 된다.
  4. 다른 서브 클래스를 추가하는 것으로 쉽게 알고리즘을 구현할 수 있다.
  5. 일부 구현만 실제 서브 클래스에서 의존
- Template Method Pattern의 단점
  1. 추상 메소드가 많아지면 서브 클래스에서 일일히 추상 메소드를 구현해야 한다.
     - hook를 잘 이용하거나, 알고리즘 구분을 더 적게 나누는 방법이 있다.

# 2. Template Method Pattern의 구현

<img width="389" alt="1" src="https://user-images.githubusercontent.com/68282095/180774268-d64c5616-2059-4356-9a45-55c5ea6c7ed5.png">



- Abstract Class : 템플릿 메소드가 들어있다. abstract method들이 Template Method에서 활용된다.
- Concrete Class : 구현 클래스는 여러개가 있을 수 있다. 각 클래스는 템플릿 메소드에서 요구하는 각 단계를 제공해야 한다.

각각의 구현된 추상화 클래스는 모두 외부에서 접근하지 못하도록 default 접근 제한자로 설정하는 것이 좋다.

```java
package design.pattern.template.template;

public abstract class Template {
      
      // Template Method : 오버라이딩하지 못하도록 final 처리
      public final void templateMethod() {
            
            primitiveOperation1();
            primitiveOperation2();
            concreteOperation();
            hook();
      }
      
      // 서브 클래스에서 구현
      abstract void primitiveOperation1();
      
      abstract void primitiveOperation2();
      
      final void concreteOperation() {
            
            // Template 자체 구현 코드
      }
      
      // Hook 구상 메소드 : 서브 클래스에서 구현할 수도 있는 옵션
      void hook() {}
}
```

## 2-1. Template Method 예제

1. Abstract class

   ```java
   package design.pattern.template.template;
   
   /**
    * Tea와 Coffee 클래스를 추상화한 메소드 특히 prepareRecipe를 추상화하였다.
    *
    * 즉 Coffee와 tea를 일반화한 후 일부 단계를 서브클래스에 의존하는 방식
    * 이 방식은 슈퍼 클래스인 CaffeineBeverage에서 모든것을 관리
    * */
   public abstract class CaffeineBeverage {
   		
   		// 이때 prepareRecipe는 템플릿 메소드 이다. 어떤 알고리즘의 템플릿 역할을 하기 때문
   		// 즉 템플릿 메소드는 알고리즘의 각 단계를 정의하며 서브클래스에서 일부 단계를 구현할 수 있도록 한다.ㄴ
   		public final void prepareRecipe() {
   				
   				boilWater();
   				brew();
   				pourInCup();
   				
   				if ( isAddCondiments() ) {
   						addCondiments();
   				}
   		}
   		
   		// 서브 클래스가 구현해야 하는 메소드
   		abstract void brew();
   		
   		abstract void addCondiments();
   		
   		// 아래는 상속받아서 사용하는 메소드
   		void boilWater() {
   				System.out.println( "물 끓이는 중" );
   		}
   		
   		void pourInCup() {
   				System.out.println( "컵에 따르는 중" );
   		}
   		
   		boolean isAddCondiments () {
   				return true;
   		}
   }
   ```

2. Concrete Class

   ```java
   package design.pattern.template.template;
   
   public class Coffee extends CaffeineBeverage{
   		
   		@Override
   		void brew() {
   			System.out.println( "핕터에 커피를 내리는 중" );
   		}
   		
   		@Override
   		void addCondiments() {
   			System.out.println( "설탕 및 시럽 추가" );
   		}
   		
   		@Override
   		boolean isAddCondiments() {
   				
   				return true;
   		}
   }
   ```

## 2-2. 후크 사용

hook 메소드는 추상 클래스에서 선언되지만 기본적인 내용만 구현되어 있거나, 아무것도 구현되어 있지 않은 메소드이다. 이러한 메소드를 hook 이라고 부르며, 이 hook으로 서브클래스에서 다양한 위치에 알고리즘을 끼울 수 있다.

```java
package design.pattern.template.template;

/**
 * Tea와 Coffee 클래스를 추상화한 메소드 특히 prepareRecipe를 추상화하였다.
 *
 * 즉 Coffee와 tea를 일반화한 후 일부 단계를 서브클래스에 의존하는 방식
 * 이 방식은 슈퍼 클래스인 CaffeineBeverage에서 모든것을 관리
 * */
public abstract class CaffeineBeverage {
		
		// 이때 prepareRecipe는 템플릿 메소드 이다. 어떤 알고리즘의 템플릿 역할을 하기 때문
		// 즉 템플릿 메소드는 알고리즘의 각 단계를 정의하며 서브클래스에서 일부 단계를 구현할 수 있도록 한다.ㄴ
		public final void prepareRecipe() {
				
				boilWater();
				brew();
				pourInCup();
				
				if ( isAddCondiments() ) {
						addCondiments();
				}
		}
		
		// 서브 클래스가 구현해야 하는 메소드
		abstract void brew();
		
		abstract void addCondiments();
		
		// 아래는 상속받아서 사용하는 메소드
		void boilWater() {
				System.out.println( "물 끓이는 중" );
		}
		
		void pourInCup() {
				System.out.println( "컵에 따르는 중" );
		}
		
		boolean isAddCondiments () {
				return true;
		}
}
```

```java
package design.pattern.template.template;

public class Coffee extends CaffeineBeverage{
		
		@Override
		void brew() {
			System.out.println( "핕터에 커피를 내리는 중" );
		}
		
		@Override
		void addCondiments() {
			System.out.println( "설탕 및 시럽 추가" );
		}
		
		@Override
		boolean isAddCondiments() {
				
				return true;
		}
}
```

# 3. 디자인 원칙 6 : 할리우드 원칙 ( 의존성 부패 )

의존성 부패란, 고수준 구상 요소가 저수준 구성 요소에 의존하고, 반대로 그 저수준 구성 요소가 다시 고수준 구상 요소에 의존하는 상태를 말한다. 이 상태가 된다면 시스템 디자인이 어떻게 되어 있는지 아무도 알아볼 수 없다.

따라서 저수준 구상 요소가 시스템에 접속은 할 수 있지만, 어떤 저수준 구상 요소를 언제 사용할 지는 고수준 구성 요소가 결정한다.

## 3-2. 템플릿 메소드와 할리우드 원칙

템플릿 메소드를 사용하면, 자연스럽게 할리우드 원칙을 사용하는 것과 같다.

1. 추상 클래스는 고수준 구성 요소이다. 핵심 알고리즘을 갖고 있으며, 메소드 구현이 필요한 시점에만 서브 클래스를 불러낸다.
2. 다시 추상 클래스는 서브 클래스가 아닌, 추상 클래스를 추상화한 곳에서 의존하고 있다. 
3. 서브 클래스는 알고리즘 구현에만 사용된다. 서브 클래스를 호출당하기만 한다.

## 3-2. 다른 패턴과의 비교

1. Template MethodPattern : 알고리즘의 어떤 단계를 구현하는 방법을 서브클래스에서 결정
2. Strategy Pattern : 바꿔 쓸 수 있는 행동을 캡슐화하고, 어떤 행동을 사용할지는 서브클래스에 맡긴다.
3. Factory Method Pattern : 구상 클래스의 인스턴스 생성을 서브클래스에서 결정한다.