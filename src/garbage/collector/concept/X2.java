package garbage.collector.concept;

public class X2 {
	public X2 x;
	
	public X2() {
		
	}

	public static void main(String[] args) {
		X2 x2 = new X2(); /* Line 6 */
		X2 x3 = new X2(); /* Line 7 */
		x2.x = x3;
		x3.x = x2;
		x2 = new X2();
		x3 = x2; /* Line 11 */
		//doComplexStuff();
		x3=null;
		System.gc();
		
	}
	

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage collector called");
		System.out.println("Object garbage collected : " + this);
	}
}
