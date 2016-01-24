import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.halt;

/**
 * Created by Jonathan on 12/01/2016.
 */
public class HelloWorkSparkFreeMarkerStyle {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorkSparkFreeMarkerStyle.class, "/");

        get("/hello", (req, res) -> {
            StringWriter strWriter = new StringWriter();
            try {

                Template template = configuration.getTemplate("helloWorld.ftl");

                Map<String, Object> helloMap = new HashMap<String, Object>();
                helloMap.put("name", "john");

                template.process(helloMap, strWriter);


            } catch (Exception e) {
                halt(500);
                e.printStackTrace();
            }
            return strWriter;
        });

        get("/test/:thing", (req, res) -> "hello " +  req.params(":thing"));

    }


}
