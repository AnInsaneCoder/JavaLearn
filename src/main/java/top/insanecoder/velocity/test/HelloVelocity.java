package top.insanecoder.velocity.test;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/12.
 */
public class HelloVelocity {

    public static void main(String[] args) {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        VelocityContext context = new VelocityContext();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "InsaneCoder");
        map.put("age", "25");
        map.put("sport", "football");
        context.put("map", map);
        List<String> list = new ArrayList<String>();
        list.add("Cristiano");
        list.add("Bale");
        list.add("Ramos");
        context.put("list", list);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("hello.vm", "utf-8", context, sw);
        System.out.println(sw.toString());
    }
}
