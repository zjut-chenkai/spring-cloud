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

/**
 * @Type VoiceboxInfo.java
 * @Desc
 * @author ChenKai
 * @date 2019年5月8日 下午2:44:42
 * @version
 */

public class VoiceboxDto {
    private StbInfo stbInfo;
    private BoxInfo boxInfo;
	public StbInfo getStbInfo() {
		return stbInfo;
	}
	public void setStbInfo(StbInfo stbInfo) {
		this.stbInfo = stbInfo;
	}
	public BoxInfo getBoxInfo() {
		return boxInfo;
	}
	public void setBoxInfo(BoxInfo boxInfo) {
		this.boxInfo = boxInfo;
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
