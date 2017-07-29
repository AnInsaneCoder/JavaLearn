package top.insanecoder.netty.model;

import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-29
 */
@Message
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -2728448474891939039L;

    private String id;
    private String name;
    private int age;

    /**
     * getter
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * setter
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * setter
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
