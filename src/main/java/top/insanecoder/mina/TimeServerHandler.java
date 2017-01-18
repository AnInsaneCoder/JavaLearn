package top.insanecoder.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

/**
 * Created by admin on 2017/1/18.
 */
public class TimeServerHandler extends IoHandlerAdapter {

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("session idle status: " + status + ", session id = " + session.getId());
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        if ("quit".equals(str)) {
            System.out.println("session close, session id = " + session.getId());
            session.closeNow();
            return;
        }
        session.write(new Date().toString());
        System.out.println(str);
    }
}
