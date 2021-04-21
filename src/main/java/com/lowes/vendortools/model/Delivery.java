package com.lowes.vendortools.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
@JsonPropertyOrder({ "deliveryId", "destinationCountryName", "asnNumber","destinationNodeNumber" ,"destinationNodeName", 
	"destinationNodeType", "destinationStopNumber", "requiredDeliveryTimestamp", "estimatedToActualDeliveryTimestamp"
	,"deliveryStatus","primarySealId","secondarySealId","agency","order","shipmentHandlingUnit"
})
public class Delivery {
	
	@NotNull
	@JsonProperty("deliveryId")
	private String deliveryId;
	@JsonProperty("destinationCountryName")
	private String destinationCountryName;	
	//@NotNull
	@JsonProperty("asnNumber")
	private long asnNumber;
	@NotNull
	@JsonProperty("destinationNodeNumber")
	private String destinationNodeNumber;
	@JsonProperty("primarySealNumber")
	private String primarySealNumber;
	@JsonProperty("secondarySealNumber")
	private String secondarySealNumber;
	@JsonProperty("destinationNodeName")
	private String destinationNodeName;
	@JsonProperty("destinationNodeType")
	private String destinationNodeType;
	@JsonProperty("destinationStopNumber")
	private Integer destinationStopNumber;
	@JsonProperty("requiredDeliveryTimestamp")
	private String requiredDeliveryTimestamp;
	@JsonProperty("estimatedToActualDeliveryTimestamp")
	private String estimatedToActualDeliveryTimestamp;
	@JsonProperty("deliveryStatus")
	private String deliveryStatus;
	@JsonProperty("primarySealId")
	private String primarySealId;
	@JsonProperty("secondarySealId")
	private String secondarySealId;
	@JsonProperty("agency")
	private String agency;
	@JsonProperty("order")
	@Valid
	private List<Order> order;
	@JsonProperty("shipmentHandlingUnit")
	private List<ShipmentHandlingUnit> shipmentHandlingUnit;
	

}
