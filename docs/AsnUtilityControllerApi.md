# AsnUtilityControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getASNValidatedByTypeOfASN**](AsnUtilityControllerApi.md#getASNValidatedByTypeOfASN) | **GET** /getASNValidated/{typeOfASN} | 
[**getFailedASN**](AsnUtilityControllerApi.md#getFailedASN) | **POST** /getASNFailedToSend | 
[**getFailedASNByLoadId**](AsnUtilityControllerApi.md#getFailedASNByLoadId) | **GET** /getASNByLoadId/{loadId} | 
[**getFailedASNByOrderNumber**](AsnUtilityControllerApi.md#getFailedASNByOrderNumber) | **GET** /getASN/{orderNumber} | 
[**missingValidatedASN**](AsnUtilityControllerApi.md#missingValidatedASN) | **GET** /resolve | 
[**missingValidatedASNByLoadId**](AsnUtilityControllerApi.md#missingValidatedASNByLoadId) | **GET** /resolveByLoadId | 
[**publishFailedASNToKafkaTopic**](AsnUtilityControllerApi.md#publishFailedASNToKafkaTopic) | **GET** /publishFailedASN | Publish Failed ASN to Kafka Topic
[**publishFailedASNToKafkaTopicByLoadId**](AsnUtilityControllerApi.md#publishFailedASNToKafkaTopicByLoadId) | **GET** /publishFailedASN/loadId/{loadId} | Publish Failed ASN to Kafka Topic
[**publishFailedASNToKafkaTopicByNodeType**](AsnUtilityControllerApi.md#publishFailedASNToKafkaTopicByNodeType) | **GET** /publishFailedASN/nodeType/{nodeType} | Publish Failed ASN to Kafka Topic
[**publishFailedASNToKafkaTopicByOrderNumber**](AsnUtilityControllerApi.md#publishFailedASNToKafkaTopicByOrderNumber) | **GET** /publishFailedASN/orderNumber/{orderNumber} | Publish Failed ASN to Kafka Topic

<a name="getASNValidatedByTypeOfASN"></a>
# **getASNValidatedByTypeOfASN**
> getASNValidatedByTypeOfASN(typeOfASN)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AsnUtilityControllerApi;


AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
String typeOfASN = "typeOfASN_example"; // String | 
try {
    apiInstance.getASNValidatedByTypeOfASN(typeOfASN);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#getASNValidatedByTypeOfASN");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **typeOfASN** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFailedASN"></a>
# **getFailedASN**
> getFailedASN(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AsnUtilityControllerApi;


AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
Map<String, Object> body = new Map(); // Map<String, Object> | 
try {
    apiInstance.getFailedASN(body);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#getFailedASN");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Map&lt;String, Object&gt;**](Map.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getFailedASNByLoadId"></a>
# **getFailedASNByLoadId**
> getFailedASNByLoadId(loadId)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AsnUtilityControllerApi;


AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
String loadId = "loadId_example"; // String | 
try {
    apiInstance.getFailedASNByLoadId(loadId);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#getFailedASNByLoadId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loadId** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFailedASNByOrderNumber"></a>
# **getFailedASNByOrderNumber**
> getFailedASNByOrderNumber(orderNumber)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AsnUtilityControllerApi;


AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
String orderNumber = "orderNumber_example"; // String | 
try {
    apiInstance.getFailedASNByOrderNumber(orderNumber);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#getFailedASNByOrderNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderNumber** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="missingValidatedASN"></a>
# **missingValidatedASN**
> missingValidatedASN()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AsnUtilityControllerApi;


AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
try {
    apiInstance.missingValidatedASN();
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#missingValidatedASN");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="missingValidatedASNByLoadId"></a>
# **missingValidatedASNByLoadId**
> missingValidatedASNByLoadId()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AsnUtilityControllerApi;


AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
try {
    apiInstance.missingValidatedASNByLoadId();
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#missingValidatedASNByLoadId");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="publishFailedASNToKafkaTopic"></a>
# **publishFailedASNToKafkaTopic**
> String publishFailedASNToKafkaTopic()

Publish Failed ASN to Kafka Topic

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
try {
    String result = apiInstance.publishFailedASNToKafkaTopic();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#publishFailedASNToKafkaTopic");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="publishFailedASNToKafkaTopicByLoadId"></a>
# **publishFailedASNToKafkaTopicByLoadId**
> String publishFailedASNToKafkaTopicByLoadId(loadId)

Publish Failed ASN to Kafka Topic

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
String loadId = "loadId_example"; // String | 
try {
    String result = apiInstance.publishFailedASNToKafkaTopicByLoadId(loadId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#publishFailedASNToKafkaTopicByLoadId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loadId** | **String**|  |

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="publishFailedASNToKafkaTopicByNodeType"></a>
# **publishFailedASNToKafkaTopicByNodeType**
> String publishFailedASNToKafkaTopicByNodeType(nodeType)

Publish Failed ASN to Kafka Topic

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
String nodeType = "nodeType_example"; // String | 
try {
    String result = apiInstance.publishFailedASNToKafkaTopicByNodeType(nodeType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#publishFailedASNToKafkaTopicByNodeType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **nodeType** | **String**|  |

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="publishFailedASNToKafkaTopicByOrderNumber"></a>
# **publishFailedASNToKafkaTopicByOrderNumber**
> String publishFailedASNToKafkaTopicByOrderNumber(orderNumber)

Publish Failed ASN to Kafka Topic

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AsnUtilityControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AsnUtilityControllerApi apiInstance = new AsnUtilityControllerApi();
String orderNumber = "orderNumber_example"; // String | 
try {
    String result = apiInstance.publishFailedASNToKafkaTopicByOrderNumber(orderNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AsnUtilityControllerApi#publishFailedASNToKafkaTopicByOrderNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderNumber** | **String**|  |

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

