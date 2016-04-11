package org.jsoup.extension;

import static org.junit.Assert.*;

import org.jsoup.HttpStatusException;
import org.junit.Test;

public class HttpStatusExceptionTest {

	@Test
	public void testHttpStatusException() {
		try {
			throw new HttpStatusException("Test", 1, "http://test.com");
		} catch (HttpStatusException e) {
			String expectedExceptionMsg = "org.jsoup.HttpStatusException: Test. Status=1, URL=http://test.com";
			int expectedStatusCode = 1;
			String expectedUrl = "http://test.com";
			assertEquals(expectedExceptionMsg, e.toString());
			assertEquals(expectedStatusCode, e.getStatusCode());
			assertEquals(expectedUrl, e.getUrl());
		}
	}
}
