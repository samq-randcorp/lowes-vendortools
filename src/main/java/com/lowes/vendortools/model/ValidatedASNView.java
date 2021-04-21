package com.lowes.vendortools.model;

import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ValidatedASNView {
	private String id;
	private String ordType;
	private long numberOfValidationFailed;
	private boolean sentToKafkaTopic;
	private String environment;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String asnCreateTimestamp;
	//@Schema(implementation = org.joda.time.LocalDateTime.class)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String asnUpdateTimestamp;
	private long vendorNumber;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String eventCreatedAt;
	private long revisionNumber;
	private String orlShipId;
	private String orderNumber;
	@Schema(allOf = ValidatedASNView.class)
	private List<ValidationError> validationError;
	//private List<HashMap<String,Object>> rawASN;
}
