package enumconcept.testing;

/**
 * Java program without making class Can you run Java program without making *
 * class?
 * 
 * @author nitin The idea is to us enum is Java. Every enum constant is always
 *         implicitly public static final. Since it is static, we can access it
 *         by using enum Name. Since it is final, we can’t create child enums.
 *         We can declare main() method inside enum. Hence we can invoke enum
 *         directly from the Command Prompt.
 */

public enum Color {
	RED, GREEN, BLUE;
	// Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
        displaySomething();
    }
    
    
   static void displaySomething(){
    	System.out.println("Testing");
    }

}
