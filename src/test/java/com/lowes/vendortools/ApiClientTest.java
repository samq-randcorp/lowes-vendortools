package com.lowes.vendortools;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import com.lowes.vendortools.auth.Authentication;
import com.lowes.vendortools.auth.OAuth;

@RunWith(MockitoJUnitRunner.class)
public class ApiClientTest {
	
	private static final int PORTNUMBER = 9000;
	ApiClient apiClient=null;
	static String oauthToken=UUID.randomUUID().toString();
	static ApiClientTest test =null;

	@BeforeAll
	public static void createExpectationForInvalidAuth() throws InterruptedException {
		ClientAndServer clientAndServer= startClientAndServer(PORTNUMBER);
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
			bw.flush();
			if (bw != null)
				bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apiClient = new ApiClient();
		Map<String, Authentication> authMap = apiClient.getAuthentications();
		OAuth oauth = (OAuth) authMap.get("Oauth");
		Assertions.assertEquals(this.oauthToken, oauth.getAccessToken());
	}
}
