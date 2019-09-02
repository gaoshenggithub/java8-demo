package cn.andy;

import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientTest {

    @Test
    public void testName2() throws Exception {
        var client = HttpClient.newHttpClient();
        var req = HttpRequest.newBuilder(URI.create("http://47.105.177.77/test")).build();

        var handlers = HttpResponse.BodyHandlers.ofString();

        var sendAsync = client.sendAsync(req, handlers);
        //var send = client.send(req,handlers);
        var response = sendAsync.get();

        String body = response.body();

        System.out.println("body = " + body);
    }

    @Test
    public void testName3() {

    }
}
