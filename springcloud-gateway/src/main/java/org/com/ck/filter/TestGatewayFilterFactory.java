package org.com.ck.filter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SetPathGatewayFilterFactory.Config;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestGatewayFilterFactory extends AbstractGatewayFilterFactory<TestGatewayFilterFactory.Config> {

	/*
	 * @Override public GatewayFilter apply(Object config) {
	 * System.out.println("自定义filter---"); return new InnerFilter(); }
	 */
	public TestGatewayFilterFactory() {
		super(Config.class);
	}
	@Override
	public GatewayFilter apply(Config config) {
		return new GatewayFilter() {

			@Override
			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
				String reMsg = "staggsaga";
				System.out.println(reMsg);
				byte[] bytes = reMsg.getBytes(StandardCharsets.UTF_8);
				DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
				List<String> head = new ArrayList<>();
				head.add("application/json");
				exchange.getResponse().getHeaders().put("Content-Type", head);
				return exchange.getResponse().writeWith(Flux.just(buffer));
			}

		};
	}

	public static class Config {
		private String type;
		private String op;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getOp() {
			return op;
		}

		public void setOp(String op) {
			this.op = op;
		}
	}
}
