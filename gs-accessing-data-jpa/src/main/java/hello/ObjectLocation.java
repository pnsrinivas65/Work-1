package hello;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class ObjectLocation {

	private static int apple1 = 10;
	private int orange = 10;

	public static void main(String[] args) throws Exception {
		Unsafe unsafe = getUnsafeInstance();
		

		Field appleField = ObjectLocation.class.getDeclaredField("apple1");
		System.out.println("Location of Apple: " + unsafe.staticFieldOffset(appleField));

		Field orangeField = ObjectLocation.class.getDeclaredField("orange");
		System.out.println("Location of Orange: " + unsafe.objectFieldOffset(orangeField));
	}

	private static Unsafe getUnsafeInstance()
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafeInstance.setAccessible(true);
		return (Unsafe) theUnsafeInstance.get(Unsafe.class);
	}
}