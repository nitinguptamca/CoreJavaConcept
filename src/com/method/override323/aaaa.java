package com.method.override323;

class SuperClass
{
    void firstMethodOfSuperClass()
    {
        System.out.println("From Super Class");
    }
 
    double secondMethodOfSuperClass()
    {
        return 0.0;
    }
 
    Object thirdMethodOfSuperClass()
    {
        return new Object();
    }
}
 
class SubClass extends SuperClass
{
    void /*int*/ firstMethodOfSuperClass()
    {
        //Compile time error, return type must be void not int
    }
 
    double  secondMethodOfSuperClass()
    {
        //Complie time error, return type must be double not void
    	return 10;
    }
 
    String thirdMethodOfSuperClass()
    {
        //No Compile time error,
        //return type is compatible with super class method, because
        //String is sub class of Object class
        return new String();
    }
}
