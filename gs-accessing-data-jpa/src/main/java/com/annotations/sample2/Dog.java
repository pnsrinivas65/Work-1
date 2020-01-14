package com.annotations.sample2;

@AutoElement(value = "dog")
public class Dog implements Animal {

	@Override
	public void bark() {
		System.out.println("bow bow");
	}

}
