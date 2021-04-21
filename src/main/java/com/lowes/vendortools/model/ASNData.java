package com.lowes.vendortools.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author pjaiswa
 *
 */
@Data
@JsonPropertyOrder({ "loadId", "shipperNodeNumber","shipperNodeName","shipperNodeType","primaryEquipmentType" 
	,"primaryEquipmentId","primaryEquipmentCarrierSCAC","estimatedToActualShipTimestamp","loadStatus"
	,"freightMovement","delivery"})
public class ASNData {
	
	@JsonProperty("loadId")
	private String loadId;
	/**
	 * Using Wrapper Class Boolean because we would not persist this Attribute if its Set To Null
	 * we will Persist only if True or False 
	 * Tried @Transient its not saving this field at all 
	 */
	@JsonProperty("sent")
	@JsonInclude(Include.NON_NULL)
	 @Schema(required = false,hidden = true) 
	private Boolean dataSentToKafkaTopic;
	@JsonInclude(Include.NON_NULL)
	 @Schema(required = false,hidden = true)
	private int retryCounter;
	@JsonIgnore
	@JsonProperty("revisionNumber")
	private long revisionNumber;
	@Min(1)
	@NotNull
	@JsonProperty("shipperNodeNumber")
	private long shipperNodeNumber;	
	@JsonProperty("shipperNodeName")
	private String shipperNodeName;
	@JsonProperty("shipperNodeType")
	private String shipperNodeType; 
	@JsonProperty("primaryEquipmentType")
	private String primaryEquipmentType;
	@JsonProperty("primaryEquipmentId")
	private String primaryEquipmentId;
	@JsonProperty("primaryEquipmentCarrierSCAC")
	private String primaryEquipmentCarrierSCAC;
	@JsonProperty("requiredShipTimestamp")
	private String requiredShipTimestamp;
	@JsonProperty("estimatedToActualShipTimestamp")
	private String estimatedToActualShipTimestamp;	
	@JsonProperty("loadStatus")
	private String loadStatus;
	@Valid
	@JsonProperty("freightMovement")
	private List<FreightMovement> freightMovement;
	@JsonProperty("validationError")
	@Schema(required = false,hidden = true) 
	private List<ValidationError>validationError;
	@JsonProperty("delivery")
	@Valid
	private List<Delivery> delivery;

}
