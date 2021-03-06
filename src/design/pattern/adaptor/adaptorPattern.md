# Adeptor 패턴

# TL;DR

- **기존 클래스를 사용하려고 하는데 인터페이스가 맞지 않다면 어댑터를 사용하면 된다.**
- **큰 인터페이스와 여러 인터페이스를 단순하게 바꾸거나 통합해야 하면 퍼사드를 쓰면 된다.**
- **어댑터는 인터페이스를 클라이언트에서 원하는 인터페이스로 변경하는 역할을 합니다.**
- **파사드는 클라이언트를 복잡한 서브시스템과 분리하는 역할을 한다.**
- 어댑터를 구현할 때는 Target Interface의 크기와 구조에 따라 코딩해야 할 분량이 결정된다.
- 파사드 패턴에서는 서브시스템으로 파사드를 만들고 진짜 작업은 서브클래스에 맡깁니다.
- 어댑터 패턴에서는 객체 어댑터 패턴과 클래스 어댑터 패턴이 있습니다. 클래스 어댑터는 다중상속이 가능한 경우 사용할 수 있습니다.
- 한 서브시스템에 여러 파사드를 만들어도 됩니다.
- **어댑터는 객체를 감싸서 인터페이스를 바꾸는 용도로, 데코레이터는 객체를 감싸서 새로운 행동을 추가하는 용도로, 파사드는 일련의 객체를 감싸서 단순하게 만드는 용도로 사용한다.**

# 1. 어댑터 패턴이란

일반적으로 전원 소켓을 플러그 모양에 맞게 바꿔주는 역할을 하는걸 어댑터 라고 부른다. 이 어댑터가 있어야 다양한 소켓에 플러그를 꽂을 수 있다.

개발에서도 이런 어댑터가 필요할 때가 있다. 다른 라이브러리의 인터페이스가 우리가 사용했던 인터페이스와 적합하지 않다면, 기존 시스템과 업체에서 제공한 클래스 사이에 어댑터를 넣어서 구현해야 한다. *즉 개발에서 어댑터는 클라이언트로부터 요청을 받아서 다양한 라이브러리가 제공하는 클래스를 클라이언트가 받을 수 있는 형태로 변환해 주는 역할을 한다*.

**어댑터 패턴이란 특정 클래스 인터페이스를 클라이언트에서 요구하는 다른 인터페이스로 변환합니다, 인터페이스가 호환되지 않아 같이 쓸 수 없었던 클래스를 사용할 수 있다.**

아래 클래스 다이어그램은 `객체 어댑터`이다. 다중 상속을 지원하는 언어는 `클래스 어댑터`를 사용할 수 있다. 클래스 어댑터는 어댑터를 클라이언트와 어댑티를 다중 상속 받아서 구현한다.

![1](https://user-images.githubusercontent.com/68282095/179761511-10464b00-d9c4-4088-8a39-53e58e33db42.gif)

# 2. 어댑터 패턴 구현

![1](https://user-images.githubusercontent.com/68282095/179758314-da6e4f55-6429-436e-af9b-54df8293014a.png)

- Client : Target Interface로 Method를 호출해서 어댑터에 요청을 보냅니다.
- Adaptor : 어댑터는 어댑티 인터페이스로 그 요청을 어댑티에 관한 하나 이상의 메소드 호출로 변환합니다.
- **클라이언트는 호출 결과를 받지만 중간에 어댑터가 있다는 사실을 모릅니다.**