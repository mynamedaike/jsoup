package org.jsoup.extension;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.jsoup.helper.DescendableLinkedList;
import org.junit.Before;
import org.junit.Test;

public class DescendableLinkedListTest {
	DescendableLinkedList<String> dll;
	
	@Before
	public void setUp() {
		dll = new DescendableLinkedList<String>();
	}
	
	@Test
	public void testPush() {
		dll.push("abc");
		dll.push("123");
		String expected = "123";
		assertEquals(expected, dll.get(0));
	}
    
	@Test
	public void testPeekLast() {
		String expected = null;
		assertEquals(expected, dll.peekLast());
		dll.push("124");
		dll.push("def");
		expected = "124";
		assertEquals(expected, dll.peekLast());
	}
	
	@Test
	public void testPoolLast() {
		String expectedElement = null;
		assertEquals(expectedElement, dll.pollLast());
		dll.push("124");
		dll.push("def");
		expectedElement = "124";
		int expectedSize = 1;
		assertEquals(expectedElement, dll.pollLast());
		assertEquals(expectedSize, dll.size());
	}
	
	@Test
	public void testHasNext() {
		Iterator<String> it = dll.descendingIterator();
		assertFalse(it.hasNext());
		dll.push("234");
		it = dll.descendingIterator();
		assertTrue(it.hasNext());
	}
	
	@Test
	public void testNext() {
		dll.push("234");
		dll.push("fgh");
		Iterator<String> it = dll.descendingIterator();
		String expected = "234";
		assertEquals(expected, it.next());
		expected = "fgh";
		assertEquals(expected, it.next());
	}
	
	@Test
	public void testRemove() {
		dll.push("err");
		Iterator<String> it = dll.descendingIterator();
		it.next();
		it.remove();
		assertEquals(0, dll.size());
	}
}
