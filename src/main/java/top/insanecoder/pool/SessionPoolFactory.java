package top.insanecoder.pool;

import org.apache.commons.pool.PoolableObjectFactory;

/**
 * Created by admin on 2017/1/19.
 */
public class SessionPoolFactory implements PoolableObjectFactory {

    private static int number;

    public Object makeObject() throws Exception {
        Session session = new Session("session-" + count());
        session.connect("localhost", 9999);
        return session;
    }

    public void destroyObject(Object obj) throws Exception {
        Session session = (Session) obj;
        session.close();
        System.out.println(session.getName() + " is destroyed");
    }

    public boolean validateObject(Object obj) {
        Session session = (Session) obj;
        return session.isValidate();
    }

    public void activateObject(Object obj) throws Exception {
        Session session = (Session) obj;
        System.out.println(session.getName() + " is activated");
    }

    public void passivateObject(Object obj) throws Exception {
        Session session = (Session) obj;
        System.out.println(session.getName() + " is deactivated");
    }

    public synchronized int count() {
        return number++;
    }
}
