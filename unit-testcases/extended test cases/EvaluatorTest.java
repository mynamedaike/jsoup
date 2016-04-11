package org.jsoup.extension;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.jsoup.select.Evaluator;
import org.junit.Test;

public class EvaluatorTest {
    
	@Test
	public void testIdToString() {
		Evaluator id = new Evaluator.Id("testId");
		String expected = "#testId";
		assertEquals(expected, id.toString());
	}
	
	@Test
	public void testAttributeToString() {
		Evaluator attr = new Evaluator.Attribute("testAttribute");
		String expected = "[testAttribute]";
		assertEquals(expected, attr.toString());
	}
	
	@Test
	public void testAttributeStartingToString() {
		Evaluator attrStarting = new Evaluator.AttributeStarting("testAttributeStarting");
		String expected = "[^testAttributeStarting]";
		assertEquals(expected, attrStarting.toString());
	}
	
	@Test
	public void testAttributeWithValue() {
		Evaluator attrWithValue = new Evaluator.AttributeWithValue("testKey", "testValue");
		String expected = "[testkey=testvalue]";
		assertEquals(expected, attrWithValue.toString());
	}
	
	@Test
	public void testAttributeWithValueNot() {
		Evaluator attrWithValueNot = new Evaluator.AttributeWithValueNot("testKey", "testValue");
		String expected = "[testkey!=testvalue]";
		assertEquals(expected, attrWithValueNot.toString());
	}
	
	@Test
	public void testAttributeWithValueStarting() {
		Evaluator attrWithValueStarting = new Evaluator.AttributeWithValueStarting("testKey", "testValue");
		String expected = "[testkey^=testvalue]";
		assertEquals(expected, attrWithValueStarting.toString());
	}
	
	@Test
	public void testAttributeWithValueEnding() {
		Evaluator attrWithValueEnding = new Evaluator.AttributeWithValueEnding("testKey", "testValue");
		String expected = "[testkey$=testvalue]";
		assertEquals(expected, attrWithValueEnding.toString());
	}
	
	@Test
	public void testAttributeWithValueContaining() {
		Evaluator attrWithValueContaining = new Evaluator.AttributeWithValueContaining("testKey", "testValue");
		String expected = "[testkey*=testvalue]";
		assertEquals(expected, attrWithValueContaining.toString());
	}
	
	@Test
	public void testAllElements() {
		Evaluator allElements = new Evaluator.AllElements();
		String expected = "*";
		assertEquals(expected, allElements.toString());
	}
	
	@Test
	public void testIndexLessThan() {
		Evaluator indexLessThan = new Evaluator.IndexLessThan(5);
		String expected = ":lt(5)";
		assertEquals(expected, indexLessThan.toString());
	}
	
	@Test
	public void testIndexGreaterThan() {
		Evaluator indexGreaterThan = new Evaluator.IndexGreaterThan(6);
		String expected = ":gt(6)";
		assertEquals(expected, indexGreaterThan.toString());
	}
	
	@Test
	public void testIndexEquals() {
		Evaluator indexEquals = new Evaluator.IndexEquals(7);
		String expected = ":eq(7)";
		assertEquals(expected, indexEquals.toString());
	}
	
	@Test
	public void testIsLastChild() {
		Evaluator isLastChild = new Evaluator.IsLastChild();
		String expected = ":last-child";
		assertEquals(expected, isLastChild.toString());
	}
	
	@Test
	public void testIsFirstOfType() {
		Evaluator isFirstOfType = new Evaluator.IsFirstOfType();
		String expected = ":first-of-type";
		assertEquals(expected, isFirstOfType.toString());
	}
	
	@Test
	public void testIsLastOfType() {
		Evaluator isLastOfType = new Evaluator.IsLastOfType();
		String expected = ":last-of-type";
		assertEquals(expected, isLastOfType.toString());
	}
	
	@Test
	public void testIsFirstChild() {
		Evaluator isFirstChild = new Evaluator.IsFirstChild();
		String expected = ":first-child";
		assertEquals(expected, isFirstChild.toString());
	}
	
	@Test
	public void testIsRoot() {
		Evaluator isRoot = new Evaluator.IsRoot();
		String expected = ":root";
		assertEquals(expected, isRoot.toString());
	}
	
	@Test
	public void testIsOnlyChild() {
		Evaluator isOnlyChild = new Evaluator.IsOnlyChild();
		String expected = ":only-child";
		assertEquals(expected, isOnlyChild.toString());
	}
	
	@Test
	public void testIsOnlyOfType() {
		Evaluator isOnlyOfType = new Evaluator.IsOnlyOfType();
		String expected = ":only-of-type";
		assertEquals(expected, isOnlyOfType.toString());
	}
	
	@Test
	public void testIsEmpty() {
		Evaluator isEmpty = new Evaluator.IsEmpty();
		String expected = ":empty";
		assertEquals(expected, isEmpty.toString());
	}
	
	@Test
	public void testContainsText() {
		Evaluator containsText = new Evaluator.ContainsText("test");
		String expected = ":contains(test";
		assertEquals(expected, containsText.toString());
	}
	
	@Test
	public void testContainsOwnText() {
		Evaluator containsOwnText = new Evaluator.ContainsOwnText("test");
		String expected = ":containsOwn(test";
		assertEquals(expected, containsOwnText.toString());
	}
	
	@Test
	public void testMatches() {
		Evaluator matches = new Evaluator.Matches(Pattern.compile("\\w+"));
		String expected = ":matches(\\w+";
		assertEquals(expected, matches.toString());
	}
	
	@Test
	public void testMatchesOwn() {
		Evaluator matchesOwn = new Evaluator.Matches(Pattern.compile("\\d+"));
		String expected = ":matches(\\d+";
		assertEquals(expected, matchesOwn.toString());
	}
}
