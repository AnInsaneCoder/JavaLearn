package top.insanecoder.xml.test;

import top.insanecoder.xml.model.Person;
import top.insanecoder.xml.util.XmlUtil;

import javax.xml.bind.JAXBException;
import java.io.*;

/**
 * Created by admin on 2017/1/12.
 */
public class UtilMain {

    public static void main(String[] args) throws IOException, JAXBException {
        XmlUtil<Person> xmlUtil = new XmlUtil<Person>();
        BufferedInputStream binput = new BufferedInputStream(new FileInputStream("src/main/resources/test.xml"));
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = binput.read(bytes)) > 0) {
            sb.append(new String(bytes, 0, len));
        }

        // xml to java bean
        Person person = xmlUtil.xml2JavaBean(sb.toString(), Person.class);
        System.out.println(person);
        binput.close();

        // java bean to xml
        String xml = xmlUtil.javaBean2Xml(person);
        System.out.println(xml);
    }
}
