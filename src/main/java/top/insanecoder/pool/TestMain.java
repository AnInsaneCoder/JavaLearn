package top.insanecoder.pool;

import org.apache.commons.pool.impl.GenericObjectPool;

/**
 * Created by admin on 2017/1/19.
 */
public class TestMain {

    public static void main(String[] args) {

        GenericObjectPool.Config config = new GenericObjectPool.Config();
        config.maxActive = 5;
        config.maxIdle =  5;
        config.minIdle = 1;
        config.maxWait = 5 * 1000;
        GenericObjectPool pool = new GenericObjectPool(new SessionPoolFactory(), config);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyRunnable(pool, i + ""));
            t.start();
        }
    }

    public static class MyRunnable implements Runnable {

        private GenericObjectPool pool;
        private String data;

        public MyRunnable (GenericObjectPool pool, String data) {
            this.pool = pool;
            this.data = data;
        }

        public void run() {
            Session session = null;
            try {
                session = (Session) pool.borrowObject();
                session.write("test data -> " + data);
                Thread.sleep(3 * 1000);
            } catch (Exception e) {
                try {
                    pool.invalidateObject(session);
                    System.out.println("destroy " + session);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            } finally {
                try {
                    pool.returnObject(session);
                    System.out.println("return " + session);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
