package top.insanecoder.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-05-25
 */
public class NettyClientHandler extends ChannelHandlerAdapter {

    private static Logger logger = Logger.getLogger(NettyClientHandler.class);

    private byte[] msgToSend;
    private int counter = 0;

    public NettyClientHandler() {
        String str = "QUERY TIME" + System.getProperty("line.separator");
        msgToSend = str.getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ByteBuf byteBuf = null;
        for (int i = 0; i < 100; i++) {
            byteBuf = Unpooled.buffer(msgToSend.length);
            byteBuf.writeBytes(msgToSend);
            ctx.writeAndFlush(byteBuf);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        logger.info(body + " : " + counter++);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
