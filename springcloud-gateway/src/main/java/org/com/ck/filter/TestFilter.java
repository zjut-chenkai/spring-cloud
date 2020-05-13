package org.com.ck.filter;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TestFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("-----------------");
/*		URI uri = exchange.getRequest().getURI();
		System.out.println(uri.getPath());
		System.out.println(uri.getHost());
		String reMsg = "staggsaga";
		byte[] bytes = reMsg.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        List<String> head = new ArrayList<>();
        head.add("application/json");
        exchange.getResponse().getHeaders().put("Content-Type", head);
        return exchange.getResponse().writeWith(Flux.just(buffer));*/
        return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}

}
