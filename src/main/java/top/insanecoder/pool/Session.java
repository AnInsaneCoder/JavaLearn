package top.insanecoder.pool;

/**
 * Created by admin on 2017/1/19.
 */
public class Session {

    private String name;
    private boolean isValidate;
    public Session(String name) {
        this.name = name;
    }

    public void connect(String ip, int port) {
        isValidate = true;
        System.out.println("connecting to " + ip + ":" + port + " success -> " + name);
    }

    public void write(String data) {
        System.out.println("writing data -> " + name + " -> " + data);
    }

    public void close() {
        isValidate = false;
        System.out.println("session closed -> " + name);
    }

    public boolean isValidate() {
        return isValidate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Session{" +
                "name='" + name + '\'' +
                '}';
    }

}
