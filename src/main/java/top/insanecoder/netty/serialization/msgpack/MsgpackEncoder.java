package top.insanecoder.netty.serialization.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-29
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {

    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        MessagePack msgPack = new MessagePack();
        byte[] bytes = msgPack.write(msg);
        out.writeBytes(bytes);
    }
}
