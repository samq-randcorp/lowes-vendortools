package com.lowes.vendortools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackagingInfo{
	
@JsonProperty("pckType")
private String pckType;
@JsonProperty("pckCount")
private int pckCount;
}
