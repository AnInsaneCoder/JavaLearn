package top.insanecoder.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by admin on 2017/1/18.
 */
public class TimeClientHandler extends IoHandlerAdapter {

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("session opened, session id = " + session.getId());
        session.write("hello");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println(message.toString());
    }
}
