/****************************************************************************
 * Copyright (C)  Lowe's Companies, Inc.  All rights reserved.
 * This file  is for internal use only at Lowe's Companies, Inc.
 ***************************************************************************/
package com.lowes.vendortools.model;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dtlStatus", "qty", "absQtyIdc" })
public class DetailStatusQuantity {
	
	@NotNull
	@JsonProperty("dtlStatus")
	private String dtlStatus;
	@NotNull
	@JsonProperty("qty")
	private int qty;
	@JsonProperty("absQtyIdc")
	private Boolean absQtyIdc;


}
