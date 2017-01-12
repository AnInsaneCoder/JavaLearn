package top.insanecoder.xml.test;

import top.insanecoder.xml.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by admin on 2017/1/12.
 */
public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Person person = (Person) unmarshaller.unmarshal(new FileReader("src/main/resources/test.xml"));
        System.out.println(person);

        Writer writer = new StringWriter();
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(person, writer);
        System.out.println(writer.toString());

    }
}
