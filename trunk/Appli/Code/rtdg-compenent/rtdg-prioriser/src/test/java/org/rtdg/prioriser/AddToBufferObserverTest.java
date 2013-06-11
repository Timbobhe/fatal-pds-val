package org.rtdg.prioriser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rtdg.parser.ParsedMessage;

public class AddToBufferObserverTest {

	AddToBufferObserver addToBufferObserver;

	@Before
	public void setUp() throws Exception {
		addToBufferObserver = new AddToBufferObserver();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAddToBuffer() {

		String criticite = "critique";
		MessageBuffer buf1 = new MessageBuffer("buf2");
		MessageBuffer buf3 = new MessageBuffer("buf3");

		ParsedMessage parsedMessage = new ParsedMessage("Metro 12",
				"iD_SOURCE", "CapteurTemperature", "sENSOR_NUM_VALUE",
				"nonIntelligent", "dATA_VALUE", "80");
		addToBufferObserver.addToBuffer(buf1, buf3, parsedMessage, criticite);
		Assert.assertTrue(buf1.contains(parsedMessage));
		Assert.assertTrue(buf3.contains(parsedMessage));
		Assert.assertEquals(parsedMessage.getCRIT_VALUE(), criticite);

	}

	@Test
	public void testCompareDataIndicationTrue() {
		CriticiteValue s = new CriticiteValue();
		Double equartype = (double) 10;
		s.setEquartype(equartype);
		String value = "100";
		s.setValue(value);
		ParsedMessage parsedMessage = new ParsedMessage("Metro 12",
				"iD_SOURCE", "CapteurTemperature", "sENSOR_NUM_VALUE",
				"nonIntelligent", "dATA_VALUE", "90");
		boolean result = addToBufferObserver.compareDataIndication(
				parsedMessage, s);
		// 90 est egale à (100-10)
		Assert.assertEquals(true, result);
	}

	@Test
	public void testCompareDataIndicationFalse() {
		CriticiteValue s = new CriticiteValue();
		Double equartype = (double) 10;
		s.setEquartype(equartype);
		String value = "100";
		s.setValue(value);
		ParsedMessage parsedMessage = new ParsedMessage("Metro 12",
				"iD_SOURCE", "CapteurTemperature", "sENSOR_NUM_VALUE",
				"nonIntelligent", "dATA_VALUE", "80");
		boolean result = addToBufferObserver.compareDataIndication(
				parsedMessage, s);
		// 80 est inferieur à (100-10)
		Assert.assertEquals(false, result);
	}

	@Test
	public void testCompareDataValueTrue() {
		CriticiteValue s = new CriticiteValue();
		Double equartype = (double) 10;
		s.setEquartype(equartype);
		String value = "100";
		s.setValue(value);
		ParsedMessage parsedMessage = new ParsedMessage("Metro 12",
				"iD_SOURCE", "CapteurTemperature", "sENSOR_NUM_VALUE",
				"nonIntelligent", "dATA_VALUE", 90);
		boolean result = addToBufferObserver.compareDataValue(parsedMessage, s);
		// 80 est inferieur à (100-10)
		Assert.assertEquals(true, result);
	}

	@Test
	public void testCompareDataValueFalse() {
		CriticiteValue s = new CriticiteValue();
		Double equartype = (double) 10;
		s.setEquartype(equartype);
		String value = "100";
		s.setValue(value);
		ParsedMessage parsedMessage = new ParsedMessage("Metro 12",
				"iD_SOURCE", "CapteurTemperature", "sENSOR_NUM_VALUE",
				"nonIntelligent", "dATA_VALUE", 80);
		boolean result = addToBufferObserver.compareDataValue(parsedMessage, s);
		// 80 est inferieur à (100-10)
		Assert.assertEquals(false, result);
	}

}
