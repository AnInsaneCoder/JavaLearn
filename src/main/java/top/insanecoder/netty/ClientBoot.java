package top.insanecoder.netty;

import top.insanecoder.netty.client.NettyClient;
import top.insanecoder.netty.enums.HandlerTypeEnum;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-22
 */
public class ClientBoot {

    public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException {

        new NettyClient().buildHandlerType(HandlerTypeEnum.DELIMITER_BASED_DECODER).connect("127.0.0.1", 8007);
    }
}
