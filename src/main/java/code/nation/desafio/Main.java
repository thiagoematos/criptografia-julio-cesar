package code.nation.desafio;

import code.nation.desafio.model.Answer;
import code.nation.desafio.util.JulioCesarCryptography;
import code.nation.desafio.util.SHA1Wrapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.NoSuchAlgorithmException;

public class Main {

    // https://docs.oracle.com/javase/9/docs/api/jdk/incubator/http/HttpRequest.html
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, NoSuchAlgorithmException {
        var token = "22a9e36c01e7e69ffbb74f24dfd6a28550f3c610";

        var client = HttpClient.newHttpClient();

        var response = client.send(
                HttpRequest
                        .newBuilder(new URI("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + token))
                        .GET()
                        .build(),
                HttpResponse.BodyHandlers.ofString()
        );
        var body = response.body();

        var gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        var answer = gson.fromJson(body, Answer.class);
        answer.setDecifrado(JulioCesarCryptography.encrypt(answer.getCifrado(), answer.getNumeroCasas()));
        answer.setResumoCriptografico(SHA1Wrapper.execute(answer.getDecifrado()));

        var answerJson = new File("answer.json");
        var writer = new FileWriter(answerJson);
        gson.toJson(answer, writer);
        writer.flush();
        writer.close();

        System.out.println(body);
        System.out.println(gson.toJson(answer));

//        var postResponse = client.send(
//                HttpRequest
//                        .newBuilder(new URI("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=" + token))
//                        .header("Content-Type", "multipart/form-data;boundary=ABCDEF")
//                        .header("Content-Disposition", "form-data;name=answer;filename=answer.json")
//                        .POST(HttpRequest.BodyPublishers.ofFile(answerJson.toPath()))
//                        .build(),
//                HttpResponse.BodyHandlers.ofString()
//        );

//        System.out.println(postResponse.statusCode());
//        System.out.println(postResponse.headers());
//        System.out.println(postResponse.body());
    }

}
