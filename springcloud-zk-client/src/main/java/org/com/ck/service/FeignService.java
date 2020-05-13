package org.com.ck.service;

@FeignClient(value = "hello-service", fallback = FeignFallBack.class)
public interface FeignService {
	public String home();
}
