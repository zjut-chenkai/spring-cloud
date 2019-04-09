package org.com.ck.service;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

public interface IndexService {
	
	public String index(JSONObject obj);
}
