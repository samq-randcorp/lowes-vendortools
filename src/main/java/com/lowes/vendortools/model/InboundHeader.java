package com.lowes.vendortools.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundHeader {
	private String transactionId;
	private LocalDateTime asnReceivedAt;
	private String tnsPpsId;
	private String asnHrcSruId;
	@JsonProperty("dstMthTxt")
	private String DST_MTH_TXT; // OF order level 'CON'
	@JsonProperty("orgTmZonTxt")
	private String ORG_TM_ZON_TXT;// shipment
	@JsonProperty("arvTmZonTxt")
	private String arrivalTimeZone;// order
	@JsonProperty("shpMthPayId")
	private String shpMthPayId;// order
	@JsonProperty("equipmentDescTxt")
	private String equipmentDescTxt;// shipment
	@JsonProperty("equipmentId")
	private String equipmentId;// shipment
	@JsonProperty("frgCaiTxt")
	private String frgCaiTxt;// shipment
	@JsonProperty("cdkLocNbr")
	private String cdkLocNbr;// E350 Order Level
	@JsonProperty("packagingInfo")
	private List<PackagingInfo> packagingInfo;// TDI
	@JsonProperty("troMthId")
	private String troMthId;
	@JsonProperty("stxErrCdTxt")
	private String stx_Err_Cd_txt;// EDI Layout
	@JsonProperty("evpErrCdTxt")
	private String EVP_ERR_CD_TXT;// Edi Layout
	@JsonProperty("gsCmcId")
	private String GSComnID;// Edi Layout
	@JsonProperty("cmcQlfTxt")
	private String comIdQulifierText;// Edi Layout
	@JsonProperty("pnrTesPdcIdc")
	private String transPdcIdc;// Edi Layout
	@JsonProperty("fileName")
	private String fileName;
}
