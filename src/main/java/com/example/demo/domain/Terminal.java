package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Terminal {

	@Id
	private Integer logic;

	@NotEmpty(message="Preenchimento obrigatório")
	@Column(nullable = false)
	private String serial;

	@NotEmpty(message="Preenchimento obrigatório")
	@Column(nullable = false)
	private String model;

	private Integer sam;

	private String ptid;

	private Integer plat;

	@NotEmpty(message="Preenchimento obrigatório")
	@Column(nullable = false)
	private String version;

	private Integer mxr;

	private Integer mxf;

	private String verfm;
	
	public Terminal(Integer logic, String serial, String model, Integer sam, String ptid, Integer plat, String version,
			Integer mxr, Integer mxf, String verfm) {
		super();
		this.logic = logic;
		this.serial = serial;
		this.model = model;
		this.sam = sam;
		this.ptid = ptid;
		this.plat = plat;
		this.version = version;
		this.mxr = mxr;
		this.mxf = mxf;
		this.verfm = verfm;
	}
	
	public Terminal() {
		
	}

	public Integer getLogic() {
		return logic;
	}

	public void setLogic(Integer logic) {
		this.logic = logic;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getSam() {
		return sam;
	}

	public void setSam(Integer sam) {
		this.sam = sam;
	}

	public String getPtid() {
		return ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public Integer getPlat() {
		return plat;
	}

	public void setPlat(Integer plat) {
		this.plat = plat;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getMxr() {
		return mxr;
	}

	public void setMxr(Integer mxr) {
		this.mxr = mxr;
	}

	public Integer getMxf() {
		return mxf;
	}

	public void setMxf(Integer mxf) {
		this.mxf = mxf;
	}

	public String getVerfm() {
		return verfm;
	}

	public void setVerfm(String verfm) {
		this.verfm = verfm;
	}
	

}
