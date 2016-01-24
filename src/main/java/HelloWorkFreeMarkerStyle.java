import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jonathan on 12/01/2016.
 */
public class HelloWorkFreeMarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorkFreeMarkerStyle.class, "/");
        try {
            Template template  = configuration.getTemplate("helloWorld.ftl");
            StringWriter strWriter = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name","john");

            template.process(helloMap, strWriter);

            System.out.println(strWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
