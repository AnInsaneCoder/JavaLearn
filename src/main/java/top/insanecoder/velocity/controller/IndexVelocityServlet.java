package top.insanecoder.velocity.controller;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import top.insanecoder.xml.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;

/**
 * Created by admin on 2017/1/12.
 */
public class IndexVelocityServlet extends VelocityViewServlet {

    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {

        String root = getServletContext().getRealPath("/");
        JAXBContext context = null;
        Person person = null;
        try {
            context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            person = (Person) unmarshaller.unmarshal(new FileReader(root + "WEB-INF/classes/test.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ctx.put("person", person);
        request.setAttribute("title", "FirstVelocityPage");

        return getTemplate("/WEB-INF/index.vm");
    }
}
