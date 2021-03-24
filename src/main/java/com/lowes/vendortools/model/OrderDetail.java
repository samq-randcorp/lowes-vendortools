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
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "lineNbr", "inbLinks", "otbLinks", "dtlId", "dtlRefs", "dtlType", "priority", "demandType",
	"requestedState", "cancelRejectQty", "dtlStatusQty", "constraints", "instructions", "fulfillmentDetailObject" })
public class OrderDetail{
	
	@NotNull
	@JsonProperty("lineNbr")
	private int lineNbr;
	@NotNull
	@JsonProperty("dtlId")
	private String dtlId;
	
	@JsonProperty("dtlRefs")
	private List<DetailReferences> dtlRefs;
	@NotNull
	@JsonProperty("dtlType")
	private String dtlType;
	@NotNull
	@JsonProperty("dtlStatusQty")
	private List<DetailStatusQuantity> dtlStatusQty;   
    @JsonProperty("hrcId")
    private String hrcId;
	@JsonProperty("barcodeId")
	private String barcodeId;
    @JsonProperty("prtHrcId")
	private String prtHrcId;
	
}
