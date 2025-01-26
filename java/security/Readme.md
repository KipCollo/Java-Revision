# Java Security Features

Java provides built-in libraries and APIs for security purposes:

**Encryption and Decryption**:- Encryption ensures confidentiality. The javax.crypto package provides encryption functionality.

Example using AES (Advanced Encryption Standard):

```java
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESCryptoExample {
    public static void main(String[] args) throws Exception {
        // Generate a key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES
        SecretKey secretKey = keyGen.generateKey();

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES");

        // Encrypt data
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal("Hello, World!".getBytes());
        System.out.println("Encrypted: " + new String(encryptedData));

        // Decrypt data
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println("Decrypted: " + new String(decryptedData));
    }
}
```
  
**Message Digests (Hashing)**:- Used for integrity. The java.security.MessageDigest class is used for hashing.

Example using SHA-256:

```java
import java.security.MessageDigest;

public class HashingExample {
    public static void main(String[] args) throws Exception {
        String data = "Hello, World!";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes());
        System.out.println("Hashed Data: " + bytesToHex(hash));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
```

**Java Authentication and Authorization Service (JAAS)**:- JAAS is a standard Java API for user authentication and authorization.

LoginModule for pluggable authentication.
Subject and Principal for identity representation.

## Network Security

Java supports network security via HTTPS, SSL/TLS, and other protocols using the javax.net.ssl package.

Example of creating an HTTPS server:

```java
import com.sun.net.httpserver.HttpsServer;
import java.net.InetSocketAddress;
import java.io.OutputStream;

public class SimpleHttpsServer {
    public static void main(String[] args) throws Exception {
        HttpsServer server = HttpsServer.create(new InetSocketAddress(8443), 0);
        server.createContext("/", exchange -> {
            String response = "Secure response";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.setExecutor(null);
        server.start();
        System.out.println("HTTPS server started on port 8443");
    }
}
```
