package com.lowes.vendortools.model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ASNServiceResponseDTO {
String response;
@SerializedName(value = "transaction-Id")
private String transactionId;
private String time;
}
