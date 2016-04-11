package org.jsoup.extension;

import static org.junit.Assert.*;

import org.jsoup.helper.Validate;
import org.junit.Test;

public class ValidateTest {

	@Test
	public void testIsTrue() {
		try {
			Validate.isTrue(true);
		}catch (IllegalArgumentException e) {
			fail("should not throw exception");
		}
		
		try {
			Validate.isTrue(false);
			fail("should throw exception");
		}catch (IllegalArgumentException e) {
			assertEquals("Must be true", e.getMessage());
		}
	}
	
	@Test
	public void testIsFalse() {
		try {
			Validate.isFalse(false);
		}catch (IllegalArgumentException e) {
			fail("should not throw exception");
		}
		
		try {
			Validate.isFalse(true);
			fail("should throw exception");
		}catch (IllegalArgumentException e) {
			assertEquals("Must be false", e.getMessage());
		}
	}
	
	@Test
	public void testIsFalseWithMsg() {
		try {
			Validate.isFalse(false, "test");
		}catch (IllegalArgumentException e) {
			fail("should not throw exception");
		}
		
		try {
			Validate.isFalse(true, "test");
			fail("should throw exception");
		}catch (IllegalArgumentException e) {
			assertEquals("test", e.getMessage());
		}
	}
	
	@Test
	public void testNotNullElements() {
		try {
			Validate.noNullElements(new Object[]{1,2,3}, "test");
		}catch (IllegalArgumentException e) {
			fail("should not throw exception");
		}
		
		try {
			Validate.noNullElements(new Object[]{1,null,3}, "test");
			fail("should throw exception");
		}catch (IllegalArgumentException e) {
			assertEquals("test", e.getMessage());
		} 
	}
	
	@Test
	public void testFail() {
		try {
			Validate.fail("test");
		}catch (IllegalArgumentException e) {
			assertEquals("test", e.getMessage());
		}
	}
}
