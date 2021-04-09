/*
 * ASN Service
 * This app provides REST APIs for ASN Service
 *
 * OpenAPI spec version: v3
 * Contact: firstname.lastname@company.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.lowes.vendortools.api;

import com.google.gson.reflect.TypeToken;
import com.lowes.vendortools.ApiCallback;
import com.lowes.vendortools.ApiClient;
import com.lowes.vendortools.ApiResponse;
import com.lowes.vendortools.Configuration;
import com.lowes.vendortools.Pair;
import com.lowes.vendortools.ProgressRequestBody;
import com.lowes.vendortools.ProgressResponseBody;
import com.lowes.vendortools.exception.ApiException;
import com.lowes.vendortools.model.ASNInformation;
import com.lowes.vendortools.model.ASNServiceResponseDTO;
import com.lowes.vendortools.model.ValidatedASNView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsnMasterApi {
    private static final String ASN = "/shipment-notification";
	private static final String AUTH_TYPE = "Oauth";
	private ApiClient apiClient;

    public AsnMasterApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AsnMasterApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getASNStatusByTransactionId
     * @param txnId  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getASNStatusByTransactionIdCall(String txnId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = ASN+"/{txnId}"
            .replaceAll("\\{" + "txnId" + "\\}", apiClient.escapeString(txnId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { AUTH_TYPE };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getASNStatusByTransactionIdValidateBeforeCall(String txnId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'txnId' is set
        if (txnId == null) {
            throw new ApiException("Missing the required parameter 'txnId' when calling getASNStatusByTransactionId(Async)");
        }
        
        com.squareup.okhttp.Call call = getASNStatusByTransactionIdCall(txnId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get ASN Information By Transaction Id
     * 
     * @param txnId  (required)
     * @return ValidatedASNView
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ValidatedASNView getASNStatusByTransactionId(String txnId) throws ApiException {
        ApiResponse<ValidatedASNView> resp = getASNStatusByTransactionIdWithHttpInfo(txnId);
        return resp.getData();
    }

    /**
     * Get ASN Information By Transaction Id
     * 
     * @param txnId  (required)
     * @return ApiResponse&lt;ValidatedASNView&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ValidatedASNView> getASNStatusByTransactionIdWithHttpInfo(String txnId) throws ApiException {
        com.squareup.okhttp.Call call = getASNStatusByTransactionIdValidateBeforeCall(txnId, null, null);
        Type localVarReturnType = new TypeToken<ValidatedASNView>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get ASN Information By Transaction Id (asynchronously)
     * 
     * @param txnId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getASNStatusByTransactionIdAsync(String txnId, final ApiCallback<ValidatedASNView> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getASNStatusByTransactionIdValidateBeforeCall(txnId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ValidatedASNView>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
   
    /**
     * Build call for postAsn
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postAsnCall(ASNInformation body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = ASN;

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { AUTH_TYPE };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postAsnValidateBeforeCall(ASNInformation body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling postAsn(Async)");
        }
        
       return postAsnCall(body, progressListener, progressRequestListener);

        
        
        
        
    }

    /**
     * POST ASN Data
     * 
     * @param body  (required)
     * @return ASNServiceResponseDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ASNServiceResponseDTO postAsn(ASNInformation body) throws ApiException {
        ApiResponse<ASNServiceResponseDTO> resp = postAsnWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * POST ASN Data
     * 
     * @param body  (required)
     * @return ApiResponse&lt;ASNServiceResponseDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ASNServiceResponseDTO> postAsnWithHttpInfo(ASNInformation body) throws ApiException {
        com.squareup.okhttp.Call call = postAsnValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<ASNServiceResponseDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * POST ASN Data (asynchronously)
     * 
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postAsnAsync(ASNInformation body, final ApiCallback<ASNServiceResponseDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            }; 
        }

        com.squareup.okhttp.Call call = postAsnValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ASNServiceResponseDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
