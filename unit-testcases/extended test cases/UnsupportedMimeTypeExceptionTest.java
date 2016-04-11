package org.jsoup.extension;

import static org.junit.Assert.assertEquals;

import org.jsoup.UnsupportedMimeTypeException;
import org.junit.Test;

public class UnsupportedMimeTypeExceptionTest {

	@Test
	public void testUnsupportedMimeTypeException() {
		try {
			throw new UnsupportedMimeTypeException("Test", "1", "http://test.com");
		} catch (UnsupportedMimeTypeException e) {
			String expectedExceptionMsg = "org.jsoup.UnsupportedMimeTypeException: Test. Mimetype=1, URL=http://test.com";
			String expectedMimeType = "1";
			String expectedUrl = "http://test.com";
			assertEquals(expectedExceptionMsg, e.toString());
			assertEquals(expectedMimeType, e.getMimeType());
			assertEquals(expectedUrl, e.getUrl());
		}
	}
}
