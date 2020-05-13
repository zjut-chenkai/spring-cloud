package org.com.ck.webservice.service.impl;

import javax.jws.WebService;

import org.com.ck.webservice.bean.User;
import org.com.ck.webservice.service.CommonService;
import org.springframework.stereotype.Component;

@WebService(serviceName = "CommonService", // 与接口中指定的name一致
		targetNamespace = "http://service.webservice.ck.com.org/", // 与接口中的命名空间一致,一般是接口的包名倒
		endpointInterface = "org.com.ck.webservice.service.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {
	@Override
	public String getUser(String param) {
		User user = new User("1", "吹比龙", "18");
		return user.toString();
	}

	@Override
	public String sayHello(String param) {
		// TODO Auto-generated method stub
		return null;
	}
}