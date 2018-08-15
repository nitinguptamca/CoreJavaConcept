package exam;

public class Test124324 {
	public static void printValue(int i, int j, int k) {
		System.out.println("int");
	}

	public static void printValue(byte... b) {
		System.out.println("long");
	}
	
	public static void printValue(byte b,byte c,byte d) {
		System.out.println("long byte");
	}
	
	public static void printValue(Short b,Short c,Short d) {
		System.out.println("long short");
	}

	public static void main11(String... args) {
		byte b = 9;
		printValue(b, b, b);
	}
	
	public static void main(String[] args) {
		
	}
	
}
