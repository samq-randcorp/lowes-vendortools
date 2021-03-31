package com.lowes.vendortools.api;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
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
import com.lowes.vendortools.ApiCallback;
import com.lowes.vendortools.ApiClient;
import com.lowes.vendortools.ApiResponse;
import com.lowes.vendortools.exception.ApiException;
import com.lowes.vendortools.model.ASNInformation;
import com.lowes.vendortools.model.ASNServiceResponseDTO;
import com.lowes.vendortools.model.ValidatedASNView;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

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
	@Test
	public void testGetASNByTransactionIdHttpInfo() throws JsonParseException, JsonMappingException, IOException, ApiException {
		AsnMasterApi asnMasterApi = new AsnMasterApi();
		ApiResponse<ValidatedASNView> validatedASNView = asnMasterApi.getASNStatusByTransactionIdWithHttpInfo(trnxId);
		Assertions.assertEquals(trnxId, validatedASNView.getData().getId());
	}
	
	@Test
	public void testGetASNByTransactionIdAsync() throws JsonParseException, JsonMappingException, IOException, ApiException {
		AsnMasterApi asnMasterApi = new AsnMasterApi();
		ApiCallback<ValidatedASNView> validatdASNViewCallback= new ApiCallback<ValidatedASNView>() {
			
			@Override
			public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onSuccess(ValidatedASNView result, int statusCode, Map<String, List<String>> responseHeaders) {
				Assertions.assertEquals(trnxId, result.getId());
				Assertions.assertEquals(200, statusCode);
				
			}
			
			@Override
			public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
				Assertions.fail();
				
			}
			
			@Override
			public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
				// TODO Auto-generated method stub
				
			}
		};
		asnMasterApi.getASNStatusByTransactionIdAsync(trnxId, validatdASNViewCallback);
		
	}
	
	@AfterAll
	public static void cleanup() {
		clientAndServer.stop();
	}
	@Test
	public void testpostWithHttpInfo() throws JsonParseException, JsonMappingException, IOException, ApiException {
		AsnMasterApi asnMasterApi = new AsnMasterApi();
		ASNInformation asnInformation = new ObjectMapper().readValue(new File(testFile + "testJSON.json"),
				ASNInformation.class);
		ApiResponse<ASNServiceResponseDTO> response = asnMasterApi.postAsnWithHttpInfo(asnInformation);

		Assertions.assertEquals("SUCCESS", response.getData().getResponse());
		Assertions.assertEquals(trnxId, response.getData().getTransactionId());
	}
	@Test
	public void testPostAsync() throws ApiException, JsonParseException, JsonMappingException, IOException {
		AsnMasterApi asnMasterApi = new AsnMasterApi();
		ApiCallback<ASNServiceResponseDTO> responseCallback = new ApiCallback<ASNServiceResponseDTO>() {
			
			@Override
			public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onSuccess(ASNServiceResponseDTO result, int statusCode, Map<String, List<String>> responseHeaders) {
				Assertions.assertEquals("SUCCESS", result.getResponse());
				Assertions.assertEquals(trnxId, result.getTransactionId());
				Assertions.assertEquals(202, statusCode);
			}
			
			@Override
			public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
				Assertions.fail();
				
			}
			
			@Override
			public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
				// TODO Auto-generated method stub
				
			}
		};
		ASNInformation asnInformation = new ObjectMapper().readValue(new File(testFile + "testJSON.json"),
				ASNInformation.class);
		System.out.println("-------------------------------------------------------------------------------------------");
		asnMasterApi.postAsnAsync(asnInformation, responseCallback);
		
	}
	
	@Test
	public void testPostAsyncNegative() throws ApiException, JsonParseException, JsonMappingException, IOException {
		AsnMasterApi asnMasterApi = new AsnMasterApi();
		ApiCallback<ASNServiceResponseDTO> responseCallback = new ApiCallback<ASNServiceResponseDTO>() {
			
			@Override
			public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onSuccess(ASNServiceResponseDTO result, int statusCode, Map<String, List<String>> responseHeaders) {
				
			}
			
			@Override
			public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
				
			}
			
			@Override
			public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
				// TODO Auto-generated method stub
				
			}
		};
		ASNInformation asnInformation = new ObjectMapper().readValue(new File(testFile + "testJSON.json"),
				ASNInformation.class);
		System.out.println("-------------------------------------------------------------------------------------------");
		try {
		asnMasterApi.postAsnAsync(null, responseCallback);
		}catch(ApiException apiException) {
			Assertions.assertTrue(apiException.getLocalizedMessage().equals("Missing the required parameter 'body' when calling postAsn(Async)"));
			Assertions.assertEquals(0, apiException.getCode());
			Assertions.assertNull(apiException.getResponseBody());
			Map data=apiException.getResponseHeaders();
		}
		
	}
	
}
