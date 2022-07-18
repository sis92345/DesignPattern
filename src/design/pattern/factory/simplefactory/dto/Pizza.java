package design.pattern.factory.simplefactory.dto;

public class Pizza {
		
		protected String description = "피자";
		protected String dough;
		protected String sauce;
		
		public Pizza() {}
		
		public Pizza( String description ) {
				this.description = description;
		}
		
		public Pizza prepare() {
				return this;
		}
		
		public Pizza bake() {
				return this;
		}
		
		public Pizza cut() {
				return this;
		}
		
		public Pizza box() {
				System.out.println( this.description + " 완료되었습니다." );
				return this;
		}
		
		public void setDescription( String description ) {
				this.description = description;
		}
		
		public String getDescription() {
				return description;
		}
}
