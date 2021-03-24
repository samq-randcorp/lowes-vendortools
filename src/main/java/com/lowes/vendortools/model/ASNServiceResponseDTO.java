package com.lowes.vendortools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ASNServiceResponseDTO {
String response;
@JsonProperty(value = "transaction-Id")
private String transactionId;
private String time;
}
