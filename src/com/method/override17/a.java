package com.method.override17;

class SuperClass
{
    Object superClassMethod()
    {
        return new Object();
    }
}

class X
{
    static void methodOfX()
    {
        System.out.println("Class X");
    }
}
 
class Y extends X
{/**
	- overrides com.method.override17.X.methodOfX
	- This instance method cannot override the static 
	void methodOfX(){}
	*/
  static  void methodOfX()
    {
        System.out.println("Class X");
       // return 10;
    }
}
