package com.method.overriding;



class MainClass11 
{
	//Answer :
	//Duplicated. Because, var args (int … a) are nothing but the arrays. So here, 
	//(int … a) and (int[] a) are the same.
    void method(int ... a)
    {
        System.out.println(1);
    }
     
   /* void method(int[] a)
    {
        System.out.println(2);
    }*/
    void method(long[] a)
    {
        System.out.println(2);
    }
}

class SuperClass{
	 int i=10; 
	public void display() {
		System.out.println("display"+i);
	}
	
}
 class SubClass extends SuperClass{
	  int i=11; 
		public void display() {
			System.out.println("display"+i);
		}
 }

public class MethodOverriding {

	public static void main(String[] args) {
		SuperClass superClass=new SubClass();
		superClass.display();
		System.out.println(superClass.i);

	}

}
