package com.lowes.vendortools.model;


import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;


/**
 * @author pjaiswa
 *
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "freightStatus", "freightMovementId", "freightMovementSequenceNumber", "shippingMode", "lowesFreightPayIndicator", "carrierScacId"
	,"billOfLadingId","freightDestinationNodeNumber","freightDestinationNodeName","freightDestinationNodeAddress","freightDestinationNodeType"})
public class FreightMovement {
	
	@JsonProperty("freightStatus")
	private String freightStatus;	
	@JsonProperty("freightMovementId")
	private String freightMovementId;	
	@JsonProperty("freightMovementSequenceNumber")
	private int freightMovementSequenceNumber;
	@JsonProperty("shippingMode")
   // @ValueOfEnum(enumClass = ShippingMode.class)
	private String shippingMode;
	@JsonProperty("lowesFreightPayIndicator")
	private boolean lowesFreightPayIndicator;
	@JsonProperty("carrierScacId")
	private String carrierScacId;
	@JsonProperty("billOfLadingId")
	private String billOfLadingId;
	@JsonProperty("freightDestinationNodeNumber")
	private long freightDestinationNodeNumber;
	@JsonProperty("freightDestinationNodeName")
	private String freightDestinationNodeName;
	@JsonProperty("freightDestinationNodeAddress")
	@Valid
	private FreightDestinationNodeAddress freightDestinationNodeAddress;
	@JsonProperty("freightDestinationNodeType")
	private String freightDestinationNodeType;

}
