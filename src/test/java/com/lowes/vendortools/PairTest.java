package com.lowes.vendortools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairTest {
@Test	
public void testPairIsValidString() {
	Pair p = new Pair(" ", "Service");
	Assertions.assertEquals("", p.getName());
	Assertions.assertNotNull(p.getValue());
}
}
