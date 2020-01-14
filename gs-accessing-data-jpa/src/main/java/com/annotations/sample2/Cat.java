package com.annotations.sample2;

@AutoElement(value = "cat1234")
public class Cat implements Animal {

	@Override
	public void bark() {
		System.out.println("meow meow");
	}

}
