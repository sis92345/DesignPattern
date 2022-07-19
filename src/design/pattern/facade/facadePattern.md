# Facade Pattern

# 1. 파사드 패턴이란

**파사드 패턴은 서브시스템에 있는 일련의 인터페이스를 통합 인터페이스로 묶어 준다. 또한 고수준의 인터페이스도 정의하므로 서브시스템을 더 편리하게 사용할 수 있다.**

![1](https://user-images.githubusercontent.com/68282095/179770302-d3531254-b5fd-4580-a340-92131f4023b1.png)

# 2. 디자인 원칙 4 : 최소 지식의 원칙

객체 사이의 상호작용은 될 수 있으면 아주 가까운 기능에게만 허용하는 편이 좋다. 다음이 최소 지식의 원칙에서 허용되는 범위이다.

1. 객체 자체
2. 메소드에 매개변수로 전달된 객체
3. 메소드를 생성하거나 인스턴스를 만든 객체
4. 객체에 속하는 구성 요소

- 아래 코드는 최소 지식의 원칙을 안지킨 케이스이다. 이 메소드를 호출하는 클래스는 station과 station이 가지고 있는 thermometer를 의존한다.

  ```
  public float getTemp() {
  	return station.getThermometer().getTemperature();
  }
  ```

- 아래 코드는 최소 지식의 원칙을 지킨 케이스이다. station의 thermometer에게 요청을 전달하는 메소드가 추가됨으로서 의존하고 있는 클래스의 개수를 줄일 수 있다.

  ```
  public float getTemp() {
  	return station.getTemperature();
  }
  ```

  