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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Type BoxInfo.java
 * @Desc
 * @author ChenKai
 * @date 2019年5月8日 下午2:45:46
 * @version
 */

public class BoxInfo {

	@NotNull(message = "参数校验失败")
	@NotBlank(message = "参数校验失败")
	private String dvsId;

	private String dvsMac;
	private String dvsSn;
	private String dvsChannelId;
	private String manufactor;
	private String model;
	public String getDvsId() {
		return dvsId;
	}
	public void setDvsId(String dvsId) {
		this.dvsId = dvsId;
	}
	public String getDvsMac() {
		return dvsMac;
	}
	public void setDvsMac(String dvsMac) {
		this.dvsMac = dvsMac;
	}
	public String getDvsSn() {
		return dvsSn;
	}
	public void setDvsSn(String dvsSn) {
		this.dvsSn = dvsSn;
	}
	public String getDvsChannelId() {
		return dvsChannelId;
	}
	public void setDvsChannelId(String dvsChannelId) {
		this.dvsChannelId = dvsChannelId;
	}
	public String getManufactor() {
		return manufactor;
	}
	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
