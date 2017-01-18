package top.insanecoder.mina;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by admin on 2017/1/18.
 */
public class MinaTimeClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;
    public static void main(String[] args) {

        NioSocketConnector nioSocketConnector = new NioSocketConnector();

        nioSocketConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));

        nioSocketConnector.setHandler(new TimeClientHandler());

        ConnectFuture future = nioSocketConnector.connect(new InetSocketAddress(HOST, PORT));
        future.awaitUninterruptibly();
        IoSession session = future.getSession();

        session.getCloseFuture().awaitUninterruptibly();

        nioSocketConnector.dispose();
    }
}
