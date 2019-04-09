package code.nation.desafio;

import code.nation.desafio.model.Answer;
import code.nation.desafio.util.JulioCesarCryptography;
import code.nation.desafio.util.SHA1Wrapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

public class Second {

    public static void main(String[] args) throws IOException, URISyntaxException, NoSuchAlgorithmException {
        var token = "22a9e36c01e7e69ffbb74f24dfd6a28550f3c610";

        var json = Request
                .Get(new URI("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + token))
                .execute()
                .returnContent()
                .asString();

        System.out.println("json = " + json);

        var gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        var answer = gson.fromJson(json, Answer.class);
        answer.setDecifrado(JulioCesarCryptography.encrypt(answer.getCifrado(), answer.getNumeroCasas()));
        answer.setResumoCriptografico(SHA1Wrapper.execute(answer.getDecifrado()));

        var answerJson = new File("answer.json");
        var writer = new FileWriter(answerJson);
        gson.toJson(answer, writer);
        writer.flush();
        writer.close();

        var form = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .setCharset(Charset.forName("UTF-8"))
                .addBinaryBody("answer", answerJson)
                .build();

        var response = Request
                .Post(new URI("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=" + token))
                .body(form)
                .execute()
                .returnContent();

        System.out.println("response = " + response);
    }

}
