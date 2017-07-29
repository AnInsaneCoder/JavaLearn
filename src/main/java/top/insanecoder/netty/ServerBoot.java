package top.insanecoder.netty;

import top.insanecoder.netty.enums.HandlerTypeEnum;
import top.insanecoder.netty.server.NettyServer;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-22
 */
public class ServerBoot {

    public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException {
        new NettyServer().buildHandlerType(HandlerTypeEnum.MESSAGE_PACK).bind(8007);
    }

}
