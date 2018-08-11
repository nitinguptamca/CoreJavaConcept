package exam;

public class Test2342 {
	public static void main(String[] args) {
		byte b = 6;
		b += 8;
		System.out.println(b);
		b =(byte) ((Byte)b+ 7);
		System.out.println(b);
	}
}