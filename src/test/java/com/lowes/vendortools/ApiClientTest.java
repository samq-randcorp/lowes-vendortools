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
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.mockserver.model.Header;

import com.lowes.vendortools.api.AsnMasterApi;
import com.lowes.vendortools.auth.Authentication;
import com.lowes.vendortools.auth.OAuth;
import com.lowes.vendortools.exception.ApiException;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.RealResponseBody;

import okio.Buffer;

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
		HashMap<String,String> responseHeader=new HashMap<>();
		
		
		Response response = new Response.Builder().request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(responseHeader), new Buffer().writeString("Hello", Charset.defaultCharset()))).code(404).protocol(Protocol.HTTP_2).build();
			Assertions.assertEquals("Hello",asnManager.getApiClient().deserialize(response, "".getClass()));			
	}
	
	@Test
	public void testDeserialize_2() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		HashMap<String,String> responseHeader=new HashMap<>();
		responseHeader.put("Content-type", "application");
		
		Response response = new Response.Builder().header("Content-type", "application").request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(responseHeader), new Buffer().writeString("Hello", Charset.defaultCharset()))).code(404).protocol(Protocol.HTTP_2).build();
			Assertions.assertEquals("Hello",asnManager.getApiClient().deserialize(response, "".getClass()));			
	}
	
	@Test
	public void testDeserialize_3() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		HashMap<String,String> responseHeader=new HashMap<>();
		responseHeader.put("Content-type", "application");
		
		Response response = new Response.Builder().header("Content-type", "application").request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(responseHeader), new Buffer().writeString("Hello", Charset.defaultCharset()))).code(404).protocol(Protocol.HTTP_2).build();
			Assertions.assertThrows(ApiException.class, ()->{
				asnManager.getApiClient().deserialize(response, Integer.class);			
			});
	}
	
	@Test
	public void testDeserializeByteArray() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		Response response = new Response.Builder().request(new Request.Builder().url("http://127.0.0.1:9000").build()).body(new RealResponseBody(Headers.of(new HashMap<>()), new Buffer())).code(404).protocol(Protocol.HTTP_2).build();
			Assertions.assertNull(asnManager.getApiClient().deserialize(response, byte[].class));
			Type type = byte[].class.getSuperclass();
			Assertions.assertNull(asnManager.getApiClient().deserialize(null, byte[].class));
	}

	@Test
	public void testParameterToString() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		String data=asnManager.getApiClient().parameterToString(org.threeten.bp.LocalDate.now());
		Assertions.assertEquals("\"year\":"+org.threeten.bp.LocalDate.now().getYear()+","+"\"month\":"+org.threeten.bp.LocalDate.now().getMonthValue()+","+"\"day\":"+org.threeten.bp.LocalDate.now().getDayOfMonth(), data);
		
		LocalDateTime now = LocalDateTime.now();
		data=asnManager.getApiClient().parameterToString(now);
		Assertions.assertEquals(now.toString(), data);
		data=asnManager.getApiClient().parameterToString(Arrays.asList(now));
		Assertions.assertEquals(now.toString(), data);
		
	}
	
	@Test
	public void testDebuggingTest() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		ApiClient apiClient_Parent = asnManager.getApiClient();
		ApiClient apiClient=apiClient_Parent.setDebugging(true);
		Assertions.assertEquals(apiClient_Parent, apiClient);
		
		
	}
	
	@Test
	public void testSerialize() throws FileNotFoundException, ApiException {
		byte[] data= {1};
		AsnMasterApi asnManager = new AsnMasterApi();		
		ApiClient apiClient_Parent = asnManager.getApiClient();
		Assertions.assertThrows(NullPointerException.class, ()->{
			apiClient_Parent.serialize(null, "application/json");
		});
		Assertions.assertThrows(ApiException.class, ()->{
			apiClient_Parent.serialize(null, "application/url");
		});
		RequestBody body=apiClient_Parent.serialize(data, "application/json");
		Assertions.assertEquals(MediaType.parse("application/json"), body.contentType());
		body =apiClient_Parent.serialize(new File(testFile+"getASNByTransactionId.json"), "application/json");
		Assertions.assertEquals(MediaType.parse("application/json"), body.contentType());
		
	}
	
	@Test
	public void testBuildRequestFormEncoding() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		ApiClient apiClient_Parent = asnManager.getApiClient();
		Map<String,Object> formParameter = new HashMap<String, Object>();
		formParameter.put("clientId", "testClientId");
		formParameter.put("clientSecret", "testclientSecret");
		formParameter.put("token_url", "testtoken_url");
		RequestBody body=apiClient_Parent.buildRequestBodyFormEncoding(formParameter);
		Assertions.assertEquals(MediaType.parse("application/x-www-form-urlencoded"), body.contentType());
	}
	
	
	
	
	@Test
	public void testParameterToPair() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		ApiClient apiClient_Parent = asnManager.getApiClient();
		List<Pair> pairs=apiClient_Parent.parameterToPair("testKey", "testValue");
		for(Pair pair:pairs) {
			Assertions.assertEquals(pair.getName(), "testKey");
			Assertions.assertEquals(pair.getValue(), "testValue");
		}
	}
	
	
	@Test
	public void testSetAccessToken() throws FileNotFoundException, ApiException {
		AsnMasterApi asnManager = new AsnMasterApi();		
		ApiClient apiClient_Parent = asnManager.getApiClient();
		String AccessToken = UUID.randomUUID().toString();
		apiClient_Parent.setAccessToken(AccessToken);
		Map<String, Authentication> authMap = apiClient_Parent.getAuthentications();
		OAuth oauth = (OAuth) authMap.get("Oauth");
		Assertions.assertEquals(AccessToken, oauth.getAccessToken());
	}
	
	
	@AfterAll
	public static void cleanup() {
		clientAndServer.stop();
	}
}
