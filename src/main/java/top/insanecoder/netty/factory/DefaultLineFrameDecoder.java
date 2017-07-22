package top.insanecoder.netty.factory;

import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-22
 */
public class DefaultLineFrameDecoder extends LineBasedFrameDecoder {

    public DefaultLineFrameDecoder() {
        super(1024);
    }

    public DefaultLineFrameDecoder(int length) {
        super(length);
    }
}
