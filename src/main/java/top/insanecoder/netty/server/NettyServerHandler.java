package top.insanecoder.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-05-25
 */
public class NettyServerHandler extends ChannelHandlerAdapter {

    private static Logger logger = Logger.getLogger(NettyServerHandler.class);

    private int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        logger.info(body + " : " + counter++);
        String curTime = new Date(System.currentTimeMillis()).toString() + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(curTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.disconnect(ctx, promise);
    }
}
