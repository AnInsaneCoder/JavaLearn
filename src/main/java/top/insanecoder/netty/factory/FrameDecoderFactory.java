package top.insanecoder.netty.factory;

import io.netty.channel.ChannelHandlerAdapter;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-22
 */
public class FrameDecoderFactory {

    public static <T extends ChannelHandlerAdapter> T newInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
