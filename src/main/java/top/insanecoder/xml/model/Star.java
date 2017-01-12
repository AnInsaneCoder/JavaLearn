package top.insanecoder.xml.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by admin on 2017/1/12.
 */
@XmlRootElement
public class Star {

    private String name;
    private String age;
    private String nationality;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @XmlElement
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
