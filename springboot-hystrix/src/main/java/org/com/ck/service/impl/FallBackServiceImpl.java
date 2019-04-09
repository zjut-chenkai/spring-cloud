package org.com.ck.service.impl;

import org.com.ck.service.FallBackService;
import org.springframework.stereotype.Service;

@Service
public class FallBackServiceImpl implements FallBackService {

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "ck----1111";
	}

}
