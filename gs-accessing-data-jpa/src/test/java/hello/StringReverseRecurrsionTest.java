package hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hello.leetcode.StringReverse;

public class StringReverseRecurrsionTest {

	@Test
	public void testPrintReverse() {
		//fail("Not yet implemented");
		String revreseStr = new String(StringReverse.helper(0,"Hello World".toCharArray()));
		System.out.println(revreseStr);
		assertEquals(revreseStr, "dlroW olleH");
	}

	@Test
	public void testHelper() {
		//fail("Not yet implemented");
	}

}
