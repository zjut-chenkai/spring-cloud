package org.com.ck.webservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String userId;
	private String username;
	private String age;
}
