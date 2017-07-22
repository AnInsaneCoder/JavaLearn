package top.insanecoder.netty.factory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-22
 */
public class DefaultDelimiterDecoder extends DelimiterBasedFrameDecoder {

    public static final String DEFAULT_DELIMITER = "$";

    public DefaultDelimiterDecoder() {
        super(1024, Unpooled.copiedBuffer(DEFAULT_DELIMITER.getBytes()));
    }

    public DefaultDelimiterDecoder(int maxFrameLength, ByteBuf delimiter) {
        super(maxFrameLength, delimiter);
    }
}
