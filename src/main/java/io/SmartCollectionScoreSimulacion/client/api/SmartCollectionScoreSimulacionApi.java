package io.SmartCollectionScoreSimulacion.client.api;

import io.SmartCollectionScoreSimulacion.client.ApiCallback;
import io.SmartCollectionScoreSimulacion.client.ApiClient;
import io.SmartCollectionScoreSimulacion.client.ApiException;
import io.SmartCollectionScoreSimulacion.client.ApiResponse;
import io.SmartCollectionScoreSimulacion.client.Configuration;
import io.SmartCollectionScoreSimulacion.client.Pair;
import io.SmartCollectionScoreSimulacion.client.ProgressRequestBody;
import io.SmartCollectionScoreSimulacion.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.SmartCollectionScoreSimulacion.client.model.Peticion;
import io.SmartCollectionScoreSimulacion.client.model.Respuesta;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartCollectionScoreSimulacionApi {
    private ApiClient apiClient;
    public SmartCollectionScoreSimulacionApi() {
        this(Configuration.getDefaultApiClient());
    }
    public SmartCollectionScoreSimulacionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call getReporteCall(String xApiKey, Peticion body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "/v1/smartcollection";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
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
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    private okhttp3.Call getReporteValidateBeforeCall(String xApiKey, Peticion body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getReporte(Async)");
        }
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getReporte(Async)");
        }
        
        okhttp3.Call call = getReporteCall(xApiKey, body, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta getReporte(String xApiKey, Peticion body) throws ApiException {
        ApiResponse<Respuesta> resp = getReporteWithHttpInfo(xApiKey, body);
        return resp.getData();
    }
    
    public ApiResponse<Respuesta> getReporteWithHttpInfo(String xApiKey, Peticion body) throws ApiException {
        okhttp3.Call call = getReporteValidateBeforeCall(xApiKey, body, null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call getReporteAsync(String xApiKey, Peticion body, final ApiCallback<Respuesta> callback) throws ApiException {
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
        okhttp3.Call call = getReporteValidateBeforeCall(xApiKey, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
}
