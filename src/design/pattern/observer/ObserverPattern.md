# Observer Pattern

# TL;DR

- 옵저버 패턴은 객체들 사이에 일대다 관계를 정의
- Subject는 동일한 인터페이스를 구현해서 옵저버에게 연락
- Observer는 Observer 인터페이스를 구현해서 어떤 구상 클래스의 옵저버라도 패턴에 사용할 수 있다.
- Subject는 Observer들이 Observer interface를 구현한다는 것을 제외하면 Observer에 대해서 모른다.
- Observer Pattern을 사용하면 주제가 데이터를 보내는 Push 방식이나 데이터를 가져오는 Pull 방식으로 구현할 수 있다.
- Observer Pattern은 publisher - subscriber Pattern과 유사하다.

# 1. 옵저버 패턴이란

<u>한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체에 연락이 가고 자동으로 내용이 갱신되는 **일대다( 1 : N ) 의존성을 정의합니다.**</u>

옵저버 패턴은 다수의 구독자 객체를 주제 객체에게 등록 후 상태 변화가 있을 시 메소드 등을 통해서 구독자에게 통지를 하는 패턴입니다.

# 2. 옵저버 패턴의 구현

# ![1](https://user-images.githubusercontent.com/68282095/179000493-cd5b55d1-ffcc-499b-9b7f-594e6c5d9c5a.png)

- Subject 객체 : 객체에서 옵저버로 등록하거나 옵저버 목록에서 탈퇴할 때 이 메소드를 사용
- Observer 객체 : 옵저버가 될 가능성이 있는 객체는 반드시 이 Observer 인터페이스를 구현해야 한다.
- Concreate Observer 객체 : Oberserver Interface를 구현한 옵저버 클래스
- Concreate Subject 객체 : 주제 인터페이스를 구현한 주제 클래스 추가적으로 상태를 설정하는 Setter/Getter 메소드가 올 수 있다.

# 3. 디자인 원칙 2 : 느슨한 결합

### 1. **상호작용하는 객체 사이에는 가능하면 느슨한 결합을 사용해야 한다.**

​	- 구현 보다는 인터페이스에 맞추어서 프로그래밍

위 그림에서 Subject 클래스는 Observer interface를 구현한 객체만 추가할 수 있다. 따라서 실제 어떤 옵저버 구현체를 사용하던 Subject 클래스는 Observer에 데이터를 받을 수 있다. 

또한 Observer 입장에서도 구현체가 변경되어도 Subject를 변경할 필요가 없으니 느슨한 결합을 가진다고 할 수 있다.

즉 핵심은 느슨한 결합을 통해 각 Subject와 Observer가 달라져도 영향을 미치지 않도록 구현할 수 있다.