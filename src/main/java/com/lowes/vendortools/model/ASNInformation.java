package com.lowes.vendortools.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({ "ASN"})
@Data
public class ASNInformation{
	@JsonProperty("IncomingHeader")
	private InboundHeader header;
	@NotNull
	@JsonProperty("ASN")
	@Valid
	private ASNData asn;	
}
