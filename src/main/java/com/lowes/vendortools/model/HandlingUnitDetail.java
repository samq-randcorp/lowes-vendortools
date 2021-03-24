/****************************************************************************
 * Copyright (C)  Lowe's Companies, Inc.  All rights reserved.
 * This file  is for internal use only at Lowe's Companies, Inc.
 ***************************************************************************/

package com.lowes.vendortools.model;

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
@JsonPropertyOrder({ "ordNbr","lineNbr", "qty" })
public class HandlingUnitDetail {

	@JsonProperty("ordNbr")
	private long orderNumber;
	@JsonProperty("lineNbr")
	private long detailLineNumber;
	@JsonProperty("qty")
	private long quantity;



}
