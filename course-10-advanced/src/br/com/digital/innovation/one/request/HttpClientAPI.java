package br.com.digital.innovation.one.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class HttpClientAPI {

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println("Nova thread criada: " +
                    (thread.isDaemon() ? "daemon" : "") + "; Thread group: " + thread.getThreadGroup());

            return thread;
        }
    });

    public static void main(String[] args) throws IOException, InterruptedException {
//        connectAndPrintURLJavaOracle();
//        connectAkamaiHttpClient();
        connectAkamaiHttp2Client();
    }

    private static void connectAkamaiHttpClient() throws IOException, InterruptedException {
        System.out.println("Running HTTP/1.1 example ...");

        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response headers: " + response.headers());

            List<Future<?>> future = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgFuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("Https://http2.akamai.com" + image))
                                    .build();

                            try {
                                HttpResponse<String> imgResponse = httpClient
                                        .send(imgRequest, HttpResponse.BodyHandlers.ofString());

                                System.out.println("Imagem carregada! " + image + ", status code: " + imgResponse.statusCode());
                            } catch (IOException | InterruptedException e) {
                                System.out.println("Cagô durante requisição para recuperar a imagem " + image);
                                e.printStackTrace();
                            }
                        });

                        future.add(imgFuture);
                        System.out.println("Submetido um futuro para a imagem " + image);
                    });

            future.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Cagõ ao esperar carregar imagem do futuro");
                    e.printStackTrace();
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total: " + ((end - start)) + "ms");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void connectAkamaiHttp2Client() throws IOException, InterruptedException {
        System.out.println("Running HTTP/2 example ...");

        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response headers: " + response.headers());

            List<Future<?>> future = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgFuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("Https://http2.akamai.com" + image))
                                    .build();

                            try {
                                HttpResponse<String> imgResponse = httpClient
                                        .send(imgRequest, HttpResponse.BodyHandlers.ofString());

                                System.out.println("Imagem carregada! " + image + ", status code: " + imgResponse.statusCode());
                            } catch (IOException | InterruptedException e) {
                                System.out.println("Cagô durante requisição para recuperar a imagem " + image);
                                e.printStackTrace();
                            }
                        });

                        future.add(imgFuture);
                        System.out.println("Submetido um futuro para a imagem " + image);
                    });

            future.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Cagõ ao esperar carregar imagem do futuro");
                    e.printStackTrace();
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total: " + ((end - start)) + "ms");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void connectAndPrintURLJavaOracle() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://docs.oracle.com/javase/10/language"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Headers response: " + response.headers());
    }
}
