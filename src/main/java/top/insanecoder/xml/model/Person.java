package top.insanecoder.xml.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by admin on 2017/1/12.
 */
@XmlRootElement
public class Person {

    private String name;
    private String age;
    private Hobby hobby;
    private List<Star> favoriteStars;

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
    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    @XmlElementWrapper(name = "favorite-stars")
    @XmlElements({
            @XmlElement(name = "star", type = Star.class)
    })
    public List<Star> getFavoriteStars() {
        return favoriteStars;
    }

    public void setFavoriteStars(List<Star> favoriteStars) {
        this.favoriteStars = favoriteStars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", hobby=" + hobby +
                ", favoriteStars=" + favoriteStars +
                '}';
    }
}
