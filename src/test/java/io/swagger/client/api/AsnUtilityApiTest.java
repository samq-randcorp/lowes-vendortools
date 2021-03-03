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

package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.ASNInformation;
import io.swagger.client.model.ValidatedASNView;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AsnUtilityApi
 */
@Ignore
public class AsnUtilityApiTest {

    private final AsnUtilityApi api = new AsnUtilityApi();

    /**
     * Get ASN Informated Posted to ASN Service 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNumberOfASNPostedForTimeRangeTest() throws ApiException {
        String from = null;
        String to = null;
        String fileName = null;
        List<ASNInformation> response = api.getNumberOfASNPostedForTimeRange(from, to, fileName);

        // TODO: test validations
    }
    /**
     * Get Validated ASN Informated Posted to ASN Service 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNumberOfASNProcessedByASNServiceTest() throws ApiException {
        String from = null;
        String to = null;
        String fileName = null;
        List<ValidatedASNView> response = api.getNumberOfASNProcessedByASNService(from, to, fileName);

        // TODO: test validations
    }
    /**
     * Refresh cache
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void refreshASNCacheTest() throws ApiException {
        String cache = null;
        api.refreshASNCache(cache);

        // TODO: test validations
    }
    /**
     * Refresh cache
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void refreshAllASNCacheTest() throws ApiException {
        api.refreshAllASNCache();

        // TODO: test validations
    }
}