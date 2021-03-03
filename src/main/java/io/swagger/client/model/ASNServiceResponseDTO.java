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
/**
 * ASNServiceResponseDTO
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-03-03T04:59:55.167Z[GMT]")
public class ASNServiceResponseDTO {
  @SerializedName("response")
  private String response = null;

  @SerializedName("time")
  private String time = null;

  @SerializedName("transaction-Id")
  private String transactionId = null;

  public ASNServiceResponseDTO response(String response) {
    this.response = response;
    return this;
  }

   /**
   * Get response
   * @return response
  **/
  @Schema(description = "")
  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public ASNServiceResponseDTO time(String time) {
    this.time = time;
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @Schema(description = "")
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public ASNServiceResponseDTO transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

   /**
   * Get transactionId
   * @return transactionId
  **/
  @Schema(description = "")
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ASNServiceResponseDTO asNServiceResponseDTO = (ASNServiceResponseDTO) o;
    return Objects.equals(this.response, asNServiceResponseDTO.response) &&
        Objects.equals(this.time, asNServiceResponseDTO.time) &&
        Objects.equals(this.transactionId, asNServiceResponseDTO.transactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(response, time, transactionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ASNServiceResponseDTO {\n");
    
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
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