# State Pattern

# TR;DR

- 상태 패턴을 사용하면 내부 상태를 바탕으로 여러 가지 서로 다른 행동을 사용할 수 있습니다.
- 상태 패턴을 사용하면 프로시저형 상태 기계를 쓸 때와는 달리 각 상태를 클래스로 표현합니다.
- Context 객체는 현재 상태에게 행동을 위임합니다.
- 각 상태를 클래스로 캡슐화해서 나중에 변경해야 하는 내용을 국지화 할 수 있습니다.
- 상태 패턴과 전략 패턴의 클래스 다이어그램을 같지만, 그 용도는 다릅니다.
  - 전략 패턴 : Context 클래스를 만들 때 행동과 알고리즘을 설정합니다.
  - 상태 패턴을 사용하면 Context의 내부 상태가 바뀜에 따라 객체가 알아서 행동을 바꿀 수 있도록 할 수 있습니다.
- 상태 전환은 State 클래스로 제어하거나, Context 클래스로 제어할 수 있다.
- 상태 패턴을 사용하면 디자인에 필요한 클래스의 개수가 늘어난다.
- State 클래스를 여러 Context 객체의 여러 인스턴스에서 공유하도록 디자인 할 수 있습니다. 

# 1. 상태 패턴 이란

상태 패턴 ( State Pattern )을 사용하면 객체의 내부 상태가 바뀜에 따라서 객체의 행동을 바꿀 수 있습니다. 마치 객체의 클래스가 바뀌는 것과 같은 결과를 얻을 수 있습니다.

상태 패턴은 전략 패턴과 유사한다. 상태 패턴은 상태 객체의 일련의 행동을 캡슐화하여 상황에 따라 Context 객체에서 여러 상태 객체 중 현재 상태 객체에게 행동을 맡긴다. 따라서 Context의 행동은 상태 객체에 따라 변경된다. 반면 전략패턴은 Client가 직접 Context 객체에게 어떤 전략 객체를 사용할지 지정한다. 따라서 상태 패턴에서는 클라이언트가 상태 객체를 몰라도 되지만, 전략 패턴은 하위 전략을 알아야 한다.

# 2. 상태 패턴 구성

![다운로드](https://user-images.githubusercontent.com/68282095/182180357-c2551853-2199-4631-98ee-2e111d73a8a7.png)

- Context : 컨텍스트 클래스는 State interface를 상속받는 여러 상태를 가진다. Context의 request()메소드가 호출되면 그 작업은 상태 객체에 맡겨진다.
- State interface : 모든 상태 구현체의 인터페이스
- State 구현체 : Context로부터 전달된 요청을 각 State에서 구현해서 처리한다. 따라서 Context의 State가 변경되면 request()의 실제 로직도 달라지게 된다.