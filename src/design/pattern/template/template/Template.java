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
