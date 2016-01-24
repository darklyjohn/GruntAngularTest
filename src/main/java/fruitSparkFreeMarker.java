import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;

/**
 * Created by Jonathan on 12/01/2016.
 */
public class fruitSparkFreeMarker {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(fruitSparkFreeMarker.class, "/");

        get("/", (req, res) -> {
            StringWriter strWriter = new StringWriter();
            try {

                Template template = configuration.getTemplate("fruit.ftl");

                Map<String, Object> fruits = new HashMap<String, Object>();
                fruits.put("fruits", Arrays.asList("apple","banana","kiwi","mongo"));

                template.process(fruits, strWriter);


            } catch (Exception e) {
                halt(500);
                e.printStackTrace();
            }
            return strWriter;
        });

        post("/favorite_fruit", (req, res) -> {
            String chooseenFruit = req.queryParams("fruit");
            if (chooseenFruit == null) {
                return "Why don't you choose a fruit ?";
            } else {
                return "Your favorite fruit is " + chooseenFruit;
            }
        });

    }
}
