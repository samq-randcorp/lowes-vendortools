package com.lowes.vendortools;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.BinaryBody;
import org.mockserver.model.Header;

import com.lowes.vendortools.api.AsnMasterApi;
import com.lowes.vendortools.auth.Authentication;
import com.lowes.vendortools.auth.OAuth;
import com.lowes.vendortools.test.helper.ByteArrayResponseType;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.http.RealResponseBody;

import okio.Buffer;
import okio.BufferedSource;

public class ApiClientTest {
	
	private static final int PORTNUMBER = 9000;
	ApiClient apiClient=null;
	static String oauthToken=UUID.randomUUID().toString();
	static ApiClientTest test =null;
	static ClientAndServer clientAndServer=null; 
	private static final String testFile = System.getProperty("user.dir") + File.separatorChar + "src"
			+ File.separatorChar + "test" + File.separatorChar + "resources" + File.separatorChar;
	@BeforeAll
	public static void createExpectationForInvalidAuth() throws InterruptedException {
		 clientAndServer= startClientAndServer(PORTNUMBER);
		clientAndServer.when(request("/oauth2/token").withMethod("POST"), exactly(10))
				.respond(response().withStatusCode(200)
						.withHeaders(new Header("Content-Type", "application/x-www-form-urlencoded"),
								new Header("Cache-Control", "public, max-age=86400"))
						.withBody("{ \"token_type\": \"bearer\",\"access_token\": " +'"'+ oauthToken+'"' + "}")
						.withDelay(TimeUnit.SECONDS, 0));
	}

	@Test
	public void testOauthToken() {
		
		File file = new File(System.getProperty("user.dir") + File.separatorChar + "test.properties");
		ApiClient.OAUTH_PROPERTY_FILE = "test.properties";
		try (FileWriter fw = new FileWriter(file)) {
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(apiClient.CLIENT_ID + "=" + "testClientId");
			bw.write('\n');
			bw.write(apiClient.CLIENT_SECRET + "=" + "testClientSecret");
			bw.write('\n');
			bw.write(apiClient.TOKEN_URL + "=" + "http://127.0.0.1:"+PORTNUMBER+"/oauth2/token");
			bw.write('\n');
			bw.write(apiClient.GRANT_TYPE+"="+"client_credentials");
			bw.write('\n');
			bw.write("base_path="+"http://127.0.0.1"+PORTNUMBER);
			bw.flush();
			if (bw != null)
				bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apiClient = new ApiClient();
		Assertions.assertEquals(apiClient, apiClient.setVerifyingSsl(true));
		Map<String, Authentication> authMap = apiClient.getAuthentications();
		OAuth oauth = (OAuth) authMap.get("Oauth");
		Assertions.assertEquals("http://127.0.0.1"+PORTNUMBER,apiClient.getBasePath());
		Assertions.assertEquals(this.oauthToken, oauth.getAccessToken());
		
	}
	
	@Test
	public void testUrlBuildApiClient() {
		AsnMasterApi asnManager = new AsnMasterApi();
		List<Pair> pairList = new ArrayList<>();
		String from = LocalDateTime.now().toString();
		pairList.add(new Pair("from", from));
		List<Pair> collectionQueryParams = new ArrayList<>();
		collectionQueryParams.add(new Pair("to", from));
		String url = asnManager.getApiClient().buildUrl("/getAsn", pairList, collectionQueryParams);
		System.out.println(url);
		Assertions.assertEquals("http://127.0.0.1:"+PORTNUMBER+"/getAsn?from="+from.replaceAll(":", "%3A")+"&to="+from, url);
	}
	
	@Test
	public void testApplySSLSetting() throws FileNotFoundException {
		AsnMasterApi asnManager = new AsnMasterApi();
		File f = new File(testFile+"SSLCACert.pem");
		FileInputStream fis  = new FileInputStream(f);
		asnManager.getApiClient().setVerifyingSsl(true);
		asnManager.getApiClient().setSslCaCert(fis);
		Assertions.assertEquals(true, asnManager.getApiClient().isVerifyingSsl());
	}
	
	@Test
	public void testHandelResponse() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		Response response = new Response.Builder().request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(new HashMap<>()), new Buffer())).code(204).protocol(Protocol.HTTP_2).build();
		Assertions.assertNull(asnManager.getApiClient().handleResponse(response, String.class));
	}
	
	@Test
	public void testHandelResponseNegFlow() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		Response response = new Response.Builder().request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(new HashMap<>()), new Buffer())).code(404).protocol(Protocol.HTTP_2).build();
		Assertions.assertThrows(ApiException.class, ()->{
			asnManager.getApiClient().handleResponse(response, String.class);	
		});
	}
	
	@Test
	public void testDeserialize() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		Response response = new Response.Builder().request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(new HashMap<>()), new Buffer())).code(404).protocol(Protocol.HTTP_2).build();
			Assertions.assertNull(asnManager.getApiClient().deserialize(response, null));			
	}
	
	@Test
	public void testDeserializeByteArray() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		Response response = new Response.Builder().request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(new HashMap<>()), new Buffer())).code(404).protocol(Protocol.HTTP_2).build();
			Assertions.assertNull(asnManager.getApiClient().deserialize(response, ByteArrayResponseType.class));			
	}
	
	@AfterAll
	public static void cleanup() {
		clientAndServer.stop();
	}
}
