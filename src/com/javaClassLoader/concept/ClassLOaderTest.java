package com.javaClassLoader.concept;

public class ClassLOaderTest {
	public static void method(Object o) {
		System.out.println("Object impl");
	}
	public static void method(String s) {
		System.out.println("String impl");
	}
	public static void method(StringBuffer i){
		System.out.println("StringBuffer impl");
	}
	public static void main(String[] args) {
		
		/*System.out.println("lang package"+java.lang.String.class.getClassLoader());
		System.out.println("util package"+java.util.HashMap.class.getClassLoader());
		System.out.println("sun"+sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
		System.out.println(com.mysql.jdbc.Blob.class.getClassLoader());*/
		
		//public static void main(String[] args) {
		//	method(null);
		//}
			long longWithL = 1000*60*60*24*365L;
			long longWithoutL = 1000*60*60*24*365;
			System.out.println(longWithL);
			System.out.println(longWithoutL);

	}

}
