package com.lowes.vendortools.exception;

import java.util.List;
import java.util.Map;

public class OauthClientException  extends RuntimeException{
	private int code = 0;
    private Map<String, List<String>> responseHeaders = null;
    private String responseBody = null;
	
    public OauthClientException(int code, Map<String, List<String>> responseHeaders, String responseBody) {
		super();
		this.code = code;
		this.responseHeaders = responseHeaders;
		this.responseBody = responseBody;
	}
   
    
    
}
