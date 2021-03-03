# AsnUtilityApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getNumberOfASNPostedForTimeRange**](AsnUtilityApi.md#getNumberOfASNPostedForTimeRange) | **GET** /getASN | Get ASN Informated Posted to ASN Service 
[**getNumberOfASNProcessedByASNService**](AsnUtilityApi.md#getNumberOfASNProcessedByASNService) | **GET** /getASNProcessed | Get Validated ASN Informated Posted to ASN Service 
[**refreshASNCache**](AsnUtilityApi.md#refreshASNCache) | **GET** /asn/cache/refresh/{cache} | Refresh cache
[**refreshAllASNCache**](AsnUtilityApi.md#refreshAllASNCache) | **GET** /asn/cache/evictAll | Refresh cache

<a name="getNumberOfASNPostedForTimeRange"></a>
# **getNumberOfASNPostedForTimeRange**
> List&lt;ASNInformation&gt; getNumberOfASNPostedForTimeRange(from, to, fileName)

Get ASN Informated Posted to ASN Service 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityApi apiInstance = new AsnUtilityApi();
String from = "from_example"; // String | 
String to = "to_example"; // String | 
String fileName = "fileName_example"; // String | 
try {
    List<ASNInformation> result = apiInstance.getNumberOfASNPostedForTimeRange(from, to, fileName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityApi#getNumberOfASNPostedForTimeRange");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **from** | **String**|  |
 **to** | **String**|  |
 **fileName** | **String**|  |

### Return type

[**List&lt;ASNInformation&gt;**](ASNInformation.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNumberOfASNProcessedByASNService"></a>
# **getNumberOfASNProcessedByASNService**
> List&lt;ValidatedASNView&gt; getNumberOfASNProcessedByASNService(from, to, fileName)

Get Validated ASN Informated Posted to ASN Service 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityApi apiInstance = new AsnUtilityApi();
String from = "from_example"; // String | 
String to = "to_example"; // String | 
String fileName = "fileName_example"; // String | 
try {
    List<ValidatedASNView> result = apiInstance.getNumberOfASNProcessedByASNService(from, to, fileName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityApi#getNumberOfASNProcessedByASNService");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **from** | **String**|  |
 **to** | **String**|  |
 **fileName** | **String**|  |

### Return type

[**List&lt;ValidatedASNView&gt;**](ValidatedASNView.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="refreshASNCache"></a>
# **refreshASNCache**
> refreshASNCache(cache)

Refresh cache

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityApi apiInstance = new AsnUtilityApi();
String cache = "cache_example"; // String | 
try {
    apiInstance.refreshASNCache(cache);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityApi#refreshASNCache");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cache** | **String**|  |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="refreshAllASNCache"></a>
# **refreshAllASNCache**
> refreshAllASNCache()

Refresh cache

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityApi apiInstance = new AsnUtilityApi();
try {
    apiInstance.refreshAllASNCache();
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityApi#refreshAllASNCache");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

