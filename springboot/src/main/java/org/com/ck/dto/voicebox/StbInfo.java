/*
 * Project: magic-dispatch
 * 
 * File Created at 2019年5月8日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package org.com.ck.dto.voicebox;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

/**
 * @Type StbInfo.java
 * @Desc
 * @author ChenKai
 * @date 2019年5月8日 下午2:45:31
 * @version
 */

public class StbInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String stbid;
	private String stbMac;
	private String stbAccount;
	private String model;
	private String manufactor;
	private String itvAccount;
	private String itvLogo;

	public String getStbid() {
		return stbid;
	}

	public void setStbid(String stbid) {
		this.stbid = stbid;
	}

	public String getStbMac() {
		return stbMac;
	}

	public void setStbMac(String stbMac) {
		this.stbMac = stbMac;
	}

	public String getStbAccount() {
		return stbAccount;
	}

	public void setStbAccount(String stbAccount) {
		this.stbAccount = stbAccount;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getItvAccount() {
		return itvAccount;
	}

	public void setItvAccount(String itvAccount) {
		this.itvAccount = itvAccount;
	}

	public String getItvLogo() {
		return itvLogo;
	}

	public void setItvLogo(String itvLogo) {
		this.itvLogo = itvLogo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2019年5月8日 ChenKai creat
 */
