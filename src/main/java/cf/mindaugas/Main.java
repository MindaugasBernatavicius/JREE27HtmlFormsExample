package cf.mindaugas;

import java.nio.file.Files;
import java.nio.file.Paths;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        get("/", (request, response) -> Files
                .readString(Paths.get("target\\classes\\index.html")));

        post("/handle-form", (request, response) -> {
            System.out.println(">>>" + request.body());
            return "Hello " + request.body().split("&")[0] + "!!!";
        });
    }
}