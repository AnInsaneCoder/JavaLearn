package top.insanecoder.netty.serialization.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-29
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int length = msg.readableBytes();
        byte[] data = new byte[length];
        msg.getBytes(msg.readerIndex(), data, 0, length);
        MessagePack messagePack = new MessagePack();
        out.add(messagePack.read(data));
    }
}
