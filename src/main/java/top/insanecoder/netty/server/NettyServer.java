package top.insanecoder.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
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
public class NettyServer {

    private static final Logger logger = Logger.getLogger(NettyServer.class);

    private HandlerTypeEnum handlerType;

    public NettyServer buildHandlerType (HandlerTypeEnum handlerType) {
        this.handlerType = handlerType;
        return this;
    }
    public void bind(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());

            ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        protected void initChannel(SocketChannel socketChannel) throws Exception {
            switch (handlerType) {
                case LINE_BASED_DECODER:
                    socketChannel.pipeline().addLast(FrameDecoderFactory.newInstance(DefaultLineFrameDecoder.class));
                    socketChannel.pipeline().addLast(new StringDecoder());
                    socketChannel.pipeline().addLast(new NettyServerHandler(System.getProperty("line.separator")));
                    break;
                case DELIMITER_BASED_DECODER:
                    socketChannel.pipeline().addLast(FrameDecoderFactory.newInstance(DefaultDelimiterDecoder.class));
                    socketChannel.pipeline().addLast(new StringDecoder());
                    socketChannel.pipeline().addLast(new NettyServerHandler(DefaultDelimiterDecoder.DEFAULT_DELIMITER));
                    break;
                case MESSAGE_PACK:
                    socketChannel.pipeline().addLast(new MsgpackDecoder());
                    socketChannel.pipeline().addLast(new MsgpackEncoder());
                    socketChannel.pipeline().addLast(new MsgpackServerHandler());
                    break;
                default:
                    logger.error("HandlerType should be given");
                    throw new RuntimeException("HandlerType should be given");
            }
        }
    }
}
