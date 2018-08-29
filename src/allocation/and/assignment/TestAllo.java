package allocation.and.assignment;

//Java program to demonstrate one object to
//initialize another
class Box1
{
	double width, height, depth;

	// Notice this constructor. It takes an
	// object of type Box1. This constructor use
	// one object to initialize another
	Box1(Box1 mybox)
	{
		width = mybox.width;
		height = mybox.height;
		depth = mybox.depth;
	}

	// constructor used when all dimensions
	// specified
	Box1(double w, double h, double d)
	{
		width = w;
		height = h;
		depth = d;
	}

	// compute and return volume
	double volume()
	{
		return width * height * depth;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}

//driver class
public class TestAllo
{
	public static void main(String args[])
	{
		// creating a box with all dimensions specified
		Box1 mybox = new Box1(10, 20, 15);
		mybox.setHeight(100);
		// creating a copy of mybox
		Box1 myclone = new Box1(mybox);

		double vol;
		mybox.setHeight(200);
		// get volume of mybox
		vol = mybox.volume();
		System.out.println("Volume of mybox is " + vol);

		// get volume of myclone
		vol = myclone.volume();
		System.out.println("Volume of myclone is " + vol);
	}
}

