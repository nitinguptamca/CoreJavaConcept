package allocation.and.assignment;

//Java program to demonstrate assigning 
//of object reference variables

//Box class
class Box {
	double width;
	double height;
	double depth;
	public Box(double width, double height, double depth) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	public Box() {
		super();
	}
}

// Driver class
public class Test {
	// Driver method
	// Declearation ,instantiation ,initialization of an object of type box.
	public static void main(String[] args) {
		// creating box object
		Box b1 = new Box();

		// assigning b2 to b1
		Box b2 = b1;

		// height via b1 and b2
		System.out.println(b1.height +"b1.width"+b1.width +"b1.depth "+b1.depth);
		System.out.println(b2.height +"b2.width"+b2.width +"b2.depth "+b2.depth);

		// changing height via b2
		b2.height = 20;
		b1.depth=30;
		// height via b1 and b2
		// after modification through b2
		System.out.println(b1.height +"b1.width"+b1.width +"b1.depth "+b1.depth);
		System.out.println(b2.height +"b2.width"+b2.width +"b2.depth "+b2.depth);
		b1.height = 40;
		/**
		 * You might think that b2 is being assigned a reference to a copy of the object
		 * referred to by b1. That is, you might think that b1 and b2 refer to separate
		 * and distinct objects. However, this would be wrong. Instead, after this
		 * fragment executes, b1 and b2 will both refer to the same object. The
		 * assignment of b1 to b2 did not allocate any memory or copy any part of the
		 * original object. It simply makes b2 refer to the same object as does b1.
		 * Thus, any changes made to the object through b2 will affect the object to
		 * which b1 is referring, since they are the same object. Same can be verified
		 * by output when we change height of box via b2.
		 */
		System.out.println(b1.height);
		System.out.println(b2.height);

	}

}
