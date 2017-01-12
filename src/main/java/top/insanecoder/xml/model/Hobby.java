package top.insanecoder.xml.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by admin on 2017/1/12.
 */
@XmlRootElement
public class Hobby {

    private String art;
    private String sport;

    @XmlElement
    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    @XmlElement
    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "art='" + art + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
