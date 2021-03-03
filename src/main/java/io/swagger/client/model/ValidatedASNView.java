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

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.threeten.bp.OffsetDateTime;
/**
 * ValidatedASNView
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-03-03T04:59:55.167Z[GMT]")
public class ValidatedASNView {
  @SerializedName("id")
  private String id = null;

  @SerializedName("ordType")
  private String ordType = null;

  @SerializedName("numberOfValidationFailed")
  private Long numberOfValidationFailed = null;

  @SerializedName("sentToKafkaTopic")
  private Boolean sentToKafkaTopic = null;

  @SerializedName("environment")
  private String environment = null;

  @SerializedName("asnCreateTimestamp")
  private OffsetDateTime asnCreateTimestamp = null;

  @SerializedName("asnUpdateTimestamp")
  private OffsetDateTime asnUpdateTimestamp = null;

  @SerializedName("vendorNumber")
  private Long vendorNumber = null;

  @SerializedName("eventCreatedAt")
  private OffsetDateTime eventCreatedAt = null;

  @SerializedName("revisionNumber")
  private Long revisionNumber = null;

  @SerializedName("orlShipId")
  private String orlShipId = null;

  @SerializedName("orderNumber")
  private String orderNumber = null;

  @SerializedName("validationError")
  private List<Map<String, Object>> validationError = null;

  public ValidatedASNView id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ValidatedASNView ordType(String ordType) {
    this.ordType = ordType;
    return this;
  }

   /**
   * Get ordType
   * @return ordType
  **/
  @Schema(description = "")
  public String getOrdType() {
    return ordType;
  }

  public void setOrdType(String ordType) {
    this.ordType = ordType;
  }

  public ValidatedASNView numberOfValidationFailed(Long numberOfValidationFailed) {
    this.numberOfValidationFailed = numberOfValidationFailed;
    return this;
  }

   /**
   * Get numberOfValidationFailed
   * @return numberOfValidationFailed
  **/
  @Schema(description = "")
  public Long getNumberOfValidationFailed() {
    return numberOfValidationFailed;
  }

  public void setNumberOfValidationFailed(Long numberOfValidationFailed) {
    this.numberOfValidationFailed = numberOfValidationFailed;
  }

  public ValidatedASNView sentToKafkaTopic(Boolean sentToKafkaTopic) {
    this.sentToKafkaTopic = sentToKafkaTopic;
    return this;
  }

   /**
   * Get sentToKafkaTopic
   * @return sentToKafkaTopic
  **/
  @Schema(description = "")
  public Boolean isSentToKafkaTopic() {
    return sentToKafkaTopic;
  }

  public void setSentToKafkaTopic(Boolean sentToKafkaTopic) {
    this.sentToKafkaTopic = sentToKafkaTopic;
  }

  public ValidatedASNView environment(String environment) {
    this.environment = environment;
    return this;
  }

   /**
   * Get environment
   * @return environment
  **/
  @Schema(description = "")
  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public ValidatedASNView asnCreateTimestamp(OffsetDateTime asnCreateTimestamp) {
    this.asnCreateTimestamp = asnCreateTimestamp;
    return this;
  }

   /**
   * Get asnCreateTimestamp
   * @return asnCreateTimestamp
  **/
  @Schema(description = "")
  public OffsetDateTime getAsnCreateTimestamp() {
    return asnCreateTimestamp;
  }

  public void setAsnCreateTimestamp(OffsetDateTime asnCreateTimestamp) {
    this.asnCreateTimestamp = asnCreateTimestamp;
  }

  public ValidatedASNView asnUpdateTimestamp(OffsetDateTime asnUpdateTimestamp) {
    this.asnUpdateTimestamp = asnUpdateTimestamp;
    return this;
  }

   /**
   * Get asnUpdateTimestamp
   * @return asnUpdateTimestamp
  **/
  @Schema(description = "")
  public OffsetDateTime getAsnUpdateTimestamp() {
    return asnUpdateTimestamp;
  }

  public void setAsnUpdateTimestamp(OffsetDateTime asnUpdateTimestamp) {
    this.asnUpdateTimestamp = asnUpdateTimestamp;
  }

  public ValidatedASNView vendorNumber(Long vendorNumber) {
    this.vendorNumber = vendorNumber;
    return this;
  }

   /**
   * Get vendorNumber
   * @return vendorNumber
  **/
  @Schema(description = "")
  public Long getVendorNumber() {
    return vendorNumber;
  }

  public void setVendorNumber(Long vendorNumber) {
    this.vendorNumber = vendorNumber;
  }

  public ValidatedASNView eventCreatedAt(OffsetDateTime eventCreatedAt) {
    this.eventCreatedAt = eventCreatedAt;
    return this;
  }

   /**
   * Get eventCreatedAt
   * @return eventCreatedAt
  **/
  @Schema(description = "")
  public OffsetDateTime getEventCreatedAt() {
    return eventCreatedAt;
  }

  public void setEventCreatedAt(OffsetDateTime eventCreatedAt) {
    this.eventCreatedAt = eventCreatedAt;
  }

  public ValidatedASNView revisionNumber(Long revisionNumber) {
    this.revisionNumber = revisionNumber;
    return this;
  }

   /**
   * Get revisionNumber
   * @return revisionNumber
  **/
  @Schema(description = "")
  public Long getRevisionNumber() {
    return revisionNumber;
  }

  public void setRevisionNumber(Long revisionNumber) {
    this.revisionNumber = revisionNumber;
  }

  public ValidatedASNView orlShipId(String orlShipId) {
    this.orlShipId = orlShipId;
    return this;
  }

   /**
   * Get orlShipId
   * @return orlShipId
  **/
  @Schema(description = "")
  public String getOrlShipId() {
    return orlShipId;
  }

  public void setOrlShipId(String orlShipId) {
    this.orlShipId = orlShipId;
  }

  public ValidatedASNView orderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
    return this;
  }

   /**
   * Get orderNumber
   * @return orderNumber
  **/
  @Schema(description = "")
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public ValidatedASNView validationError(List<Map<String, Object>> validationError) {
    this.validationError = validationError;
    return this;
  }

  public ValidatedASNView addValidationErrorItem(Map<String, Object> validationErrorItem) {
    if (this.validationError == null) {
      this.validationError = new ArrayList<Map<String, Object>>();
    }
    this.validationError.add(validationErrorItem);
    return this;
  }

   /**
   * Get validationError
   * @return validationError
  **/
  @Schema(description = "")
  public List<Map<String, Object>> getValidationError() {
    return validationError;
  }

  public void setValidationError(List<Map<String, Object>> validationError) {
    this.validationError = validationError;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidatedASNView validatedASNView = (ValidatedASNView) o;
    return Objects.equals(this.id, validatedASNView.id) &&
        Objects.equals(this.ordType, validatedASNView.ordType) &&
        Objects.equals(this.numberOfValidationFailed, validatedASNView.numberOfValidationFailed) &&
        Objects.equals(this.sentToKafkaTopic, validatedASNView.sentToKafkaTopic) &&
        Objects.equals(this.environment, validatedASNView.environment) &&
        Objects.equals(this.asnCreateTimestamp, validatedASNView.asnCreateTimestamp) &&
        Objects.equals(this.asnUpdateTimestamp, validatedASNView.asnUpdateTimestamp) &&
        Objects.equals(this.vendorNumber, validatedASNView.vendorNumber) &&
        Objects.equals(this.eventCreatedAt, validatedASNView.eventCreatedAt) &&
        Objects.equals(this.revisionNumber, validatedASNView.revisionNumber) &&
        Objects.equals(this.orlShipId, validatedASNView.orlShipId) &&
        Objects.equals(this.orderNumber, validatedASNView.orderNumber) &&
        Objects.equals(this.validationError, validatedASNView.validationError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ordType, numberOfValidationFailed, sentToKafkaTopic, environment, asnCreateTimestamp, asnUpdateTimestamp, vendorNumber, eventCreatedAt, revisionNumber, orlShipId, orderNumber, validationError);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidatedASNView {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ordType: ").append(toIndentedString(ordType)).append("\n");
    sb.append("    numberOfValidationFailed: ").append(toIndentedString(numberOfValidationFailed)).append("\n");
    sb.append("    sentToKafkaTopic: ").append(toIndentedString(sentToKafkaTopic)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    asnCreateTimestamp: ").append(toIndentedString(asnCreateTimestamp)).append("\n");
    sb.append("    asnUpdateTimestamp: ").append(toIndentedString(asnUpdateTimestamp)).append("\n");
    sb.append("    vendorNumber: ").append(toIndentedString(vendorNumber)).append("\n");
    sb.append("    eventCreatedAt: ").append(toIndentedString(eventCreatedAt)).append("\n");
    sb.append("    revisionNumber: ").append(toIndentedString(revisionNumber)).append("\n");
    sb.append("    orlShipId: ").append(toIndentedString(orlShipId)).append("\n");
    sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
    sb.append("    validationError: ").append(toIndentedString(validationError)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}