package top.insanecoder.netty.client;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;
import top.insanecoder.netty.model.UserInfo;

import java.util.UUID;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-29
 */
public class MsgpackClientHandler extends ChannelHandlerAdapter {

    private static final Logger logger = Logger.getLogger(MsgpackClientHandler.class);

    private static final String DEFAULT_NAME = "shaohang.zsh";
    private int length;

    public MsgpackClientHandler(int length) {
        this.length = length;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        for (int i = 0; i < length; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(UUID.randomUUID().toString());
            userInfo.setName(DEFAULT_NAME + i);
            userInfo.setAge(i);

            ctx.write(userInfo);
        }

        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("Message from server: " + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
