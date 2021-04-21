package com.lowes.vendortools;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonSyntaxException;
import com.lowes.vendortools.model.ASNServiceResponseDTO;

public class JSONTest {
	String trnxId = UUID.randomUUID().toString();
	String data ="{ \"response\": \"SUCCESS\",\"transaction-Id\": " + '"' + trnxId + '"' + "," + "\"time\":"
			+ '"' + LocalDateTime.now().toString() + '"' + "}";
@Test	
public void testDeserialize() {
	JSON json = new JSON();
	json.setLenientOnJson(true);
	ASNServiceResponseDTO response=json.deserialize(data, ASNServiceResponseDTO.class);
	Assertions.assertEquals("SUCCESS", response.getResponse());
	Assertions.assertEquals(trnxId, response.getTransactionId());
	json.setLenientOnJson(false);
	Assertions.assertThrows(JsonSyntaxException.class, ()->{
		json.deserialize("{", ASNServiceResponseDTO.class);
	});
}
}
