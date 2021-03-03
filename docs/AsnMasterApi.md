# AsnMasterApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getASNStatusByTransactionId**](AsnMasterApi.md#getASNStatusByTransactionId) | **GET** /asn/{txnId} | Get ASN Information By Transaction Id
[**getASNStatusByTransactionIdAndOrderNumber**](AsnMasterApi.md#getASNStatusByTransactionIdAndOrderNumber) | **GET** /asn/order/{orderNumber} | Get ASN Information By Order Number
[**getASNStatusByTransactionIdAndOrderNumberAndLoadId**](AsnMasterApi.md#getASNStatusByTransactionIdAndOrderNumberAndLoadId) | **GET** /asn/{orderNumber}/{loadId} | Get ASN Information By  Order Number and LoadId
[**postAsn**](AsnMasterApi.md#postAsn) | **POST** /asn | POST ASN Data

<a name="getASNStatusByTransactionId"></a>
# **getASNStatusByTransactionId**
> ValidatedASNView getASNStatusByTransactionId(txnId)

Get ASN Information By Transaction Id

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnMasterApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnMasterApi apiInstance = new AsnMasterApi();
String txnId = "txnId_example"; // String | 
try {
    ValidatedASNView result = apiInstance.getASNStatusByTransactionId(txnId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnMasterApi#getASNStatusByTransactionId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **txnId** | **String**|  |

### Return type

[**ValidatedASNView**](ValidatedASNView.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getASNStatusByTransactionIdAndOrderNumber"></a>
# **getASNStatusByTransactionIdAndOrderNumber**
> ValidatedASNView getASNStatusByTransactionIdAndOrderNumber(orderNumber)

Get ASN Information By Order Number

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnMasterApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnMasterApi apiInstance = new AsnMasterApi();
String orderNumber = "orderNumber_example"; // String | 
try {
    ValidatedASNView result = apiInstance.getASNStatusByTransactionIdAndOrderNumber(orderNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnMasterApi#getASNStatusByTransactionIdAndOrderNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderNumber** | **String**|  |

### Return type

[**ValidatedASNView**](ValidatedASNView.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getASNStatusByTransactionIdAndOrderNumberAndLoadId"></a>
# **getASNStatusByTransactionIdAndOrderNumberAndLoadId**
> ValidatedASNView getASNStatusByTransactionIdAndOrderNumberAndLoadId(orderNumber, loadId)

Get ASN Information By  Order Number and LoadId

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnMasterApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnMasterApi apiInstance = new AsnMasterApi();
String orderNumber = "orderNumber_example"; // String | 
String loadId = "loadId_example"; // String | 
try {
    ValidatedASNView result = apiInstance.getASNStatusByTransactionIdAndOrderNumberAndLoadId(orderNumber, loadId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnMasterApi#getASNStatusByTransactionIdAndOrderNumberAndLoadId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderNumber** | **String**|  |
 **loadId** | **String**|  |

### Return type

[**ValidatedASNView**](ValidatedASNView.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postAsn"></a>
# **postAsn**
> ASNServiceResponseDTO postAsn(body)

POST ASN Data

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnMasterApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnMasterApi apiInstance = new AsnMasterApi();
ASNInformation body = new ASNInformation(); // ASNInformation | 
try {
    ASNServiceResponseDTO result = apiInstance.postAsn(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnMasterApi#postAsn");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ASNInformation**](ASNInformation.md)|  |

### Return type

[**ASNServiceResponseDTO**](ASNServiceResponseDTO.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

