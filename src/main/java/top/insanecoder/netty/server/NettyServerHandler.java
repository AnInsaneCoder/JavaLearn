package top.insanecoder.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.apache.log4j.Logger;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-05-25
 */
public class NettyServerHandler extends ChannelHandlerAdapter {

    private static Logger logger = Logger.getLogger(NettyServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        String body = new String(data, "utf-8");
        logger.info(body);
        long curTime = System.currentTimeMillis();
        ByteBuf resp = Unpooled.copiedBuffer((curTime + "").getBytes());
        ctx.write(resp);
        ctx.flush();
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
        logger.info("client disconnected!!!");
    }
}
