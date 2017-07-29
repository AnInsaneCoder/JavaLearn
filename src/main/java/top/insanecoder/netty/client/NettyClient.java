package top.insanecoder.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.apache.log4j.Logger;
import top.insanecoder.netty.enums.HandlerTypeEnum;
import top.insanecoder.netty.factory.DefaultDelimiterDecoder;
import top.insanecoder.netty.factory.DefaultLineFrameDecoder;
import top.insanecoder.netty.factory.FrameDecoderFactory;
import top.insanecoder.netty.serialization.msgpack.MsgpackDecoder;
import top.insanecoder.netty.serialization.msgpack.MsgpackEncoder;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-05-25
 */
public class NettyClient {

    private static final Logger logger = Logger.getLogger(NettyClient.class);

    private HandlerTypeEnum handlerType;

    public NettyClient buildHandlerType (HandlerTypeEnum handlerType) {
        this.handlerType = handlerType;
        return this;
    }

    public void connect(String ip, int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new MyChannelHandler());

            ChannelFuture future = bootstrap.connect(ip, port).sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    private class MyChannelHandler extends ChannelInitializer<SocketChannel> {

        protected void initChannel(SocketChannel socketChannel) throws Exception {
            switch (handlerType) {
                case LINE_BASED_DECODER:
                    socketChannel.pipeline().addLast(FrameDecoderFactory.newInstance(DefaultLineFrameDecoder.class));
                    socketChannel.pipeline().addLast(new StringDecoder());
                    socketChannel.pipeline().addLast(new NettyClientHandler(System.getProperty("line.separator")));
                    break;
                case DELIMITER_BASED_DECODER:
                    socketChannel.pipeline().addLast(FrameDecoderFactory.newInstance(DefaultDelimiterDecoder.class));
                    socketChannel.pipeline().addLast(new StringDecoder());
                    socketChannel.pipeline().addLast(new NettyClientHandler(DefaultDelimiterDecoder.DEFAULT_DELIMITER));
                    break;
                case MESSAGE_PACK:
                    socketChannel.pipeline().addLast(new MsgpackDecoder());
                    socketChannel.pipeline().addLast(new MsgpackEncoder());
                    socketChannel.pipeline().addLast(new MsgpackClientHandler(1));
                    break;
                default:
                    logger.error("HandlerType should be given!!!");
                    throw new RuntimeException("HandlerType should be given");
            }
        }
    }
}
