package exam;

public class A111 {
	static {
		System.out.println("static");
	}
	{
		System.out.println("block");
	}

	public A111() {
		System.out.println("A");
	}

	public static void main(String[] args) {
		A111 a = new A111();
	}
}