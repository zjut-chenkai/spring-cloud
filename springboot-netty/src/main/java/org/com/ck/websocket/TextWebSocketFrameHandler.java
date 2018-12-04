package org.com.ck.websocket;

import java.util.concurrent.ConcurrentHashMap;

import org.com.ck.bean.ChatProtocolInfo;

import com.alibaba.fastjson.JSON;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	private static ConcurrentHashMap<String, Channel> sessionChannelMap = new ConcurrentHashMap<String, Channel>();

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		Channel incoming = ctx.channel();
		String requestmsg = ((TextWebSocketFrame) msg).text();
		ChatProtocolInfo obj = JSON.parseObject(requestmsg, ChatProtocolInfo.class);
		if ("100001".equals(obj.getCode())) {
			sessionChannelMap.put(obj.getFr(), incoming);
		} else if ("100002".equals(obj.getCode())) {
			incoming.writeAndFlush(new TextWebSocketFrame(obj.getFr() + ":" + obj.getMsg()));

			sessionChannelMap.get(obj.getTo()).writeAndFlush(new TextWebSocketFrame(obj.getFr() + ":" + obj.getMsg()));
		} else {
			for (Channel channel : channels) {
				if (channel != incoming) {
					channel.writeAndFlush(
							new TextWebSocketFrame(obj.getMsg()));
				} else {
					channel.writeAndFlush(new TextWebSocketFrame(obj.getMsg()));
				}
			}
		}
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception { // (2)
		Channel incoming = ctx.channel();
		channels.writeAndFlush(new TextWebSocketFrame("[SERVER--join--] - " + incoming.remoteAddress() + " 加入"));

		channels.add(incoming);
		System.out.println("Client:" + incoming.remoteAddress() + "加入");
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception { // (3)
		Channel incoming = ctx.channel();

		// Broadcast a message to multiple Channels
		channels.writeAndFlush(new TextWebSocketFrame("[SERVER--leave--] - " + incoming.remoteAddress() + " 离开"));

		// System.out.println("Client:" + incoming.remoteAddress() + "离开");

		// A closed Channel is automatically removed from ChannelGroup,
		// so there is no need to do "channels.remove(ctx.channel());"
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
		Channel incoming = ctx.channel();
		// System.out.println("Client:--you--" + incoming.remoteAddress() +
		// "在线");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
		Channel incoming = ctx.channel();
		System.out.println(incoming);
		// System.out.println("Client:--out --" + incoming.remoteAddress() +
		// "掉线");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		Channel incoming = ctx.channel();
		// System.out.println("Client:" + incoming.remoteAddress() + "异常");
		// 当出现异常就关闭连接
		cause.printStackTrace();
		ctx.close();
	}

}
