package com.exception.handling;

import javax.management.RuntimeErrorException;

public class ExceptionHandling {

	public static String parse(String str) {
		try {
			throw new NumberFormatException();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException();
		} finally {
			return "10";
		}
	}

	public static void main(String[] args) {
		try {
		System.out.println(	parse("nitin"));
		
		} catch (Exception e) {
		System.out.println("sdfsd");
		}

	}

}
