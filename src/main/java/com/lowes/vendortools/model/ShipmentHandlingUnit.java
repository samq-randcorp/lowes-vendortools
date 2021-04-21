/****************************************************************************
 * Copyright (C)  Lowe's Companies, Inc.  All rights reserved.
 * This file  is for internal use only at Lowe's Companies, Inc.
 ***************************************************************************/

package com.lowes.vendortools.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "uId", "uType", "barCdId", "barCdType", "uWgt", "uCube", "uLen", "uWid", "uHgt",
	"uStackWgtLimit", "lxwOrientationIdc", "uStatus", "shipmentHandlingUnit", "uDtl" })
public class ShipmentHandlingUnit {
	
	@NotNull
	@JsonProperty("uId")
	private String handlingUnitId;
	@NotNull
	@JsonProperty("uType")
	private String handlingUnitType;
	@NotNull
	@JsonProperty("puId")
	private int parentUID;
	@JsonProperty("barCdId")
	private String barCodeId;
	@JsonProperty("barCdType")
	private String barCdType;
	@JsonProperty("uWgt")
	private float handlingUnitWeight;
	@JsonProperty("uCube")
	private float handlingUnitCube;
	@JsonProperty("uLen")
	private float handlingUnitLength;
	@JsonProperty("uWid")
	private float handlingUnitWidth;
	@JsonProperty("uHgt")
	private float handlingUnitHeight;
	@JsonProperty("uStatus")
	private String handlingUnitStatus;
	@JsonProperty("uDtl")
	private List<HandlingUnitDetail> handlingUnitDetail;
}
