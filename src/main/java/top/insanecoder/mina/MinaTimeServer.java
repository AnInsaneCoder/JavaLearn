package top.insanecoder.mina;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by admin on 2017/1/18.
 */
public class MinaTimeServer {

    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {

        IoAcceptor ioAcceptor = new NioSocketAcceptor();

        ioAcceptor.getFilterChain().addLast("logger", new LoggingFilter());
        ioAcceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));

        ioAcceptor.setHandler(new TimeServerHandler());
        ioAcceptor.bind(new InetSocketAddress(PORT));
    }
}
