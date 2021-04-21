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

import lombok.Data;




@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ordNbr", "ordSource", "orderType","xDockNodeNumber" , "finalDestinationNodeNumber", "orderReferences",
	"ordWgt", "ordCube", "ordStatus", "ordDetail"

})
public class Order {
	
	@NotNull
	@JsonProperty("ordNbr")
	private String ordNbr;
	@JsonProperty("ordSource")
	private String ordSource;
	@JsonProperty("orderType")
	private String ordType;
	@JsonProperty("xDockNodeNumber")
	private Long xDockNodeNumber;
	@JsonProperty("finalDestinationNodeNumber")
	private Long finalDestinationNodeNumber;
	@JsonProperty("orderReferences")
	private List<OrderReferences> ordReferences;	
	@JsonProperty("ordWgt")
	private float ordWgt;
	@JsonProperty("ordCube")
	private float ordCube;	
	@NotNull
	@JsonProperty("ordStatus")
	private String ordStatus;
	@JsonProperty("poDestinationNodeNumber")
	private long poDestinationNodeNumber;
	@JsonProperty("ordDetail")
	private List<OrderDetail> ordDetail;
	@JsonProperty("asnCreateTimestamp")
	private String asnCreateTimestamp;
	@JsonProperty("asnUpdateTimestamp")
	private String asnUpdateTimestamp;
    @JsonProperty("hrcId")
	private String hrcId;
}
