package org.jsoup.extension;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class JsoupTest {

	@Test
	public void testParse() throws MalformedURLException, IOException {
		Document document = Jsoup.parse(new URL("http://google.com"), 5000);
		String expectedTitle = "Google";
		assertEquals(expectedTitle, document.title());
	}
}
