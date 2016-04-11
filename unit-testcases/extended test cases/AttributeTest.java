package org.jsoup.extension;

import static org.junit.Assert.*;

import org.jsoup.nodes.Attribute;
import org.junit.Test;

public class AttributeTest {
	Attribute attribute = new Attribute("1", "2");

	@Test
	public void testSetKey() {
		attribute.setKey("  ABC  ");
		String expectedKey = "abc";
		assertEquals(expectedKey, attribute.getKey());
	}
    
	@Test
	public void testCreatFromEncoded() {
		attribute = Attribute.createFromEncoded("123", "456");
		String expectedKey = "123";
		assertEquals(expectedKey, attribute.getKey());
	}
}
