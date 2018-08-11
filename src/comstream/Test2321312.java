package comstream;

interface InfA {
	String getName();
}

 class D {
	int i;
	int j;

	public D(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public void printName() {
		System.out.println("Name-D");
	}
}

public class Test2321312 implements InfA {
	public String getName() {
		return "test-name";
	}

	public static void main(String[] args) {
		Test2321312 t = new Test2321312();
		System.out.println(t.getName());
		
		D d = new D(0, 0);
		///4. d.printName();
	}
}