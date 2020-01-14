package com.annotations;

import com.annotations.InfoType.Priority;

@InfoType(priority = Priority.HIGH, 
		createdBy = "com.epam", 
		tags = { "JUNIT", "test"})
public class InfoTypeExample {

	@TestAnnot
	void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@TestAnnot(enabled = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@TestAnnot(enabled = true)
	void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}

	@TestAnnot(enabled = true)
	void testD() {
		if (2 > 1) {
			System.out.println(" Print in Test D method");
		}
	}
}
