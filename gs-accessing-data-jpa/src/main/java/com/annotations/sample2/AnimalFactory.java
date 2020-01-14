package com.annotations.sample2;

public final class AnimalFactory {
	public static Animal createAnimal(String type) {
		System.out.println(" Here -->" + type);
		switch (type) {
		case "cat":
			return new Cat();
		case "dog":
			return new Dog();
		}
		throw new RuntimeException("not support type");
	}

	public static void main(String s[]) {
		Animal dog = AnimalFactory.createAnimal("dog");
		dog.bark(); // woof
		Animal cat = AnimalFactory.createAnimal("cat");
		cat.bark(); // meow
	}
}