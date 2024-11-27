# OkHttp Library

OkHttp is a popular open-source HTTP client library for Java and Android. It simplifies making network requests and handling responses efficiently. OkHttp supports HTTP/1.1, HTTP/2, WebSockets, and features like connection pooling, request caching, and retry mechanisms.

An HTTP+HTTP/2 client for Android and Java applications.

## Key Features of OkHttp

1. Synchronous and Asynchronous requests.
2. Built-in support for modern protocols like HTTP/2.
3. Connection pooling for better performance.
4. Automatic GZIP compression of responses.
5. Caching for improved speed and offline support.
6. Handling redirects and retries.

Adding OkHttp to Your Project

```groovy
Gradle (Android/Java): Add the following to your build.gradle:
implementation 'com.squareup.okhttp3:okhttp:4.11.0' // Use the latest version
```

Maven: Add this dependency to your pom.xml:

```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.11.0</version> <!-- Use the latest version -->
</dependency>
```

Basic Usage of OkHttp

- Synchronous Request (Blocking):

```java
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpExample {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.err.println("Request failed: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

- Asynchronous Request (Non-Blocking):

```java
import okhttp3.*;

public class AsyncExample {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println(response.body().string());
                } else {
                    System.err.println("Request failed: " + response.code());
                }
            }
        });

        System.out.println("Request sent!");
    }
}
```

POST Request:

```java
    import okhttp3.*;

    public class PostExample {
        public static void main(String[] args) {
            OkHttpClient client = new OkHttpClient();

            MediaType JSON = MediaType.get("application/json; charset=utf-8");
            String json = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";

            RequestBody body = RequestBody.create(json, JSON);

            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/posts")
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    System.out.println("Response: " + response.body().string());
                } else {
                    System.err.println("Request failed: " + response.code());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
```

Advanced Usage

Timeouts:

```java
OkHttpClient client = new OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build();

Request Headers:

Request request = new Request.Builder()
        .url("https://jsonplaceholder.typicode.com/posts/1")
        .addHeader("Authorization", "Bearer YOUR_TOKEN")
        .build();

Caching:

File cacheDirectory = new File("cacheDir", "http-cache");
Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024); // 10 MB

OkHttpClient client = new OkHttpClient.Builder()
        .cache(cache)
        .build();

Interceptors: Add custom logic to requests or responses.

OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Custom-Header", "Value")
                    .build();
            return chain.proceed(request);
        })
        .build();
```

WebSocket:

```java
    import okhttp3.*;

    public class WebSocketExample {
        public static void main(String[] args) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("wss://echo.websocket.org")
                    .build();

            WebSocket webSocket = client.newWebSocket(request, new WebSocketListener() {
                @Override
                public void onOpen(WebSocket webSocket, Response response) {
                    webSocket.send("Hello, WebSocket!");
                }

                @Override
                public void onMessage(WebSocket webSocket, String text) {
                    System.out.println("Message received: " + text);
                }

                @Override
                public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                    t.printStackTrace();
                }
            });

            client.dispatcher().executorService().shutdown();
        }
    }
```

## Best Practices

1. Reuse a single OkHttpClient instance across your application to leverage connection pooling.
2. Use enqueue() for network operations in the background.
3. Handle exceptions and edge cases like timeouts, retries, and API errors gracefully.
4. Use interceptors to centralize logging, headers, or retry logic.

OkHttp is powerful, efficient, and well-suited for modern Java and Android applications!
