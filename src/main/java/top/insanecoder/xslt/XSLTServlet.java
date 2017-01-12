package top.insanecoder.xslt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by admin on 2017/1/12.
 */
public class XSLTServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String root = getServletContext().getRealPath("/");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        StreamSource xslStreamSource = new StreamSource(new FileReader(root + "WEB-INF/classes/test.xsl"));
        StreamSource xmlStreamSource = new StreamSource(new FileReader(root + "WEB-INF/classes/test.xml"));
        try {
            OutputStream output = response.getOutputStream();
            Transformer transformer = transformerFactory.newTransformer(xslStreamSource);
            transformer.transform(xmlStreamSource, new StreamResult(output));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
