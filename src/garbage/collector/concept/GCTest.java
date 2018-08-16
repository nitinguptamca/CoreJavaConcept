package garbage.collector.concept;

public class GCTest {
	public static void main(String[] args) throws InterruptedException {
		A a = new A("white");
 
		for (int i = 0; i < 1022222; i++) {
			if (i % 2 == 1) {
				a = new A("red");
			} else {
				a = new A("green");
			}
			a = null;
		}
		System.gc();
	}
}
 
class A {
	private String color;
	static int count=0;
	public A(String color) {
		this.color = color;
	}
 
	@Override
	public void finalize() {
		System.out.println(this.color + " cleaned"+ count++ );
	}
}