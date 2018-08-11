package com.vargs;

import java.util.Arrays;
import java.util.List;

public class VargsTest {
	
	public static void display(String...strings ) {
		System.out.println(""+strings);
	}

	public static void main(String[] args) {
		String[] strarray= {"erwer","ret","eter",};
		display(strarray);
		List<String> strlist=Arrays.asList(strarray);
		display("nitin","sachin","test");
	}

}
