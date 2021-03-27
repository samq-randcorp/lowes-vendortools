package com.lowes.vendortools.api;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowes.vendortools.ApiClient;
import com.lowes.vendortools.ApiException;
import com.lowes.vendortools.model.ASNInformation;
import com.lowes.vendortools.model.ASNServiceResponseDTO;
import com.lowes.vendortools.model.ValidatedASNView;

public class ASNMasterAPITest {
	private static final int PORTNUMBER = 9000;
	static String trnxId = UUID.randomUUID().toString();
	private static final String testFile = System.getProperty("user.dir") + File.separatorChar + "src"
			+ File.separatorChar + "test" + File.separatorChar + "resources" + File.separatorChar;
	static String oauthToken=UUID.randomUUID().toString();
	static ClientAndServer clientAndServer =null; 
	@BeforeAll
	public static void createExpectationForInvalidAuth()
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		ApiClient.OAUTH_PROPERTY_FILE="Auth.properties";
		 clientAndServer = startClientAndServer(PORTNUMBER);
		
		
		clientAndServer.when(request("/oauth2/token").withMethod("POST"), exactly(10))
		.respond(response().withStatusCode(200)
				.withHeaders(new Header("Content-Type", "application/x-www-form-urlencoded"),
						new Header("Cache-Control", "public, max-age=86400"))
				.withBody("{ \"token_type\": \"bearer\",\"access_token\": " +'"'+ oauthToken+'"' + "}")
				.withDelay(TimeUnit.SECONDS, 0));
		
		clientAndServer.when(request("/asn").withMethod("POST"), exactly(10)).respond(response().withStatusCode(202)
				.withHeaders(new Header("Content-Type", "application/json"),
						new Header("Cache-Control", "public, max-age=86400"))
				.withBody("{ \"response\": \"SUCCESS\",\"transaction-Id\": " + '"' + trnxId + '"' + "," + "\"time\":"
						+ '"' + LocalDateTime.now().toString() + '"' + "}")
				.withDelay(TimeUnit.SECONDS, 0));

		File f = new File(testFile + "getASNByTransactionId.json");
		Map response = new ObjectMapper().readValue(f, Map.class);
		response.put("id", trnxId);
		String parsedResponseForMockServer = new ObjectMapper().writeValueAsString(response);

		clientAndServer.when(request("/asn/" + trnxId).withMethod("GET"), exactly(10))
				.respond(response().withStatusCode(202)
						.withHeaders(new Header("Content-Type", "application/json"),
								new Header("Cache-Control", "public, max-age=86400"))
						.withBody(parsedResponseForMockServer).withDelay(TimeUnit.SECONDS, 0));

	}

	@Test
	public void testASNPostEvent() throws JsonParseException, JsonMappingException, IOException, ApiException {
		AsnMasterApi asnMasterApi = new AsnMasterApi();
		ASNInformation asnInformation = new ObjectMapper().readValue(new File(testFile + "testJSON.json"),
				ASNInformation.class);
		ASNServiceResponseDTO response = asnMasterApi.postAsn(asnInformation);
		Assertions.assertEquals("SUCCESS", response.getResponse());
		Assertions.assertEquals(trnxId, response.getTransactionId());

	}

	@Test
	public void testGetASNByTransactionId() throws JsonParseException, JsonMappingException, IOException, ApiException {
		AsnMasterApi asnMasterApi = new AsnMasterApi();
		ValidatedASNView validatedASNView = asnMasterApi.getASNStatusByTransactionId(trnxId);
		Assertions.assertEquals(trnxId, validatedASNView.getId());
	}
	
	@AfterAll
	public static void cleanup() {
		clientAndServer.stop();
	}
}
