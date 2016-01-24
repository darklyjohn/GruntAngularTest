import static spark.Spark.get;

/**
 * Created by Jonathan on 12/01/2016.
 */
public class Test {


        public static void main(String[] args) {

            get("/hello", (req, res) -> "Hello World");
        }

}
