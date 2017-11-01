package com.qc.you.socket.server.netty.handler;

import com.qc.you.socket.server.netty.ChannelGroups;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelMatcher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by youxiaojia on 2017/10/31.
 */
@Component
@Qualifier("broadCastChannelHandler")
@ChannelHandler.Sharable
public class BroadCastChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel ch = ctx.channel();
        String channelKey = ch.remoteAddress().toString();
        if (ChannelGroups.size() > 0) {
            ChannelGroups.broadcast("welcome :" + channelKey + "\n\r", new ChannelMatchers());
        }
        ChannelGroups.add(ch);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel ch = ctx.channel();
        String channelKey = ch.remoteAddress().toString();
        if (ChannelGroups.size() > 0) {
            ChannelGroups.broadcast("exist :" + channelKey + "\n\r", new ChannelMatchers());
        }
        ChannelGroups.remove(ch);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    public static class ChannelMatchers implements ChannelMatcher {

        @Override
        public boolean matches(Channel channel) {
            return true;
        }

    }
}
